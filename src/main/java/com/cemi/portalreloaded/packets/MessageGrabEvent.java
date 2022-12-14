package com.cemi.portalreloaded.packets;

import java.util.ArrayList;

import com.cemi.portalreloaded.grab.PortalReloadedGrabHandler;

import io.netty.buffer.ByteBuf;
import me.ichun.mods.ichunutil.common.iChunUtil;
import me.ichun.mods.ichunutil.common.core.network.AbstractPacket;
import me.ichun.mods.ichunutil.common.grab.GrabHandler;
import me.ichun.mods.ichunutil.common.item.ItemHandler;
import me.ichun.mods.portalgun.common.PortalGun;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageGrabEvent extends AbstractPacket {
	public String ident;
	public int grabberId;
	public int grabbedId;
	public float dist;
	public boolean grabbed;
	public boolean shouldDrop;

	public MessageGrabEvent() {
	}

	public MessageGrabEvent(String string, int integer3, int integer4, float float5, boolean isGrabbed,
			boolean shouldDrop) {
		this.ident = string;
		this.grabberId = integer3;
		this.grabbedId = integer4;
		this.dist = float5;
		this.grabbed = isGrabbed;
		this.shouldDrop = shouldDrop;
	}

	public void writeTo(ByteBuf byteBuf) {
		ByteBufUtils.writeUTF8String(byteBuf, this.ident);
		byteBuf.writeInt(this.grabberId);
		byteBuf.writeInt(this.grabbedId);
		byteBuf.writeFloat(this.dist);
		byteBuf.writeBoolean(this.grabbed);
		byteBuf.writeBoolean(this.shouldDrop);
	}

	public void readFrom(ByteBuf byteBuf) {
		this.ident = ByteBufUtils.readUTF8String(byteBuf);
		this.grabberId = byteBuf.readInt();
		this.grabbedId = byteBuf.readInt();
		this.dist = byteBuf.readFloat();
		this.grabbed = byteBuf.readBoolean();
		this.shouldDrop = byteBuf.readBoolean();
	}

	public void execute(Side side, EntityPlayer entityPlayer) {
		this.handleClient();
	}

	public Side receivingSide() {
		return Side.CLIENT;
	}

	@SideOnly(Side.CLIENT)
	public void handleClient() {
		ArrayList<GrabHandler> arrayList2 = GrabHandler.grabbedEntities.get(Side.CLIENT);
		ArrayList<PortalReloadedGrabHandler> arrayList3 = new ArrayList<PortalReloadedGrabHandler>();
		for (final GrabHandler handler : GrabHandler.grabbedEntities.get(Side.CLIENT)) {
			if (handler instanceof PortalReloadedGrabHandler) {
				arrayList3.add((PortalReloadedGrabHandler) handler);
			}
		}
		if (this.grabbed) {
			boolean boolean4 = false;
			for (final PortalReloadedGrabHandler handler2 : arrayList3) {
				if (handler2.identifier.equals(this.ident)) {
					boolean4 = true;
					if (handler2.grabberId != this.grabberId || handler2.grabbedId != this.grabbedId) {
						handler2.grabber = null;
						handler2.grabbed = null;
						handler2.grabberId = this.grabberId;
						handler2.grabbedId = this.grabbedId;
						handler2.getIDs();
					}
					handler2.grabDistance = this.dist;
					break;
				}
			}
			if (!boolean4) {
				PortalReloadedGrabHandler portalGunGrabHandler5 = new PortalReloadedGrabHandler(this.ident,
						this.grabberId, this.grabbedId, this.dist);
				arrayList2.add(portalGunGrabHandler5);
				portalGunGrabHandler5.getIDs();
//				ItemStack itemStack6 = ItemHandler
//						.getUsableDualHandedItem((EntityLivingBase) Minecraft.getMinecraft().player);
				if (this.grabberId == Minecraft.getMinecraft().player.getEntityId()) {
					iChunUtil.proxy.nudgeHand(15.0f);
				}
			}
		} else if (this.shouldDrop) {
			for (final PortalReloadedGrabHandler handler3 : arrayList3) {
				if (handler3.identifier.equals(this.ident)) {
					arrayList2.remove(handler3);
					handler3.terminate();
					ItemStack itemStack6 = ItemHandler
							.getUsableDualHandedItem((EntityLivingBase) Minecraft.getMinecraft().player);
					if (this.grabberId == Minecraft.getMinecraft().player.getEntityId()) {
						iChunUtil.proxy.nudgeHand(15.0f);
						break;
					}
					break;
				}
			}
		}
	}
}
