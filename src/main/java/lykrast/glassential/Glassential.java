package lykrast.glassential;

import lykrast.glassential.blocks.BlockProperties;
import lykrast.glassential.blocks.GlassentialGlassBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Block;
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

    @SuppressWarnings("unused") public static final ItemGroup GLASSENTIAL_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MODID, "items")).icon(() -> new ItemStack(GLASS_LIGHT)).appendItems(itemStacks -> Registry.ITEM.getIds().stream().filter(identifier -> identifier.getNamespace().equals(MODID)).map(Registry.ITEM::get).map(ItemStack::new).forEachOrdered(itemStacks::add)).build();

	@Override
	public void onInitialize() {
        GLASS_DARK = registerBlock("glass_dark", new GlassentialGlassBlock(BlockProperties.DARK));
        GLASS_DARK_ETHEREAL = registerBlock("glass_dark_ethereal", new GlassentialGlassBlock(settings -> settings.collidable(false), BlockProperties.DARK, BlockProperties.ETHEREAL));
        GLASS_DARK_ETHEREAL_REVERSE = registerBlock("glass_dark_ethereal_reverse", new GlassentialGlassBlock(settings -> settings.collidable(false), BlockProperties.DARK, BlockProperties.REVERSE_ETHEREAL));
        GLASS_ETHEREAL = registerBlock("glass_ethereal", new GlassentialGlassBlock(settings -> settings.collidable(false), BlockProperties.ETHEREAL));
        GLASS_ETHEREAL_REVERSE = registerBlock("glass_ethereal_reverse", new GlassentialGlassBlock(settings -> settings.collidable(false), BlockProperties.REVERSE_ETHEREAL));
        GLASS_GHOSTLY = registerBlock("glass_ghostly", new GlassentialGlassBlock(settings -> settings.collidable(false), BlockProperties.GHOSTLY));
        GLASS_LIGHT = registerBlock("glass_light", new GlassentialGlassBlock(settings -> settings.lightLevel(15), BlockProperties.LUMINOUS));
        GLASS_REDSTONE = registerBlock("glass_redstone", new GlassentialGlassBlock(BlockProperties.REDSTONE), ItemGroup.REDSTONE);
	}

	private static Block registerBlock(String name, Block block, ItemGroup creativeTab) {
	    Identifier blockName = new Identifier(MODID, name);
		block = Registry.register(Registry.BLOCK, blockName, block);
		Registry.register(Registry.ITEM, blockName, new BlockItem(block, new Item.Settings().group(creativeTab)));
		return block;
	}

    private static Block registerBlock(String name, Block block) {
	    return registerBlock(name, block, ItemGroup.BUILDING_BLOCKS);
    }
}
