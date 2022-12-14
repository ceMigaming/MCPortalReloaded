package com.cemi.portalreloaded.utility;

import java.util.ArrayList;
import java.util.List;

import com.cemi.portalreloaded.PortalReloaded;

import net.minecraft.util.math.BlockPos;

public class ListHelper {
	public static boolean contains(List<BlockPos> list, BlockPos pos) {
		// System.out.println(pos);
		// print(list);
		return indexOf(list, pos) >= 0;
	}

	public static int indexOf(List<BlockPos> list, BlockPos pos) {
		if (pos == null) {
			for (int i = 0; i < list.size(); i++)
				if (list.get(i) == null)
					return i;
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (pos.getX() == list.get(i).getX() && pos.getY() == list.get(i).getY()
						&& pos.getZ() == list.get(i).getZ()) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void print(List<BlockPos> blocks) {
		PortalReloaded.log("");
		PortalReloaded.log("BlockPos list contains: ");
		PortalReloaded.log("");
		PortalReloaded.log("-----------------------------------------");
		for (BlockPos blockPos : blocks) {
			PortalReloaded.log(blockPos);
		}
		PortalReloaded.log("-----------------------------------------");
	}
}
