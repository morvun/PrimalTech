package net.morvun.primaltech.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.morvun.primaltech.PrimalTech;
import net.morvun.primaltech.items.PrimalStoneAxe;
import net.morvun.primaltech.items.materials.PrimalStoneMaterial;

public class PrimalItems {


    private static final ItemGroup PRIMALTECH_ITEM_GROUP = FabricItemGroupBuilder.create(
        new Identifier(PrimalTech.ID, "general"))
        .icon(() -> new ItemStack(PrimalItems.PLANT_FIBER_ITEM))
        .build();

    public static final Item PLANT_FIBER_ITEM = new Item(new FabricItemSettings().group(PRIMALTECH_ITEM_GROUP));
    public static final Item PEBBLE_ITEM = new Item(new FabricItemSettings().group(PRIMALTECH_ITEM_GROUP));
    public static final Item PRIMAL_STONE_AXE_HEAD_ITEM = new Item(new FabricItemSettings().group(PRIMALTECH_ITEM_GROUP));
    public static final Item RAW_TIN_ITEM = new Item(new FabricItemSettings().group(PRIMALTECH_ITEM_GROUP));
    public static final Item BRONZE_INGOT_ITEM = new Item(new FabricItemSettings().group(PRIMALTECH_ITEM_GROUP));

    public static final ToolItem PRIMAL_STONE_AXE = new PrimalStoneAxe(PrimalStoneMaterial.PRIMAL_STONE_MATERIAL, 6, -3.2F, new Item.Settings().group(PRIMALTECH_ITEM_GROUP));

    private static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(PrimalTech.ID, "plant_fiber"), PLANT_FIBER_ITEM);
        Registry.register(Registry.ITEM, new Identifier(PrimalTech.ID, "pebble"), PEBBLE_ITEM);
        Registry.register(Registry.ITEM, new Identifier(PrimalTech.ID, "primal_stone_axe_head"), PRIMAL_STONE_AXE_HEAD_ITEM);
        Registry.register(Registry.ITEM, new Identifier(PrimalTech.ID, "primal_stone_axe"), PRIMAL_STONE_AXE);
        Registry.register(Registry.ITEM, new Identifier(PrimalTech.ID, "raw_tin"), RAW_TIN_ITEM);
        Registry.register(Registry.ITEM, new Identifier(PrimalTech.ID, "bronze_ingot"), BRONZE_INGOT_ITEM);
    }

    private static void registerBlockItems() {
        Registry.register(Registry.ITEM, new Identifier(PrimalTech.ID, "tin_ore"), new BlockItem(PrimalBlocks.TIN_ORE_BLOCK, new FabricItemSettings().group(PRIMALTECH_ITEM_GROUP)));
        Registry.register(Registry.ITEM, new Identifier(PrimalTech.ID, "primal_grindstone"), new BlockItem(PrimalBlocks.PRIMAL_GRINDSTONE_BLOCK, new FabricItemSettings().group(PRIMALTECH_ITEM_GROUP)));
    }


    public static void registerAll() {
        registerItems();
        registerBlockItems();
    }
}
