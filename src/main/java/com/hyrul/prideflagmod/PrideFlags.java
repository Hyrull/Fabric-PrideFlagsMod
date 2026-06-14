package com.hyrul.prideflagmod;

import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import com.hyrul.prideflagmod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrideFlags implements ModInitializer {
	public static final String MOD_ID = "prideflagmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// registering new blocks & items
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		// adding content to the world chests
		ModLootTableModifiers.modifyLootTables();

		// Making them flammable
		FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();
		registry.add(ModBlocks.FLAG_BI, 30, 60);
		registry.add(ModBlocks.FLAG_TRANS, 30, 60);
		registry.add(ModBlocks.FLAG_GAY, 30, 60);
		registry.add(ModBlocks.FLAG_LESB, 30, 60);
		registry.add(ModBlocks.FLAG_INTER, 30, 60);
		registry.add(ModBlocks.FLAG_PRIDE, 30, 60);
		registry.add(ModBlocks.FLAG_PROGRESS, 30, 60);
		registry.add(ModBlocks.FLAG_POLYAMORY, 30, 60);
		registry.add(ModBlocks.FLAG_PANSEXUAL, 30, 60);
		registry.add(ModBlocks.FLAG_NONBINARY, 30, 60);
		registry.add(ModBlocks.FLAG_ASEXUAL, 30, 60);
		registry.add(ModBlocks.FLAG_AROMANTIC, 30, 60);
		registry.add(ModBlocks.FLAG_GENDERFLUID, 30, 60);
	}
}