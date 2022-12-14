package com.cemi.portalreloaded.tileentity;

import me.ichun.mods.portalgun.common.PortalGun;
import me.ichun.mods.portalgun.common.portal.info.ChannelInfo;
import me.ichun.mods.portalgun.common.portal.info.PortalInfo;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPortalSpawner extends TileEntity {

	public PortalInfo portalInfo;

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		if (portalInfo != null) {
			compound.setString("uuid", portalInfo.uuid);
			compound.setString("channelName", portalInfo.channelName);
			compound.setBoolean("isTypeA", portalInfo.isTypeA);
		}
		return super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		String uuid = compound.getString("uuid");
		String channelName = compound.getString("channelName");
		boolean isTypeA = compound.getBoolean("isTypeA");
		ChannelInfo channelInfo5 = PortalGun.eventHandlerServer.lookupChannel(uuid, channelName);
		portalInfo = new PortalInfo().setInfo(uuid, channelName, isTypeA).setColour(isTypeA ? channelInfo5.colourA : channelInfo5.colourB);
	}
}
