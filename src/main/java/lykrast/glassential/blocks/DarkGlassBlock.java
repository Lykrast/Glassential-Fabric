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
    public int getLightSubtracted(BlockState blockState_1, BlockView blockView_1, BlockPos blockPos_1) {
        return blockView_1.getMaxLightLevel();
    }
}
