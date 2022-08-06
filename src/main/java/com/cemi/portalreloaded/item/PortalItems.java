package com.cemi.portalreloaded.item;

import com.cemi.portalreloaded.PortalReloaded;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class PortalItems {

	public static PortalArmor longFallBoots = new PortalArmor(PortalReloaded.LONGFALL_BOOTS_MATERIAL, EntityEquipmentSlot.FEET, "longfall_boots");
	
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				longFallBoots
		);
	}
	
	public static void registerModels() {
		longFallBoots.registerItemModel();
	}
}
