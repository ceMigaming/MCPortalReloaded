package com.cemi.portalreloaded.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityWheatley extends EntityPathFollowing {

	public EntityWheatley(World worldIn) {
		super(worldIn);
		//setSize(.6875F, 0.6875F);
		//genDefaultPath();
	}

	public EntityWheatley(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
		//setSize(.6875F, 0.6875F);
		//genDefaultPath();
	}
}
