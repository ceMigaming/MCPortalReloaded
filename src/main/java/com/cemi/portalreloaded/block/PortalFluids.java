package com.cemi.portalreloaded.block;

import com.cemi.portalreloaded.PortalReloaded;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class PortalFluids {

	private static final ResourceLocation STATIC_NEUROTOXIN = new ResourceLocation(PortalReloaded.MODID,
			"blocks/neurotoxin_still");
	private static final ResourceLocation FLOWING_NEUROTOXIN = new ResourceLocation(PortalReloaded.MODID,
			"blocks/neurotoxin_flow");

	public static PortalFluid neurotoxinFluid = (PortalFluid) new PortalFluid("neurotoxin", STATIC_NEUROTOXIN,
			FLOWING_NEUROTOXIN).setMaterial(Material.WATER).setDensity(1100).setGaseous(false).setLuminosity(9)
					.setViscosity(25000).setTemperature(300);

	public static void register() {
		registerFluid(neurotoxinFluid);
	}

	private static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

}
