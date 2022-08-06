package com.cemi.portalreloaded.tileentity;

import java.io.IOException;

import com.cemi.portalreloaded.entity.EntityHEP;
import com.cemi.portalreloaded.utility.Parser;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class TileEntityBallTarget extends TileEntity {

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		
		return super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
	}
}
