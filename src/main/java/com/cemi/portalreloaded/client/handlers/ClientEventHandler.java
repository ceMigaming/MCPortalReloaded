package com.cemi.portalreloaded.client.handlers;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.packets.MessageKeyEvent;

import me.ichun.mods.ichunutil.client.keybind.KeyEvent;
import me.ichun.mods.ichunutil.common.iChunUtil;
import me.ichun.mods.ichunutil.common.core.network.AbstractPacket;
import me.ichun.mods.ichunutil.common.item.ItemHandler;
import me.ichun.mods.portalgun.common.PortalGun;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ClientEventHandler {
	public static void onKeyEvent(KeyEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
		if (mc.player != null && mc.currentScreen == null && !iChunUtil.eventHandlerClient.hasScreen) {
			ItemStack stack = ItemHandler.getUsableDualHandedItem((EntityLivingBase) mc.player);
			if (stack.getItem() == PortalGun.itemPortalGun)
				return;
			if (event.keyBind.isPressed()) {
				if (event.keyBind.equals(PortalGun.config.keyGrab)) {
					AbstractPacket packet = (AbstractPacket) new MessageKeyEvent(5);
					PortalReloaded.channel.sendToServer(packet);
				}
			}
		}
	}
}
