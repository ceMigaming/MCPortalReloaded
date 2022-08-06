package com.cemi.portalreloaded.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.annotation.Nullable;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.tileentity.TileEntityIndicatorLight;
import com.cemi.portalreloaded.utility.ListHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockObserver;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockIndicatorLight extends TileEntityBlock<TileEntityIndicatorLight> {

	public static final PropertyEnum<BlockIndicatorLight.EnumAttachPosition> NORTH = PropertyEnum.<BlockIndicatorLight.EnumAttachPosition>create(
			"north", BlockIndicatorLight.EnumAttachPosition.class);
	public static final PropertyEnum<BlockIndicatorLight.EnumAttachPosition> EAST = PropertyEnum.<BlockIndicatorLight.EnumAttachPosition>create(
			"east", BlockIndicatorLight.EnumAttachPosition.class);
	public static final PropertyEnum<BlockIndicatorLight.EnumAttachPosition> SOUTH = PropertyEnum.<BlockIndicatorLight.EnumAttachPosition>create(
			"south", BlockIndicatorLight.EnumAttachPosition.class);
	public static final PropertyEnum<BlockIndicatorLight.EnumAttachPosition> WEST = PropertyEnum.<BlockIndicatorLight.EnumAttachPosition>create(
			"west", BlockIndicatorLight.EnumAttachPosition.class);
	public static final PropertyBool POWER = PropertyBool.create("power");
	private boolean powered = false;
	List<BlockPos> visitedBlocks = new ArrayList<BlockPos>();
	protected static final AxisAlignedBB[] INDICATOR_LIGHT_AABB = new AxisAlignedBB[] {
			new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 0.8125D),
			new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 0.8125D),
			new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 0.8125D, 0.0625D, 1.0D),
			new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 0.8125D, 0.0625D, 0.8125D),
			new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 0.8125D, 0.0625D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.8125D, 0.0625D, 0.8125D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.8125D, 0.0625D, 1.0D),
			new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 1.0D, 0.0625D, 0.8125D),
			new AxisAlignedBB(0.1875D, 0.0D, 0.1875D, 1.0D, 0.0625D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 1.0D, 0.0625D, 0.8125D),
			new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 1.0D, 0.0625D, 1.0D),
			new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 1.0D, 0.0625D, 0.8125D),
			new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 0.8125D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D) };
	protected static final AxisAlignedBB WALL_NORTH = new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 0.8125D, 1.0D, 0.0625D);
	protected static final AxisAlignedBB WALL_EAST = new AxisAlignedBB(0.9375D, 0.0D, 0.1875D, 1.0D, 1.0D, 0.8125D);
	protected static final AxisAlignedBB WALL_SOUTH = new AxisAlignedBB(0.1875D, 0.0D, 0.9375D, 0.8125D, 1.0D, 1.0D);
	protected static final AxisAlignedBB WALL_WEST = new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 0.0625D, 1.0D, 0.8125D);
	
	private boolean canProvidePower = true;

	public BlockIndicatorLight() {
		super(Material.CIRCUITS, "indicator_light");
		this.setDefaultState(
				this.blockState.getBaseState().withProperty(NORTH, BlockIndicatorLight.EnumAttachPosition.NONE)
						.withProperty(EAST, BlockIndicatorLight.EnumAttachPosition.NONE)
						.withProperty(SOUTH, BlockIndicatorLight.EnumAttachPosition.NONE)
						.withProperty(WEST, BlockIndicatorLight.EnumAttachPosition.NONE)
						.withProperty(POWER, Boolean.valueOf(false)));
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		IBlockState state2 = state.getActualState(source, pos);
		if(state2.getValue(NORTH) == BlockIndicatorLight.EnumAttachPosition.WALL)
			return WALL_NORTH;
		if(state2.getValue(EAST) == BlockIndicatorLight.EnumAttachPosition.WALL)
			return WALL_EAST;
		if(state2.getValue(SOUTH) == BlockIndicatorLight.EnumAttachPosition.WALL)
			return WALL_SOUTH;
		if(state2.getValue(WEST) == BlockIndicatorLight.EnumAttachPosition.WALL)
			return WALL_WEST;
		return INDICATOR_LIGHT_AABB[getAABBIndex(state2)];
	}

	private static int getAABBIndex(IBlockState state) {
		int i = 0;
		boolean flag = state.getValue(NORTH) != BlockIndicatorLight.EnumAttachPosition.NONE;
		boolean flag1 = state.getValue(EAST) != BlockIndicatorLight.EnumAttachPosition.NONE;
		boolean flag2 = state.getValue(SOUTH) != BlockIndicatorLight.EnumAttachPosition.NONE;
		boolean flag3 = state.getValue(WEST) != BlockIndicatorLight.EnumAttachPosition.NONE;

		if (flag || flag2 && !flag && !flag1 && !flag3) {
			i |= 1 << EnumFacing.NORTH.getHorizontalIndex();
		}

		if (flag1 || flag3 && !flag && !flag1 && !flag2) {
			i |= 1 << EnumFacing.EAST.getHorizontalIndex();
		}

		if (flag2 || flag && !flag1 && !flag2 && !flag3) {
			i |= 1 << EnumFacing.SOUTH.getHorizontalIndex();
		}

		if (flag3 || flag1 && !flag && !flag2 && !flag3) {
			i |= 1 << EnumFacing.WEST.getHorizontalIndex();
		}

		return i;
	}

	/**
	 * Get the actual Block state of this Block at the given position. This applies
	 * properties not visible in the metadata, such as fence connections.
	 */
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		state = state.withProperty(WEST, this.getAttachPosition(worldIn, pos, EnumFacing.WEST));
		state = state.withProperty(EAST, this.getAttachPosition(worldIn, pos, EnumFacing.EAST));
		state = state.withProperty(NORTH, this.getAttachPosition(worldIn, pos, EnumFacing.NORTH));
		state = state.withProperty(SOUTH, this.getAttachPosition(worldIn, pos, EnumFacing.SOUTH));
		return state;
	}

	private BlockIndicatorLight.EnumAttachPosition getAttachPosition(IBlockAccess worldIn, BlockPos pos,
			EnumFacing direction) {
		BlockPos blockpos = pos.offset(direction);
		IBlockState iblockstate = worldIn.getBlockState(pos.offset(direction));

		if (!canConnectTo(worldIn.getBlockState(blockpos), direction, worldIn, blockpos)
				&& (iblockstate.isNormalCube() || !canConnectUpwardsTo(worldIn, blockpos.down()))) {
			IBlockState iblockstate1 = worldIn.getBlockState(pos.up());

			if (!worldIn.getBlockState(pos.down()).isTopSolid()) {
				if (worldIn.getBlockState(pos.offset(direction)).isSideSolid(worldIn, blockpos,
						direction.getOpposite()))
					return BlockIndicatorLight.EnumAttachPosition.WALL;
			}
			if (worldIn.getBlockState(pos.up()).getBlock() == this
					|| canBeConnectedTo(worldIn, blockpos.up(), direction))
				if (worldIn.getBlockState(pos.offset(direction)).isSideSolid(worldIn, blockpos,
						direction.getOpposite()))
					return BlockIndicatorLight.EnumAttachPosition.UP;
			if (!iblockstate1.isNormalCube()) {
				if (worldIn.getBlockState(pos.offset(direction)).getBlock() != this) {
					boolean flag = worldIn.getBlockState(blockpos).isSideSolid(worldIn, blockpos, EnumFacing.UP)
							|| worldIn.getBlockState(blockpos).getBlock() == Blocks.GLOWSTONE;

					if (flag && canConnectUpwardsTo(worldIn, blockpos.up())) {
						if (iblockstate.isBlockNormalCube()) {
							return BlockIndicatorLight.EnumAttachPosition.UP;
						}
						
						return BlockIndicatorLight.EnumAttachPosition.SIDE;
					}
				}
			}

			return BlockIndicatorLight.EnumAttachPosition.NONE;
		} else {
			if (worldIn.getBlockState(pos.down()).getBlock() == this
					|| canBeConnectedTo(worldIn, blockpos.up(), direction))
				return BlockIndicatorLight.EnumAttachPosition.NONE;
			return BlockIndicatorLight.EnumAttachPosition.SIDE;
		}
	}

	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for
	 * render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/**
	 * Checks if this block can be placed exactly at the given position.
	 */
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		IBlockState downState = worldIn.getBlockState(pos.down());
		return true;
	}

	private TileEntityIndicatorLight findMainTE(World worldIn, BlockPos pos) {
		TileEntityIndicatorLight te = null;
		TileEntityIndicatorLight te1 = null;
		TileEntityIndicatorLight te2 = ((TileEntityIndicatorLight) worldIn.getTileEntity(pos));
		if (te2 != null) {
			if (te2.isMain()) {
				return te2;
			}
		}
		visitedBlocks.add(pos);
		for (EnumFacing enumfacing : EnumFacing.values()) {
			BlockPos newPos = pos.offset(enumfacing);
			if (worldIn.getBlockState(newPos).getBlock() == this)
				if (!ListHelper.contains(visitedBlocks, newPos)) {
					te = findMainTE(worldIn, newPos);
				}
		}
		return te;
	}

	private void updateConnectedWires(TileEntityIndicatorLight te, World worldIn, BlockPos pos) {
		if (te != null)
			te.addConnectedWire(pos);
	}

	private void updatePower(World worldIn, BlockPos pos, BlockPos neighbourPos) {
		powered = false;
		canProvidePower = false;
		for (EnumFacing enumfacing : EnumFacing.values()) {
			if (isPowerSourceAt(worldIn, pos, enumfacing) && worldIn.isBlockPowered(pos))
				powered = true;
		}
		canProvidePower = true;
		this.changePower(worldIn, pos, powered);
	}

	private void changePower(World worldIn, BlockPos pos, boolean power) {
		visitedBlocks.clear();
		TileEntityIndicatorLight te = findMainTE(worldIn, pos);
		if (te != null)
			for (BlockPos p : te.getConnectedWires()) {
				if (worldIn.getBlockState(p).getBlock() == this) {
					worldIn.setBlockState(p, worldIn.getBlockState(p).withProperty(POWER, power));
				}
				notifyWireNeighborsOfStateChange(worldIn, p);
			}
	}

	/**
	 * Calls World.notifyNeighborsOfStateChange() for all neighboring blocks, but
	 * only if the given block is a redstone wire.
	 */
	private void notifyWireNeighborsOfStateChange(World worldIn, BlockPos pos) {
		TileEntityIndicatorLight te = findMainTE(worldIn, pos);
		if (te != null) {
			for (BlockPos p : te.getConnectedWires()) {
				for (EnumFacing enumfacing : EnumFacing.values()) {
					BlockPos newPos = pos.offset(enumfacing);
					if (worldIn.getBlockState(newPos).getBlock() != this) {
						worldIn.neighborChanged(newPos, this, pos);
						for (EnumFacing enumfacing2 : EnumFacing.values()) {
							BlockPos newPos2 = newPos.offset(enumfacing2);
							if (worldIn.getBlockState(newPos2).getBlock() != this) {
								worldIn.neighborChanged(newPos2, this, newPos);
								worldIn.markAndNotifyBlock(newPos2, worldIn.getChunkFromBlockCoords(newPos2),
										worldIn.getBlockState(newPos2), worldIn.getBlockState(newPos2), 0);
							}
						}

					}

				}
			}
		}
	}

	/**
	 * Called after the block is set in the Chunk data, but before the Tile Entity
	 * is set
	 */
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			boolean isFirst = true;
			for (EnumFacing enumfacing : EnumFacing.values()) {
				if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() == this)
					isFirst = false;
			}
			TileEntityIndicatorLight te = ((TileEntityIndicatorLight) worldIn.getTileEntity(pos));
			if (isFirst) {
				te.setMain(true);
			} else {
				visitedBlocks.clear();
				te = findMainTE(worldIn, pos);
			}
			this.updateConnectedWires(te, worldIn, pos);
			// this.updatePower(worldIn, pos);

			for (EnumFacing enumfacing : EnumFacing.Plane.VERTICAL) {
				worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this, false);
			}

			for (EnumFacing enumfacing1 : EnumFacing.Plane.HORIZONTAL) {
				this.notifyWireNeighborsOfStateChange(worldIn, pos.offset(enumfacing1));
			}

			for (EnumFacing enumfacing2 : EnumFacing.Plane.HORIZONTAL) {
				BlockPos blockpos = pos.offset(enumfacing2);

				if (worldIn.getBlockState(blockpos).isNormalCube()) {
					this.notifyWireNeighborsOfStateChange(worldIn, blockpos.up());
				} else {
					this.notifyWireNeighborsOfStateChange(worldIn, blockpos.down());
				}
			}
		}
	}

	/**
	 * Called serverside after this block is replaced with another in Chunk, but
	 * before the Tile Entity is updated
	 */
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);

		if (!worldIn.isRemote) {
			for (EnumFacing enumfacing : EnumFacing.values()) {
				worldIn.notifyNeighborsOfStateChange(pos.offset(enumfacing), this, false);
			}

			visitedBlocks.clear();
			TileEntityIndicatorLight te = findMainTE(worldIn, pos);
			if (te != null)
				te.clearConnectedWires();
			// this.updateConnectedWires(te, worldIn, pos);

			for (EnumFacing enumfacing1 : EnumFacing.Plane.HORIZONTAL) {
				this.notifyWireNeighborsOfStateChange(worldIn, pos.offset(enumfacing1));
			}

			for (EnumFacing enumfacing2 : EnumFacing.Plane.HORIZONTAL) {
				BlockPos blockpos = pos.offset(enumfacing2);

				if (worldIn.getBlockState(blockpos).isNormalCube()) {
					this.notifyWireNeighborsOfStateChange(worldIn, blockpos.up());
				} else {
					this.notifyWireNeighborsOfStateChange(worldIn, blockpos.down());
				}
			}
		}
	}

	/**
	 * Called when a neighboring block was changed and marks that this state should
	 * perform any checks during a neighbor change. Cases may include when redstone
	 * power is updated, cactus blocks popping off due to a neighboring solid block,
	 * etc.
	 */
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote) {
			if (this.canPlaceBlockAt(worldIn, pos)) {
				if (worldIn.getBlockState(fromPos).getBlock() != this) {
					this.updatePower(worldIn, pos, fromPos);
				}
				notifyWireNeighborsOfStateChange(worldIn, pos);
			} else {
				this.dropBlockAsItem(worldIn, pos, state, 0);
				worldIn.setBlockToAir(pos);
			}
		}
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return blockState.getValue(POWER) && this.canProvidePower ? 15 : 0;
	}

	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return blockState.getValue(POWER) && this.canProvidePower ? 15 : 0;
	}

	private boolean isPowerSourceAt(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		BlockPos blockpos = pos.offset(side);
		IBlockState iblockstate = worldIn.getBlockState(blockpos);
		boolean flag = iblockstate.isNormalCube();
		boolean flag1 = worldIn.getBlockState(pos.up()).isNormalCube();

		if (!flag1 && flag && canConnectUpwardsTo(worldIn, blockpos.up())) {
			return true;
		} else if (canConnectTo(iblockstate, side, worldIn, pos)) {
			return true;
		} else {
			return !flag && canConnectUpwardsTo(worldIn, blockpos.down());
		}
	}

	protected static boolean canConnectUpwardsTo(IBlockAccess worldIn, BlockPos pos) {
		return canConnectTo(worldIn.getBlockState(pos), null, worldIn, pos);
	}

	protected static boolean canConnectTo(IBlockState blockState, @Nullable EnumFacing side, IBlockAccess world,
			BlockPos pos) {
		Block block = blockState.getBlock();

		if (block == PortalBlocks.indicatorLight) {
			return true;
		} else if (Blocks.OBSERVER == blockState.getBlock()) {
			return side == blockState.getValue(BlockObserver.FACING);
		} else {
			return blockState.getBlock().canConnectRedstone(blockState, world, pos, side);
		}
	}

	/**
	 * Can this block provide power. Only wire currently seems to have this change
	 * based on its state.
	 */
	public boolean canProvidePower(IBlockState state) {
		return this.canProvidePower;
	}

	@SideOnly(Side.CLIENT)
	public static int colorMultiplier(boolean powered) {
		int r = 39;
		int g = 167;
		int b = 216;
		if (powered) {
			r = 255;
			g = 154;
			b = 0;
		}
		return -16777216 | r << 16 | g << 8 | b;
	}

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this);
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(POWER, Boolean.valueOf(meta > 0));
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state) {
		return ((Boolean) state.getValue(POWER)) ? 1 : 0;
	}

	/**
	 * Returns the blockstate with the given rotation from the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 */
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		switch (rot) {
		case CLOCKWISE_180:
			return state.withProperty(NORTH, state.getValue(SOUTH)).withProperty(EAST, state.getValue(WEST))
					.withProperty(SOUTH, state.getValue(NORTH)).withProperty(WEST, state.getValue(EAST));
		case COUNTERCLOCKWISE_90:
			return state.withProperty(NORTH, state.getValue(EAST)).withProperty(EAST, state.getValue(SOUTH))
					.withProperty(SOUTH, state.getValue(WEST)).withProperty(WEST, state.getValue(NORTH));
		case CLOCKWISE_90:
			return state.withProperty(NORTH, state.getValue(WEST)).withProperty(EAST, state.getValue(NORTH))
					.withProperty(SOUTH, state.getValue(EAST)).withProperty(WEST, state.getValue(SOUTH));
		default:
			return state;
		}
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 */
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		switch (mirrorIn) {
		case LEFT_RIGHT:
			return state.withProperty(NORTH, state.getValue(SOUTH)).withProperty(SOUTH, state.getValue(NORTH));
		case FRONT_BACK:
			return state.withProperty(EAST, state.getValue(WEST)).withProperty(WEST, state.getValue(EAST));
		default:
			return super.withMirror(state, mirrorIn);
		}
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { NORTH, EAST, SOUTH, WEST, POWER });
	}

	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	static enum EnumAttachPosition implements IStringSerializable {
		UP("up"), SIDE("side"), NONE("none"), WALL("wall");

		private final String name;

		private EnumAttachPosition(String name) {
			this.name = name;
		}

		public String toString() {
			return this.getName();
		}

		public String getName() {
			return this.name;
		}
	}

	@Override
	public Class<TileEntityIndicatorLight> getTileEntityClass() {
		return TileEntityIndicatorLight.class;
	}

	@Override
	public TileEntityIndicatorLight createTileEntity(World world, IBlockState state) {
		return new TileEntityIndicatorLight();
	}

}
