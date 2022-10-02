package com.cemi.portalreloaded.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFloorButtonDummy extends PortalBlock {

	public static final PropertyBool POWERED = PropertyBool.create("powered");
	protected static final AxisAlignedBB PRESSED_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.015625D, 0.9375D);

	public BlockFloorButtonDummy(String name) {
		super(Material.IRON, name, false);
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	public boolean canSpawnInBlock() {
		return true;
	}

	public boolean canProvidePower(IBlockState state) {
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		for (EnumFacing enumFacing : EnumFacing.VALUES) {
			if (enumFacing == EnumFacing.DOWN || enumFacing == EnumFacing.UP) {
				continue;
			}
			Block b = worldIn.getBlockState(pos.offset(enumFacing)).getBlock();
			if (b == this || b == PortalBlocks.floorButton)
				worldIn.setBlockToAir(pos.offset(enumFacing));

		}
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBox(IBlockState state, World worldIn, BlockPos pos) {
		return PRESSED_AABB;
	}

	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (!worldIn.isRemote) {
			if (worldIn.getBlockState(pos.east()).getBlock() == PortalBlocks.floorButton) {
				worldIn.getBlockState(pos.east()).getBlock().onEntityCollidedWithBlock(worldIn, pos.east(),
						worldIn.getBlockState(pos.east()), entityIn);
			} else if (worldIn.getBlockState(pos.south()).getBlock() == PortalBlocks.floorButton) {
				worldIn.getBlockState(pos.south()).getBlock().onEntityCollidedWithBlock(worldIn, pos.south(),
						worldIn.getBlockState(pos.south()), entityIn);
			} else if (worldIn.getBlockState(pos.east().south()).getBlock() == PortalBlocks.floorButton) {
				worldIn.getBlockState(pos.east().south()).getBlock().onEntityCollidedWithBlock(worldIn,
						pos.east().south(), worldIn.getBlockState(pos.east().south()), entityIn);
			}
		}
	}
	
	protected int getRedstoneStrength(IBlockState state)
    {
		return ((Boolean)state.getValue(POWERED)).booleanValue() ? 15 : 0;
    }

	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return this.getRedstoneStrength(blockState);
	}
	
	@Override
	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		if (blockAccess.getBlockState(pos.east()).getBlock() == PortalBlocks.floorButton) {
			return blockAccess.getBlockState(pos.east()).getStrongPower(blockAccess, pos.east(), side);
		} else if (blockAccess.getBlockState(pos.south()).getBlock() == PortalBlocks.floorButton) {
			return blockAccess.getBlockState(pos.south()).getStrongPower(blockAccess, pos.south(), side);
		} else if (blockAccess.getBlockState(pos.east().south()).getBlock() == PortalBlocks.floorButton) {
			return blockAccess.getBlockState(pos.east().south()).getStrongPower(blockAccess, pos.east().south(), side);
		}
		else return 0;
	}
	
	public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(POWERED, Boolean.valueOf(meta == 1));
    }

    public int getMetaFromState(IBlockState state)
    {
        return ((Boolean)state.getValue(POWERED)).booleanValue() ? 1 : 0;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {POWERED});
    }
    
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}
}
