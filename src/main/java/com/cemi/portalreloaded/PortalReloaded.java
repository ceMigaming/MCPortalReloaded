package com.cemi.portalreloaded;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import com.cemi.portalreloaded.block.PortalBlocks;
import com.cemi.portalreloaded.block.PortalFluids;
import com.cemi.portalreloaded.client.handlers.ClientEventHandler;
import com.cemi.portalreloaded.command.PortalCommands;
import com.cemi.portalreloaded.entity.PortalEntities;
import com.cemi.portalreloaded.handlers.PacketHandler;
import com.cemi.portalreloaded.item.PortalItems;
import com.cemi.portalreloaded.packets.MessageGrabEvent;
import com.cemi.portalreloaded.packets.MessageKeyEvent;
import com.cemi.portalreloaded.proxy.CommonProxy;
import com.cemi.portalreloaded.sounds.PortalSounds;

import me.ichun.mods.ichunutil.client.keybind.KeyEvent;
import me.ichun.mods.ichunutil.common.core.network.PacketChannel;
import me.ichun.mods.ichunutil.common.grab.GrabHandler;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = PortalReloaded.MODID, name = PortalReloaded.NAME, version = PortalReloaded.VERSION, dependencies = "required-after:ichunutil; required-after:portalgun; after:chiselsandbits;")
public class PortalReloaded {
	public static final String MODID = "portalreloaded";
	public static final String NAME = "Portal Reloaded";
	public static final String VERSION = "0.5";
	public static PacketChannel channel;

	private static Logger logger;

	static {
		FluidRegistry.enableUniversalBucket();
	}

	public static final ItemArmor.ArmorMaterial LONGFALL_BOOTS_MATERIAL = EnumHelper.addArmorMaterial("LONGFALLBOOTS",
			MODID + ":longfallboots", 15, new int[] { 0, 0, 0, 0 }, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F);

	@SidedProxy(serverSide = "com.cemi.portalreloaded.proxy.CommonProxy", clientSide = "com.cemi.portalreloaded.proxy.ClientProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		channel = new PacketChannel("PortalReloaded", new Class[] { MessageKeyEvent.class, MessageGrabEvent.class });
		PacketHandler.register();
		PortalFluids.register();
		PortalBlocks.initializeFluidBlocks();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		try {
			Class<?> clazz = Class.forName("mod.chiselsandbits.core.ChiselsAndBits");
			PortalBlocks.forceCnB();
		} catch (Exception e) {
			log("Chisels&Bits unavailable.");
		}
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		PortalCommands.register(event);
	}

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			PortalItems.register(event.getRegistry());
			PortalBlocks.registerItemBlocks(event.getRegistry());
		}

		@SubscribeEvent
		public static void registerModels(ModelRegistryEvent event) {
			PortalItems.registerModels();
			PortalBlocks.registerModels();
			PortalBlocks.neurotoxin.setupRender();
		}

		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			PortalBlocks.register(event.getRegistry());
		}

		@SubscribeEvent
		public static void registerEntity(RegistryEvent.Register<EntityEntry> event) {
			PortalEntities.register(event.getRegistry());
		}

		@SubscribeEvent
		@SideOnly(Side.CLIENT)
		public static void registerBlockColors(final ColorHandlerEvent.Block event) {
			PortalBlocks.registerBlockColors(event);
		}
		
		@SubscribeEvent(receiveCanceled = true)
		public static void registerSoundEvents(RegistryEvent.Register<SoundEvent> event) {
			PortalSounds.register(event);
		}      

		@SubscribeEvent
		@SideOnly(Side.CLIENT)
		public static void onKeyEvent(KeyEvent event) {
			ClientEventHandler.onKeyEvent(event);
		}

		@SubscribeEvent
		@SideOnly(Side.CLIENT)
		public static void clientTick(TickEvent event) {
		}
	}

	public static void log(Object obj) {
		logger.log(Level.INFO, obj);
	}

	public static void logError(Object obj) {
		logger.log(Level.ERROR, obj);
	}
}
