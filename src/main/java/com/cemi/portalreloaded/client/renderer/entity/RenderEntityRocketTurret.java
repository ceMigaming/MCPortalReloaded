package com.cemi.portalreloaded.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.client.renderer.entity.model.TurretModel;
import com.cemi.portalreloaded.entity.EntityRocketTurret;
import com.cemi.portalreloaded.entity.EntityTurret;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;

public class RenderEntityRocketTurret extends RenderLivingBase<EntityRocketTurret> {

	private static final ResourceLocation texture = new ResourceLocation(PortalReloaded.MODID,
			"textures/entity/turret.png");
	private static ModelBase model = new TurretModel();

	public RenderEntityRocketTurret(RenderManager renderManager) {
		super(renderManager, model, 1.0f);
		shadowSize = .5f;
	}

	@Override
	protected boolean canRenderName(EntityRocketTurret entity) {
		return false;
	}

	@Override
	public void doRender(EntityRocketTurret entity, double x, double y, double z, float entityYaw, float partialTicks) {
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
	protected ResourceLocation getEntityTexture(EntityRocketTurret entity) {
		return texture;
	}

}
