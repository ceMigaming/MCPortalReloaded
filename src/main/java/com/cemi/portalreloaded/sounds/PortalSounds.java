package com.cemi.portalreloaded.sounds;

import com.cemi.portalreloaded.PortalReloaded;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;

public class PortalSounds {
	public static final SoundEvent RADIO;
	
	static {
		RADIO = portalSoundEvent("radio");
	}
	
	private static SoundEvent portalSoundEvent(String name) {
		ResourceLocation soundLocation = new ResourceLocation(PortalReloaded.MODID, name);
        SoundEvent soundEvent = new SoundEvent(soundLocation);
        soundEvent.setRegistryName(soundLocation);
        System.out.println(soundLocation);
        return soundEvent;
	}
	
	public static void register(RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().registerAll(RADIO);
	}
}
