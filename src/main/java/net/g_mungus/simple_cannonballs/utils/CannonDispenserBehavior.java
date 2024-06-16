/*
 * Decompiled with CFR 0.2.2 (FabricMC 7c48b8c4).
 */
package net.g_mungus.simple_cannonballs.utils;

import net.g_mungus.simple_cannonballs.sound.ModSounds;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ItemDispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

/**
 * A dispenser behavior that spawns a projectile with velocity in front of the dispenser.
 */
public abstract class CannonDispenserBehavior
        extends ItemDispenserBehavior {
    @Override
    public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
        ServerWorld world = pointer.world();
        Position position = DispenserBlock.getOutputLocation(pointer);
        Direction direction = pointer.state().get(DispenserBlock.FACING);
        ProjectileEntity projectileEntity = this.createProjectile(world, position, stack);
        projectileEntity.setVelocity(direction.getOffsetX(), (float)direction.getOffsetY() + 0.2f, direction.getOffsetZ(), this.getForce() + 0.4f, this.getVariation() / 2);
        world.spawnEntity(projectileEntity);
        stack.decrement(1);
        return stack;
    }

    @Override
    protected void playSound(BlockPointer pointer) {
        pointer.world().playSound(null, pointer.pos().getX(), pointer.pos().getY(), pointer.pos().getZ(), ModSounds.CANNONBALL_SHOT, SoundCategory.BLOCKS, 0.5F, 1F);
    }


    protected abstract ProjectileEntity createProjectile(World var1, Position var2, ItemStack var3);

    /**
     * {@return the variation of a projectile's velocity when spawned}
     */
    protected float getVariation() {
        return 6.0f;
    }

    /**
     * {@return the force of a projectile's velocity when spawned}
     */
    protected float getForce() {
        return 1.1f;
    }
}

