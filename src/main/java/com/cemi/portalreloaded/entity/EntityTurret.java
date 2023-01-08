package com.cemi.portalreloaded.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cemi.portalreloaded.utility.Math;

import me.ichun.mods.ichunutil.common.iChunUtil;
import me.ichun.mods.ichunutil.common.grab.GrabHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;

public class EntityTurret extends EntityLivingBase {

	public boolean shouldOpen = false;
	public boolean isOpen = false;
	public float openingSpeed = 0.1f;
	int shootingTimer = 0;
	float openingTime = 0;
	public double targetingDistance = 15.d;

	public EntityTurret(World worldIn) {
		super(worldIn);
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
		setSize(0.4f, 1f);
	}

	@Override
	public void onUpdate() {
		ArrayList<GrabHandler> ents = (ArrayList<GrabHandler>) GrabHandler.grabbedEntities.get(Side.SERVER);
		for (int i = ents.size() - 1; i >= 0; --i) {
			GrabHandler handler = (GrabHandler) ents.get(i);
			if (handler.grabbed == this) {
				if (!world.isRemote)
					this.setRotation(handler.grabber.prevRotationYaw, this.rotationPitch);
			}
		}
		this.rotationYawHead = this.prevRotationYaw;

		List<EntityPlayer> players = world.getEntitiesWithinAABB(EntityPlayer.class,
				getEntityBoundingBox().grow(targetingDistance));
		for (EntityPlayer player : players) {
			if (!Math.isEntityLookingAtPlayer(this, player, 90, 0.f)) {
				shouldOpen = false;
			} else {
				shouldOpen = true;
				shootingTimer = (shootingTimer + 1) % 10;
				if (shootingTimer == 0) {
					if (isOpen) {
						player.attackEntityFrom(DamageSource.causeIndirectDamage(this, this).setProjectile(), 4.0F);
					}
				}
				if (shouldOpen) {
					Vec3d particleVec = player.getPositionVector().subtract(getPositionVector()).normalize();
					world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, posX, posY + .5d, posZ, particleVec.x * 2,
							particleVec.y + .2d, particleVec.z * 2);
				}
			}
			if (!world.isRemote) {
				if (shouldOpen && !isOpen) {
					isOpen = true;
				} else if (!shouldOpen) {
					isOpen = false;
				}
			}
		}
		if (players.size() == 0) {
			shouldOpen = false;
		}
		super.onUpdate();
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

	}

	@Override
	public EnumHandSide getPrimaryHand() {
		return EnumHandSide.RIGHT;
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer entityIn) {
		this.attackEntityFrom(DamageSource.causePlayerDamage(entityIn), Float.MAX_VALUE);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		compound.setFloat("turretRotation", this.rotationYawHead);
		super.writeEntityToNBT(compound);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		this.rotationYawHead = compound.getFloat("turretRotation");
		super.readEntityFromNBT(compound);
	}
}
