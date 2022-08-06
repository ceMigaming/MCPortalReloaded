package com.cemi.portalreloaded.command;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class PortalCommands {

	public static void register(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandAddToPath());
		event.registerServerCommand(new CommandRemoveFromPath());
		event.registerServerCommand(new CommandStartPath());
	}
	
}
