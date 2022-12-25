package com.cemi.portalreloaded.client.renderer.utility;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.lwjgl.util.vector.Quaternion;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;

public class Render {

	public static void renderLine(Vec3d vec1, Vec3d vec2, Color color, float partialTicks) {
		Entity player = Minecraft.getMinecraft().player;

		double playerX = player.prevPosX + (player.posX - player.prevPosX) * partialTicks;
		double playerY = player.prevPosY + (player.posY - player.prevPosY) * partialTicks;
		double playerZ = player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks;

		GlStateManager.pushMatrix();
		GlStateManager.disableTexture2D();
		GlStateManager.disableLighting();
		GlStateManager.disableCull();
		GlStateManager.disableBlend();
		GlStateManager.translate(-playerX, -playerY, -playerZ);
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		bufferbuilder.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(vec1.x, vec1.y, vec1.z)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		bufferbuilder.pos(vec2.x, vec2.y, vec2.z)
				.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.enableLighting();
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
	}

	public static void renderCone(int sides, float radius, float direction, Vec3d entityPos, Vec3d targetPos,
			Color color, float partialTicks) {
		Entity player = Minecraft.getMinecraft().player;

		double playerX = player.prevPosX + (player.posX - player.prevPosX) * partialTicks;
		double playerY = player.prevPosY + (player.posY - player.prevPosY) * partialTicks;
		double playerZ = player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks;

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder circleBufferBuilder = tessellator.getBuffer();
		GlStateManager.pushMatrix();
		GlStateManager.disableTexture2D();
		GlStateManager.disableLighting();
		GlStateManager.disableCull();
		GlStateManager.disableBlend();
		GlStateManager.translate(-playerX, -playerY, -playerZ);
		circleBufferBuilder.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		// draw circle
		for (int i = 0; i <= sides; i++) {
			double angle = 2 * Math.PI * i / sides;
			double x = radius * Math.cos(angle) * Math.cos(Math.toRadians(direction));
			double y = radius * Math.sin(angle);
			double z = radius * Math.cos(angle) * Math.sin(Math.toRadians(direction));
			circleBufferBuilder.pos(targetPos.x + x, targetPos.y + y, targetPos.z + z)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
		}
		tessellator.draw();
		// draw sides
		for (int i = 0; i <= sides; i++) {
			double angle = 2 * Math.PI * i / sides;
			double x = radius * Math.cos(angle) * Math.cos(Math.toRadians(direction));
			double y = radius * Math.sin(angle);
			double z = radius * Math.cos(angle) * Math.sin(Math.toRadians(direction));
			BufferBuilder sidesBufferBuilder = tessellator.getBuffer();
			sidesBufferBuilder.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION_COLOR);
			sidesBufferBuilder.pos(entityPos.x, entityPos.y, entityPos.z)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			sidesBufferBuilder.pos(targetPos.x + x, targetPos.y + y, targetPos.z + z)
					.color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).endVertex();
			tessellator.draw();
		}
		GlStateManager.enableTexture2D();
		GlStateManager.enableLighting();
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
	}

}
