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
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class CommandRemoveFromPath extends CommandBase {

	/**
	 * Gets the name of the command
	 */
	public String getName() {
		return "removefrompath";
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
		return "commands.removefrompath.usage";
	}

	/**
	 * Callback for when the command is executed
	 */
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 2) {
			throw new WrongUsageException("commands.removefrompath.usage", new Object[0]);
		} else {
			Entity entity = getEntity(server, sender, args[0]);
			int i = parseInt(args[1]);
			if (entity instanceof EntityPathFollowing) {
				((EntityPathFollowing) entity).removePathEntry(i);;
				notifyCommandListener(sender, this, "commands.removefrompath.successful",
						new Object[] { entity.getDisplayName() });
			} else {
				throw new WrongUsageException("commands.removefrompath.entityerror", new Object[0]);
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
