package lykrast.glassential;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Glassential implements ModInitializer {
	public static final String MODID = "glassential";
	public Block light, redstone, dark, ghostly, ethereal, etherealReverse;
	
	@Override
	public void onInitialize() {
		registerBlocks();
	}
	
	private Block register(String name, Block block, ItemGroup creativeTab) {
		block = Registry.register(Registry.BLOCK, new Identifier(MODID, name), block);
		Registry.register(Registry.ITEM, new Identifier(MODID, name), new BlockItem(block, new Item.Settings().itemGroup(creativeTab)));
		return block;
	}
	
	private void registerBlocks() {
		Block.Settings glass = Block.Settings.copy(Blocks.GLASS);
		light = register("glass_light", new GlassBlock(glass), ItemGroup.BUILDING_BLOCKS);
		redstone = register("glass_redstone", new GlassBlock(glass), ItemGroup.REDSTONE);
		dark = register("glass_dark", new GlassBlock(glass), ItemGroup.BUILDING_BLOCKS);
		ghostly = register("glass_ghostly", new GlassBlock(glass), ItemGroup.BUILDING_BLOCKS);
		ethereal = register("glass_ethereal", new GlassBlock(glass), ItemGroup.BUILDING_BLOCKS);
		etherealReverse = register("glass_ethereal_reverse", new GlassBlock(glass), ItemGroup.BUILDING_BLOCKS);
	}
}
