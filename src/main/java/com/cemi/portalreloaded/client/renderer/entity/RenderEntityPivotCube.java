package com.cemi.portalreloaded.client.renderer.entity;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.client.renderer.entity.model.PivotCubeModel;
import com.cemi.portalreloaded.client.renderer.entity.model.StorageCubeModel;
import com.cemi.portalreloaded.client.renderer.utility.LineRenderer;
import com.cemi.portalreloaded.entity.EntityPivotCube;
import com.cemi.portalreloaded.entity.EntityStorageCube;

import me.ichun.mods.ichunutil.common.grab.GrabHandler;
import me.ichun.mods.ichunutil.common.module.worldportals.common.portal.WorldPortal;
import me.ichun.mods.portalgun.common.PortalGun;
import me.ichun.mods.portalgun.common.portal.PortalGunGrabHandler;
import me.ichun.mods.portalgun.common.portal.world.PortalPlacement;
import me.ichun.mods.portalgun.common.tileentity.TilePortalBase;
import me.ichun.mods.portalgun.common.tileentity.TilePortalMaster;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraftforge.fml.relauncher.Side;
import scala.tools.nsc.interpreter.Results;

public class RenderEntityPivotCube extends RenderLivingBase<EntityPivotCube> {

	Minecraft mc;
	LineRenderer lineRenderer;

	private static final ResourceLocation texture = new ResourceLocation(PortalReloaded.MODID,
			"textures/entity/pivot_cube.png");
	private static ModelBase model = new PivotCubeModel();

	public RenderEntityPivotCube(RenderManager renderManagerIn) {
		super(renderManagerIn, model, 1.0f);
		mc = Minecraft.getMinecraft();
		lineRenderer = new LineRenderer(mc);
	}

	@Override
	protected boolean canRenderName(EntityPivotCube entity) {
		return false;
	}
	
	@Override
	public void doRender(EntityPivotCube entity, double x, double y, double z, float entityYaw, float partialTicks) {
		RayTraceResult result = entity.getRayTraceResult();
		if (result != null) {
			lineRenderer.render(new Vec3d(entity.posX - .5d, entity.posY + .5d, entity.posZ - .5d),
					result.hitVec.subtract(new Vec3d(-.5d, 1.d, -.5d)), partialTicks);
			Vec3d pairLaserStart = entity.getPairLaserStart();
			Vec3d pairLaserEnd = entity.getPairLaserEnd();
			if (pairLaserStart != null && pairLaserEnd != null) {
				lineRenderer.render(pairLaserStart.addVector(-0d, -0d, -0d), pairLaserEnd, partialTicks);
			}

		}
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	@Override
	public boolean shouldRender(EntityPivotCube livingEntity, ICamera camera, double camX, double camY, double camZ) {
		AxisAlignedBB axisalignedbb = livingEntity.getRenderBoundingBox().grow(0.5D);

		if (axisalignedbb.hasNaN() || axisalignedbb.getAverageEdgeLength() == 0.0D) {
			axisalignedbb = new AxisAlignedBB(livingEntity.posX - 2.0D, livingEntity.posY - 2.0D,
					livingEntity.posZ - 2.0D, livingEntity.posX + 2.0D, livingEntity.posY + 2.0D,
					livingEntity.posZ + 2.0D);
		}

		return livingEntity.isInRangeToRender3d(camX, camY, camZ)
				&& (livingEntity.ignoreFrustumCheck || camera.isBoundingBoxInFrustum(axisalignedbb));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPivotCube entity) {
		return texture;
	}

}
