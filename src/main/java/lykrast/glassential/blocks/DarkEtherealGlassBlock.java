package lykrast.glassential.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class DarkEtherealGlassBlock extends EtherealGlassBlock {

    public DarkEtherealGlassBlock(Settings settings, boolean collideOnSneaking) {
        super(settings, collideOnSneaking);
    }
    
    @Override
    public int getOpacity(BlockState state, BlockView view, BlockPos pos) {
        return view.getMaxLightLevel();
    }
}
