package com.cemi.portalreloaded.client.renderer.entity.model;

import com.cemi.portalreloaded.entity.EntityTurret;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.1.1
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

public class TurretModel extends ModelBase {
	private final ModelRenderer buddy;
	private final ModelRenderer cube_r1;
	private final ModelRenderer erms;
	private final ModelRenderer lefterm;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer rajterm;
	private final ModelRenderer cube_r4;
	private final ModelRenderer legos;
	private final ModelRenderer leflteg;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer rajtleg;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer backleg;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;

	private float openingTime = 0;

	public TurretModel() {
		textureWidth = 53;
		textureHeight = 54;
		
		buddy = new ModelRenderer(this);
		buddy.setRotationPoint(0.0F, 24.0F, 0.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-1.0F, 0.0F, -1.0F);
		buddy.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.0F);
		cube_r1.cubeList.add(new ModelBox(cube_r1, 33, 43, -2.0F, -19.5F, 0.0F, 1, 2, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 12, 50, 1.05F, -22.0F, 0.0F, 1, 1, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 4, 50, -0.05F, -22.0F, 0.0F, 1, 1, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 33, 48, 0.5F, -8.9F, -1.0F, 1, 1, 5, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 17, 47, 3.0F, -19.5F, 0.0F, 1, 2, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 25, 50, -0.05F, -12.7F, -1.5F, 2, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 41, 48, -0.6F, -12.9F, -1.5F, 1, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 50, 1.6F, -12.9F, -1.5F, 1, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 52, 1.6F, -15.1F, -1.5F, 1, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 32, 4, -0.6F, -15.1F, -1.5F, 1, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 20, 52, -0.05F, -15.3F, -1.5F, 2, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 3, 51, -0.8F, -12.7F, -2.0F, 1, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 49, 0, 1.8F, -12.7F, -2.0F, 1, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 30, 51, 1.8F, -15.3F, -2.0F, 1, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 41, 50, -0.8F, -15.3F, -2.0F, 1, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 47, 32, -0.8F, -14.5F, -1.5F, 1, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 34, 48, 1.8F, -14.5F, -1.5F, 1, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 38, 26, -1.0F, -18.5F, -2.0F, 1, 11, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 38, 38, 1.05F, -12.5F, -2.0F, 1, 6, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 32, 39, -0.05F, -12.5F, -2.0F, 1, 6, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 45, 48, -0.05F, -19.5F, -2.0F, 1, 5, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 49, 47, 1.05F, -19.5F, -2.0F, 1, 5, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 39, 14, 2.0F, -18.5F, -2.0F, 1, 11, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 16, 46, -1.0F, -19.5F, -1.0F, 1, 3, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 12, 47, -2.0F, -18.5F, -1.0F, 1, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 18, 40, 2.0F, -19.5F, -1.0F, 1, 3, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 8, 47, 3.0F, -18.5F, -1.0F, 1, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 22, 39, -1.0F, -18.0F, -1.0F, 4, 10, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 26, 52, -0.2F, -14.0F, -1.1F, 1, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 9, 50, 0.0F, -13.3F, -1.1F, 2, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 16, 44, 0.0F, -14.7F, -1.1F, 2, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 34, 51, 1.2F, -14.0F, -1.1F, 1, 1, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 22, 39, -1.0F, -18.0F, -1.0F, 4, 10, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 4, 47, -0.05F, -21.0F, -1.0F, 1, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 47, 1.05F, -21.0F, -1.0F, 1, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 40, 0, 1.05F, -19.5F, 4.0F, 1, 13, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 34, 27, 2.0F, -18.5F, 4.0F, 1, 11, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 35, 13, -0.05F, -19.5F, 4.0F, 1, 13, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 36, 0, -1.0F, -18.5F, 4.0F, 1, 11, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 0, 44, -2.0F, -18.5F, 3.0F, 1, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 31, 0, -1.0F, -19.5F, 3.0F, 1, 3, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 24, 27, -1.0F, -18.0F, 3.0F, 4, 10, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 28, 3, 1.05F, -21.0F, 3.0F, 1, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 21, 25, -0.05F, -21.0F, 3.0F, 1, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 10, 31, 2.0F, -19.5F, 3.0F, 1, 3, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 10, 28, 3.0F, -18.5F, 3.0F, 1, 2, 1, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 44, 0, 2.0F, -21.0F, 0.0F, 1, 13, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 43, 16, 0.0F, -21.0F, 0.0F, 2, 13, 3, 0.0F, false));
		cube_r1.cubeList.add(new ModelBox(cube_r1, 42, 32, -1.0F, -21.0F, 0.0F, 1, 13, 3, 0.0F, false));

		erms = new ModelRenderer(this);
		erms.setRotationPoint(0.0F, 24.0F, 0.0F);

		lefterm = new ModelRenderer(this);
		lefterm.setRotationPoint(0.0F, 0.0F, 0.0F);
		erms.addChild(lefterm);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-1.0F, 0.0F, -1.0F);
		lefterm.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.0F);
		cube_r2.cubeList.add(new ModelBox(cube_r2, 15, 26, 4.0F, -17.5F, 0.0F, 1, 11, 3, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 8, 36, 4.0F, -18.5F, 0.5F, 1, 1, 2, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 12, 24, 3.0F, -6.5F, 0.5F, 1, 1, 2, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 6, 26, 3.0F, -17.5F, 2.0F, 1, 11, 1, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 31, 14, 3.0F, -17.5F, 0.0F, 1, 11, 1, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 0, 32, 2.0F, -16.5F, 3.0F, 2, 9, 1, 0.0F, false));
		cube_r2.cubeList.add(new ModelBox(cube_r2, 25, 14, 2.0F, -16.5F, -1.0F, 2, 9, 1, 0.0F, false));

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-7.0F, 0.0F, -1.0F);
		lefterm.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, 0.0F);
		cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 42, 6.75F, -11.5F, 0.0F, 1, 1, 1, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 22, 0, 6.75F, -13.5F, 0.0F, 1, 1, 1, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 16, 24, 4.5F, -14.0F, 1.0F, 2, 1, 1, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 24, 24, 4.5F, -12.0F, 1.0F, 2, 1, 1, 0.0F, false));
		cube_r3.cubeList.add(new ModelBox(cube_r3, 4, 40, 6.5F, -14.5F, 0.5F, 4, 5, 2, 0.0F, false));

		rajterm = new ModelRenderer(this);
		rajterm.setRotationPoint(0.0F, 0.0F, 0.0F);
		erms.addChild(rajterm);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-1.0F, 0.0F, -1.0F);
		rajterm.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.0F);
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 12, -2.0F, -16.5F, 3.0F, 2, 9, 1, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 20, 3, -3.0F, -18.5F, 0.5F, 1, 1, 2, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 6, 12, -3.0F, -17.5F, 0.0F, 1, 11, 3, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 17, 9, -2.0F, -6.5F, 0.5F, 1, 1, 2, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 16, 0, 1.5F, -14.0F, 1.0F, 2, 1, 1, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 11, 13, 1.5F, -12.0F, 1.0F, 2, 1, 1, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 24, 7, -2.5F, -14.5F, 0.5F, 4, 5, 2, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 17, 12, -2.0F, -17.5F, 0.0F, 1, 11, 1, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 21, 13, -2.0F, -17.5F, 2.0F, 1, 11, 1, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 4, 7, 0.25F, -13.5F, 0.0F, 1, 1, 1, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 4, 9, 0.25F, -11.5F, 0.0F, 1, 1, 1, 0.0F, false));
		cube_r4.cubeList.add(new ModelBox(cube_r4, 0, 22, -2.0F, -16.5F, -1.0F, 2, 9, 1, 0.0F, false));

		legos = new ModelRenderer(this);
		legos.setRotationPoint(0.0F, 24.0F, 0.0F);

		leflteg = new ModelRenderer(this);
		leflteg.setRotationPoint(0.0F, -1.0F, 1.0F);
		legos.addChild(leflteg);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(3.0F, 6.0F, -1.0F);
		leflteg.addChild(cube_r5);
		setRotationAngle(cube_r5, -2.3562F, 0.0F, 3.1416F);
		cube_r5.cubeList.add(new ModelBox(cube_r5, 12, 4, 0.0F, -7.5F, 9.5F, 1, 1, 1, 0.0F, false));

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(3.0F, 6.0F, -1.0F);
		leflteg.addChild(cube_r6);
		setRotationAngle(cube_r6, -2.4435F, 0.0F, 3.1416F);
		cube_r6.cubeList.add(new ModelBox(cube_r6, 11, 6, -0.5F, -7.4F, 9.0F, 1, 1, 1, 0.0F, false));
		cube_r6.cubeList.add(new ModelBox(cube_r6, 7, 6, 0.0F, -7.4F, 9.0F, 1, 1, 1, 0.0F, false));

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(3.0F, 6.0F, -1.0F);
		leflteg.addChild(cube_r7);
		setRotationAngle(cube_r7, -2.618F, 0.0F, 3.1416F);
		cube_r7.cubeList.add(new ModelBox(cube_r7, 7, 8, -1.0F, -7.15F, 8.0F, 2, 1, 1, 0.0F, false));

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(3.0F, 6.0F, -1.0F);
		leflteg.addChild(cube_r8);
		setRotationAngle(cube_r8, -2.5307F, 0.0F, 3.1416F);
		cube_r8.cubeList.add(new ModelBox(cube_r8, 7, 10, -1.0F, -7.3F, 8.5F, 2, 1, 1, 0.0F, false));

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-4.0F, 0.0F, -1.0F);
		leflteg.addChild(cube_r9);
		setRotationAngle(cube_r9, 1.0472F, 0.0F, 0.0F);
		cube_r9.cubeList.add(new ModelBox(cube_r9, 20, 0, 6.5F, -6.0F, -5.0F, 1, 1, 6, 0.0F, false));

		rajtleg = new ModelRenderer(this);
		rajtleg.setRotationPoint(0.0F, -1.0F, 1.0F);
		legos.addChild(rajtleg);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-9.0F, 0.0F, -1.0F);
		rajtleg.addChild(cube_r10);
		setRotationAngle(cube_r10, 1.0472F, 0.0F, 0.0F);
		cube_r10.cubeList.add(new ModelBox(cube_r10, 12, 2, 5.5F, -6.0F, -5.0F, 1, 1, 6, 0.0F, false));

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-2.0F, 6.0F, -1.0F);
		rajtleg.addChild(cube_r11);
		setRotationAngle(cube_r11, -2.5307F, 0.0F, 3.1416F);
		cube_r11.cubeList.add(new ModelBox(cube_r11, 12, 9, 0.0F, -7.3F, 8.5F, 2, 1, 1, 0.0F, false));

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-2.0F, 6.0F, -1.0F);
		rajtleg.addChild(cube_r12);
		setRotationAngle(cube_r12, -2.618F, 0.0F, 3.1416F);
		cube_r12.cubeList.add(new ModelBox(cube_r12, 12, 11, 0.0F, -7.15F, 8.0F, 2, 1, 1, 0.0F, false));

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-2.0F, 6.0F, -1.0F);
		rajtleg.addChild(cube_r13);
		setRotationAngle(cube_r13, -2.4435F, 0.0F, 3.1416F);
		cube_r13.cubeList.add(new ModelBox(cube_r13, 7, 4, 0.5F, -7.4F, 9.0F, 1, 1, 1, 0.0F, false));
		cube_r13.cubeList.add(new ModelBox(cube_r13, 14, 2, 0.0F, -7.4F, 9.0F, 1, 1, 1, 0.0F, false));

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-2.0F, 6.0F, -1.0F);
		rajtleg.addChild(cube_r14);
		setRotationAngle(cube_r14, -2.3562F, 0.0F, 3.1416F);
		cube_r14.cubeList.add(new ModelBox(cube_r14, 4, 5, 0.0F, -7.5F, 9.5F, 1, 1, 1, 0.0F, false));

		backleg = new ModelRenderer(this);
		backleg.setRotationPoint(0.0F, 0.0F, 0.0F);
		legos.addChild(backleg);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-1.0F, 0.0F, -1.0F);
		backleg.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.5236F, 0.0F, 0.0F);
		cube_r15.cubeList.add(new ModelBox(cube_r15, 10, 2, 0.5F, -7.5F, 9.5F, 1, 1, 1, 0.0F, false));

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-1.0F, 0.0F, -1.0F);
		backleg.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.4363F, 0.0F, 0.0F);
		cube_r16.cubeList.add(new ModelBox(cube_r16, 4, 2, 0.0F, -7.4F, 9.0F, 2, 1, 1, 0.0F, false));

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-1.0F, 0.0F, -1.0F);
		backleg.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.2618F, 0.0F, 0.0F);
		cube_r17.cubeList.add(new ModelBox(cube_r17, 8, 0, -0.5F, -7.15F, 8.0F, 3, 1, 1, 0.0F, false));
		cube_r17.cubeList.add(new ModelBox(cube_r17, 0, 2, 0.5F, -6.15F, 8.0F, 1, 9, 1, 0.0F, false));

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-1.0F, 0.0F, -1.0F);
		backleg.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.3491F, 0.0F, 0.0F);
		cube_r18.cubeList.add(new ModelBox(cube_r18, 0, 0, -0.5F, -7.3F, 8.5F, 3, 1, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		buddy.render(scale);
		erms.render(scale);
		legos.render(scale);
	}

	private void openLeftArm(float t) {
		this.lefterm.offsetX = (float) MathHelper.clampedLerp(0, 4.d / 16.d, t);
	}

	private void openRightArm(float t) {
		this.rajterm.offsetX = (float) MathHelper.clampedLerp(0, -4.d / 16.d, t);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch, float scaleFactor, Entity entityIn) {
		EntityTurret turret = (EntityTurret) entityIn;
		if (turret.shouldOpen && !turret.isOpen) {
			if (openingTime >= 1)
				openingTime = 1;
			openingTime += turret.openingSpeed;
		} else if(!turret.shouldOpen) {
			if(openingTime <= 0)
				openingTime = 0;
			openingTime -= turret.openingSpeed;
		}
		openLeftArm(openingTime);
		openRightArm(openingTime);

	}
}