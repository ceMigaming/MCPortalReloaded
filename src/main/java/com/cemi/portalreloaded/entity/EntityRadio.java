package com.cemi.portalreloaded.entity;

import java.util.Collections;

import com.cemi.portalreloaded.sounds.PortalSounds;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.MouseHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class EntityRadio extends EntityLivingBase {

	private int timeOut = 10;

	public EntityRadio(World worldIn) {
		super(worldIn);
		getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
		setSize(0.4f, 1f);
	}

	@Override
	public boolean processInitialInteract(EntityPlayer player, EnumHand hand) {
		if (hand == EnumHand.MAIN_HAND && timeOut == 0) {
			player.sendMessage(new TextComponentString("You right clicked on Radio!"));
			playSound(PortalSounds.RADIO, 1.f, 1.f);
			timeOut = 10;
		}
		return super.processInitialInteract(player, hand);
	}

	@Override
	public void onUpdate() {
		timeOut--;
		if(timeOut < 0)
			timeOut = 0;
		super.onUpdate();
	}
	
	@Override
	public Iterable<ItemStack> getArmorInventoryList() {
		return Collections.EMPTY_LIST;
	}

	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		if (source == DamageSource.LAVA)
			return false;
		return true;
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

}
