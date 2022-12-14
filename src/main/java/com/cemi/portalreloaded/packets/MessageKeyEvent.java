package com.cemi.portalreloaded.packets;

import java.util.ArrayList;
import java.util.HashSet;

import com.cemi.portalreloaded.utility.PortalGunHelper;

import io.netty.buffer.ByteBuf;
import me.ichun.mods.ichunutil.common.core.network.AbstractPacket;
import me.ichun.mods.ichunutil.common.core.util.EntityHelper;
import me.ichun.mods.ichunutil.common.grab.GrabHandler;
import me.ichun.mods.ichunutil.common.item.ItemHandler;
import me.ichun.mods.portalgun.common.PortalGun;
import me.ichun.mods.portalgun.common.core.SoundIndex;
import me.ichun.mods.portalgun.common.item.ItemPortalGun;
import me.ichun.mods.portalgun.common.portal.PortalGunGrabHandler;
import me.ichun.mods.portalgun.common.portal.info.PortalInfo;
import me.ichun.mods.portalgun.common.portal.world.PortalPlacement;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;

public class MessageKeyEvent extends AbstractPacket {
	public int event;

	public MessageKeyEvent() {
	}

	public MessageKeyEvent(int integer) {
		this.event = integer;
	}

	public void writeTo(ByteBuf byteBuf) {
		byteBuf.writeInt(this.event);
	}

	public void readFrom(ByteBuf byteBuf) {
		this.event = byteBuf.readInt();
	}

	public void execute(Side side, EntityPlayer entityPlayer) {
		ItemStack itemStack4 = ItemHandler.getUsableDualHandedItem((EntityLivingBase) entityPlayer);
		boolean boolean5 = itemStack4.getItem() == PortalGun.itemPortalGun;
		switch (event) {
		case 5:
			if (!PortalGunHelper.tryGrabBareHand((EntityLivingBase) entityPlayer) && !boolean5) {
				EntityHelper.playSoundAtEntity((Entity) entityPlayer, SoundIndex.pg_object_use_failure,
						entityPlayer.getSoundCategory(), 0.2f, 1.0f);
			}
			break;

		default:
			break;
		}
	}

	public Side receivingSide() {
		return Side.SERVER;
	}
}
