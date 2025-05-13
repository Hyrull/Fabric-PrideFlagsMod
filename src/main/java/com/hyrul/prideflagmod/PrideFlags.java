package com.hyrul.prideflagmod;

import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrideFlags implements ModInitializer {
		public static final String MOD_ID = "prideflagmod";
		public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}