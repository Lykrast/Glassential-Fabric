package lykrast.glassential;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;

import net.minecraft.client.render.RenderLayer;

@SuppressWarnings("unused")
public class GlassentialClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMapImpl.INSTANCE.putBlocks(RenderLayer.getCutout(),
				Glassential.GLASS_DARK, Glassential.GLASS_DARK_ETHEREAL, Glassential.GLASS_DARK_ETHEREAL_REVERSE,
				Glassential.GLASS_ETHEREAL, Glassential.GLASS_ETHEREAL_REVERSE, Glassential.GLASS_GHOSTLY,
				Glassential.GLASS_LIGHT, Glassential.GLASS_REDSTONE
		);
	}
}
