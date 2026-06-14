package com.hyrul.prideflagmod.datagen;

import com.hyrul.prideflagmod.PrideFlags;
import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver) {

        // Advancement 1 : upon getting any pattern
        AdvancementHolder getPattern = Advancement.Builder.advancement()
                .parent(Identifier.withDefaultNamespace("husbandry/root"))
                .display(
                        ModItems.PATTERN_PROGRESS, // The display icon
                        Component.translatable("advancement.prideflagmod.got_pattern.title"), // The title
                        Component.translatable("advancement.prideflagmod.got_pattern.description"), // The description
                        Identifier.withDefaultNamespace("textures/gui/advancements/backgrounds/adventure.png"), // Background image
                        AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it?
                        true, // Announce it to chat?
                        false // Hidden?
                )
                .addCriterion("has_pride", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_PRIDE))
                .addCriterion("has_trans", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_TRANS))
                .addCriterion("has_gay", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_GAY))
                .addCriterion("has_bi", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_BI))
                .addCriterion("has_lesb", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_LESB))
                .addCriterion("has_progress", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_PROGRESS))
                .addCriterion("has_inter", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_INTER))
                .addCriterion("has_polyamory", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_POLYAMORY))
                .addCriterion("has_pansexual", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_PANSEXUAL))
                .addCriterion("has_nonbinary", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_NONBINARY))
                .addCriterion("has_asexual", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_ASEXUAL))
                .addCriterion("has_aromantic", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_AROMANTIC))
                .addCriterion("has_genderfluid", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PATTERN_GENDERFLUID))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "got_pattern"));

        // Advancement 2 - Get any flag
        AdvancementHolder getFlag = Advancement.Builder.advancement()
                .parent(getPattern)
                .display(
                        ModBlocks.FLAG_PROGRESS, // The display icon
                        Component.translatable("advancement.prideflagmod.got_flag.title"), // The title
                        Component.translatable("advancement.prideflagmod.got_flag.description"), // The description
                        Identifier.withDefaultNamespace("textures/gui/advancements/backgrounds/adventure.png"), // Background image
                        AdvancementType.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it?
                        true, // Announce it to chat?
                        false // Hidden?
                )
                .addCriterion("has_pride_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_PRIDE))
                .addCriterion("has_trans_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_TRANS))
                .addCriterion("has_gay_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_GAY))
                .addCriterion("has_bi_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_BI))
                .addCriterion("has_lesb_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_LESB))
                .addCriterion("has_progress_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_PROGRESS))
                .addCriterion("has_inter_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_INTER))
                .addCriterion("has_polyamory_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_POLYAMORY))
                .addCriterion("has_pansexual_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_PANSEXUAL))
                .addCriterion("has_nonbinary_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_NONBINARY))
                .addCriterion("has_asexual_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_ASEXUAL))
                .addCriterion("has_aromantic_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_AROMANTIC))
                .addCriterion("has_genderfluid_flag", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.FLAG_GENDERFLUID))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, "got_flag"));
    }
}