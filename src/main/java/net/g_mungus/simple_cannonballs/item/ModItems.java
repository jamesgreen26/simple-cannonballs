package net.g_mungus.simple_cannonballs.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.g_mungus.simple_cannonballs.SimpleCannonballs;
import net.g_mungus.simple_cannonballs.entity.CannonballEntity;
import net.g_mungus.simple_cannonballs.utils.CannonDispenserBehavior;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.dispenser.ProjectileDispenserBehavior;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Position;
import net.minecraft.world.World;

public class ModItems {

    public static final Item CANNONBALL = registerItem("cannonball", new CannonballItem(new Item.Settings()));

    private static void addItemsToCombatItemGroup(FabricItemGroupEntries entries) {
        entries.add(CANNONBALL);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SimpleCannonballs.MOD_ID, name), item);
    }

    public static void registerModItems () {
        SimpleCannonballs.LOGGER.info("Registering mod items for " + SimpleCannonballs.MOD_ID);

        DispenserBlock.registerBehavior(ModItems.CANNONBALL, new CannonDispenserBehavior(){

            @Override
            protected ProjectileEntity createProjectile(World world, Position position, ItemStack stack) {
                return Util.make(new CannonballEntity(world, position.getX(), position.getY(), position.getZ()), entity -> entity.setItem(stack));
            }



        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToCombatItemGroup);
    }
}
