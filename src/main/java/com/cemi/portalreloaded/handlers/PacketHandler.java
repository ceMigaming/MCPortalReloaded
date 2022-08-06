package com.cemi.portalreloaded.handlers;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.packets.MessageRotatePickedObject;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class PacketHandler {
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(PortalReloaded.MODID);
	private static int msgid = 0;
	
	private static enum Side
    {
        CLIENT, SERVER, BOTH;
    }
	
	public static void register() {
		registerMessage(MessageRotatePickedObject.class, Side.SERVER);
	}
	
	private static void registerMessage(Class packet, Side side)
	{
        if (side != Side.CLIENT)
            registerMessage(packet, net.minecraftforge.fml.relauncher.Side.SERVER);

        if (side != Side.SERVER)
            registerMessage(packet, net.minecraftforge.fml.relauncher.Side.CLIENT);
    }

	private static void registerMessage(Class packet, net.minecraftforge.fml.relauncher.Side side) {
        INSTANCE.registerMessage(packet, packet, msgid++, side);
    }
}
