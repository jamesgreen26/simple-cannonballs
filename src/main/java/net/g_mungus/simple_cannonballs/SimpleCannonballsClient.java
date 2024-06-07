package net.g_mungus.simple_cannonballs;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.g_mungus.simple_cannonballs.entity.ModEntities;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class SimpleCannonballsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.CANNONBALL_ENTITY, FlyingItemEntityRenderer::new);

    }
}
