package com.cemi.portalreloaded.client.renderer.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class WheatleyModel extends ModelBase {
	private final ModelRenderer innerCore;
	private final ModelRenderer outerCore;
	private final ModelRenderer right;
	private final ModelRenderer left;
	private final ModelRenderer front;
	private final ModelRenderer aj;
	private final ModelRenderer bottom;
	private final ModelRenderer top;
	private final ModelRenderer back;
	private final ModelRenderer handle;
	private final ModelRenderer upper;
	private final ModelRenderer lower;

	public WheatleyModel() {
		textureWidth = 50;
		textureHeight = 50;

		innerCore = new ModelRenderer(this);
		innerCore.setRotationPoint(0.0F, 0.0F, 0.0F);
		innerCore.cubeList.add(new ModelBox(innerCore, 22, 0, -3.0F, -8.0F, -3.0F, 7, 7, 7, 0.0F, true));
		innerCore.cubeList.add(new ModelBox(innerCore, 42, 47, -1.0F, -5.5F, -3.5F, 3, 2, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 44, 43, -0.5F, -6.0F, -3.5F, 2, 3, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 38, 14, -2.0F, -8.0F, 4.0F, 5, 7, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 30, 48, -2.0F, -8.0F, -4.0F, 5, 1, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 30, 48, -2.0F, -2.0F, -4.0F, 5, 1, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 22, 48, -2.0F, -7.0F, -4.0F, 1, 1, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 22, 48, 2.0F, -7.0F, -4.0F, 1, 1, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 22, 48, 2.0F, -3.0F, -4.0F, 1, 1, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 22, 48, -2.0F, -3.0F, -4.0F, 1, 1, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 46, 0, -3.0F, -7.0F, 4.0F, 1, 5, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 26, 44, -3.0F, -7.0F, -4.0F, 1, 5, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 26, 44, 3.0F, -7.0F, -4.0F, 1, 5, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 46, 0, 3.0F, -7.0F, 4.0F, 1, 5, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 26, 26, -3.0F, -1.0F, -2.0F, 7, 1, 5, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 26, 26, -3.0F, -9.0F, -2.0F, 7, 1, 5, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 38, 0, -2.0F, -9.0F, 3.0F, 5, 1, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 38, 0, -2.0F, -9.0F, -3.0F, 5, 1, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 38, 0, -2.0F, -1.0F, -3.0F, 5, 1, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 38, 0, -2.0F, -1.0F, 3.0F, 5, 1, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 38, 14, -4.0F, -8.0F, -2.0F, 1, 7, 5, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 26, 14, 4.0F, -8.0F, -2.0F, 1, 7, 5, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 46, 0, 4.0F, -7.0F, 3.0F, 1, 5, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 46, 0, 4.0F, -7.0F, -3.0F, 1, 5, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 46, 0, -4.0F, -7.0F, -3.0F, 1, 5, 1, 0.0F, false));
		innerCore.cubeList.add(new ModelBox(innerCore, 46, 0, -4.0F, -7.0F, 3.0F, 1, 5, 1, 0.0F, false));

		outerCore = new ModelRenderer(this);
		outerCore.setRotationPoint(0.0F, 1.0F, 0.0F);

		right = new ModelRenderer(this);
		right.setRotationPoint(0.0F, 0.0F, 0.0F);
		outerCore.addChild(right);
		right.cubeList.add(new ModelBox(right, 0, 30, 5.0F, -8.0F, -3.0F, 1, 5, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 0, 30, 5.0F, -8.0F, 3.0F, 1, 5, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 4, 30, 5.0F, -3.0F, -2.0F, 1, 1, 5, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 18, 44, 5.0F, -4.0F, 2.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 18, 44, 5.0F, -4.0F, -2.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 18, 44, 5.0F, -8.0F, -2.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 18, 44, 5.0F, -8.0F, 2.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 4, 30, 5.0F, -9.0F, -2.0F, 1, 1, 5, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 31, 45, 3.0F, -10.0F, 3.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 4, 30, 4.0F, -10.0F, -2.0F, 1, 1, 5, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 18, 44, 4.0F, -9.0F, -3.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 18, 44, 4.0F, -3.0F, -3.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 4, 30, 4.0F, -2.0F, -2.0F, 1, 1, 5, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 18, 44, 4.0F, -3.0F, 3.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 31, 45, 3.0F, -2.0F, -3.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 18, 44, 4.0F, -9.0F, 3.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 31, 45, 3.0F, -2.0F, 3.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 18, 35, 3.0F, -11.0F, -2.0F, 1, 1, 5, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 31, 45, 3.0F, -10.0F, -3.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 0, 30, 4.0F, -8.0F, 4.0F, 1, 5, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 31, 45, 3.0F, -3.0F, 4.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 31, 45, 3.0F, -9.0F, 4.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 18, 35, 3.0F, -1.0F, -2.0F, 1, 1, 5, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 31, 45, 3.0F, -9.0F, -4.0F, 1, 1, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 0, 30, 4.0F, -8.0F, -4.0F, 1, 5, 1, 0.0F, false));
		right.cubeList.add(new ModelBox(right, 31, 45, 3.0F, -3.0F, -4.0F, 1, 1, 1, 0.0F, false));

		left = new ModelRenderer(this);
		left.setRotationPoint(0.0F, 0.0F, 0.0F);
		outerCore.addChild(left);
		left.cubeList.add(new ModelBox(left, 0, 30, -5.0F, -8.0F, 3.0F, 1, 5, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 18, 44, -5.0F, -8.0F, 2.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 18, 44, -5.0F, -8.0F, -2.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 18, 44, -5.0F, -4.0F, -2.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 18, 44, -5.0F, -4.0F, 2.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 0, 30, -5.0F, -8.0F, -3.0F, 1, 5, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 4, 30, -5.0F, -3.0F, -2.0F, 1, 1, 5, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 4, 30, -5.0F, -9.0F, -2.0F, 1, 1, 5, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 18, 44, -4.0F, -9.0F, 3.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 31, 45, -3.0F, -10.0F, -3.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 31, 45, -3.0F, -10.0F, 3.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 18, 44, -4.0F, -3.0F, -3.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 0, 30, -4.0F, -8.0F, -4.0F, 1, 5, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 31, 45, -3.0F, -3.0F, -4.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 18, 44, -4.0F, -9.0F, -3.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 18, 44, -4.0F, -3.0F, 3.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 31, 45, -3.0F, -2.0F, 3.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 4, 30, -4.0F, -2.0F, -2.0F, 1, 1, 5, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 18, 35, -3.0F, -11.0F, -2.0F, 1, 1, 5, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 4, 30, -4.0F, -10.0F, -2.0F, 1, 1, 5, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 31, 45, -3.0F, -3.0F, 4.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 0, 30, -4.0F, -8.0F, 4.0F, 1, 5, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 31, 45, -3.0F, -9.0F, 4.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 18, 35, -3.0F, -1.0F, -2.0F, 1, 1, 5, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 31, 45, -3.0F, -9.0F, -4.0F, 1, 1, 1, 0.0F, false));
		left.cubeList.add(new ModelBox(left, 31, 45, -3.0F, -2.0F, -3.0F, 1, 1, 1, 0.0F, false));

		front = new ModelRenderer(this);
		front.setRotationPoint(0.0F, 0.0F, 0.0F);
		outerCore.addChild(front);

		aj = new ModelRenderer(this);
		aj.setRotationPoint(0.0F, 0.0F, 0.0F);
		front.addChild(aj);
		aj.cubeList.add(new ModelBox(aj, 6, 18, -3.0F, -8.0F, -5.0F, 1, 5, 1, 0.0F, false));
		aj.cubeList.add(new ModelBox(aj, 15, 29, 3.0F, -8.0F, -5.0F, 1, 5, 1, 0.0F, false));
		aj.cubeList.add(new ModelBox(aj, 0, 14, -2.0F, -3.0F, -5.0F, 5, 1, 1, 0.0F, false));
		aj.cubeList.add(new ModelBox(aj, 36, 43, 2.0F, -4.0F, -5.0F, 1, 1, 1, 0.0F, false));
		aj.cubeList.add(new ModelBox(aj, 36, 43, -2.0F, -4.0F, -5.0F, 1, 1, 1, 0.0F, false));
		aj.cubeList.add(new ModelBox(aj, 36, 45, -2.0F, -8.0F, -5.0F, 1, 1, 1, 0.0F, false));
		aj.cubeList.add(new ModelBox(aj, 36, 45, 2.0F, -8.0F, -5.0F, 1, 1, 1, 0.0F, false));
		aj.cubeList.add(new ModelBox(aj, 12, 25, -2.0F, -9.0F, -4.5F, 5, 2, 1, 0.0F, false));
		aj.cubeList.add(new ModelBox(aj, 12, 25, -2.0F, -4.0F, -4.5F, 5, 2, 1, 0.0F, false));
		aj.cubeList.add(new ModelBox(aj, 0, 16, -2.0F, -9.0F, -5.0F, 5, 1, 1, 0.0F, false));

		bottom = new ModelRenderer(this);
		bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
		outerCore.addChild(bottom);
		bottom.cubeList.add(new ModelBox(bottom, 0, 40, -2.0F, -1.0F, -3.0F, 5, 1, 7, 0.0F, false));
		bottom.cubeList.add(new ModelBox(bottom, 0, 36, -2.0F, -2.0F, -4.0F, 5, 1, 1, 0.0F, false));
		bottom.cubeList.add(new ModelBox(bottom, 0, 38, -2.0F, -2.0F, 4.0F, 5, 1, 1, 0.0F, false));

		top = new ModelRenderer(this);
		top.setRotationPoint(0.0F, 0.0F, 0.0F);
		outerCore.addChild(top);
		top.cubeList.add(new ModelBox(top, 0, 36, -2.0F, -10.0F, -4.0F, 5, 1, 1, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 40, -2.0F, -11.0F, -3.0F, 5, 1, 7, 0.0F, false));
		top.cubeList.add(new ModelBox(top, 0, 38, -2.0F, -10.0F, 4.0F, 5, 1, 1, 0.0F, false));

		back = new ModelRenderer(this);
		back.setRotationPoint(0.0F, 0.0F, 0.0F);
		outerCore.addChild(back);
		back.cubeList.add(new ModelBox(back, 0, 18, 3.0F, -8.0F, 5.0F, 1, 5, 1, 0.0F, false));
		back.cubeList.add(new ModelBox(back, 18, 41, -2.0F, -3.0F, 5.0F, 5, 1, 1, 0.0F, false));
		back.cubeList.add(new ModelBox(back, 0, 18, -3.0F, -8.0F, 5.0F, 1, 5, 1, 0.0F, false));
		back.cubeList.add(new ModelBox(back, 18, 41, -2.0F, -9.0F, 5.0F, 5, 1, 1, 0.0F, false));
		back.cubeList.add(new ModelBox(back, 18, 44, -2.0F, -8.0F, 5.0F, 1, 1, 1, 0.0F, false));
		back.cubeList.add(new ModelBox(back, 18, 44, 2.0F, -8.0F, 5.0F, 1, 1, 1, 0.0F, false));
		back.cubeList.add(new ModelBox(back, 18, 44, 2.0F, -4.0F, 5.0F, 1, 1, 1, 0.0F, false));
		back.cubeList.add(new ModelBox(back, 18, 44, -2.0F, -4.0F, 5.0F, 1, 1, 1, 0.0F, false));

		handle = new ModelRenderer(this);
		handle.setRotationPoint(0.0F, 0.0F, 0.0F);

		upper = new ModelRenderer(this);
		upper.setRotationPoint(0.5F, -8.5F, 0.0F);
		handle.addChild(upper);
		setRotationAngle(upper, -0.2618F, 0.0F, 0.0F);
		upper.cubeList.add(new ModelBox(upper, 30, 32, -4.5F, -0.5F, -7.0F, 9, 1, 1, 0.0F, false));
		upper.cubeList.add(new ModelBox(upper, 30, 34, 4.5F, -0.5F, -6.0F, 1, 1, 6, 0.0F, false));
		upper.cubeList.add(new ModelBox(upper, 30, 34, -5.5F, -0.5F, -6.0F, 1, 1, 6, 0.0F, false));

		lower = new ModelRenderer(this);
		lower.setRotationPoint(0.5F, -2.5F, 0.0F);
		handle.addChild(lower);
		setRotationAngle(lower, 0.2618F, 0.0F, 0.0F);
		lower.cubeList.add(new ModelBox(lower, 30, 32, -4.5F, -0.5F, -7.0F, 9, 1, 1, 0.0F, false));
		lower.cubeList.add(new ModelBox(lower, 30, 34, -5.5F, -0.5F, -6.0F, 1, 1, 6, 0.0F, false));
		lower.cubeList.add(new ModelBox(lower, 30, 34, 4.5F, -0.5F, -6.0F, 1, 1, 6, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		innerCore.render(f5);
		outerCore.render(f5);
		handle.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}