package net.morvun.primaltech.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.morvun.primaltech.entity.primalGrindstoneBlockEntity;

public class primalGrindstone extends Block implements BlockEntityProvider {

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new primalGrindstoneBlockEntity(pos, state);
    }

    public primalGrindstone(Settings settings) {
        super(settings);
    }
    
}
