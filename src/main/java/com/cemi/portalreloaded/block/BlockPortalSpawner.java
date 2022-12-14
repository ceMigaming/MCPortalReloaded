package com.cemi.portalreloaded.block;

import com.cemi.portalreloaded.client.PortalTabs;
import com.cemi.portalreloaded.tileentity.TileEntityBallLauncher;
import com.cemi.portalreloaded.tileentity.TileEntityPortalSpawner;

import me.ichun.mods.portalgun.common.PortalGun;
import me.ichun.mods.portalgun.common.portal.PortalGunHelper;
import me.ichun.mods.portalgun.common.portal.info.ChannelInfo;
import me.ichun.mods.portalgun.common.portal.info.PortalInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BlockPortalSpawner extends TileEntityBlock<TileEntityPortalSpawner> {

	public static final PropertyDirection FACING = BlockDirectional.FACING;
	private boolean isTypeA;
	public BlockPortalSpawner(String name, boolean isTypeA) {
		super(Material.IRON, name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		setCreativeTab(PortalTabs.PORTAL_REDSTONE);
		this.isTypeA = isTypeA;
	}

	@Override
	public Class<TileEntityPortalSpawner> getTileEntityClass() {
		return TileEntityPortalSpawner.class;
	}

	@Override
	public TileEntityPortalSpawner createTileEntity(World world, IBlockState state) {
		return new TileEntityPortalSpawner();
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote) {
			EnumFacing enumfacing = (EnumFacing) state.getValue(FACING);
			if (fromPos.equals(pos.offset(enumfacing)))
				return;
			boolean flag = worldIn.isBlockPowered(pos) || worldIn.isBlockPowered(pos.up());
			if (flag) {
				Vec3d vec3d8 = new Vec3d(EnumFacing.fromAngle((double) 0).getDirectionVec());
				EnumFacing enumFacing9 = EnumFacing.getFacingFromVector((float) vec3d8.x, 0.0f, (float) vec3d8.z);
				PortalInfo portalInfo = ((TileEntityPortalSpawner)worldIn.getTileEntity(pos)).portalInfo;
				com.cemi.portalreloaded.utility.PortalGunHelper.RemovePortals(worldIn, worldIn.provider.getDimension(),
						portalInfo.uuid, portalInfo.channelName, isTypeA ? 1 : 0);
				if (PortalGunHelper.spawnPortal(worldIn, pos, enumfacing, EnumFacing.NORTH, portalInfo, 1, 2,
						PortalGun.config.canPortalsResizeWhenCreated == 1)) {
				}
			} else {
				// ((TileEntityPortalSpawner)worldIn.getTileEntity(pos)).powered = false;
			}
		}
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)), 2);
		if (placer instanceof EntityPlayer) {
			ChannelInfo channelInfo5 = PortalGun.eventHandlerServer.lookupChannel("Global", "Chell");
			PortalInfo portalInfo = new PortalInfo().setInfo("Global", "Chell", isTypeA)
					.setColour(isTypeA ? channelInfo5.colourA : channelInfo5.colourB);
			((TileEntityPortalSpawner)worldIn.getTileEntity(pos)).portalInfo = portalInfo;
		}
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
}
