package net.g_mungus.simple_cannonballs.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.g_mungus.simple_cannonballs.SimpleCannonballs;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<CannonballEntity> CANNONBALL_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(SimpleCannonballs.MOD_ID, "cannonball_entity"),
            FabricEntityTypeBuilder.<CannonballEntity>create(SpawnGroup.MISC, CannonballEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
                    .trackRangeBlocks(4)
                    .trackedUpdateRate(10).build()
    );

    public static void registerModEntities () {
        SimpleCannonballs.LOGGER.info("Registering mod entities for " + SimpleCannonballs.MOD_ID);
    }
}
