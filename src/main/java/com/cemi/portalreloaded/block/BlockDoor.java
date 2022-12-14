package com.cemi.portalreloaded.block;

import java.util.Random;

import com.cemi.portalreloaded.client.PortalTabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDoor extends PortalBlock {
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool OPEN = PropertyBool.create("open");
	public static final PropertyBool POWERED = PropertyBool.create("powered");
	protected static final AxisAlignedBB EAST_WEST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.1875D, 1.0D, 1.0D, 0.8125D);
	protected static final AxisAlignedBB NORTH_SOUTH_AABB = new AxisAlignedBB(0.1875D, 0.0D, 0.0D, 0.8125D, 1.0D, 1.0D);
	protected static final AxisAlignedBB EMPTY_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

	protected BlockDoor(String name) {
		super(Material.IRON, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)
				.withProperty(OPEN, Boolean.valueOf(false)).withProperty(POWERED, Boolean.valueOf(false)));
		setCreativeTab(PortalTabs.PORTAL_REDSTONE);
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

	/**
	 * Gets the localized name of this block. Used for the statistics page.
	 */
	public String getLocalizedName() {
		return I18n.translateToLocal((this.getUnlocalizedName() + ".name").replaceAll("tile", "item"));
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for
	 * render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	/**
	 * Determines if an entity can path through this block
	 */
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos) {
		return isOpen(combineMetadata(worldIn, pos));
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	private int getCloseSound() {
		return this.blockMaterial == Material.IRON ? 1011 : 1012;
	}

	private int getOpenSound() {
		return this.blockMaterial == Material.IRON ? 1005 : 1006;
	}

	/**
	 * Called when the block is right clicked by a player.
	 */
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		return false;
	}

	public void toggleDoor(World worldIn, BlockPos pos, boolean open) {
		IBlockState iblockstate = worldIn.getBlockState(pos);

		if (iblockstate.getBlock() == this) {
			if (iblockstate.getBlock() == this && ((Boolean) iblockstate.getValue(OPEN)).booleanValue() != open) {
				worldIn.setBlockState(pos, iblockstate.withProperty(OPEN, Boolean.valueOf(open)), 10);
				worldIn.markBlockRangeForRenderUpdate(pos, pos);
				worldIn.playEvent((EntityPlayer) null, open ? this.getOpenSound() : this.getCloseSound(), pos, 0);
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

		boolean flag1 = false;

		if (!worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos.down(), EnumFacing.UP)) {
			worldIn.setBlockToAir(pos);
			flag1 = true;

		}

		if (flag1) {
			if (!worldIn.isRemote) {
				this.dropBlockAsItem(worldIn, pos, state, 0);
			}
		} else {
			boolean flag = worldIn.isBlockPowered(pos);

			if (flag != ((Boolean) state.getValue(OPEN)).booleanValue()) {
				worldIn.setBlockState(pos, state.withProperty(OPEN, Boolean.valueOf(flag)), 2);
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
				BlockPos upperLeftBlockPos = new BlockPos(pos.getX(), pos.getY() + dy, pos.getZ() + dw);
				BlockPos upperRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY() + dy, pos.getZ() + dz + dw);
				BlockPos lowerRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY(), pos.getZ() + dz);

				worldIn.setBlockState(upperLeftBlockPos, worldIn.getBlockState(upperLeftBlockPos)
						.withProperty(BlockDoorDummy.OPEN, Boolean.valueOf(flag)), 2);
				worldIn.setBlockState(upperRightBlockPos, worldIn.getBlockState(upperRightBlockPos)
						.withProperty(BlockDoorDummy.OPEN, Boolean.valueOf(flag)), 2);
				worldIn.setBlockState(lowerRightBlockPos, worldIn.getBlockState(lowerRightBlockPos)
						.withProperty(BlockDoorDummy.OPEN, Boolean.valueOf(flag)), 2);

				worldIn.markBlockRangeForRenderUpdate(pos, upperLeftBlockPos);
				worldIn.markBlockRangeForRenderUpdate(lowerRightBlockPos, upperRightBlockPos);

				worldIn.playEvent((EntityPlayer) null, flag ? this.getOpenSound() : this.getCloseSound(), pos, 0);
			}
		}
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return this.getItem();
	}

	/**
	 * Checks if this block can be placed exactly at the given position.
	 */
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		EnumFacing facing = placer.getHorizontalFacing().getOpposite(); // EnumFacing.getDirectionFromEntityLiving(pos,
																		// placer).getOpposite();
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
		BlockPos upperLeftBlockPos = new BlockPos(pos.getX(), pos.getY() + dy, pos.getZ() + dw);
		BlockPos upperRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY() + dy, pos.getZ() + dz + dw);
		BlockPos lowerRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY(), pos.getZ() + dz);
		if (worldIn.isAirBlock(upperLeftBlockPos) && worldIn.isAirBlock(upperRightBlockPos)
				&& worldIn.isAirBlock(lowerRightBlockPos)) {
			facing = facing.rotateY();
			worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, facing));
			worldIn.setBlockState(upperLeftBlockPos,
					PortalBlocks.dummyDoor.getDefaultState().withProperty(BlockDoorDummy.FACING, facing));
			worldIn.setBlockState(upperRightBlockPos,
					PortalBlocks.dummyDoor.getDefaultState().withProperty(BlockDoorDummy.FACING, facing));
			worldIn.setBlockState(lowerRightBlockPos,
					PortalBlocks.dummyDoor.getDefaultState().withProperty(BlockDoorDummy.FACING, facing));
		}
	}

	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.DESTROY;
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

	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this.getItem());
	}

	private Item getItem() {
		return Item.getItemFromBlock(this);
	}

	/**
	 * Called before the Block is set to air in the world. Called regardless of if
	 * the player's tool can actually collect this block
	 */
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
		BlockPos upperLeftBlockPos = new BlockPos(pos.getX(), pos.getY() + dy, pos.getZ() + dw);
		BlockPos upperRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY() + dy, pos.getZ() + dz + dw);
		BlockPos lowerRightBlockPos = new BlockPos(pos.getX() + dx, pos.getY(), pos.getZ() + dz);
		facing = facing.rotateY();
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
		worldIn.setBlockState(upperLeftBlockPos, Blocks.AIR.getDefaultState());
		worldIn.setBlockState(upperRightBlockPos, Blocks.AIR.getDefaultState());
		worldIn.setBlockState(lowerRightBlockPos, Blocks.AIR.getDefaultState());

	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	/**
	 * Get the actual Block state of this Block at the given position. This applies
	 * properties not visible in the metadata, such as fence connections.
	 */
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos.up());

		if (iblockstate.getBlock() == this) {
			state = state.withProperty(POWERED, iblockstate.getValue(POWERED));
		}

		return state;
	}

	/**
	 * Returns the blockstate with the given rotation from the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 */
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
	}

	/**
	 * Returns the blockstate with the given mirror of the passed blockstate. If
	 * inapplicable, returns the passed blockstate.
	 */
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return mirrorIn == Mirror.NONE ? state
				: state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
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

	protected static int removeHalfBit(int meta) {
		return meta & 7;
	}

	public static boolean isOpen(IBlockAccess worldIn, BlockPos pos) {
		return isOpen(combineMetadata(worldIn, pos));
	}

	public static EnumFacing getFacing(IBlockAccess worldIn, BlockPos pos) {
		return getFacing(combineMetadata(worldIn, pos));
	}

	public static EnumFacing getFacing(int combinedMeta) {
		return EnumFacing.getHorizontal(combinedMeta & 3).rotateYCCW();
	}

	protected static boolean isOpen(int combinedMeta) {
		return (combinedMeta & 4) != 0;
	}

	protected static boolean isTop(int meta) {
		return (meta & 8) != 0;
	}

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, OPEN, POWERED });
	}

}