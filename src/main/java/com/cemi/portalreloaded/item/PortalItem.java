package com.cemi.portalreloaded.item;

import com.cemi.portalreloaded.PortalReloaded;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PortalItem extends Item {
	protected String name;

	public PortalItem(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public void registerItemModel() {
		PortalReloaded.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public PortalItem setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}
