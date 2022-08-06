package com.cemi.portalreloaded.block;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.client.PortalTabs;
import com.cemi.portalreloaded.utility.EntityHelper;

import me.ichun.mods.portalgun.common.PortalGun;
import me.ichun.mods.portalgun.common.entity.EntityPortalProjectile;
import me.ichun.mods.portalgun.common.portal.world.PortalPlacement;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInterModComms;

public class PortalBlock extends Block {

	protected String name;
	protected boolean canPlacePortals = true;
	protected boolean isChiselable = true;

	public PortalBlock(Material material, String name) {
		super(material);

		this.name = name;
		if (name.contains("metal")) {
			canPlacePortals = false;
		}

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(PortalTabs.PORTAL_BUILDING_BLOCKS);
	}
	
	public PortalBlock(Material material, String name, boolean isChiselable) {
		super(material);
		
		this.name = name;
		if (name.contains("metal")) {
			canPlacePortals = false;
		}
		this.isChiselable = isChiselable;
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(PortalTabs.PORTAL_BUILDING_BLOCKS);
	}

	public void registerItemModel(Item itemBlock) {
		PortalReloaded.proxy.registerItemRenderer(itemBlock, 0, name);
	}

	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	public void forceCnB() {
		if(!isChiselable)
			return;
		try {
			FMLInterModComms.sendMessage( "chiselsandbits", "ignoreblocklogic", this.name);
            
        } catch (Exception e) {
            PortalReloaded.log("Exception overriding Chisels & Bits supportedBlocks:");
            e.printStackTrace();
        }
	}

	@Override
	public PortalBlock setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (!(entityIn instanceof EntityPortalProjectile))
			return;

		if (!worldIn.isRemote) {
			EntityPortalProjectile projectile = ((EntityPortalProjectile) entityIn);

			if (projectile.shooter == null)
				return;

			if (!canPlacePortals) {
				if (projectile.portalInfo != null) {
					projectile.portalHeight = 1;
					PortalPlacement portalPlacement = projectile.portalInfo
							.getPortalPlacement(projectile.shooter.world);
					if (portalPlacement != null) {
						portalPlacement.remove(BlockPos.ORIGIN);
					}
					projectile.portalInfo = null;
				}
			}

			Vec3d posVec = new Vec3d(pos).addVector(.5f, 0, .5f);
			Vec3d entVec = projectile.shooter.getPositionVector();
			RayTraceResult result = EntityHelper.rayTrace(worldIn,
					posVec.add(entVec.subtract(posVec).normalize()),
					entVec,
					PortalGun.config.canFireThroughLiquid == 0,
					false, false, PortalBlocks.fizzlerField);
			if (result != null) {
				if (worldIn.getBlockState(result.getBlockPos()).getMaterial() == Material.GLASS)
					if (projectile.portalInfo != null) {
						projectile.portalHeight = 1;
						PortalPlacement portalPlacement = projectile.portalInfo
								.getPortalPlacement(projectile.shooter.world);
						if (portalPlacement != null) {
							portalPlacement.remove(BlockPos.ORIGIN);
						}
						projectile.portalInfo = null;
					}
			}
		}
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
	}
}
