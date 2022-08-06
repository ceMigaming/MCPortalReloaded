package com.cemi.portalreloaded.proxy;

import javax.annotation.Nullable;

import com.cemi.portalreloaded.block.BlockIndicatorLight;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.event.ColorHandlerEvent;

public class CommonProxy {
	public void registerItemRenderer(Item item, int meta, String id) {
	}

	public <T extends Entity, U extends Render<? super T>> void registerEntityRenderer(Class<T> entityClass,
			Class<U> renderClass) {
	}
	
	public void registerBlockColors(final ColorHandlerEvent.Block event) {
	}
}
