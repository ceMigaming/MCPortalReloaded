package com.cemi.portalreloaded.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.grab.PortalReloadedGrabHandler;
import com.cemi.portalreloaded.packets.MessageGrabEvent;

import me.ichun.mods.ichunutil.common.iChunUtil;
import me.ichun.mods.ichunutil.common.core.network.AbstractPacket;
import me.ichun.mods.ichunutil.common.entity.EntityBlock;
import me.ichun.mods.ichunutil.common.grab.GrabHandler;
import me.ichun.mods.ichunutil.common.item.ItemHandler;
import me.ichun.mods.portalgun.common.PortalGun;
import me.ichun.mods.portalgun.common.packet.PacketGrabEvent;
import me.ichun.mods.portalgun.common.portal.PortalGunGrabHandler;
import me.ichun.mods.portalgun.common.portal.info.PortalInfo;
import me.ichun.mods.portalgun.common.portal.world.PortalPlacement;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class PortalGunHelper {
	public static void RemovePortals(World world, int dimID, String UUID, String ChannelName, int isTypeA) {
		HashSet<PortalInfo> infoHS = PortalGun.eventHandlerServer.getWorldSaveData(dimID).portalList;
		ArrayList<PortalInfo> infoList = new ArrayList<PortalInfo>();

		for (final PortalInfo info : infoHS) {
			if (info.uuid.equals(UUID) && info.channelName.equals(ChannelName)) {
				if (isTypeA == -1)
					infoList.add(info);
				else {
					if ((info.isTypeA ? 1 : 0) == isTypeA)
						infoList.add(info);
				}
			}
		}

		for (final PortalInfo info : infoList) {
			PortalPlacement portalPlacement = info.getPortalPlacement(world);
			if (portalPlacement != null) {
				portalPlacement.remove(BlockPos.ORIGIN);
			}
		}
	}

	public static boolean tryGrabBareHand(EntityLivingBase entityLivingBase) {
		// ItemStack portalGunItemStack =
		// ItemHandler.getUsableDualHandedItem(entityLivingBase);
		// boolean hasPortalGun = portalGunItemStack.getItem() ==
		// PortalGun.itemPortalGun;
		if (GrabHandler.hasHandlerType(entityLivingBase, Side.SERVER, (Class) null)) {
			GrabHandler.release(entityLivingBase, Side.SERVER, (Class) null);
			return true;
		}
		int grabStrength = 1;
		RayTraceResult rayTraceResult = me.ichun.mods.ichunutil.common.core.util.EntityHelper
				.getEntityLook((Entity) entityLivingBase, 5.0);
		Entity grabbedEntity = null;
		if (rayTraceResult.typeOfHit == RayTraceResult.Type.ENTITY
				&& canEntityBeGrabbed(grabStrength, rayTraceResult.entityHit)) {
			grabbedEntity = rayTraceResult.entityHit;
		}
		if (grabbedEntity != null) {
			ArrayList<GrabHandler> arrayList7 = GrabHandler.grabbedEntities.get(Side.SERVER);
			for (final GrabHandler handler : arrayList7) {
				if (handler.grabbed == grabbedEntity) {
					handler.terminate();
					arrayList7.remove(handler);
				}
			}
			float float8 = 3.5f;
			float float9 = grabbedEntity.width;
			if (float9 > 2.0) {
				float8 = MathHelper.clamp(float8 + float9 - 2.0f, 3.5f, 6.0f);
			}
			PortalReloadedGrabHandler grabHandler = new PortalReloadedGrabHandler(entityLivingBase, grabbedEntity,
					float8);
			GrabHandler.grab((GrabHandler) grabHandler, Side.SERVER);
			GrabHandler.grab((GrabHandler) grabHandler, Side.SERVER);
			PortalReloaded.channel.sendToAll((AbstractPacket) new MessageGrabEvent(grabHandler.identifier,
					grabHandler.grabberId, grabHandler.grabbedId, grabHandler.grabDistance, true, false));
			return true;
		}
		return false;
	}

	private static boolean canEntityBeGrabbed(int integer, Entity entity) {
		if (entity instanceof EntityPlayer) {
			return false;
		}
		int integer4 = PortalGun.config.entityGrabWeightBase;
		double double5 = integer4 / 100.0f
				* ((integer == 1) ? 1.0 : ((integer == 2) ? 1.5 : ((integer == 3) ? 2.25 : 3.0)));
		double5 = double5 * double5 * double5;
		double double7 = entity.width * entity.width * entity.height;
		return double7 < double5;
	}
}
