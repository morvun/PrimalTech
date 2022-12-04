package net.morvun.primaltech;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PrimalTech implements ModInitializer {

	public static final String ID = "primaltech";

	public static final Logger LOGGER = LoggerFactory.getLogger(ID);


	//Item Group
	public static final ItemGroup PRIMALTECH_ITEM_GROUP = FabricItemGroupBuilder.build(
		new Identifier(ID, "general"),
		() -> new ItemStack(PrimalTech.PLANT_FIBER_ITEM));

	//Items
	public static final Item PLANT_FIBER_ITEM =
		Registry.register(Registry.ITEM, new Identifier(ID, "plant_fiber"),
			new Item(new FabricItemSettings().group(PrimalTech.PRIMALTECH_ITEM_GROUP)));

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Primal world!");
	}
}
