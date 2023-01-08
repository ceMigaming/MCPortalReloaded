package com.cemi.portalreloaded.proxy;

import javax.annotation.Nullable;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.block.BlockIndicatorLight;
import com.cemi.portalreloaded.block.PortalBlocks;
import com.cemi.portalreloaded.sounds.PortalSounds;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ClientProxy extends CommonProxy {

	static {
		OBJLoader.INSTANCE.addDomain(PortalReloaded.MODID);
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(PortalReloaded.MODID + ":" + id, "inventory"));
	}

	@Override
	public <T extends Entity, U extends Render<? super T>> void registerEntityRenderer(Class<T> entityClass,
			Class<U> renderClass) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, new IRenderFactory<T>() {

			@Override
			public Render<? super T> createRenderFor(RenderManager manager) {
				try {
					return renderClass.getConstructor(RenderManager.class).newInstance(manager);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
		});
	}

	@Override
	public void registerBlockColors(net.minecraftforge.client.event.ColorHandlerEvent.Block event) {
		event.getBlockColors().registerBlockColorHandler(new IBlockColor() {
			public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos,
					int tintIndex) {
				return BlockIndicatorLight.colorMultiplier(state.getValue(BlockIndicatorLight.POWER));
			}
		}, PortalBlocks.indicatorLight);
	}
}
