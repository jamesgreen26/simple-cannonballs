package net.g_mungus.simple_cannonballs.entity;

import net.g_mungus.simple_cannonballs.SimpleCannonballs;
import net.g_mungus.simple_cannonballs.item.CannonballItem;
import net.g_mungus.simple_cannonballs.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class CannonballEntity extends ThrownItemEntity implements FlyingItemEntity {


    public CannonballEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public CannonballEntity(World world, LivingEntity owner) {
        super(ModEntities.CANNONBALL_ENTITY, owner, world); // null will be changed later
    }

    public CannonballEntity(World world, double x, double y, double z) {
        super(ModEntities.CANNONBALL_ENTITY, x, y, z, world); // null will be changed later
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.CANNONBALL;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().createExplosion((Entity)this, this.getX(), this.getY(), this.getZ(), 1, false, World.ExplosionSourceType.BLOCK);
            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().explosion(null), 6.0f);
    }

    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
}