package net.morvun.primaltech.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.morvun.primaltech.PrimalTech;
import net.morvun.primaltech.block.primalGrindstone;
import net.morvun.primaltech.entity.primalGrindstoneBlockEntity;

public class PrimalBlocks {

    public static final Block TIN_ORE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0F).requiresTool());
    public static final primalGrindstone PRIMAL_GRINDSTONE_BLOCK = new primalGrindstone(FabricBlockSettings.of(Material.METAL));
    public static final BlockEntityType<primalGrindstoneBlockEntity> PRIMAL_GRINDSTONE_BLOCK_ENTITY = new BlockEntityType<>(null, null, null);

     
    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(PrimalTech.ID, "tin_ore"), TIN_ORE_BLOCK);
    }

    public static void registerBlockEntitys() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(PrimalTech.ID, "primal_grindstone_block_entity"), FabricBlockEntityTypeBuilder.create(primalGrindstoneBlockEntity::new, PRIMAL_GRINDSTONE_BLOCK).build());
    }

    public static void registerAll() {
        registerBlocks();
        registerBlockEntitys();
    }
    
}
