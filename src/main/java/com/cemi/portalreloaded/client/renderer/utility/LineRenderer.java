package com.cemi.portalreloaded.client.renderer.utility;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.util.math.Vec3d;

public class LineRenderer {

	Minecraft mc;
	
	public LineRenderer(Minecraft mc) {
		this.mc = mc;
	}
	
	public void render(Vec3d vec1, Vec3d vec2, float partialTicks)
	{
		double doubleX = mc.player.prevPosX + (mc.player.posX - mc.player.prevPosX) * partialTicks; 
		double doubleY = mc.player.prevPosY + (mc.player.posY - mc.player.prevPosY) * partialTicks; 
		double doubleZ = mc.player.prevPosZ + (mc.player.posZ - mc.player.prevPosZ) * partialTicks; 

		GL11.glPushMatrix();
		//GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_TEXTURE_2D);


		GL11.glLineWidth(6);
		GL11.glTranslated(-doubleX, -doubleY, -doubleZ);
		GL11.glColor3ub((byte)255,(byte)0,(byte)0);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glHint( GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST );
		GL11.glBegin(GL11.GL_LINE_STRIP);

		GL11.glVertex3d(vec1.x+0.5f,vec1.y,vec1.z+0.5f);
		GL11.glVertex3d(vec2.x-0.5f,vec2.y,vec2.z+0.5f);
		GL11.glEnd();
		GL11.glColor3ub((byte)255,(byte)255,(byte)255);
		//GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glPopMatrix();
	}
}
