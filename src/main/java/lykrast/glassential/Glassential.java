package lykrast.glassential;

import lykrast.glassential.blocks.BlockProperties;
import lykrast.glassential.blocks.GlassentialGlassBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Glassential implements ModInitializer {
	public static final String MODID = "glassential";

    public static Block TINTED_ETHEREAL_GLASS;
    public static Block TINTED_REVERSE_ETHEREAL_GLASS;
    public static Block ETHEREAL_GLASS;
    public static Block REVERSE_ETHEREAL_GLASS;
    public static Block GHOSTLY_GLASS;
    public static Block LIGHT_GLASS;
    public static Block REDSTONE_GLASS;

    @SuppressWarnings("unused") public static final ItemGroup GLASSENTIAL_ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier(MODID, "items")).icon(() -> new ItemStack(LIGHT_GLASS)).appendItems(itemStacks -> Registry.ITEM.getIds().stream().filter(identifier -> identifier.getNamespace().equals(MODID)).map(Registry.ITEM::get).map(ItemStack::new).forEachOrdered(itemStacks::add)).build();

	@Override
	public void onInitialize() {
        TINTED_ETHEREAL_GLASS = registerBlock("tinted_ethereal_glass", new GlassentialGlassBlock(AbstractBlock.Settings::noCollision, BlockProperties.TINTED, BlockProperties.ETHEREAL));
        TINTED_REVERSE_ETHEREAL_GLASS = registerBlock("tinted_reverse_ethereal_glass", new GlassentialGlassBlock(AbstractBlock.Settings::noCollision, BlockProperties.TINTED, BlockProperties.REVERSE_ETHEREAL));
        ETHEREAL_GLASS = registerBlock("ethereal_glass", new GlassentialGlassBlock(AbstractBlock.Settings::noCollision, BlockProperties.ETHEREAL));
        REVERSE_ETHEREAL_GLASS = registerBlock("reverse_ethereal_glass", new GlassentialGlassBlock(AbstractBlock.Settings::noCollision, BlockProperties.REVERSE_ETHEREAL));
        GHOSTLY_GLASS = registerBlock("ghostly_glass", new GlassentialGlassBlock(AbstractBlock.Settings::noCollision, BlockProperties.GHOSTLY));
        LIGHT_GLASS = registerBlock("light_glass", new GlassentialGlassBlock(settings -> settings.luminance(state -> 15), BlockProperties.LUMINOUS));
        REDSTONE_GLASS = registerBlock("redstone_glass", new GlassentialGlassBlock(BlockProperties.REDSTONE), ItemGroup.REDSTONE);
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
