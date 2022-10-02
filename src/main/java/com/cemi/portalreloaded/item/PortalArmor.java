package com.cemi.portalreloaded.item;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.client.PortalTabs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class PortalArmor extends ItemArmor implements ISpecialArmor {
	private String name;

	public PortalArmor(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
		super(material, 0, slot);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(PortalTabs.PORTAL_TOOLS_AND_ARMOR);
		this.name = name;
	}

	public void registerItemModel() {
		PortalReloaded.proxy.registerItemRenderer(this, 0, name);
	}

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		player.fallDistance = 0;
	}
	
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage,
			int slot) {
		if (source.getDamageType().equals("fall")) {
			return new ArmorProperties(0, 1.00, Integer.MAX_VALUE);
		} else {

			return new ArmorProperties(0, 0.08, Integer.MAX_VALUE);

		}
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 2;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {

	}
}
