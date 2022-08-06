package com.cemi.portalreloaded.entity;

import java.util.Collections;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.world.World;

public class EntityStorageCube extends EntityCubeBase {

	public EntityStorageCube(World worldIn) {
		super(worldIn);
	}
	
	@Override
	public void onAddedToWorld() {
		super.onAddedToWorld();
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

}
