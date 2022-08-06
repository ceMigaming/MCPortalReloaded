package com.cemi.portalreloaded.block;

import java.util.Random;

import com.cemi.portalreloaded.client.PortalTabs;
import com.cemi.portalreloaded.entity.EntityHEP;
import com.cemi.portalreloaded.tileentity.TileEntityBallLauncher;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PaneBlock extends PortalBlock {

	public static final PropertyDirection FACING = BlockDirectional.FACING;
	private final boolean ignoreSimilarity;

	public PaneBlock(String name) {
		super(Material.GLASS, name);
		this.ignoreSimilarity = true;
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		setCreativeTab(PortalTabs.PORTAL_BUILDING_BLOCKS);
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos,
			EnumFacing side) {
		IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
		Block block = iblockstate.getBlock();

		if (this == PortalBlocks.glassPane || this == PortalBlocks.seemedGlassPane) {
			if (block == PortalBlocks.glassPane || block == PortalBlocks.seemedGlassPane) {
				return false;
			}
		}

		return !this.ignoreSimilarity && block == this ? false
				: super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
		this.setDefaultDirection(worldIn, pos, state);
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

			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		}
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		AxisAlignedBB bb = new AxisAlignedBB(0, 0, 0, 1, 1, 1);
		EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
		switch (enumfacing) {
		case DOWN:
			bb = new AxisAlignedBB(0, 0, 0, 1, 2.d / 16.d, 1);
			break;
		case UP:
			bb = new AxisAlignedBB(0, 14.d / 16.d, 0, 1, 1, 1);
			break;
		case NORTH:
			bb = new AxisAlignedBB(0, 0, 0, 1, 1, 2.d / 16.d);
			break;
		case EAST:
			bb = new AxisAlignedBB(14.d / 16.d, 0, 0, 1, 1, 1);
			break;
		case SOUTH:
			bb = new AxisAlignedBB(0, 0, 14.d / 16.d, 1, 1, 1);
			break;
		case WEST:
			bb = new AxisAlignedBB(0, 0, 0, 2.d / 16.d, 1, 1);
			break;

		default:
			break;
		}

		return bb;
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		if (placer.isSneaking())
			worldIn.setBlockState(pos,
					state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer).getOpposite()), 2);
		else
			worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)),
					2);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta & 7));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((EnumFacing) state.getValue(FACING)).getIndex();

		return i;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { FACING });
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

}
