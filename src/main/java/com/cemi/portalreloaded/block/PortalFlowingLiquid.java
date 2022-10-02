package com.cemi.portalreloaded.block;

import com.cemi.portalreloaded.PortalReloaded;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class PortalFlowingLiquid extends BlockDynamicLiquid {

	String name;

	protected PortalFlowingLiquid(Material materialIn, String name) {
		super(materialIn);
		this.name = name;
		setHardness(100.0f);
		setLightOpacity(3);
	}

	public void registerItemModel(Item itemBlock) {
		PortalReloaded.proxy.registerItemRenderer(itemBlock, 0, name);
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	public Block setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}
