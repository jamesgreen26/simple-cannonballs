package net.g_mungus.simple_cannonballs.sound;

import net.g_mungus.simple_cannonballs.SimpleCannonballs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent CANNONBALL_SHOT = registerSoundEvent("cannonball_shot");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(SimpleCannonballs.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        SimpleCannonballs.LOGGER.info("Registering sounds for" + SimpleCannonballs.MOD_ID);
    }
}
