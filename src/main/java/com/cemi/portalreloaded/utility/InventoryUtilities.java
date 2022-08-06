package com.cemi.portalreloaded.utility;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InventoryUtilities {

	public static int findItem(InventoryPlayer inventoryIn, Item itemIn) {
		for (int i = 0; i < 36; i++) {
			if (!inventoryIn.getStackInSlot(i).isEmpty() && inventoryIn.getStackInSlot(i).getItem() == itemIn)
				return i;
		}
		System.out.println();
		return -1;
	}
}
