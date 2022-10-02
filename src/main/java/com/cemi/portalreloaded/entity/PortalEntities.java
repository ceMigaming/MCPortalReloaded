package com.cemi.portalreloaded.entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.client.renderer.entity.RenderEntityCube;
import com.cemi.portalreloaded.client.renderer.entity.RenderEntityHEP;
import com.cemi.portalreloaded.client.renderer.entity.RenderEntityPivotCube;
import com.cemi.portalreloaded.client.renderer.entity.RenderEntityWheatley;
import com.google.common.collect.Maps;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.registries.IForgeRegistry;

public class PortalEntities {

	static int id = 33;

	static IForgeRegistry<EntityEntry> registry;

	public static final List<String> CUBE_PLACERS = new LinkedList<String>();
	public static final List<String> ROBOTS_PLACERS = new LinkedList<String>();

	public static void register(IForgeRegistry<EntityEntry> registry) {
		PortalEntities.registry = registry;

		register(EntityHEP.class, "hep", getRenderer("RenderEntityHEP"));
		register(EntityWheatley.class, "wheatley", getRenderer("RenderEntityWheatley"));
		register(EntityStorageCube.class, "storage_cube", getRenderer("RenderEntityCube"));
		register(EntityPivotCube.class, "pivot_cube", getRenderer("RenderEntityPivotCube"));
		register(EntityTurret.class, "turret", getRenderer("RenderEntityTurret"));
		register(EntityCamera.class, "camera", getRenderer("RenderEntityCamera"));

		addSpawnInfo(CUBE_PLACERS, "storage_cube");
		addSpawnInfo(CUBE_PLACERS, "pivot_cube");

	}

	private static void register(Class entityClass, String name, @Nullable Class renderClass) {
		registry.register(EntityEntryBuilder.create().entity(entityClass).tracker(160, 1, true)
				.id(new ResourceLocation(PortalReloaded.MODID, name), id++).name(name).build());
		if (renderClass != null)
			PortalReloaded.proxy.registerEntityRenderer(entityClass, renderClass);
	}

	private static Class getRenderer(String clss) {
		try {
			return Class.forName("com.cemi.portalreloaded.client.renderer.entity." + clss);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected static void addSpawnInfo(List<String> list, String id) {
		list.add(id);
	}

}
