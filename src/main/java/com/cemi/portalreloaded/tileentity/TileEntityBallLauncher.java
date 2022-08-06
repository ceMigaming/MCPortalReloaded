package com.cemi.portalreloaded.tileentity;

import java.io.IOException;

import com.cemi.portalreloaded.entity.EntityHEP;
import com.cemi.portalreloaded.utility.Parser;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityBallLauncher extends TileEntity implements ITickable {

	int timeToSpawn = 40;
	boolean spawning = false;

	boolean active = true;
	
	public boolean powered = false;

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setBoolean("powered", powered);
		compound.setInteger("tts", timeToSpawn);
		compound.setBoolean("spawning", spawning);
		compound.setBoolean("active", active);
		return super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		if(compound.hasKey("powered"))
			powered = compound.getBoolean("powered");
		if(compound.hasKey("tts"))
			timeToSpawn = compound.getInteger("tts");
		if(compound.hasKey("spawning"))
			spawning = compound.getBoolean("spawning");
		if(compound.hasKey("active"))
			active = compound.getBoolean("active");
		super.readFromNBT(compound);
	}

	public void spawnHEP() {
		spawning = true;
	}
	
	public void deactivate() {
		active = false;
	}
	
	public void update() {
		if (!active)
			return;
		if (spawning)
			timeToSpawn--;
		if (timeToSpawn <= 0) {
			EntityHEP hep = new EntityHEP(world, pos.getX() + .5D, pos.getY() + .3D, pos.getZ() + .5D,
					((IBlockState) world.getBlockState(pos)).getValue(BlockDirectional.FACING), pos);
			world.spawnEntity(hep);
			spawning = false;
			timeToSpawn = 40;
		}
	}

	
}
