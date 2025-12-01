package com.hyrul.prideflagmod.util;

import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;

import java.util.List;

public class ModLootTableModifiers {
    public static void modifyLootTables() {

        Item[] pridePatterns = {
                ModItems.PATTERN_BI,
                ModItems.PATTERN_GAY,
                ModItems.PATTERN_INTER,
                ModItems.PATTERN_LESB,
                ModItems.PATTERN_TRANS,
                ModItems.PATTERN_PRIDE,
                ModItems.PATTERN_PROGRESS,
                ModItems.PATTERN_POLYAMORY,
                ModItems.PATTERN_PANSEXUAL,
                ModItems.PATTERN_NONBINARY,
                ModItems.PATTERN_ASEXUAL,
                ModItems.PATTERN_AROMANTIC,
                ModItems.PATTERN_GENDERFLUID
        };

        Block[] prideFlags = {
                ModBlocks.FLAG_BI,
                ModBlocks.FLAG_GAY,
                ModBlocks.FLAG_INTER,
                ModBlocks.FLAG_LESB,
                ModBlocks.FLAG_TRANS,
                ModBlocks.FLAG_PRIDE,
                ModBlocks.FLAG_PROGRESS,
                ModBlocks.FLAG_POLYAMORY,
                ModBlocks.FLAG_PANSEXUAL,
                ModBlocks.FLAG_NONBINARY,
                ModBlocks.FLAG_ASEXUAL,
                ModBlocks.FLAG_AROMANTIC,
                ModBlocks.FLAG_GENDERFLUID
        };

        // This array defines what chest it all gets added to. % are defined lower on
        List<RegistryKey<LootTable>> commonLootTables = List.of(
                LootTables.PILLAGER_OUTPOST_CHEST,
                LootTables.WOODLAND_MANSION_CHEST,
                LootTables.SHIPWRECK_TREASURE_CHEST,
                LootTables.VILLAGE_SHEPARD_CHEST,
                LootTables.VILLAGE_WEAPONSMITH_CHEST,
                LootTables.VILLAGE_TOOLSMITH_CHEST,
                LootTables.VILLAGE_ARMORER_CHEST,
                LootTables.VILLAGE_CARTOGRAPHER_CHEST,
                LootTables.VILLAGE_MASON_CHEST,
                LootTables.VILLAGE_BUTCHER_CHEST,
                LootTables.VILLAGE_FLETCHER_CHEST,
                LootTables.VILLAGE_FISHER_CHEST,
                LootTables.VILLAGE_TANNERY_CHEST,
                LootTables.VILLAGE_TEMPLE_CHEST,
                LootTables.VILLAGE_DESERT_HOUSE_CHEST,
                LootTables.VILLAGE_PLAINS_CHEST,
                LootTables.VILLAGE_TAIGA_HOUSE_CHEST,
                LootTables.VILLAGE_SNOWY_HOUSE_CHEST,
                LootTables.VILLAGE_SAVANNA_HOUSE_CHEST
        );

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            for (RegistryKey<LootTable> lootTable : commonLootTables) {
                if (key.equals(lootTable)) {
                    // to turn into a switch case if % gets more specific than this eventually
                    float patternChance = (lootTable == LootTables.PILLAGER_OUTPOST_CHEST || lootTable == LootTables.WOODLAND_MANSION_CHEST) ? 0.005f : 0.01f;
                    float flagChance = (lootTable == LootTables.VILLAGE_SHEPARD_CHEST) ? 0.05f : patternChance; // flag % is always the same as the pattern chance except for the shepard, so

                    // adding everything
                    for (Item pattern : pridePatterns) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(patternChance))
                                .with(ItemEntry.builder(pattern))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                        tableBuilder.pool(poolBuilder.build());
                    }

                    for (Block flag : prideFlags) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(flagChance))
                                .with(ItemEntry.builder(flag))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                        tableBuilder.pool(poolBuilder.build());
                    }
                }
            }
        });
    }
}
