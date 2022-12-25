package com.cemi.portalreloaded.utility;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class Math {
	public static Vec3d floor(Vec3d vec) {
		return new Vec3d(java.lang.Math.floor(vec.x), java.lang.Math.floor(vec.y), java.lang.Math.floor(vec.z));
	}

	public static double angle(Vec3d vec1, Vec3d vec2) {
		return java.lang.Math.atan2(vec2.z - vec1.z, vec2.x - vec1.x);
	}

	public static Vec3d reflect(Vec3d vec, Vec3d normal, Vec3d upDir) {
		vec = vec.addVector(-.5d, -.5d, -.5d);
		return new Vec3d(normal.z == 0 && upDir.z != 0 ? vec.x : -vec.x, vec.y,
				normal.x == 0 || upDir.x != 0 ? vec.z : -vec.z).addVector(.5d, .5d, .5d);
	}

	public static boolean isEntityLookingAtPlayer(Entity entity, EntityPlayer player, double angle, float offset) {
		Vec3d entityLook = getVectorForRotation(entity.rotationPitch, entity.getRotationYawHead() - offset);
		Vec3d entityToPlayer = player.getPositionVector().subtract(entity.getPositionVector()).normalize();
		double dotProduct = entityLook.dotProduct(entityToPlayer);
		return java.lang.Math.acos(dotProduct) <= java.lang.Math.toRadians(angle / 2.0);
	}

	public static Vec3d getVectorForRotation(float pitch, float yaw) {
		float f = MathHelper.cos(-yaw * 0.017453292F - (float) java.lang.Math.PI);
		float f1 = MathHelper.sin(-yaw * 0.017453292F - (float) java.lang.Math.PI);
		float f2 = -MathHelper.cos(-pitch * 0.017453292F);
		float f3 = MathHelper.sin(-pitch * 0.017453292F);
		return new Vec3d((double) (f1 * f2), (double) f3, (double) (f * f2));
	}
}
