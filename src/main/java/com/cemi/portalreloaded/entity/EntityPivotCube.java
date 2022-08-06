package com.cemi.portalreloaded.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Nullable;

import com.cemi.portalreloaded.handlers.PacketHandler;
import com.cemi.portalreloaded.packets.MessageRotatePickedObject;
import com.cemi.portalreloaded.utility.Math;

import me.ichun.mods.ichunutil.common.grab.GrabHandler;
import me.ichun.mods.ichunutil.common.module.worldportals.common.portal.WorldPortal;
import me.ichun.mods.portalgun.common.portal.world.PortalPlacement;
import me.ichun.mods.portalgun.common.tileentity.TilePortalBase;
import me.ichun.mods.portalgun.common.tileentity.TilePortalMaster;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class EntityPivotCube extends EntityCubeBase {

	RayTraceResult result;
	Vec3d pairLaserStart;
	Vec3d pairLaserEnd;

	private boolean iterating = false;

	public EntityPivotCube(World worldIn) {
		super(worldIn);
	}

	@Override
	public void onAddedToWorld() {
		super.onAddedToWorld();
	}

	@Override
	public void onUpdate() {
		result = rayTrace(20, 1.f);
		TileEntity te = world.getTileEntity(
				new BlockPos(Math.floor(result.hitVec).add(new Vec3d(result.sideHit.getDirectionVec()))));
		if (te instanceof TilePortalMaster || te instanceof TilePortalBase) {
			EnumMap<EnumFacing, PortalPlacement> portals = ((TilePortalBase) te).portals;
			this.iterating = true;
			Iterator<Map.Entry<EnumFacing, PortalPlacement>> iterator2 = portals.entrySet().iterator();

			while (iterator2.hasNext()) {
				Map.Entry<EnumFacing, PortalPlacement> entry = iterator2.next();
				PortalPlacement placement = entry.getValue();
				EnumFacing portalFacing = placement.getFaceOn();
				WorldPortal pair = placement.getPair();

				if (pair != null) {
					EnumFacing pairFacing = pair.getFaceOn();

					Vec3d hitBlockPos = new Vec3d(result.getBlockPos());
					Vec3d pairBlockPos = pair.getPosition().addVector(0d, .5d, -.5d)
							.add(new Vec3d(pairFacing.getDirectionVec()).scale(-.5));

					Vec3d laserHitPoint = hitBlockPos.subtract(result.hitVec);
					pairLaserStart = pairBlockPos.add(laserHitPoint);

					float a = (float) Math.angle(new Vec3d(portalFacing.getDirectionVec()),
							new Vec3d(pairFacing.getDirectionVec()));

					Vec3d diffVector = placement.getPosition().subtract(getPositionVector()).normalize().scale(-1)
							.rotateYaw(-2 * a);

					RayTraceResult res = world.rayTraceBlocks(new Vec3d(pair.getPos()),
							pair.getPosition().add(diffVector.addVector(0, -diffVector.y, 0).scale(20)), true, false,
							true);
					pairLaserEnd = res.hitVec;

				}

			}
			this.iterating = false;
		} else {
			pairLaserStart = null;
			pairLaserEnd = null;
		}
		if (world.isRemote) {
			for (ArrayList<GrabHandler> handlers : GrabHandler.grabbedEntities.values()) {
				for (GrabHandler handler : handlers) {
					if (handler.grabbedId == getEntityId()) {
						IMessage message = new MessageRotatePickedObject(handler.grabbedId,
								handler.grabber.rotationYawHead);
						PacketHandler.INSTANCE.sendToServer(message);
					}
				}
			}
			/*
			 * if (GrabHandler.getFirstHandler(mc.player, Side.CLIENT,
			 * PortalGunGrabHandler.class) != null) {
			 * 
			 * }
			 */
		}
		super.onUpdate();
	}

	public RayTraceResult getRayTraceResult() {
		return result;
	}

	public Vec3d getPairLaserStart() {
		return pairLaserStart;
	}

	public Vec3d getPairLaserEnd() {
		return pairLaserEnd;
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn) {
		return ItemStack.EMPTY;
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack) {
		// TODO Auto-generated method stub

	}

	@Override
	public EnumHandSide getPrimaryHand() {
		return EnumHandSide.RIGHT;
	}

	@Nullable
	public RayTraceResult rayTrace(double blockReachDistance, float partialTicks) {
		Vec3d vec3d = this.getPositionEyes(partialTicks);
		Vec3d vec3d1 = this.getLook(partialTicks);
		Vec3d vec3d2 = vec3d.addVector(vec3d1.x * blockReachDistance, vec3d1.y * blockReachDistance,
				vec3d1.z * blockReachDistance);
		return this.world.rayTraceBlocks(vec3d, vec3d2, true, false, true);
	}
}
