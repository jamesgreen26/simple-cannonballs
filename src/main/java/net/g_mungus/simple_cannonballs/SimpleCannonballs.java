package net.g_mungus.simple_cannonballs;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.g_mungus.simple_cannonballs.entity.ModEntities;
import net.g_mungus.simple_cannonballs.item.ModItems;
import net.g_mungus.simple_cannonballs.sound.ModSounds;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleCannonballs implements ModInitializer {

	public static final String MOD_ID = "simple-cannonballs";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Simple Cannons Init");

		ModItems.registerModItems();
		ModSounds.registerSounds();
		ModEntities.registerModEntities();


	}
}