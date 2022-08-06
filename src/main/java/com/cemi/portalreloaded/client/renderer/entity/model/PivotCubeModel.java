package com.cemi.portalreloaded.client.renderer.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class PivotCubeModel extends ModelBase {
	private final ModelRenderer rama;
	private final ModelRenderer front;
	private final ModelRenderer konty;
	private final ModelRenderer lg;
	private final ModelRenderer pg;
	private final ModelRenderer ld;
	private final ModelRenderer pd;
	private final ModelRenderer back;
	private final ModelRenderer konty2;
	private final ModelRenderer lg2;
	private final ModelRenderer pg2;
	private final ModelRenderer ld2;
	private final ModelRenderer pd2;
	private final ModelRenderer lens;
	private final ModelRenderer socz;
	private final ModelRenderer socz2;
	private final ModelRenderer socz3;
	private final ModelRenderer socz4;
	private final ModelRenderer socz5;
	private final ModelRenderer socz6;

	public PivotCubeModel() {
		textureWidth = 32;
		textureHeight = 32;

		rama = new ModelRenderer(this);
		rama.setRotationPoint(0.0F, 24.0F, 0.0F);
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -3.0F, -7.0F, 1, 1, 14, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -2.0F, -7.0F, 2, 1, 14, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -6.0F, -3.0F, 6.0F, 12, 1, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -5.0F, -2.0F, 5.0F, 10, 1, 2, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -5.0F, -2.0F, -6.0F, 10, 1, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -6.0F, -3.0F, -7.0F, 12, 2, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, 6.0F, -3.0F, -7.0F, 1, 1, 14, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, 5.0F, -2.0F, -7.0F, 2, 1, 14, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, 6.0F, -13.0F, -6.0F, 1, 10, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, 5.0F, -13.0F, -7.0F, 2, 10, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -13.0F, -6.0F, 1, 10, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -13.0F, -7.0F, 2, 10, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -13.0F, 5.0F, 1, 10, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -13.0F, 6.0F, 2, 10, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, 5.0F, -13.0F, 6.0F, 1, 10, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, 6.0F, -13.0F, 5.0F, 1, 10, 2, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -15.0F, -6.0F, 14, 1, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -15.0F, -7.0F, 14, 2, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, 5.0F, -15.0F, -5.0F, 1, 1, 10, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, 6.0F, -15.0F, -6.0F, 1, 2, 12, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -6.0F, -15.0F, -5.0F, 1, 1, 10, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -15.0F, -6.0F, 1, 2, 12, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -15.0F, 5.0F, 14, 1, 1, 0.0F, false));
		rama.cubeList.add(new ModelBox(rama, 0, 0, -7.0F, -15.0F, 6.0F, 14, 2, 1, 0.0F, false));

		front = new ModelRenderer(this);
		front.setRotationPoint(0.0F, 0.0F, 0.0F);
		rama.addChild(front);

		konty = new ModelRenderer(this);
		konty.setRotationPoint(0.0F, 0.0F, 0.0F);
		front.addChild(konty);

		lg = new ModelRenderer(this);
		lg.setRotationPoint(0.0F, 0.0F, 0.0F);
		konty.addChild(lg);
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
		konty.addChild(pg);
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
		konty.addChild(ld);
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
		konty.addChild(pd);
		pd.cubeList.add(new ModelBox(pd, 0, 0, -8.0F, -14.0F, -8.0F, 5, 3, 1, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -6.0F, -16.0F, -8.0F, 3, 2, 1, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -7.0F, -15.0F, -8.0F, 1, 1, 1, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -4.0F, -15.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -4.0F, -14.0F, -7.0F, 1, 3, 4, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -4.0F, -16.0F, -7.0F, 1, 2, 2, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -6.0F, -12.0F, -5.0F, 2, 1, 2, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -7.0F, -12.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pd.cubeList.add(new ModelBox(pd, 0, 0, -8.0F, -12.0F, -7.0F, 4, 1, 2, 0.0F, false));

		back = new ModelRenderer(this);
		back.setRotationPoint(0.0F, 0.0F, 0.0F);
		rama.addChild(back);
		setRotationAngle(back, 0.0F, 3.1416F, 0.0F);

		konty2 = new ModelRenderer(this);
		konty2.setRotationPoint(0.0F, 0.0F, 0.0F);
		back.addChild(konty2);

		lg2 = new ModelRenderer(this);
		lg2.setRotationPoint(0.0F, 0.0F, 0.0F);
		konty2.addChild(lg2);
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
		konty2.addChild(pg2);
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
		konty2.addChild(ld2);
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
		konty2.addChild(pd2);
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -8.0F, -14.0F, -8.0F, 5, 3, 1, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -6.0F, -16.0F, -8.0F, 3, 2, 1, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -7.0F, -15.0F, -8.0F, 1, 1, 1, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -4.0F, -15.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -4.0F, -14.0F, -7.0F, 1, 3, 4, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -4.0F, -16.0F, -7.0F, 1, 2, 2, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -6.0F, -12.0F, -5.0F, 2, 1, 2, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -7.0F, -12.0F, -5.0F, 1, 1, 1, 0.0F, false));
		pd2.cubeList.add(new ModelBox(pd2, 0, 0, -8.0F, -12.0F, -7.0F, 4, 1, 2, 0.0F, false));

		lens = new ModelRenderer(this);
		lens.setRotationPoint(0.0F, 24.0F, 0.0F);

		socz = new ModelRenderer(this);
		socz.setRotationPoint(1.0F, 0.0F, 0.0F);
		lens.addChild(socz);
		socz.cubeList.add(new ModelBox(socz, 0, 18, -7.0F, -12.0F, -3.0F, 1, 8, 6, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 0, 27, -7.0F, -13.0F, -2.0F, 1, 1, 4, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 0, 27, -7.0F, -4.0F, -2.0F, 1, 1, 4, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 0, 27, -7.0F, -10.0F, -5.0F, 1, 4, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 0, 27, -7.0F, -10.0F, 4.0F, 1, 4, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 0, 25, -7.0F, -11.0F, 3.0F, 1, 6, 1, 0.0F, false));
		socz.cubeList.add(new ModelBox(socz, 0, 25, -7.0F, -11.0F, -4.0F, 1, 6, 1, 0.0F, false));

		socz2 = new ModelRenderer(this);
		socz2.setRotationPoint(12.0F, 0.0F, 0.0F);
		lens.addChild(socz2);
		socz2.cubeList.add(new ModelBox(socz2, 0, 18, -7.0F, -12.0F, -3.0F, 1, 8, 6, 0.0F, false));
		socz2.cubeList.add(new ModelBox(socz2, 0, 18, -7.0F, -13.0F, -2.0F, 1, 1, 4, 0.0F, false));
		socz2.cubeList.add(new ModelBox(socz2, 0, 18, -7.0F, -4.0F, -2.0F, 1, 1, 4, 0.0F, false));
		socz2.cubeList.add(new ModelBox(socz2, 0, 18, -7.0F, -10.0F, -5.0F, 1, 4, 1, 0.0F, false));
		socz2.cubeList.add(new ModelBox(socz2, 0, 18, -7.0F, -10.0F, 4.0F, 1, 4, 1, 0.0F, false));
		socz2.cubeList.add(new ModelBox(socz2, 0, 18, -7.0F, -11.0F, 3.0F, 1, 6, 1, 0.0F, false));
		socz2.cubeList.add(new ModelBox(socz2, 0, 18, -7.0F, -11.0F, -4.0F, 1, 6, 1, 0.0F, false));

		socz3 = new ModelRenderer(this);
		socz3.setRotationPoint(0.0F, 0.0F, 12.0F);
		lens.addChild(socz3);
		setRotationAngle(socz3, 0.0F, -1.5708F, 0.0F);
		socz3.cubeList.add(new ModelBox(socz3, 0, 18, -7.0F, -12.0F, -3.0F, 1, 8, 6, 0.0F, false));
		socz3.cubeList.add(new ModelBox(socz3, 0, 18, -7.0F, -13.0F, -2.0F, 1, 1, 4, 0.0F, false));
		socz3.cubeList.add(new ModelBox(socz3, 0, 18, -7.0F, -4.0F, -2.0F, 1, 1, 4, 0.0F, false));
		socz3.cubeList.add(new ModelBox(socz3, 0, 18, -7.0F, -10.0F, -5.0F, 1, 4, 1, 0.0F, false));
		socz3.cubeList.add(new ModelBox(socz3, 0, 18, -7.0F, -10.0F, 4.0F, 1, 4, 1, 0.0F, false));
		socz3.cubeList.add(new ModelBox(socz3, 0, 18, -7.0F, -11.0F, 3.0F, 1, 6, 1, 0.0F, false));
		socz3.cubeList.add(new ModelBox(socz3, 0, 18, -7.0F, -11.0F, -4.0F, 1, 6, 1, 0.0F, false));

		socz4 = new ModelRenderer(this);
		socz4.setRotationPoint(0.0F, -10.0F, 2.0F);
		lens.addChild(socz4);
		setRotationAngle(socz4, 0.0F, -1.5708F, 0.0F);
		socz4.cubeList.add(new ModelBox(socz4, 0, 25, -6.0F, -4.0F, -3.0F, 8, 1, 6, 0.0F, false));
		socz4.cubeList.add(new ModelBox(socz4, 0, 25, 2.0F, -4.0F, -2.0F, 1, 1, 4, 0.0F, false));
		socz4.cubeList.add(new ModelBox(socz4, 0, 25, -7.0F, -4.0F, -2.0F, 1, 1, 4, 0.0F, false));
		socz4.cubeList.add(new ModelBox(socz4, 0, 25, -4.0F, -4.0F, -5.0F, 4, 1, 1, 0.0F, false));
		socz4.cubeList.add(new ModelBox(socz4, 0, 25, -4.0F, -4.0F, 4.0F, 4, 1, 1, 0.0F, false));
		socz4.cubeList.add(new ModelBox(socz4, 0, 25, -5.0F, -4.0F, 3.0F, 6, 1, 1, 0.0F, false));
		socz4.cubeList.add(new ModelBox(socz4, 0, 25, -5.0F, -4.0F, -4.0F, 6, 1, 1, 0.0F, false));

		socz5 = new ModelRenderer(this);
		socz5.setRotationPoint(0.0F, 1.0F, 2.0F);
		lens.addChild(socz5);
		setRotationAngle(socz5, 0.0F, -1.5708F, 0.0F);
		socz5.cubeList.add(new ModelBox(socz5, 0, 25, -6.0F, -4.0F, -3.0F, 8, 1, 6, 0.0F, false));
		socz5.cubeList.add(new ModelBox(socz5, 0, 25, 2.0F, -4.0F, -2.0F, 1, 1, 4, 0.0F, false));
		socz5.cubeList.add(new ModelBox(socz5, 0, 25, -7.0F, -4.0F, -2.0F, 1, 1, 4, 0.0F, false));
		socz5.cubeList.add(new ModelBox(socz5, 0, 25, -4.0F, -4.0F, -5.0F, 4, 1, 1, 0.0F, false));
		socz5.cubeList.add(new ModelBox(socz5, 0, 25, -4.0F, -4.0F, 4.0F, 4, 1, 1, 0.0F, false));
		socz5.cubeList.add(new ModelBox(socz5, 0, 25, -5.0F, -4.0F, 3.0F, 6, 1, 1, 0.0F, false));
		socz5.cubeList.add(new ModelBox(socz5, 0, 25, -5.0F, -4.0F, -4.0F, 6, 1, 1, 0.0F, false));

		socz6 = new ModelRenderer(this);
		socz6.setRotationPoint(0.0F, 0.0F, 1.0F);
		lens.addChild(socz6);
		setRotationAngle(socz6, 0.0F, -1.5708F, 0.0F);
		socz6.cubeList.add(new ModelBox(socz6, 0, 20, -7.0F, -12.0F, -2.0F, 1, 8, 4, 0.0F, false));
		socz6.cubeList.add(new ModelBox(socz6, 0, 20, -7.0F, -10.0F, 3.0F, 1, 4, 1, 0.0F, false));
		socz6.cubeList.add(new ModelBox(socz6, 0, 20, -7.0F, -11.0F, 2.0F, 1, 6, 1, 0.0F, false));
		socz6.cubeList.add(new ModelBox(socz6, 0, 20, -7.0F, -11.0F, -3.0F, 1, 6, 1, 0.0F, false));
		socz6.cubeList.add(new ModelBox(socz6, 0, 20, -7.0F, -10.0F, -4.0F, 1, 4, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		rama.render(f5);
		lens.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}