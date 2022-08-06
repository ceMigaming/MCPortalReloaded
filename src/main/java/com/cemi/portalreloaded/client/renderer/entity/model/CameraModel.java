package com.cemi.portalreloaded.client.renderer.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.1.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public class CameraModel extends ModelBase {
	private final ModelRenderer camera;
	private final ModelRenderer moveable;
	private final ModelRenderer jajo;
	private final ModelRenderer srod;
	private final ModelRenderer zew;
	private final ModelRenderer socz;
	private final ModelRenderer tyl;
	private final ModelRenderer rk;
	private final ModelRenderer uch;
	private final ModelRenderer nier;
	private final ModelRenderer ins;
	private final ModelRenderer outs;

	public CameraModel() {
		textureWidth = 50;
		textureHeight = 50;

		camera = new ModelRenderer(this);
		camera.setRotationPoint(0.0F, 8.0F, 0.0F);
		

		moveable = new ModelRenderer(this);
		moveable.setRotationPoint(-1.0F, 1.0F, 1.0F);
		camera.addChild(moveable);
		

		jajo = new ModelRenderer(this);
		jajo.setRotationPoint(7.0F, 10.0F, -1.0F);
		moveable.addChild(jajo);
		setRotationAngle(jajo, 0.0F, 3.1416F, 0.0F);
		

		srod = new ModelRenderer(this);
		srod.setRotationPoint(0.0F, 0.0F, 0.0F);
		jajo.addChild(srod);
		srod.cubeList.add(new ModelBox(srod, 0, 11, 0.5F, -8.5F, -3.0F, 1, 3, 2, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 0, 6, 4.5F, -8.5F, -3.0F, 1, 3, 2, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 0, 0, 1.5F, -5.5F, -3.0F, 3, 1, 2, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 36, 0, 1.5F, -9.5F, -3.0F, 3, 2, 2, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 32, 11, 1.0F, -9.0F, -3.0F, 1, 1, 2, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 35, 21, 4.0F, -9.0F, -3.0F, 1, 1, 2, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 41, 21, 4.0F, -6.0F, -3.0F, 1, 1, 2, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 40, 24, 1.0F, -6.0F, -3.0F, 1, 1, 2, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 20, 0, 1.0F, -8.0F, -3.5F, 1, 2, 1, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 46, 12, 4.0F, -8.0F, -3.5F, 1, 2, 1, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 25, 0, 1.5F, -8.5F, -3.5F, 3, 3, 1, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 44, 8, 2.0F, -6.0F, -3.5F, 2, 1, 1, 0.0F, false));
		srod.cubeList.add(new ModelBox(srod, 8, 5, 2.0F, -9.0F, -3.5F, 2, 1, 1, 0.0F, false));

		zew = new ModelRenderer(this);
		zew.setRotationPoint(0.0F, 0.0F, 0.0F);
		jajo.addChild(zew);
		zew.cubeList.add(new ModelBox(zew, 0, 32, 1.0F, -5.0F, -2.5F, 4, 1, 7, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 0, 24, 1.0F, -10.0F, -2.5F, 4, 1, 7, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 0, 12, 0.5F, -9.5F, -2.5F, 5, 5, 7, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 17, 17, 5.0F, -9.0F, -2.5F, 1, 4, 7, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 26, 21, 0.0F, -9.0F, -2.5F, 1, 4, 7, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 15, 36, 1.0F, -5.0F, 4.5F, 4, 1, 2, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 15, 33, 1.0F, -10.0F, 4.5F, 4, 1, 2, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 0, 25, 5.0F, -9.0F, 4.5F, 1, 4, 2, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 0, 33, 0.0F, -9.0F, 4.5F, 1, 4, 2, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 20, 28, 0.5F, -5.5F, 4.5F, 1, 1, 2, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 35, 25, 4.5F, -5.5F, 4.5F, 1, 1, 2, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 27, 21, 0.5F, -9.5F, 4.5F, 1, 1, 2, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 0, 16, 4.5F, -9.5F, 4.5F, 1, 1, 2, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 32, 10, -0.5F, -8.5F, -1.5F, 1, 3, 7, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 22, 6, 5.5F, -8.5F, -1.5F, 1, 3, 7, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 8, 3, 1.5F, -10.5F, -1.5F, 3, 1, 7, 0.0F, false));
		zew.cubeList.add(new ModelBox(zew, 8, 3, 1.5F, -4.5F, -1.5F, 3, 1, 7, 0.0F, false));

		socz = new ModelRenderer(this);
		socz.setRotationPoint(0.0F, 0.0F, 1.0F);
		jajo.addChild(socz);
		socz.cubeList.add(new ModelBox(socz, 44, 40, 2.0F, -9.0F, 3.5F, 2, 1, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 44, 38, 2.0F, -6.0F, 3.5F, 2, 1, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 46, 36, 2.5F, -6.5F, 4.0F, 1, 1, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 46, 34, 2.5F, -8.5F, 4.0F, 1, 1, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 46, 32, 3.5F, -7.5F, 4.0F, 1, 1, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 46, 30, 1.5F, -7.5F, 4.0F, 1, 1, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 34, 37, 2.0F, -8.0F, 4.0F, 2, 2, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 46, 27, 4.0F, -8.0F, 3.5F, 1, 2, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 46, 24, 1.0F, -8.0F, 3.5F, 1, 2, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 34, 32, 1.5F, -8.5F, 3.5F, 3, 3, 1, 0.0F, false));

		tyl = new ModelRenderer(this);
		tyl.setRotationPoint(1.0F, -6.0F, -4.0F);
		jajo.addChild(tyl);
		tyl.cubeList.add(new ModelBox(tyl, 46, 0, 0.5F, -1.5F, 0.0F, 1, 1, 1, 0.0F, false));
		tyl.cubeList.add(new ModelBox(tyl, 46, 2, 2.5F, -1.5F, 0.0F, 1, 1, 1, 0.0F, false));
		tyl.cubeList.add(new ModelBox(tyl, 46, 4, 1.5F, -0.5F, 0.0F, 1, 1, 1, 0.0F, false));
		tyl.cubeList.add(new ModelBox(tyl, 46, 6, 1.5F, -2.5F, 0.0F, 1, 1, 1, 0.0F, false));
		tyl.cubeList.add(new ModelBox(tyl, 44, 43, 1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F, false));

		rk = new ModelRenderer(this);
		rk.setRotationPoint(2.0F, 10.0F, -1.0F);
		moveable.addChild(rk);
		setRotationAngle(rk, 0.0F, 3.1416F, 0.0F);
		rk.cubeList.add(new ModelBox(rk, 44, 47, 1.5F, -7.5F, -1.5F, 1, 1, 2, 0.0F, false));
		rk.cubeList.add(new ModelBox(rk, 38, 45, 1.5F, -10.0F, -1.0F, 1, 4, 1, 0.0F, false));

		uch = new ModelRenderer(this);
		uch.setRotationPoint(1.0F, 2.0F, 4.0F);
		camera.addChild(uch);
		setRotationAngle(uch, -1.1345F, 3.1416F, 0.0F);
		uch.cubeList.add(new ModelBox(uch, 34, 36, 1.0F, -3.0F, -5.0F, 2, 1, 6, 0.0F, false));
		uch.cubeList.add(new ModelBox(uch, 34, 36, 1.0F, -5.0F, -5.0F, 2, 1, 6, 0.0F, false));
		uch.cubeList.add(new ModelBox(uch, 22, 34, 0.5F, -4.5F, -5.0F, 3, 2, 6, 0.0F, false));

		nier = new ModelRenderer(this);
		nier.setRotationPoint(1.0F, 4.0F, 7.0F);
		camera.addChild(nier);
		setRotationAngle(nier, 0.0F, 3.1416F, 0.0F);
		

		ins = new ModelRenderer(this);
		ins.setRotationPoint(-2.0F, -8.0F, 0.0F);
		nier.addChild(ins);
		ins.cubeList.add(new ModelBox(ins, 0, 45, 2.0F, 0.0F, -0.5F, 4, 4, 1, 0.0F, false));
		ins.cubeList.add(new ModelBox(ins, 10, 47, 6.0F, 1.0F, -0.5F, 1, 2, 1, 0.0F, false));
		ins.cubeList.add(new ModelBox(ins, 10, 47, 1.0F, 1.0F, -0.5F, 1, 2, 1, 0.0F, false));
		ins.cubeList.add(new ModelBox(ins, 10, 45, 3.0F, 4.0F, -0.5F, 2, 1, 1, 0.0F, false));
		ins.cubeList.add(new ModelBox(ins, 10, 45, 3.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F, false));
		ins.cubeList.add(new ModelBox(ins, 14, 45, 3.5F, 2.0F, 0.0F, 1, 1, 4, 0.0F, false));
		ins.cubeList.add(new ModelBox(ins, 14, 45, 3.5F, 1.0F, 0.0F, 1, 1, 4, 0.0F, false));
		ins.cubeList.add(new ModelBox(ins, 0, 40, 3.0F, 1.5F, 0.0F, 2, 1, 4, 0.0F, false));

		outs = new ModelRenderer(this);
		outs.setRotationPoint(0.0F, 0.0F, 0.0F);
		nier.addChild(outs);
		outs.cubeList.add(new ModelBox(outs, 24, 43, -1.0F, -9.0F, -1.0F, 6, 6, 1, 0.0F, false));
		outs.cubeList.add(new ModelBox(outs, 20, 44, -2.0F, -8.0F, -1.0F, 1, 4, 1, 0.0F, false));
		outs.cubeList.add(new ModelBox(outs, 20, 44, 5.0F, -8.0F, -1.0F, 1, 4, 1, 0.0F, false));
		outs.cubeList.add(new ModelBox(outs, 8, 42, 0.0F, -3.0F, -1.0F, 4, 1, 1, 0.0F, false));
		outs.cubeList.add(new ModelBox(outs, 8, 42, 0.0F, -10.0F, -1.0F, 4, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		camera.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
