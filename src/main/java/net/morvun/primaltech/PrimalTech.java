package net.morvun.primaltech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.morvun.primaltech.registry.PrimalBlocks;
import net.morvun.primaltech.registry.PrimalItems;


public class PrimalTech implements ModInitializer {

	public static final String ID = "primaltech";

	public static final Logger LOGGER = LoggerFactory.getLogger(ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Primal world!");

		PrimalItems.registerAll();
		PrimalBlocks.registerAll();
	}
}
