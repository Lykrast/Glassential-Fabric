package lykrast.glassential.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.entity.EntityContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class EtherealGlassBlock extends GlassBlock {

    private final boolean collideOnSneaking;

    public EtherealGlassBlock(Settings settings, boolean collideOnSneaking) {
        super(settings);
        this.collideOnSneaking = collideOnSneaking;
    }

    @Deprecated
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, EntityContext context) {
        return context.isDescending() == this.collideOnSneaking ? state.getOutlineShape(world, pos) : VoxelShapes.empty();
    }
}
