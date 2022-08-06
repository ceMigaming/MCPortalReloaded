package com.cemi.portalreloaded.client.renderer.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class StorageCubeModel extends ModelBase {
	private final ModelRenderer pboczki;
	private final ModelRenderer front;
	private final ModelRenderer corners;
	private final ModelRenderer lg;
	private final ModelRenderer pg;
	private final ModelRenderer ld;
	private final ModelRenderer pd;
	private final ModelRenderer sides;
	private final ModelRenderer back;
	private final ModelRenderer sides2;
	private final ModelRenderer lg2;
	private final ModelRenderer pg2;
	private final ModelRenderer ld2;
	private final ModelRenderer pd2;
	private final ModelRenderer sides3;
	private final ModelRenderer bb_main;

	public StorageCubeModel() {
		textureWidth = 60;
		textureHeight = 36;

		pboczki = new ModelRenderer(this);
		pboczki.setRotationPoint(0.0F, 24.0F, 0.0F);
		pboczki.cubeList.add(new ModelBox(pboczki, 0, 0, 5.0F, -16.0F, -2.0F, 3, 1, 4, 0.0F, false));
		pboczki.cubeList.add(new ModelBox(pboczki, 0, 0, 7.0F, -15.0F, -2.0F, 1, 2, 4, 0.0F, false));
		pboczki.cubeList.add(new ModelBox(pboczki, 0, 0, 7.0F, -3.0F, -2.0F, 1, 2, 4, 0.0F, false));
		pboczki.cubeList.add(new ModelBox(pboczki, 0, 0, 5.0F, -1.0F, -2.0F, 3, 1, 4, 0.0F, false));
		pboczki.cubeList.add(new ModelBox(pboczki, 0, 0, -8.0F, -3.0F, -2.0F, 1, 2, 4, 0.0F, false));
		pboczki.cubeList.add(new ModelBox(pboczki, 0, 0, -8.0F, -1.0F, -2.0F, 3, 1, 4, 0.0F, false));
		pboczki.cubeList.add(new ModelBox(pboczki, 0, 0, -8.0F, -15.0F, -2.0F, 1, 2, 4, 0.0F, false));
		pboczki.cubeList.add(new ModelBox(pboczki, 0, 0, -8.0F, -16.0F, -2.0F, 3, 1, 4, 0.0F, false));

		front = new ModelRenderer(this);
		front.setRotationPoint(0.0F, 24.0F, 0.0F);
		

		corners = new ModelRenderer(this);
		corners.setRotationPoint(0.0F, 0.0F, 0.0F);
		front.addChild(corners);
		

		lg = new ModelRenderer(this);
		lg.setRotationPoint(0.0F, 0.0F, 0.0F);
		corners.addChild(lg);
		lg.cubeList.add(new ModelBox(lg, 0, 0, -8.0F, -16.0F, -8.0F, 5, 3, 1, 0.0F, false));
		lg.cubeList.add(new ModelBox(lg, 0, 0, -8.0F, -13.0F, -8.0F, 3, 2, 1, 0.0F, false));
		lg.cubeList.add(new ModelBox(lg, 0, 0, -5.0F, -13.0F, -8.0F, 1, 1, 1, 0.0F, false));
		lg.cubeList.add(new ModelBox(lg, 0, 0, -8.0F, -13.0F, -5.0F, 1, 1, 1, 0.0F, false));
		lg.cubeList.add(new ModelBox(lg, 0, 0, -8.0F, -16.0F, -7.0F, 1, 3, 4, 0.0F, false));
		lg.cubeList.add(new ModelBox(lg, 0, 0, -8.0F, -13.0F, -7.0F, 1, 2, 2, 0.0F, false));
		lg.cubeList.add(new ModelBox(lg, 0, 0, -7.0F, -16.0F, -5.0F, 2, 1, 2, 0.0F, false));
		lg.cubeList.add(new ModelBox(lg, 0, 0, -5.0F, -16.0F, -5.0F, 1, 1, 1, 0.0F, false));
		lg.cubeList.add(new ModelBox(lg, 0, 0, -7.0F, -16.0F, -7.0F, 4, 1, 2, 0.0F, false));

		pg = new ModelRenderer(this);
		pg.setRotationPoint(11.0F, 0.0F, 0.0F);
		corners.addChild(pg);
		pg.cubeList.add(new ModelBox(pg, 0, 0, -8.0F, -16.0F, -8.0F, 5, 3, 1, 0.0F, false));
		pg.cubeList.add(new ModelBox(pg, 0, 0, -6.0F, -13.0F, -8.0F, 3, 2, 1, 0.0F, false));
		pg.cubeList.add(new ModelBox(pg, 0, 0, -7.0F, -13.0F, -8.0F, 1, 1, 1, 0.0F, false));
		pg.cubeList.add(new ModelBox(pg, 0, 0, -4.0F, -13.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pg.cubeList.add(new ModelBox(pg, 0, 0, -4.0F, -16.0F, -7.0F, 1, 3, 4, 0.0F, false));
		pg.cubeList.add(new ModelBox(pg, 0, 0, -4.0F, -13.0F, -7.0F, 1, 2, 2, 0.0F, false));
		pg.cubeList.add(new ModelBox(pg, 0, 0, -6.0F, -16.0F, -5.0F, 2, 1, 2, 0.0F, false));
		pg.cubeList.add(new ModelBox(pg, 0, 0, -7.0F, -16.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pg.cubeList.add(new ModelBox(pg, 0, 0, -8.0F, -16.0F, -7.0F, 4, 1, 2, 0.0F, false));

		ld = new ModelRenderer(this);
		ld.setRotationPoint(0.0F, 11.0F, 0.0F);
		corners.addChild(ld);
		ld.cubeList.add(new ModelBox(ld, 0, 0, -8.0F, -14.0F, -8.0F, 5, 3, 1, 0.0F, false));
		ld.cubeList.add(new ModelBox(ld, 0, 0, -8.0F, -16.0F, -8.0F, 3, 2, 1, 0.0F, false));
		ld.cubeList.add(new ModelBox(ld, 0, 0, -5.0F, -15.0F, -8.0F, 1, 1, 1, 0.0F, false));
		ld.cubeList.add(new ModelBox(ld, 0, 0, -8.0F, -15.0F, -5.0F, 1, 1, 1, 0.0F, false));
		ld.cubeList.add(new ModelBox(ld, 0, 0, -8.0F, -14.0F, -7.0F, 1, 3, 4, 0.0F, false));
		ld.cubeList.add(new ModelBox(ld, 0, 0, -8.0F, -16.0F, -7.0F, 1, 2, 2, 0.0F, false));
		ld.cubeList.add(new ModelBox(ld, 0, 0, -5.0F, -12.0F, -7.0F, 2, 1, 2, 0.0F, false));
		ld.cubeList.add(new ModelBox(ld, 0, 0, -5.0F, -12.0F, -5.0F, 1, 1, 1, 0.0F, false));
		ld.cubeList.add(new ModelBox(ld, 0, 0, -7.0F, -12.0F, -7.0F, 2, 1, 4, 0.0F, false));

		pd = new ModelRenderer(this);
		pd.setRotationPoint(11.0F, 11.0F, 0.0F);
		corners.addChild(pd);
		pd.cubeList.add(new ModelBox(pd, 0, 0, -8.0F, -14.0F, -8.0F, 5, 3, 1, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -6.0F, -16.0F, -8.0F, 3, 2, 1, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -7.0F, -15.0F, -8.0F, 1, 1, 1, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -4.0F, -15.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -4.0F, -14.0F, -7.0F, 1, 3, 4, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -4.0F, -16.0F, -7.0F, 1, 2, 2, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -6.0F, -12.0F, -5.0F, 2, 1, 2, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -7.0F, -12.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -8.0F, -12.0F, -7.0F, 4, 1, 2, 0.0F, false));

		sides = new ModelRenderer(this);
		sides.setRotationPoint(0.0F, 0.0F, 0.0F);
		front.addChild(sides);
		sides.cubeList.add(new ModelBox(sides, 0, 0, 5.0F, -10.0F, -8.0F, 3, 4, 1, 0.0F, false));
		sides.cubeList.add(new ModelBox(sides, 0, 0, 7.0F, -10.0F, -7.0F, 1, 4, 2, 0.0F, false));
		sides.cubeList.add(new ModelBox(sides, 0, 0, -2.0F, -16.0F, -7.0F, 4, 1, 2, 0.0F, false));
		sides.cubeList.add(new ModelBox(sides, 0, 0, -2.0F, -16.0F, -8.0F, 4, 3, 1, 0.0F, false));
		sides.cubeList.add(new ModelBox(sides, 0, 0, -2.0F, -1.0F, -7.0F, 4, 1, 2, 0.0F, false));
		sides.cubeList.add(new ModelBox(sides, 0, 0, -2.0F, -3.0F, -8.0F, 4, 3, 1, 0.0F, false));
		sides.cubeList.add(new ModelBox(sides, 0, 0, -8.0F, -10.0F, -8.0F, 3, 4, 1, 0.0F, false));
		sides.cubeList.add(new ModelBox(sides, 0, 0, -8.0F, -10.0F, -7.0F, 1, 4, 2, 0.0F, false));

		back = new ModelRenderer(this);
		back.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(back, 0.0F, 3.1416F, 0.0F);
		

		sides2 = new ModelRenderer(this);
		sides2.setRotationPoint(0.0F, 0.0F, 0.0F);
		back.addChild(sides2);
		

		lg2 = new ModelRenderer(this);
		lg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		sides2.addChild(lg2);
		lg2.cubeList.add(new ModelBox(lg2, 0, 0, -8.0F, -16.0F, -8.0F, 5, 3, 1, 0.0F, false));
		lg2.cubeList.add(new ModelBox(lg2, 0, 0, -8.0F, -13.0F, -8.0F, 3, 2, 1, 0.0F, false));
		lg2.cubeList.add(new ModelBox(lg2, 0, 0, -5.0F, -13.0F, -8.0F, 1, 1, 1, 0.0F, false));
		lg2.cubeList.add(new ModelBox(lg2, 0, 0, -8.0F, -13.0F, -5.0F, 1, 1, 1, 0.0F, false));
		lg2.cubeList.add(new ModelBox(lg2, 0, 0, -8.0F, -16.0F, -7.0F, 1, 3, 4, 0.0F, false));
		lg2.cubeList.add(new ModelBox(lg2, 0, 0, -8.0F, -13.0F, -7.0F, 1, 2, 2, 0.0F, false));
		lg2.cubeList.add(new ModelBox(lg2, 0, 0, -7.0F, -16.0F, -5.0F, 2, 1, 2, 0.0F, false));
		lg2.cubeList.add(new ModelBox(lg2, 0, 0, -5.0F, -16.0F, -5.0F, 1, 1, 1, 0.0F, false));
		lg2.cubeList.add(new ModelBox(lg2, 0, 0, -7.0F, -16.0F, -7.0F, 4, 1, 2, 0.0F, false));

		pg2 = new ModelRenderer(this);
		pg2.setRotationPoint(11.0F, 0.0F, 0.0F);
		sides2.addChild(pg2);
		pg2.cubeList.add(new ModelBox(pg2, 0, 0, -8.0F, -16.0F, -8.0F, 5, 3, 1, 0.0F, false));
		pg2.cubeList.add(new ModelBox(pg2, 0, 0, -6.0F, -13.0F, -8.0F, 3, 2, 1, 0.0F, false));
		pg2.cubeList.add(new ModelBox(pg2, 0, 0, -7.0F, -13.0F, -8.0F, 1, 1, 1, 0.0F, false));
		pg2.cubeList.add(new ModelBox(pg2, 0, 0, -4.0F, -13.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pg2.cubeList.add(new ModelBox(pg2, 0, 0, -4.0F, -16.0F, -7.0F, 1, 3, 4, 0.0F, false));
		pg2.cubeList.add(new ModelBox(pg2, 0, 0, -4.0F, -13.0F, -7.0F, 1, 2, 2, 0.0F, false));
		pg2.cubeList.add(new ModelBox(pg2, 0, 0, -6.0F, -16.0F, -5.0F, 2, 1, 2, 0.0F, false));
		pg2.cubeList.add(new ModelBox(pg2, 0, 0, -7.0F, -16.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pg2.cubeList.add(new ModelBox(pg2, 0, 0, -8.0F, -16.0F, -7.0F, 4, 1, 2, 0.0F, false));

		ld2 = new ModelRenderer(this);
		ld2.setRotationPoint(0.0F, 11.0F, 0.0F);
		sides2.addChild(ld2);
		ld2.cubeList.add(new ModelBox(ld2, 0, 0, -8.0F, -14.0F, -8.0F, 5, 3, 1, 0.0F, false));
		ld2.cubeList.add(new ModelBox(ld2, 0, 0, -8.0F, -16.0F, -8.0F, 3, 2, 1, 0.0F, false));
		ld2.cubeList.add(new ModelBox(ld2, 0, 0, -5.0F, -15.0F, -8.0F, 1, 1, 1, 0.0F, false));
		ld2.cubeList.add(new ModelBox(ld2, 0, 0, -8.0F, -15.0F, -5.0F, 1, 1, 1, 0.0F, false));
		ld2.cubeList.add(new ModelBox(ld2, 0, 0, -8.0F, -14.0F, -7.0F, 1, 3, 4, 0.0F, false));
		ld2.cubeList.add(new ModelBox(ld2, 0, 0, -8.0F, -16.0F, -7.0F, 1, 2, 2, 0.0F, false));
		ld2.cubeList.add(new ModelBox(ld2, 0, 0, -5.0F, -12.0F, -7.0F, 2, 1, 2, 0.0F, false));
		ld2.cubeList.add(new ModelBox(ld2, 0, 0, -5.0F, -12.0F, -5.0F, 1, 1, 1, 0.0F, false));
		ld2.cubeList.add(new ModelBox(ld2, 0, 0, -7.0F, -12.0F, -7.0F, 2, 1, 4, 0.0F, false));

		pd2 = new ModelRenderer(this);
		pd2.setRotationPoint(11.0F, 11.0F, 0.0F);
		sides2.addChild(pd2);
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -8.0F, -14.0F, -8.0F, 5, 3, 1, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -6.0F, -16.0F, -8.0F, 3, 2, 1, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -7.0F, -15.0F, -8.0F, 1, 1, 1, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -4.0F, -15.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -4.0F, -14.0F, -7.0F, 1, 3, 4, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -4.0F, -16.0F, -7.0F, 1, 2, 2, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -6.0F, -12.0F, -5.0F, 2, 1, 2, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -7.0F, -12.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -8.0F, -12.0F, -7.0F, 4, 1, 2, 0.0F, false));

		sides3 = new ModelRenderer(this);
		sides3.setRotationPoint(0.0F, 0.0F, 0.0F);
		back.addChild(sides3);
		sides3.cubeList.add(new ModelBox(sides3, 0, 0, 5.0F, -10.0F, -8.0F, 3, 4, 1, 0.0F, false));
		sides3.cubeList.add(new ModelBox(sides3, 0, 0, 7.0F, -10.0F, -7.0F, 1, 4, 2, 0.0F, false));
		sides3.cubeList.add(new ModelBox(sides3, 0, 0, -2.0F, -16.0F, -7.0F, 4, 1, 2, 0.0F, false));
		sides3.cubeList.add(new ModelBox(sides3, 0, 0, -2.0F, -16.0F, -8.0F, 4, 3, 1, 0.0F, false));
		sides3.cubeList.add(new ModelBox(sides3, 0, 0, -2.0F, -1.0F, -7.0F, 4, 1, 2, 0.0F, false));
		sides3.cubeList.add(new ModelBox(sides3, 0, 0, -2.0F, -3.0F, -8.0F, 4, 3, 1, 0.0F, false));
		sides3.cubeList.add(new ModelBox(sides3, 0, 0, -8.0F, -10.0F, -8.0F, 3, 4, 1, 0.0F, false));
		sides3.cubeList.add(new ModelBox(sides3, 0, 0, -8.0F, -10.0F, -7.0F, 1, 4, 2, 0.0F, false));

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.cubeList.add(new ModelBox(bb_main, 0, 8, -7.0F, -15.0F, -7.0F, 14, 14, 14, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		pboczki.render(f5);
		front.render(f5);
		back.render(f5);
		bb_main.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}