package com.cemi.portalreloaded.block;

import javax.annotation.Nullable;

import com.cemi.portalreloaded.client.PortalTabs;
import com.cemi.portalreloaded.tileentity.TileEntityBallTarget;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBallTarget extends TileEntityBlock<TileEntityBallTarget> {

	public static final PropertyDirection FACING = BlockDirectional.FACING;
	public static final PropertyBool POWERED = PropertyBool.create("powered");

	public BlockBallTarget() {
		super(Material.IRON, "ball_target");
		this.setDefaultState(this.blockState.getBaseState().withProperty(POWERED, Boolean.valueOf(false))
				.withProperty(FACING, EnumFacing.NORTH));
		setCreativeTab(PortalTabs.PORTAL_REDSTONE);
	}

	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
        this.setDefaultDirection(worldIn, pos, state);
    }
	
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)), 2);
	}

	@Override
	public Class<TileEntityBallTarget> getTileEntityClass() {
		return TileEntityBallTarget.class;
	}

	@Override
	public TileEntityBallTarget createTileEntity(World world, IBlockState state) {
		return new TileEntityBallTarget();
	}

	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	private void setDefaultDirection(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
			boolean flag = worldIn.getBlockState(pos.north()).isFullBlock();
			boolean flag1 = worldIn.getBlockState(pos.south()).isFullBlock();

			if (enumfacing == EnumFacing.NORTH && flag && !flag1) {
				enumfacing = EnumFacing.SOUTH;
			} else if (enumfacing == EnumFacing.SOUTH && flag1 && !flag) {
				enumfacing = EnumFacing.NORTH;
			} else {
				boolean flag2 = worldIn.getBlockState(pos.west()).isFullBlock();
				boolean flag3 = worldIn.getBlockState(pos.east()).isFullBlock();

				if (enumfacing == EnumFacing.WEST && flag2 && !flag3) {
					enumfacing = EnumFacing.EAST;
				} else if (enumfacing == EnumFacing.EAST && flag3 && !flag2) {
					enumfacing = EnumFacing.WEST;
				}
			}

			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing).withProperty(POWERED, Boolean.valueOf(false)), 2);
		}
	}

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public boolean canProvidePower(IBlockState state) {
		return true;
	}

	public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return ((Boolean) blockState.getValue(POWERED)).booleanValue() ? 15 : 0;
	}

	public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return ((Boolean) blockState.getValue(POWERED)).booleanValue() ? 15 : 0;
	}

	public IBlockState setRedstoneStrength(World world, BlockPos pos, IBlockState state, int strength) {
		IBlockState bs = state.withProperty(POWERED, true);
		world.setBlockState(pos, bs, 2);
		updateNeighbors(world, pos);
		world.scheduleUpdate(new BlockPos(pos), this, 20);
		return bs;
	}

	public void updateNeighbors(World worldIn, BlockPos pos) {
		worldIn.notifyNeighborsOfStateChange(pos, this, false);
		worldIn.notifyNeighborsOfStateChange(pos.down(), this, false);
	}

	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7)).withProperty(POWERED,
				Boolean.valueOf((meta & 8) > 0));
	}

	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing) state.getValue(FACING)).getIndex();

		if (((Boolean) state.getValue(POWERED)).booleanValue()) {
			i |= 8;
		}

		return i;
	}
	
	public IBlockState withRotation(IBlockState state, Rotation rot)
    {
        return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
    }

    public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
    {
        return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
    }

	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING, POWERED });
	}

}
