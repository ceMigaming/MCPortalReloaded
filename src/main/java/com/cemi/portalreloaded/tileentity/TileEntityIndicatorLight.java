package com.cemi.portalreloaded.tileentity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cemi.portalreloaded.block.BlockIndicatorLight;
import com.cemi.portalreloaded.block.PortalBlocks;
import com.cemi.portalreloaded.utility.ListHelper;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEntityIndicatorLight extends TileEntity {

	List<BlockPos> connectedWires = new ArrayList<BlockPos>();
	boolean isMain = false;
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setBoolean("isMain", isMain);
		compound.setInteger("connectedWiresCount", connectedWires.size());
		int i = 0;
		for (BlockPos blockPos : connectedWires) {
			compound.setLong("connectedWire" + i, blockPos.toLong());
			i++;
		}
		return super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		connectedWires.clear();
		isMain = compound.getBoolean("isMain");
		int connectedWiresCount = compound.getInteger("connectedWiresCount");
		for (int i = 0; i < connectedWiresCount; i++) {
			connectedWires.add(BlockPos.fromLong(compound.getLong("connectedWire" + i)));
		}
	}
	
	public void clearConnectedWires() {
		connectedWires.clear();
	}
	
	public void addConnectedWire(BlockPos pos) {
		if(!ListHelper.contains(connectedWires, pos))
			connectedWires.add(pos);
	}
	
	public void setMain(boolean main) {
		isMain = main;
	}
	
	public boolean isMain() {
		return isMain;
	}
	
	public List<BlockPos> getConnectedWires() {
		return connectedWires;
	}
	
	public void printConnectedWires() {
		ListHelper.print(connectedWires);
	}
	
	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
		if(world.getBlockState(pos).getBlock() != PortalBlocks.indicatorLight)
			return true;
		else return false;
	}
}
