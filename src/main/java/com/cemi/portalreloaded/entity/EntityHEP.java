package com.cemi.portalreloaded.entity;

import java.io.Serializable;

import com.cemi.portalreloaded.block.BlockBallTarget;
import com.cemi.portalreloaded.block.PortalBlocks;
import com.cemi.portalreloaded.tileentity.TileEntityBallLauncher;
import com.cemi.portalreloaded.tileentity.TileEntityBallTarget;

import me.ichun.mods.portalgun.common.PortalGun;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityHEP extends Entity implements Serializable {

	double speed = 0.15D;

	BlockPos launcherPos;

	int lifeTime = 320;

	public EntityHEP(World worldIn) {
		super(worldIn);
		setSize(.4F, .4F);
	}

	public EntityHEP(World worldIn, double x, double y, double z) {
		super(worldIn);
		setSize(.4F, .4F);
		setPosition(x, y + 1.0D, z);
		setVelocity(0.0D, speed, 0.0D);
	}
	
	public int getLifeTime() {
		return lifeTime;
	}

	public EntityHEP(World worldIn, double x, double y, double z, EnumFacing facing, BlockPos launcherPos) {
		super(worldIn);
		this.launcherPos = launcherPos;
		setSize(.4F, .4F);

		switch (facing) {
		case UP:
			y++;
			motionY = speed;
			break;
		case DOWN:
			y--;
			motionY = -speed;
			break;
		case EAST:
			x++;
			motionX = speed;
			break;
		case WEST:
			x--;
			motionX = -speed;
			break;
		case NORTH:
			z--;
			motionZ = -speed;
			break;
		case SOUTH:
			z++;
			motionZ = speed;
			break;

		default:
			break;
		}
		setPosition(x, y, z);
	}

	@Override
	protected void entityInit() {

	}

	public void setVelocity(double d, double d1, double d2) {
		this.motionX = d;
		this.motionY = d1;
		this.motionZ = d2;
	}

	@Override
	public void onUpdate() {
		if (!world.isRemote) {
			if (launcherPos == null) {
				setDead();
				return;
			}
			TileEntity bl = world.getTileEntity(launcherPos);
			if (lifeTime <= 0) {
				((TileEntityBallLauncher)bl).spawnHEP();
				world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, posX, posY, posY, 1.0D, 1.0D, 1.0D);
				setDead();
			}
			if (bl != null) {
				if (!((TileEntityBallLauncher) bl).powered) {
					world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, posX, posY, posY, 1.0D, 1.0D, 1.0D);
					setDead();
				}
			} else if (!firstUpdate) {
				world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, posX, posY, posY, 1.0D, 1.0D, 1.0D);
				setDead();
			}

			BlockPos pos = new BlockPos(posX, posY, posZ);
			IBlockState b = world.getBlockState(pos);

			if (b.getBlock() instanceof BlockBallTarget) {
				((TileEntityBallLauncher) bl).deactivate();
				((BlockBallTarget) b.getBlock()).setRedstoneStrength(world, pos, b, 1);
				world.spawnParticle(EnumParticleTypes.CRIT, posX, posY, posY, 1.0D, 1.0D, 1.0D);
				setDead();
			}
		}

		if (firstUpdate) {
			firstUpdate = false;
		}
		if (world.getBlockState(new BlockPos(posX + motionX, posY + motionY, posZ + motionZ)).getBlock() != Blocks.AIR
				&& world.getBlockState(new BlockPos(posX + motionX, posY + motionY, posZ + motionZ))
						.getBlock() != PortalGun.blockPortal
				&& world.getBlockState(new BlockPos(posX + motionX, posY + motionY, posZ + motionZ))
						.getBlock() != PortalBlocks.ballTarget) {
			motionX *= -1.0D;
			motionY *= -1.0D;
			motionZ *= -1.0D;
		}
		else if(world.getBlockState(new BlockPos(posX + motionX, posY + motionY, posZ + motionZ)).getBlock() != Blocks.AIR) {
			lifeTime = 320;
		}
		setPosition(posX + motionX, posY + motionY, posZ + motionZ);

		lifeTime--;
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		if (compound.hasKey("posX") && compound.hasKey("posY") && compound.hasKey("posZ")) {
			launcherPos = new BlockPos(compound.getInteger("posX"), compound.getInteger("posY"),
					compound.getInteger("posZ"));
		}

	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		compound.setInteger("posX", launcherPos.getX());
		compound.setInteger("posY", launcherPos.getY());
		compound.setInteger("posZ", launcherPos.getZ());
	}

}
