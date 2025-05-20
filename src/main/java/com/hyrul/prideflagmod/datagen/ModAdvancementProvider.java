package com.hyrul.prideflagmod.datagen;

import com.hyrul.prideflagmod.PrideFlags;
import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.advancement.AdvancementRequirements;

import java.util.List;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {

        // Advancement 1 : upon getting any pattern

        AdvancementEntry getPattern = Advancement.Builder.create()
                .parent(Identifier.of("husbandry/root")) // Marked for removal, but official docs still use it and didn't give any alternative yet
                .display(
                        ModItems.PATTERN_PROGRESS, // The display icon
                        Text.translatable("advancement.prideflagmod.got_pattern.title"), // The title
                        Text.translatable("advancement.prideflagmod.got_pattern.description"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it?
                        true, // Announce it to chat?
                        false // Hidden?
                )
                .criterion("has_pride", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_PRIDE))
                .criterion("has_trans", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_TRANS))
                .criterion("has_gay", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_GAY))
                .criterion("has_bi", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_BI))
                .criterion("has_lesb", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_LESB))
                .criterion("has_progress", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_PROGRESS))
                .criterion("has_inter", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_INTER))
                .criterion("has_polyamory", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_POLYAMORY))
                .criterion("has_pansexual", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_PANSEXUAL))
                .criterion("has_nonbinary", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_NONBINARY))
                .criterion("has_asexual", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_ASEXUAL))
                .criterion("has_aromantic", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_AROMANTIC))
                .criterion("has_genderfluid", InventoryChangedCriterion.Conditions.items(ModItems.PATTERN_GENDERFLUID))
                .requirements(new AdvancementRequirements(
                        List.of(
                                Arrays.asList(
                                        "has_pride",
                                        "has_trans",
                                        "has_gay",
                                        "has_bi",
                                        "has_lesb",
                                        "has_progress",
                                        "has_inter",
                                        "has_polyamory",
                                        "has_pansexual",
                                        "has_nonbinary",
                                        "has_asexual",
                                        "has_aromantic",
                                        "has_genderfluid"
                                )
                        )
                ))

                .build(consumer, PrideFlags.MOD_ID + "/got_pattern");


        // Advancement 2 - Get any flag
        AdvancementEntry getFlag = Advancement.Builder.create()
                .parent(getPattern)
                .display(
                        ModBlocks.FLAG_PROGRESS, // The display icon
                        Text.translatable("advancement.prideflagmod.got_flag.title"), // The title
                        Text.translatable("advancement.prideflagmod.got_flag.description"), // The description
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.TASK, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it?
                        true, // Announce it to chat?
                        false // Hidden?
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("has_pride_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_PRIDE))
                .criterion("has_trans_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_TRANS))
                .criterion("has_gay_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_GAY))
                .criterion("has_bi_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_BI))
                .criterion("has_lesb_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_LESB))
                .criterion("has_progress_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_PROGRESS))
                .criterion("has_inter_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_INTER))
                .criterion("has_polyamory_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_POLYAMORY))
                .criterion("has_pansexual_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_PANSEXUAL))
                .criterion("has_nonbinary_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_NONBINARY))
                .criterion("has_asexual_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_ASEXUAL))
                .criterion("has_aromantic_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_AROMANTIC))
                .criterion("has_genderfluid_flag", InventoryChangedCriterion.Conditions.items(ModBlocks.FLAG_GENDERFLUID))
                .requirements(new AdvancementRequirements(
                        List.of(
                                Arrays.asList(
                                        "has_pride_flag",
                                        "has_trans_flag",
                                        "has_gay_flag",
                                        "has_bi_flag",
                                        "has_lesb_flag",
                                        "has_progress_flag",
                                        "has_inter_flag",
                                        "has_polyamory_flag",
                                        "has_pansexual_flag",
                                        "has_nonbinary_flag",
                                        "has_asexual_flag",
                                        "has_aromantic_flag",
                                        "has_genderfluid_flag"
                                )
                        )
                ))

                .build(consumer, PrideFlags.MOD_ID + "/got_flag");
    }
}
