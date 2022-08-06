package com.cemi.portalreloaded.client.renderer.entity;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.client.renderer.entity.model.CameraModel;
import com.cemi.portalreloaded.client.renderer.entity.model.HEPModel;
import com.cemi.portalreloaded.entity.EntityCamera;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEntityCamera extends Render<EntityCamera> {

	private static final ResourceLocation texture = new ResourceLocation(PortalReloaded.MODID,
			"textures/entity/camera.png");
	private ModelBase model;
	
	public RenderEntityCamera(RenderManager renderManager) {
		super(renderManager);
		model = new CameraModel();
	}

	@Override
	public void doRender(EntityCamera entity, double x, double y, double z, float entityYaw, float partialTicks) {
		this.bindEntityTexture(entity);
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x, (float) y+1.5F, (float) z);
		GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(entity.prevRotationYaw, 0.0F, 1.0F, 0.0F);
		GlStateManager.scale(0.075F, 0.075F, 0.075F);
		bindTexture(texture);
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1F);
		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityCamera entity) {
		return texture;
	}

}
