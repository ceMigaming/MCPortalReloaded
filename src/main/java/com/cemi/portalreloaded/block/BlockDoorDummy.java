package com.cemi.portalreloaded.block;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDoorDummy extends PortalBlock {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool OPEN = PropertyBool.create("open");
	public static final PropertyBool POWERED = PropertyBool.create("powered");
	protected static final AxisAlignedBB EAST_WEST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 1.0D, 1.0D, 0.8125D);
	protected static final AxisAlignedBB NORTH_SOUTH_AABB = new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 0.8125D, 1.0D, 1.0D);
	protected static final AxisAlignedBB EMPTY_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

	public BlockDoorDummy(String name) {
		super(Material.IRON, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)
				.withProperty(OPEN, Boolean.valueOf(false)).withProperty(POWERED, Boolean.valueOf(false)));
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
		boolean isOpen = ((Boolean) state.getValue(OPEN)).booleanValue();
		if (isOpen) {
			return EMPTY_AABB;
		}
		switch (enumfacing) {
		case EAST:
		case WEST:
		default:
			return EAST_WEST_AABB;
		case NORTH:
		case SOUTH:
			return NORTH_SOUTH_AABB;
		}
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (!player.isCreative())
			return;
		EnumFacing facing = (EnumFacing) state.getValue(FACING).rotateYCCW();
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
		default:
		case WEST:
			dy++;
			dz--;
			break;
		}
		BlockPos upperLeftBlockPos_ = new BlockPos(pos.getX(), pos.getY() - dy, pos.getZ() - dw);
		BlockPos upperRightBlockPos_ = new BlockPos(pos.getX() - dx, pos.getY() - dy, pos.getZ() - dz - dw);
		BlockPos lowerRightBlockPos_ = new BlockPos(pos.getX() - dx, pos.getY(), pos.getZ() - dz);

		facing = facing.rotateY();
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		if (worldIn.getBlockState(upperLeftBlockPos_).getBlock() == PortalBlocks.door) {
			pos = upperLeftBlockPos_;
			BlockPos upperLeftBlockPos = new BlockPos(pos.getX(), pos.getY() + dy, pos.getZ() + dw);
			BlockPos upperRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY() + dy, pos.getZ() + dz + dw);
			BlockPos lowerRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY(), pos.getZ() + dz);

			worldIn.setBlockState(upperLeftBlockPos, Blocks.AIR.getDefaultState());
			worldIn.setBlockState(upperRightBlockPos, Blocks.AIR.getDefaultState());
			worldIn.setBlockState(lowerRightBlockPos, Blocks.AIR.getDefaultState());

			worldIn.setBlockState(upperLeftBlockPos_, Blocks.AIR.getDefaultState());
		}
		if (worldIn.getBlockState(upperRightBlockPos_).getBlock() == PortalBlocks.door) {
			pos = upperRightBlockPos_;
			BlockPos upperLeftBlockPos = new BlockPos(pos.getX(), pos.getY() + dy, pos.getZ() + dw);
			BlockPos upperRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY() + dy, pos.getZ() + dz + dw);
			BlockPos lowerRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY(), pos.getZ() + dz);

			worldIn.setBlockState(upperLeftBlockPos, Blocks.AIR.getDefaultState());
			worldIn.setBlockState(upperRightBlockPos, Blocks.AIR.getDefaultState());
			worldIn.setBlockState(lowerRightBlockPos, Blocks.AIR.getDefaultState());

			worldIn.setBlockState(upperRightBlockPos_, Blocks.AIR.getDefaultState());
		}
		if (worldIn.getBlockState(lowerRightBlockPos_).getBlock() == PortalBlocks.door) {
			pos = lowerRightBlockPos_;
			BlockPos upperLeftBlockPos = new BlockPos(pos.getX(), pos.getY() + dy, pos.getZ() + dw);
			BlockPos upperRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY() + dy, pos.getZ() + dz + dw);
			BlockPos lowerRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY(), pos.getZ() + dz);

			worldIn.setBlockState(upperLeftBlockPos, Blocks.AIR.getDefaultState());
			worldIn.setBlockState(upperRightBlockPos, Blocks.AIR.getDefaultState());
			worldIn.setBlockState(lowerRightBlockPos, Blocks.AIR.getDefaultState());

			worldIn.setBlockState(lowerRightBlockPos_, Blocks.AIR.getDefaultState());
		}

	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess source, BlockPos pos) {
		blockState = blockState.getActualState(source, pos);
		EnumFacing enumfacing = (EnumFacing) blockState.getValue(FACING);
		boolean isOpen = ((Boolean) blockState.getValue(OPEN)).booleanValue();
		if (isOpen) {
			return NULL_AABB;
		}
		switch (enumfacing) {
		case EAST:
		case WEST:
		default:
			return EAST_WEST_AABB;
		case NORTH:
		case SOUTH:
			return NORTH_SOUTH_AABB;
		}
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return isOpen(combineMetadata(worldIn, pos));
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public static int combineMetadata(IBlockAccess worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		int i = iblockstate.getBlock().getMetaFromState(iblockstate);
		boolean flag = isTop(i);
		IBlockState iblockstate1 = worldIn.getBlockState(pos.down());
		int j = iblockstate1.getBlock().getMetaFromState(iblockstate1);
		int k = flag ? j : i;
		IBlockState iblockstate2 = worldIn.getBlockState(pos.up());
		int l = iblockstate2.getBlock().getMetaFromState(iblockstate2);
		int i1 = flag ? i : l;
		boolean flag1 = (i1 & 1) != 0;
		boolean flag2 = (i1 & 2) != 0;
		return removeHalfBit(k) | (flag ? 8 : 0) | (flag1 ? 16 : 0) | (flag2 ? 32 : 0);
	}

	protected static boolean isOpen(int combinedMeta) {
		return (combinedMeta & 4) != 0;
	}

	protected static int removeHalfBit(int meta) {
		return meta & 7;
	}

	protected static boolean isTop(int meta) {
		return (meta & 8) != 0;
	}

	public IBlockState getStateFromMeta(int meta) {
		return (meta & 8) > 0 ? this.getDefaultState().withProperty(POWERED, Boolean.valueOf((meta & 2) > 0))
				: this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3).rotateYCCW())
						.withProperty(OPEN, Boolean.valueOf((meta & 4) > 0));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		int i = 0;

		i = i | ((EnumFacing) state.getValue(FACING)).rotateY().getHorizontalIndex();

		if (((Boolean) state.getValue(OPEN)).booleanValue()) {
			i |= 4;
		}

		return i;
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, OPEN, POWERED });
	}
}
