package lykrast.glassential.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class DarkGlassBlock extends GlassBlock {

    public DarkGlassBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int getOpacity(BlockState state, BlockView view, BlockPos pos) {
        return view.getMaxLightLevel();
    }
}
