package com.cemi.portalreloaded.client.renderer.entity;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.client.renderer.entity.model.TurretModel;
import com.cemi.portalreloaded.entity.EntityTurret;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderEntityTurret extends RenderLivingBase<EntityTurret> {

	private static final ResourceLocation texture = new ResourceLocation(PortalReloaded.MODID,
			"textures/entity/turret.png");
	private static ModelBase model = new TurretModel();

	public RenderEntityTurret(RenderManager renderManager) {
		super(renderManager, model, 1.0f);
		shadowSize = .5f;
	}

	@Override
	protected boolean canRenderName(EntityTurret entity) {
		return false;
	}

	@Override
	public void doRender(EntityTurret entity, double x, double y, double z, float entityYaw, float partialTicks) {
//		GlStateManager.pushMatrix();
//		GlStateManager.rotate(entity.deathTime * 90.0F / 20.0F, 1.0F, 0.0F, 0.0F);
//		GlStateManager.translate((float) x, (float) y+1.5F, (float) z);
//		GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
//		GlStateManager.rotate(entity.prevRotationYaw, 0.0F, 1.0F, 0.0F);
//		GlStateManager.scale(0.06F, 0.06F, 0.06F);
//		bindTexture(texture);
//		model.setRotationAngles(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, entity);
//		model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1F);
//		GlStateManager.disableRescaleNormal();
//		GlStateManager.enableLighting();
//		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTurret entity) {
		return texture;
	}

}
