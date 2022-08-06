package com.cemi.portalreloaded.client.renderer.tesr;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.tileentity.TileEntityBallLauncher;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TESRBallLauncher extends TileEntitySpecialRenderer<TileEntityBallLauncher> {
	@Override
	public void render(TileEntityBallLauncher te, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
		// TODO Auto-generated method stub
		super.render(te, x, y, z, partialTicks, destroyStage, alpha);
	}
}
