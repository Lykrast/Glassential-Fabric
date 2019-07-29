package lykrast.glassential;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class Glassential implements ModInitializer {
	public static final String MODID = "glassential";

	public static Block GLASS_LIGHT;
	public static Block GLASS_REDSTONE;
	public static Block GLASS_DARK;
	public static Block GLASS_GHOSTLY;
	public static Block GLASS_ETHEREAL;
	public static Block GLASS_ETHEREAL_REVERSE;

	@Override
	public void onInitialize() {
		registerBlocks();
	}
	
	private static Block registerBlock(String name, Block block, ItemGroup creativeTab) {
	    Identifier blockName = new Identifier(MODID, name);
		block = Registry.register(Registry.BLOCK, blockName, block);
		Registry.register(Registry.ITEM, blockName, new BlockItem(block, new Item.Settings().group(creativeTab)));
		return block;
	}
	
	private static void registerBlocks() {
        GLASS_LIGHT = registerBlock("glass_light", new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).lightLevel(15).build()), ItemGroup.BUILDING_BLOCKS);

        GLASS_REDSTONE = registerBlock("glass_redstone", new GlassBlock(Block.Settings.copy(Blocks.GLASS)) {
			@Override
			public boolean emitsRedstonePower(BlockState blockState_1) {
				return true;
			}

			@Override
			public int getWeakRedstonePower(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, Direction direction_1) {
				return 15;
			}
		}, ItemGroup.REDSTONE);

        GLASS_DARK = registerBlock("glass_dark", new GlassBlock(Block.Settings.copy(Blocks.GLASS)) {
			@Override
			public int getLightSubtracted(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
				return blockView_1.getMaxLightLevel();
			}
		}, ItemGroup.BUILDING_BLOCKS);

        GLASS_GHOSTLY = registerBlock("glass_ghostly", new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).collidable(false).build()), ItemGroup.BUILDING_BLOCKS);
		
		//GLASS_ETHEREAL = register("glass_ethereal", new GlassBlock(Block.Settings.copy(Blocks.GLASS)), ItemGroup.BUILDING_BLOCKS);
		//GLASS_ETHEREAL_REVERSE = register("glass_ethereal_reverse", new GlassBlock(Block.Settings.copy(Blocks.GLASS)), ItemGroup.BUILDING_BLOCKS);
	}
}
