package com.cemi.portalreloaded.command;

import java.util.Collections;
import java.util.List;

import javax.annotation.Nullable;

import com.cemi.portalreloaded.entity.EntityPathFollowing;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class CommandAddToPath extends CommandBase {

	/**
	 * Gets the name of the command
	 */
	public String getName() {
		return "addtopath";
	}

	/**
	 * Return the required permission level for this command.
	 */
	public int getRequiredPermissionLevel() {
		return 2;
	}

	/**
	 * Gets the usage string for the command.
	 */
	public String getUsage(ICommandSender sender) {
		return "commands.addtopath.usage";
	}

	/**
	 * Callback for when the command is executed
	 */
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		System.out.println(sender.getCommandSenderEntity().rotationPitch);
		System.out.println(sender.getCommandSenderEntity().rotationYaw);
		if (args.length < 2) {
			throw new WrongUsageException("commands.addtopath.usage", new Object[0]);
		} else {

			BlockPos blockpos = sender.getPosition();
			Vec3d vec3d = sender.getPositionVector();
			double x = vec3d.x;
			double y = vec3d.y + 1;
			double z = vec3d.z;

			double speed = 0.25D;
			double waitTime = 0.0D;
			float pitch = sender.getCommandSenderEntity().rotationPitch,
					yaw = sender.getCommandSenderEntity().rotationYaw;

			if (args.length >= 5) {
				x = parseDouble(x, args[1], true);
				y = parseDouble(y, args[2], false);
				z = parseDouble(z, args[3], true);
				speed = parseDouble(args[4]);
				blockpos = new BlockPos(x, y, z);
				if (args.length >= 6) {
					waitTime = parseDouble(args[5]);
					if (args.length >= 8) {
						pitch = (float) parseDouble(args[6]);
						yaw = (float) parseDouble(args[7]);
					}
				}
			} else {
				speed = parseDouble(args[1]);
			}

			Entity entity = getEntity(server, sender, args[0]);
			if (entity instanceof EntityPathFollowing) {
				((EntityPathFollowing) entity).addPathEntry(x, y, z, speed, waitTime, pitch, yaw);
				notifyCommandListener(sender, this, "commands.addtopath.successful",
						new Object[] { entity.getDisplayName() });
			} else {
				throw new WrongUsageException("commands.addtopath.entityError", new Object[0]);
			}
		}
	}

	/**
	 * Return whether the specified command parameter index is a username parameter.
	 */
	public boolean isUsernameIndex(String[] args, int index) {
		return index == 0;
	}

	/**
	 * Get a list of options for when the user presses the TAB key
	 */
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			@Nullable BlockPos targetPos) {
		return Collections.emptyList();
	}

}
