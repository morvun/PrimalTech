package net.morvun.primaltech.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.morvun.primaltech.PrimalTech;
import net.morvun.primaltech.registry.PrimalBlocks;

public class PrimalBlockEntities {
    public static BlockEntityType<PrimalGrindstoneBlockEntity> PRIMAL_GRINDSTONE_BLOCK;

    public static void registerBlockEntities() {
        PRIMAL_GRINDSTONE_BLOCK = Registry.register(Registry.BLOCK_ENTITY_TYPE, 
            new Identifier(PrimalTech.MOD_ID, "primal_grindstone"),
            FabricBlockEntityTypeBuilder.create(PrimalGrindstoneBlockEntity::new, 
                PrimalBlocks.PRIMAL_GRINDSTONE_BLOCK).build());
    }
    
}
