package net.morvun.primaltech.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.morvun.primaltech.items.PrimalStoneAxe;
import net.morvun.primaltech.items.materials.PrimalStoneMaterial;

public class PrimalItems {

    public static final String ID = "primaltech";

    private static final ItemGroup PRIMALTECH_ITEM_GROUP = FabricItemGroupBuilder.create(
        new Identifier(ID, "general"))
        .icon(() -> new ItemStack(PrimalItems.PLANT_FIBER_ITEM))
        .build();

    public static final Item PLANT_FIBER_ITEM = new Item(new FabricItemSettings().group(PRIMALTECH_ITEM_GROUP));
    public static final Item PEBBLE_ITEM = new Item(new FabricItemSettings().group(PRIMALTECH_ITEM_GROUP));
    public static final Item PRIMAL_STONE_AXE_HEAD_ITEM = new Item(new FabricItemSettings().group(PRIMALTECH_ITEM_GROUP));

    public static final ToolItem PRIMAL_STONE_AXE = new PrimalStoneAxe(PrimalStoneMaterial.PRIMAL_STONE_MATERIAL, 6, -3.2F, new Item.Settings().group(PRIMALTECH_ITEM_GROUP));

    private static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(ID, "plant_fiber"), PLANT_FIBER_ITEM);
        Registry.register(Registry.ITEM, new Identifier(ID, "pebble"), PEBBLE_ITEM);
        Registry.register(Registry.ITEM, new Identifier(ID, "primal_stone_axe_head"), PRIMAL_STONE_AXE_HEAD_ITEM);
        Registry.register(Registry.ITEM, new Identifier(ID, "primal_stone_axe"), PRIMAL_STONE_AXE);
    }


    public static void registerAll() {
        registerItems();
    }
}
