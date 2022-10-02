package com.cemi.portalreloaded.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBigTile extends PortalBlock {

	Block upperLeftPart, upperRightPart, lowerLeftPart, lowerRightPart;

	public BlockBigTile(Material material, String name, Block upperLeftBlock, Block upperRightBlock,
			Block lowerLeftBlock, Block lowerRightBlock) {
		super(material, name);
		upperLeftPart = upperLeftBlock;
		upperRightPart = upperRightBlock;
		lowerLeftPart = lowerLeftBlock;
		lowerRightPart = lowerRightBlock;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		EnumFacing facing =  EnumFacing.getDirectionFromEntityLiving(pos, placer).getOpposite();
		int dx = 0;
		int dy = 0;
		int dz = 0;
		int dw = 0;
		switch (facing) {
		case NORTH:
			dx++;
			dy++;
			break;
		case SOUTH:
			dx--;
			dy++;
			break;
		case EAST:
			dy++;
			dz++;
			break;
		case WEST:
			dy++;
			dz--;
			break;
		case UP:
			dx++;
			dw++;
			break;
		default:
		case DOWN:
			dx++;
			dw--;
			break;
		}
		BlockPos upperLeftBlockPos = new BlockPos(pos.getX(), pos.getY() + dy, pos.getZ()+dw);
		BlockPos upperRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY() + dy, pos.getZ()+dz+dw);
		BlockPos lowerRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY(), pos.getZ()+dz);
		if (worldIn.isAirBlock(upperLeftBlockPos) && worldIn.isAirBlock(upperRightBlockPos)
				&& worldIn.isAirBlock(lowerRightBlockPos)) {
			worldIn.setBlockState(pos, lowerLeftPart.getDefaultState());
			worldIn.setBlockState(upperLeftBlockPos, upperLeftPart.getDefaultState());
			worldIn.setBlockState(upperRightBlockPos, upperRightPart.getDefaultState());
			worldIn.setBlockState(lowerRightBlockPos, lowerRightPart.getDefaultState());
		}
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

}
