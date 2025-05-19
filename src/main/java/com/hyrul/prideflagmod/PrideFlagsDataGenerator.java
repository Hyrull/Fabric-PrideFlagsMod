package com.hyrul.prideflagmod;

import com.hyrul.prideflagmod.datagen.ModAdvancementProvider;
import com.hyrul.prideflagmod.datagen.ModLootTableProvider;
import com.hyrul.prideflagmod.datagen.ModModelProvider;
import com.hyrul.prideflagmod.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PrideFlagsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModAdvancementProvider::new);
	}
}
