package com.cemi.portalreloaded.client.renderer.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class HEPModel extends ModelBase {
	private final ModelRenderer bubble;
	private final ModelRenderer bb_main;

	public HEPModel() {
		textureWidth = 16;
		textureHeight = 16;

		bubble = new ModelRenderer(this);
		bubble.setRotationPoint(0.0F, 0.0F, 0.0F);
		bubble.cubeList.add(new ModelBox(bubble, 0, 0, -1.0F, 1.0F, -1.0F, 2, 1, 2, 0.0F, false));
		bubble.cubeList.add(new ModelBox(bubble, 0, 0, -1.0F, -2.0F, -1.0F, 2, 1, 2, 0.0F, false));
		bubble.cubeList.add(new ModelBox(bubble, 0, 0, -1.0F, -1.0F, -2.0F, 2, 2, 1, 0.0F, false));
		bubble.cubeList.add(new ModelBox(bubble, 0, 0, -1.0F, -1.0F, 1.0F, 2, 2, 1, 0.0F, false));
		bubble.cubeList.add(new ModelBox(bubble, 0, 0, -2.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F, false));
		bubble.cubeList.add(new ModelBox(bubble, 0, 0, 1.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 0.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 8, 12, -1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bb_main.render(f5);
	}
	
	public void renderBubble() {
		bubble.render(1.0F);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}