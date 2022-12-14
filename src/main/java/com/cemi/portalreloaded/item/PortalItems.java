package com.cemi.portalreloaded.item;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.entity.PortalEntities;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class PortalItems {

	public static PortalArmor longFallBoots = new PortalArmor(PortalReloaded.LONGFALL_BOOTS_MATERIAL,
			EntityEquipmentSlot.FEET, "longfall_boots");

	public static PortalEntityPlacer cubePlacer = new PortalEntityPlacer("cube_placer", PortalEntities.CUBE_PLACERS);
	public static PortalEntityPlacer robotsPlacer = new PortalEntityPlacer("robots_placer",
			PortalEntities.ROBOTS_PLACERS);

	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(longFallBoots, cubePlacer, robotsPlacer);
	}

	public static void registerModels() {
		longFallBoots.registerItemModel();
		cubePlacer.registerItemModel();
		robotsPlacer.registerItemModel();
	}
}
