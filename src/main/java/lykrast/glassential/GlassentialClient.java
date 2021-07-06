package lykrast.glassential;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;

@SuppressWarnings("unused")
public class GlassentialClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderLayer.getCutout(), Glassential.ETHEREAL_GLASS, Glassential.REVERSE_ETHEREAL_GLASS, Glassential.GHOSTLY_GLASS, Glassential.LIGHT_GLASS, Glassential.REDSTONE_GLASS);

        // TODO change to translucent when updating textures for tinted variants
        BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderLayer.getCutout(), Glassential.TINTED_ETHEREAL_GLASS, Glassential.TINTED_REVERSE_ETHEREAL_GLASS);
    }
}
