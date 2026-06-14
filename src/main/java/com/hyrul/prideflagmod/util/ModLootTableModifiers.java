package com.hyrul.prideflagmod.util;

import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

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

        List<ResourceKey<LootTable>> commonLootTables = List.of(
                BuiltInLootTables.PILLAGER_OUTPOST,
                BuiltInLootTables.WOODLAND_MANSION,
                BuiltInLootTables.SHIPWRECK_TREASURE,
                BuiltInLootTables.VILLAGE_SHEPHERD,
                BuiltInLootTables.VILLAGE_WEAPONSMITH,
                BuiltInLootTables.VILLAGE_TOOLSMITH,
                BuiltInLootTables.VILLAGE_ARMORER,
                BuiltInLootTables.VILLAGE_CARTOGRAPHER,
                BuiltInLootTables.VILLAGE_MASON,
                BuiltInLootTables.VILLAGE_BUTCHER,
                BuiltInLootTables.VILLAGE_FLETCHER,
                BuiltInLootTables.VILLAGE_FISHER,
                BuiltInLootTables.VILLAGE_TANNERY,
                BuiltInLootTables.VILLAGE_TEMPLE,
                BuiltInLootTables.VILLAGE_DESERT_HOUSE,
                BuiltInLootTables.VILLAGE_PLAINS_HOUSE,
                BuiltInLootTables.VILLAGE_TAIGA_HOUSE,
                BuiltInLootTables.VILLAGE_SNOWY_HOUSE,
                BuiltInLootTables.VILLAGE_SAVANNA_HOUSE
        );

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (commonLootTables.contains(key)) {
                float patternChance = (key == BuiltInLootTables.PILLAGER_OUTPOST || key == BuiltInLootTables.WOODLAND_MANSION) ? 0.005f : 0.01f;
                float flagChance = (key == BuiltInLootTables.VILLAGE_SHEPHERD) ? 0.05f : patternChance;

                for (Item pattern : pridePatterns) {
                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0f))
                            .when(LootItemRandomChanceCondition.randomChance(patternChance))
                            .add(LootItem.lootTableItem(pattern))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)));

                    tableBuilder.withPool(poolBuilder);
                }

                for (Block flag : prideFlags) {
                    LootPool.Builder poolBuilder = LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1.0f))
                            .when(LootItemRandomChanceCondition.randomChance(flagChance))
                            .add(LootItem.lootTableItem(flag))
                            .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)));

                    tableBuilder.withPool(poolBuilder);
                }
            }
        });
    }
}