package com.cemi.portalreloaded.block;

import javax.annotation.Nullable;

import com.cemi.portalreloaded.PortalReloaded;
import com.cemi.portalreloaded.block.BlockFloorButton.Sensitivity;
import com.cemi.portalreloaded.block.BlockFloorButton.Style;
import com.cemi.portalreloaded.tileentity.TileEntityIndicatorLight;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class PortalBlocks {

	// APERTURE SCIENCE ELECTRONICS
	public static BlockIndicatorLight indicatorLight = new BlockIndicatorLight();
	public static BlockBallLauncher ballLauncher = new BlockBallLauncher();
	public static BlockBallTarget ballTarget = new BlockBallTarget();
	public static GlassBlock glassBlock = new GlassBlock("glass_block");
	public static BlockFizzlerField fizzlerField = new BlockFizzlerField();
	public static BlockFloorButton floorButton = new BlockFloorButton("floor_button", Sensitivity.EVERYTHING,
			Style.NEW);
	public static BlockFloorButtonDummy dummyFloorButton = new BlockFloorButtonDummy("dummy_floor_button");
	public static BlockDoor door = new BlockDoor("door");
	public static BlockDoorDummy dummyDoor = new BlockDoorDummy("dummy_door");
	public static BlockPortalSpawner portalSpawnerA = new BlockPortalSpawner("portal_spawner_a", true);
	public static BlockPortalSpawner portalSpawnerB = new BlockPortalSpawner("portal_spawner_b", false);

	// GLASS
	public static GlassBlock seemedGlassBlock = new GlassBlock("glass_block_seemed");
	public static PaneBlock glassPane = new PaneBlock("glass_pane");
	public static PaneBlock seemedGlassPane = new PaneBlock("glass_pane_seemed");

	// CONCRETE TILES
	public static PortalBlock smallConcreteTile = new PortalBlock(Material.ROCK, "small_concrete_tile");
	public static PortalBlock mediumConcreteTile = new PortalBlock(Material.ROCK, "medium_concrete_tile");
	public static PortalBlock upperConcreteCollumnTile = new PortalBlock(Material.ROCK, "upper_concrete_collumn_tile");
	public static PortalBlock lowerConcreteCollumnTile = new PortalBlock(Material.ROCK, "lower_concrete_collumn_tile");
	public static BlockCollumn concreteCollumnTile = new BlockCollumn(Material.ROCK, "concrete_collumn_tile",
			lowerConcreteCollumnTile, upperConcreteCollumnTile);
	public static PortalBlock upperLeftConcreteBigTile = new PortalBlock(Material.ROCK, "upper_left_concrete_big_tile");
	public static PortalBlock upperRightConcreteBigTile = new PortalBlock(Material.ROCK,
			"upper_right_concrete_big_tile");
	public static PortalBlock lowerLeftConcreteBigTile = new PortalBlock(Material.ROCK, "lower_left_concrete_big_tile");
	public static PortalBlock lowerRightConcreteBigTile = new PortalBlock(Material.ROCK,
			"lower_right_concrete_big_tile");
	public static BlockBigTile concreteBigTile = new BlockBigTile(Material.ROCK, "concrete_big_tile",
			upperLeftConcreteBigTile, upperRightConcreteBigTile, lowerLeftConcreteBigTile, lowerRightConcreteBigTile);

	// METAL TILES
	public static PortalBlock smallMetalTile = new PortalBlock(Material.ROCK, "small_metal_tile");
	public static PortalBlock mediumMetalTile = new PortalBlock(Material.ROCK, "medium_metal_tile");
	public static PortalBlock upperMetalCollumnTile = new PortalBlock(Material.ROCK, "upper_metal_collumn_tile");
	public static PortalBlock lowerMetalCollumnTile = new PortalBlock(Material.ROCK, "lower_metal_collumn_tile");
	public static BlockCollumn metalCollumnTile = new BlockCollumn(Material.ROCK, "metal_collumn_tile",
			lowerMetalCollumnTile, upperMetalCollumnTile);

	public static PortalBlock upperLeftMetalBigTile = new PortalBlock(Material.ROCK, "upper_left_metal_big_tile");
	public static PortalBlock upperRightMetalBigTile = new PortalBlock(Material.ROCK, "upper_right_metal_big_tile");
	public static PortalBlock lowerLeftMetalBigTile = new PortalBlock(Material.ROCK, "lower_left_metal_big_tile");
	public static PortalBlock lowerRightMetalBigTile = new PortalBlock(Material.ROCK, "lower_right_metal_big_tile");
	public static BlockBigTile metalBigTile = new BlockBigTile(Material.ROCK, "metal_big_tile", upperLeftMetalBigTile,
			upperRightMetalBigTile, lowerLeftMetalBigTile, lowerRightMetalBigTile);

	// LIQUIDS
	public static BlockPortalFluid neurotoxin;

	public static Block[] blocks = {
			// CONCRETE TILES
			smallConcreteTile, mediumConcreteTile, upperConcreteCollumnTile, lowerConcreteCollumnTile,
			concreteCollumnTile, upperLeftConcreteBigTile, upperRightConcreteBigTile, lowerLeftConcreteBigTile,
			lowerRightConcreteBigTile, concreteBigTile,
			// METAL TILES
			smallMetalTile, mediumMetalTile, upperMetalCollumnTile, lowerMetalCollumnTile, metalCollumnTile,
			upperLeftMetalBigTile, upperRightMetalBigTile, lowerLeftMetalBigTile, lowerRightMetalBigTile, metalBigTile,
			// GLASS
			glassBlock, seemedGlassBlock, glassPane, seemedGlassPane,
			// ELECTRONICS
			fizzlerField, ballLauncher, ballTarget, indicatorLight, floorButton, dummyFloorButton, door, dummyDoor,
			portalSpawnerA, portalSpawnerB };

	public static void initializeFluidBlocks() {
		neurotoxin = new BlockPortalFluid("neurotoxin", PortalFluids.neurotoxinFluid, Material.WATER);		
	}
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(blocks);
		registry.register(neurotoxin);
		GameRegistry.registerTileEntity(ballLauncher.getTileEntityClass(), ballLauncher.getRegistryName().toString());
		GameRegistry.registerTileEntity(ballTarget.getTileEntityClass(), ballTarget.getRegistryName().toString());
		GameRegistry.registerTileEntity(indicatorLight.getTileEntityClass(),
				indicatorLight.getRegistryName().toString());
		GameRegistry.registerTileEntity(portalSpawnerA.getTileEntityClass(),
				portalSpawnerA.getRegistryName().toString());
	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		for (Block block : blocks) {
			if (block instanceof PortalBlock)
				registry.register(((PortalBlock) block).createItemBlock());
		}
	}

	public static void registerModels() {
		for (Block block : blocks) {
			if (block instanceof PortalBlock)
				((PortalBlock) block).registerItemModel(Item.getItemFromBlock(block));
		}
	}

	public static void registerBlockColors(final ColorHandlerEvent.Block event) {
		PortalReloaded.proxy.registerBlockColors(event);
	}

	public static void forceCnB() {
		for (Block block : blocks) {
			if (block instanceof PortalBlock)
				((PortalBlock) block).forceCnB();
		}
	}

}
