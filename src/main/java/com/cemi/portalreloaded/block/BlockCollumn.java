package com.cemi.portalreloaded.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCollumn extends PortalBlock {

	Block lowerPart, upperPart;

	public BlockCollumn(Material material, String name, Block lowerBlock, Block upperBlock) {
		super(material, name);
		lowerPart = lowerBlock;
		upperPart = upperBlock;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		BlockPos upperBlockPos = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
		if (worldIn.isAirBlock(upperBlockPos)) {
			worldIn.setBlockState(pos, lowerPart.getDefaultState());
			worldIn.setBlockState(upperBlockPos, upperPart.getDefaultState());
		}
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

}
