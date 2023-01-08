package net.morvun.primaltech.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.morvun.primaltech.PrimalTech;
import net.morvun.primaltech.block.PrimalGrindstone;
import net.morvun.primaltech.block.entity.PrimalBlockEntities;

public class PrimalBlocks {

    public static final Block TIN_ORE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).strength(4.0F).requiresTool());
    public static final PrimalGrindstone PRIMAL_GRINDSTONE_BLOCK = new PrimalGrindstone(FabricBlockSettings.of(Material.METAL));

     
    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(PrimalTech.MOD_ID, "tin_ore"), TIN_ORE_BLOCK);
    }


    public static void registerAll() {
        registerBlocks();
        PrimalBlockEntities.registerBlockEntities();
    }
    
}
