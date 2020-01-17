package lykrast.glassential.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class GlassentialGlassBlock extends Block {

    private final BlockProperties[] properties;
    private final boolean dark;
    private final boolean ethereal;
    private final boolean redstone;
    private final boolean reverseEthereal;

    public GlassentialGlassBlock(BlockProperties... properties) {
        this(settings -> settings, properties);
    }

    public GlassentialGlassBlock(Function<FabricBlockSettings, FabricBlockSettings> settingsApplier, BlockProperties... properties) {
        super(settingsApplier.apply(FabricBlockSettings.copy(Blocks.GLASS)).build());
        this.properties = properties;
        List<BlockProperties> props = Arrays.asList(properties);
        this.dark = props.contains(BlockProperties.DARK);
        this.ethereal = props.contains(BlockProperties.ETHEREAL);
        this.redstone = props.contains(BlockProperties.REDSTONE);
        this.reverseEthereal = props.contains(BlockProperties.REVERSE_ETHEREAL);
    }

    @Deprecated
    @Override
    public int getOpacity(BlockState state, BlockView view, BlockPos pos) {
        return this.dark ? view.getMaxLightLevel() : super.getOpacity(state, view, pos);
    }

    @Deprecated
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView view, BlockPos pos, EntityContext context) {
        if(this.ethereal || this.reverseEthereal) {
            return context.isDescending() == this.reverseEthereal ? state.getOutlineShape(view, pos) : VoxelShapes.empty();
        }
        return super.getCollisionShape(state, view, pos, context);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void buildTooltip(ItemStack stack, BlockView view, List<Text> tooltip, TooltipContext options) {
        for(BlockProperties property : properties) {
            tooltip.add(new TranslatableText(property.getTranslationKey()).formatted(property.getFormatting()));
        }
    }

    @Override
    public boolean emitsRedstonePower(BlockState state) {
        return this.redstone;
    }

    @Override
    public int getWeakRedstonePower(BlockState state, BlockView view, BlockPos pos, Direction direction) {
        return this.redstone ? 15 : super.getWeakRedstonePower(state, view, pos, direction);
    }
}
