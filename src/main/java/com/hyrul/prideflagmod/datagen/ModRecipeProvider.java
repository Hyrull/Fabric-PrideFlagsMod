package com.hyrul.prideflagmod.datagen;

import com.hyrul.prideflagmod.PrideFlags;
import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static String getFlagId(Block flag) {
        return Registries.BLOCK.getId(flag).getPath();
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        // Array linking each pattern to its flag so i can for loop the recipe generation
        Map<ItemConvertible, Block> flagRecipes = Map.ofEntries(
                Map.entry(ModItems.PATTERN_TRANS, ModBlocks.FLAG_TRANS),
                Map.entry(ModItems.PATTERN_GAY, ModBlocks.FLAG_GAY),
                Map.entry(ModItems.PATTERN_BI, ModBlocks.FLAG_BI),
                Map.entry(ModItems.PATTERN_LESB, ModBlocks.FLAG_LESB),
                Map.entry(ModItems.PATTERN_PRIDE, ModBlocks.FLAG_PRIDE),
                Map.entry(ModItems.PATTERN_PROGRESS, ModBlocks.FLAG_PROGRESS),
                Map.entry(ModItems.PATTERN_INTER, ModBlocks.FLAG_INTER),
                Map.entry(ModItems.PATTERN_POLYAMORY, ModBlocks.FLAG_POLYAMORY),
                Map.entry(ModItems.PATTERN_PANSEXUAL, ModBlocks.FLAG_PANSEXUAL),
                Map.entry(ModItems.PATTERN_NONBINARY, ModBlocks.FLAG_NONBINARY),
                Map.entry(ModItems.PATTERN_ASEXUAL, ModBlocks.FLAG_ASEXUAL),
                Map.entry(ModItems.PATTERN_AROMANTIC, ModBlocks.FLAG_AROMANTIC),
                Map.entry(ModItems.PATTERN_GENDERFLUID, ModBlocks.FLAG_GENDERFLUID)
        );

        // --- REGISTERING FLAG RECIPES ----- patterns are below
        for (Map.Entry<ItemConvertible, Block> entry : flagRecipes.entrySet()) {
            ItemConvertible pattern = entry.getKey();
            Block flag = entry.getValue();

            // Recipe for the top two rows
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, flag)
                    .pattern("N N")
                    .pattern("WPW")
                    .pattern("   ")
                    .input('P', pattern)
                    .input('N', Items.IRON_NUGGET)
                    .input('W', Items.WHITE_WOOL)
                    .criterion("has_" + pattern.asItem().getName().getString(), conditionsFromItem(pattern))
                    .offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, getFlagId(flag) + "_top"));

            // Same, two bottom ones
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, flag)
                    .pattern("   ")
                    .pattern("N N")
                    .pattern("WPW")
                    .input('P', pattern)
                    .input('N', Items.IRON_NUGGET)
                    .input('W', Items.WHITE_WOOL)
                    .criterion("has_" + pattern.asItem().getName().getString(), conditionsFromItem(pattern))
                    .offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, getFlagId(flag) + "_bottom"));
        }

        // --- BUT HOW DO WE MAKE THE PATTERNS, YOU ASK --- behold
        // wait a sec, gonna commit these ones first
    }
}
