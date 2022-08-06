package com.cemi.portalreloaded.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRotatePickedObject implements IMessage, IMessageHandler<MessageRotatePickedObject, IMessage> {

	public int entityId;
	public float rotation;

	public MessageRotatePickedObject() {
	}

	public MessageRotatePickedObject(int entityId, float rotation) {
		this.entityId = entityId;
		this.rotation = rotation;
	}

	@Override
	public IMessage onMessage(MessageRotatePickedObject message, MessageContext ctx) {
		ctx.getServerHandler().player.world.getEntityByID(message.entityId).setRotationYawHead(message.rotation);
		return null;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		entityId = buf.readInt();
		rotation = buf.readFloat();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(entityId);
		buf.writeFloat(rotation);
	}

}
