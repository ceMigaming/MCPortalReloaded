package com.cemi.portalreloaded.client.renderer.entity;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.client.renderer.entity.model.HEPModel;
import com.cemi.portalreloaded.client.renderer.entity.model.WheatleyModel;
import com.cemi.portalreloaded.entity.EntityWheatley;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderEntityWheatley extends Render<EntityWheatley> {

	private static final ResourceLocation texture = new ResourceLocation(PortalReloaded.MODID,
			"textures/entity/wheatley.png");
	private ModelBase model;

	public RenderEntityWheatley(RenderManager renderManager) {
		super(renderManager);
		model = new WheatleyModel();
	}

	@Override
	public void doRender(EntityWheatley entity, double x, double y, double z, float entityYaw, float partialTicks) {

		this.bindEntityTexture(entity);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.pushMatrix();
		GlStateManager.disableLighting();
		GlStateManager.translate((float) x - 0.03125F, (float) y + 0.6875F, (float) z);
		GlStateManager.rotate(180 - entity.prevRotationYaw, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(-entity.prevRotationPitch, 1.0F, 0.0F, 0.0F);
		GlStateManager.scale(0.1F, 0.1F, 0.1F);
		bindTexture(texture);
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1F);
		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityWheatley entity) {
		return texture;
	}
}
