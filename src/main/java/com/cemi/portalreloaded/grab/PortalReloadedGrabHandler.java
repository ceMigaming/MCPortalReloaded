package com.cemi.portalreloaded.grab;

import java.util.ArrayList;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.packets.MessageGrabEvent;

import me.ichun.mods.ichunutil.common.core.network.AbstractPacket;
import me.ichun.mods.ichunutil.common.core.util.EntityHelper;
import me.ichun.mods.ichunutil.common.grab.GrabHandler;
import me.ichun.mods.portalgun.client.sound.PortalGunGrabSound;
import me.ichun.mods.portalgun.common.PortalGun;
import me.ichun.mods.portalgun.common.core.SoundIndex;
import me.ichun.mods.portalgun.common.packet.PacketGrabEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PortalReloadedGrabHandler extends GrabHandler {

	@SideOnly(Side.CLIENT)
	public PositionedSoundRecord soundLoc;

	public PortalReloadedGrabHandler(EntityLivingBase entityLivingBase, Entity entity, float float4) {
		super(entityLivingBase, entity, float4);
	}

	public PortalReloadedGrabHandler(String string, int integer3, int integer4, float float5) {
		super(string, integer3, integer4, float5);
	}

	@Override
	public boolean shouldTerminate() {
		return super.shouldTerminate();
	}

	@Override
	public void update() {
		// this.setup();
		if (this.grabber.world.isRemote) {
			this.handleClient();
		}
		super.update();
	}

	@Override
	public void terminate() {
		super.terminate();
		if (this.grabber.world.isRemote) {
			this.terminateClient();
		}
		EntityHelper.playSoundAtEntity((Entity) this.grabber, SoundIndex.pg_object_use_stop, SoundCategory.PLAYERS,
				0.2f, 1.0f);

		if (!this.grabber.world.isRemote) {
			PortalReloaded.channel.sendToAll((AbstractPacket) new MessageGrabEvent(this.identifier, this.grabberId,
					this.grabbedId, this.grabDistance, false, true));
		}
	}

	@SideOnly(Side.CLIENT)
	public void handleClient() {
		if (this.grabber == Minecraft.getMinecraft().player) {
			if (this.time == 0) {
				this.soundLoc = new PositionedSoundRecord(SoundIndex.pg_object_use_lp_start.getSoundName(),
						this.grabber.getSoundCategory(), 0.2f, 1.0f, false, 0, ISound.AttenuationType.NONE, 0.0f, 0.0f,
						0.0f);
				Minecraft.getMinecraft().getSoundHandler().playSound((ISound) this.soundLoc);
				PortalGun.eventHandlerClient.firingTime = 0;
			} else if (this.time == 23) {
//				Minecraft.getMinecraft().getSoundHandler()
//						.playSound((ISound) new PortalGunGrabSound(SoundIndex.pg_object_use_lp_loop,
//								this.grabber.getSoundCategory(), 0.2f, 1.0f, this));
			}
			if (PortalGun.eventHandlerClient.firingTime > 4) {
				PortalGun.eventHandlerClient.firingTime = 4;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void terminateClient() {
		if (this.soundLoc != null) {
			Minecraft.getMinecraft().getSoundHandler().playSound((ISound) this.soundLoc);
		}
	}
}
