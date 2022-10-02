package com.cemi.portalreloaded.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import com.cemi.portalreloaded.utility.Parser;
import com.cemi.portalreloaded.utility.Path;
import com.cemi.portalreloaded.utility.Path.PathElement;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityPathFollowing extends Entity {

	double waitTime = 0.0D;

	double speed = 0.0D;

	float rotSpeed = 0.1F;

	boolean shouldFollowPath = false;

	boolean isFollowing = false;

	double xSpeed, ySpeed, zSpeed;
	float pitchRot, yawRot;

	float nextPitch, nextYaw;
	float motionPitch, motionYaw;

	Random r = new Random();

	Path path = new Path();

	PathElement currentElement;

	public EntityPathFollowing(World worldIn) {
		super(worldIn);
		setEntityInvulnerable(true);
	}

	public EntityPathFollowing(World worldIn, double x, double y, double z) {
		super(worldIn);

		setEntityInvulnerable(true);
	}

	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		return true;
	}

	@Override
	public boolean getIsInvulnerable() {
		return true;
	}

	int frameCount = 0;

	public void onUpdate() {
		super.onUpdate();
		if (!world.isRemote) {
			if (shouldFollowPath) {
				frameCount++;
				if (currentElement != null) {
					if ((Math.abs(this.posX - currentElement.x) > speed
							|| Math.abs(this.posZ - currentElement.z) > speed)) {
						this.motionX = this.xSpeed;
						this.motionY = this.ySpeed;
						this.motionZ = this.zSpeed;
						motionPitch = nextPitch;
						motionYaw = nextYaw;
					} else {
						isFollowing = false;
						this.motionX = 0.0D;
						this.motionY = 0.0D;
						this.motionZ = 0.0D;
						motionPitch = 0.0F;
						motionYaw = 0.0F;
						rotationPitch = pitchRot;
						rotationYaw = yawRot;
					}
				} else {
					this.motionX = 0.0D;
					this.motionY = 0.0D;
					this.motionZ = 0.0D;
					motionPitch = 0.0F;
					motionYaw = 0.0F;
					rotationPitch = pitchRot;
					rotationYaw = yawRot;
				}
				if (waitTime <= 0.0D && !isFollowing) {
					isFollowing = true;
					nextPathElement();
				} else {
					waitTime -= 1.0D / 20.0D;
				}
			}
			setPosition(posX + motionX, posY + motionY, posZ + motionZ);
			setRotation(rotationYaw + motionYaw, rotationPitch + motionPitch);

		}

	}

	private void nextPathElement() {
		if (path.isFinished()) {
			shouldFollowPath = false;
			return;
		}
		currentElement = path.pop();

		speed = currentElement.speed;

		waitTime = currentElement.waitTime;

		double at2 = Math.atan2(currentElement.z - this.posZ, currentElement.x - this.posX);
		this.xSpeed = Math.cos(at2) * speed;
		this.zSpeed = Math.sin(at2) * speed;

		double dist = Math.sqrt((currentElement.x - this.posX) * (currentElement.x - this.posX)
				+ (currentElement.z - this.posZ) * (currentElement.z - this.posZ));

		this.ySpeed = (currentElement.y - this.posY) / dist * speed;

		this.pitchRot = currentElement.pitch;
		this.yawRot = currentElement.yaw;

		if ((((rotationYaw - yawRot) % 360 + 360) % 360 < ((yawRot - rotationYaw) % 360 + 360) % 360)) {
			this.nextYaw = -(((rotationYaw - yawRot) % 360 + 360) % 360) / (float) (dist * speed * 16.0D);
		} else {
			this.nextYaw = (((yawRot - rotationYaw) % 360 + 360) % 360) / (float) (dist * speed * 16.0D);
		}

		this.nextPitch = -(rotationPitch - pitchRot) / (float) (dist * speed * 16.0D);

	}

	public void genDefaultPath() {
		clearPath();
		addPathEntry(5.0D, 10.0D, 5.0D, .25D, 1.0D);
		addPathEntry(-5.0D, 10.0D, 5.0D, .25D, 1.0D);
		addPathEntry(-5.0D, 10.0D, -5.0D, .25D, 1.0D);
		addPathEntry(5.0D, 10.0D, -5.0D, .25D, 1.0D);
		startFollowingPath();
	}

	public void startFollowingPath() {
		frameCount = 0;
		path.resetQueue();
		isFollowing = false;
		shouldFollowPath = true;
	}

	public void stopFollowingPath() {
		shouldFollowPath = false;
	}

	public void addPathEntry(double x, double y, double z, double speed) {
		path.push(path.new PathElement(x, y, z, speed));
	}

	public void addPathEntry(double x, double y, double z, double speed, double waitTime) {
		path.push(path.new PathElement(x, y, z, speed, waitTime));
	}

	public void addPathEntry(double x, double y, double z, double speed, double waitTime, float pitch, float yaw) {
		path.push(path.new PathElement(x, y, z, speed, waitTime, pitch, yaw));
	}

	public void removeLastPathEntry() {
		path.pop();
	}

	public void removePathEntry(int i) {
		path.removeElementFromPath(i);
	}

	public void skipToPathEntry(int i) {
		path.skipTo(i);
	}

	public void clearPath() {
		path.clear();
	}

	@Override
	protected void entityInit() {
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		if (compound.hasKey("path")) {
			try {
				path = (Path) Parser.convertFromBytes(compound.getByteArray("path"));
			} catch (ClassNotFoundException | IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		try {
			compound.setByteArray("path", Parser.convertToBytes(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
