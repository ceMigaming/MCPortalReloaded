package com.cemi.portalreloaded.client.renderer.entity;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.client.renderer.entity.model.HEPModel;
import com.cemi.portalreloaded.entity.EntityHEP;
import com.cemi.portalreloaded.entity.EntityRocket;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderEntityRocket extends Render<EntityRocket> {

	private static final ResourceLocation texture = new ResourceLocation(PortalReloaded.MODID,
			"textures/entity/hep.png");
	private ModelBase model;

	public RenderEntityRocket(RenderManager renderManager) {
		super(renderManager);
		model = new HEPModel();
	}

	@Override
	public void doRender(EntityRocket entity, double x, double y, double z, float entityYaw, float partialTicks) {
		this.bindEntityTexture(entity);
		GlStateManager.pushMatrix();
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		GlStateManager.disableLighting();
		GlStateManager.translate((float) x, (float) y + 0.2F, (float) z);
		GlStateManager.scale(0.1F, 0.1F, 0.1F);
		bindTexture(texture);
		GlStateManager.color(1.0F, 1.0F, 1.0F, entity.getLifeTime() > 80 ? 1F : ((float) entity.getLifeTime() / 80.0F));
		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1F);
		GlStateManager.color(0.67843137254F, 0.57647058823F, 0.85490196078F,
				entity.getLifeTime() > 80 ? 1F : ((float) entity.getLifeTime() / 80.0F));
		((HEPModel) model).renderBubble();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		GlStateManager.disableAlpha();
		GlStateManager.disableBlend();
		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityRocket entity) {
		return texture;
	}

}
