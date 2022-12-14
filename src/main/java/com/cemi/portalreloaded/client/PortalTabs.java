package com.cemi.portalreloaded.client;

import com.cemi.portalreloaded.block.PortalBlocks;
import com.cemi.portalreloaded.item.PortalItem;
import com.cemi.portalreloaded.item.PortalItems;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class PortalTabs extends CreativeTabs {

	public PortalTabs(String label) {
		super(label);
	}

	public static final CreativeTabs PORTAL_BUILDING_BLOCKS = new CreativeTabs("apertureBuilding") {
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(PortalBlocks.smallConcreteTile));
		}
	};

	public static final CreativeTabs PORTAL_REDSTONE = new CreativeTabs("apertureElectronics") {
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(Item.getItemFromBlock(PortalBlocks.ballLauncher));
		}
	};

	public static final CreativeTabs PORTAL_TOOLS_AND_ARMOR = new CreativeTabs("apertureTools") {
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(PortalItems.longFallBoots);
		}
	};

	public static final CreativeTabs PORTAL_ENTITIES = new CreativeTabs("apertureEntities") {
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(PortalItems.robotsPlacer, 1, 0);
		}
	};

	@Override
	public abstract ItemStack getTabIconItem();

}
