package lykrast.glassential;

import lykrast.glassential.blocks.DarkEtherealGlassBlock;
import lykrast.glassential.blocks.DarkGlassBlock;
import lykrast.glassential.blocks.EtherealGlassBlock;
import lykrast.glassential.blocks.RedstoneGlassBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Glassential implements ModInitializer {
	public static final String MODID = "glassential";

    public static Block GLASS_DARK;
    public static Block GLASS_DARK_ETHEREAL;
    public static Block GLASS_DARK_ETHEREAL_REVERSE;
    public static Block GLASS_ETHEREAL;
    public static Block GLASS_ETHEREAL_REVERSE;
    public static Block GLASS_GHOSTLY;
    public static Block GLASS_LIGHT;
    public static Block GLASS_REDSTONE;

    public static final ItemGroup GLASSENTIAL_ITEMGROUP = FabricItemGroupBuilder.create(new Identifier(MODID, "items")).icon(() -> new ItemStack(GLASS_LIGHT)).appendItems(itemStacks -> Registry.ITEM.getIds().stream().filter(identifier -> identifier.getNamespace().equals(MODID)).forEachOrdered(identifier -> itemStacks.add(new ItemStack(Registry.ITEM.get(identifier))))).build();

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
        GLASS_DARK = registerBlock("glass_dark", new DarkGlassBlock(Block.Settings.copy(Blocks.GLASS)), ItemGroup.BUILDING_BLOCKS);
        GLASS_DARK_ETHEREAL = registerBlock("glass_dark_ethereal", new DarkEtherealGlassBlock(FabricBlockSettings.copy(Blocks.GLASS).collidable(false).build(), false), ItemGroup.BUILDING_BLOCKS);
        GLASS_DARK_ETHEREAL_REVERSE = registerBlock("glass_dark_ethereal_reverse", new DarkEtherealGlassBlock(FabricBlockSettings.copy(Blocks.GLASS).collidable(false).build(), true), ItemGroup.BUILDING_BLOCKS);
        GLASS_ETHEREAL = registerBlock("glass_ethereal", new EtherealGlassBlock(FabricBlockSettings.copy(Blocks.GLASS).collidable(false).build(), false), ItemGroup.BUILDING_BLOCKS);
        GLASS_ETHEREAL_REVERSE = registerBlock("glass_ethereal_reverse", new EtherealGlassBlock(FabricBlockSettings.copy(Blocks.GLASS).collidable(false).build(), true), ItemGroup.BUILDING_BLOCKS);
        GLASS_GHOSTLY = registerBlock("glass_ghostly", new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).collidable(false).build()), ItemGroup.BUILDING_BLOCKS);
        GLASS_LIGHT = registerBlock("glass_light", new GlassBlock(FabricBlockSettings.copy(Blocks.GLASS).lightLevel(15).build()), ItemGroup.BUILDING_BLOCKS);
        GLASS_REDSTONE = registerBlock("glass_redstone", new RedstoneGlassBlock(Block.Settings.copy(Blocks.GLASS)), ItemGroup.REDSTONE);
	}
}
