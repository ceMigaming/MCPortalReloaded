package com.cemi.portalreloaded.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import net.minecraft.world.World;

public class EntityCubeBase extends EntityLivingBase {

	public EntityCubeBase(World worldIn) {
		super(worldIn);
	}

	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemStack getItemStackFromSlot(EntityEquipmentSlot slotIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnumHandSide getPrimaryHand() {
		// TODO Auto-generated method stub
		return null;
	}

}
