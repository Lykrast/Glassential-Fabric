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
	public Block light, redstone, dark, ghostly, ethereal, etherealReverse;
	
	@Override
	public void onInitialize() {
		registerBlocks();
	}
	
	private Block register(String name, Block block, ItemGroup creativeTab) {
		block = Registry.register(Registry.BLOCK, new Identifier(MODID, name), block);
		Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(block, new Item.Settings().group(creativeTab)));
		return block;
	}
	
	private void registerBlocks() {
		Block.Settings glass = FabricBlockSettings.copy(Blocks.GLASS).build();
		light = register("glass_light", new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).lightLevel(15).build()), ItemGroup.BUILDING_BLOCKS);
		
		redstone = register("glass_redstone", new GlassBlock(glass) {
			@Override
			public boolean emitsRedstonePower(BlockState blockState_1) {
				return true;
			}

			@Override
			public int getWeakRedstonePower(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1, Direction direction_1) {
				return 15;
			}
		}, ItemGroup.REDSTONE);
		
		dark = register("glass_dark", new GlassBlock(glass) {
			@Override
			public int getLightSubtracted(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
				return blockView_1.getMaxLightLevel();
			}
		}, ItemGroup.BUILDING_BLOCKS);
		
		ghostly = register("glass_ghostly", new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).collidable(false).build()), ItemGroup.BUILDING_BLOCKS);
		
		//ethereal = register("glass_ethereal", new GlassBlock(glass), ItemGroup.BUILDING_BLOCKS);
		//etherealReverse = register("glass_ethereal_reverse", new GlassBlock(glass), ItemGroup.BUILDING_BLOCKS);
	}
}
