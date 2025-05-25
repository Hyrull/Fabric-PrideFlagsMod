package com.hyrul.prideflagmod.datagen;

import com.hyrul.prideflagmod.PrideFlags;
import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
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
        Item[] whiteMaterial = {
                Items.WHITE_DYE,
                Items.BONE_MEAL
        };

        // Recipes that work with either bone meal or white dye
        for (Item white : whiteMaterial) {

            // Trans Pattern
            ShapelessRecipeJsonBuilder transBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_TRANS)
                    .input(Items.PAPER)
                    .input(white)
                    .input(Items.CYAN_DYE)
                    .input(Items.PINK_DYE);
            addUnlockCriteriaForItems(transBuilder, Items.PAPER, white, Items.CYAN_DYE, Items.PINK_DYE);
            transBuilder.offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, "pattern_trans_" + Registries.ITEM.getId(white).getPath()));

            // Progress Pattern
            ShapelessRecipeJsonBuilder progressBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_PROGRESS)
                    .input(Items.PAPER)
                    .input(white)
                    .input(Items.CYAN_DYE)
                    .input(Items.PINK_DYE)
                    .input(Items.BLACK_DYE)
                    .input(Items.BROWN_DYE);
            addUnlockCriteriaForItems(progressBuilder, Items.PAPER, white, Items.CYAN_DYE, Items.PINK_DYE, Items.BLACK_DYE, Items.BROWN_DYE);
            progressBuilder.offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, "pattern_progress_" + Registries.ITEM.getId(white).getPath()));

            // Polyamory Pattern
            ShapelessRecipeJsonBuilder polyamoryBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_POLYAMORY)
                    .input(Items.PAPER)
                    .input(white)
                    .input(Items.YELLOW_DYE)
                    .input(Items.CYAN_DYE)
                    .input(Items.PINK_DYE)
                    .input(Items.PURPLE_DYE);
            addUnlockCriteriaForItems(polyamoryBuilder, Items.PAPER, white, Items.CYAN_DYE, Items.PINK_DYE, Items.PURPLE_DYE, Items.YELLOW_DYE);
            polyamoryBuilder.offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, "pattern_polyamory_" + Registries.ITEM.getId(white).getPath()));

            // Nonbinary Pattern
            ShapelessRecipeJsonBuilder nonbinaryBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_NONBINARY)
                    .input(Items.PAPER)
                    .input(white)
                    .input(Items.YELLOW_DYE)
                    .input(Items.BLACK_DYE)
                    .input(Items.PURPLE_DYE);
            addUnlockCriteriaForItems(nonbinaryBuilder, Items.PAPER, white, Items.BLACK_DYE, Items.PURPLE_DYE, Items.YELLOW_DYE);
            nonbinaryBuilder.offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, "pattern_nonbinary_" + Registries.ITEM.getId(white).getPath()));

            // Lesbian Pattern
            ShapelessRecipeJsonBuilder lesbianBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_LESB)
                    .input(Items.PAPER)
                    .input(white)
                    .input(Items.PINK_DYE)
                    .input(Items.MAGENTA_DYE)
                    .input(Items.ORANGE_DYE)
                    .input(Items.RED_DYE);
            addUnlockCriteriaForItems(lesbianBuilder, Items.PAPER, white, Items.PINK_DYE, Items.MAGENTA_DYE, Items.ORANGE_DYE, Items.RED_DYE);
            lesbianBuilder.offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, "pattern_lesbian_" + Registries.ITEM.getId(white).getPath()));

            // Genderfluid Pattern
            ShapelessRecipeJsonBuilder genderfluidbuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_GENDERFLUID)
                    .input(Items.PAPER)
                    .input(white)
                    .input(Items.PINK_DYE)
                    .input(Items.PURPLE_DYE)
                    .input(Items.BLACK_DYE)
                    .input(Items.BLUE_DYE);
            addUnlockCriteriaForItems(genderfluidbuilder, Items.PAPER, white, Items.PINK_DYE, Items.PURPLE_DYE, Items.BLACK_DYE, Items.BLUE_DYE);
            genderfluidbuilder.offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, "pattern_genderfluid_" + Registries.ITEM.getId(white).getPath()));

            // Gay Pattern
            ShapelessRecipeJsonBuilder gayBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_GAY)
                    .input(Items.PAPER)
                    .input(white)
                    .input(Items.GREEN_DYE)
                    .input(Items.LIME_DYE)
                    .input(Items.BLUE_DYE)
                    .input(Items.LIGHT_BLUE_DYE);
            addUnlockCriteriaForItems(gayBuilder, Items.PAPER, white, Items.GREEN_DYE, Items.LIME_DYE, Items.LIGHT_BLUE_DYE, Items.BLUE_DYE);
            gayBuilder.offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, "pattern_gay_" + Registries.ITEM.getId(white).getPath()));

            // Asexual Pattern
            ShapelessRecipeJsonBuilder asexualBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_ASEXUAL)
                    .input(Items.PAPER)
                    .input(white)
                    .input(Items.BLACK_DYE)
                    .input(Items.GRAY_DYE)
                    .input(Items.PURPLE_DYE);
            addUnlockCriteriaForItems(asexualBuilder, Items.PAPER, white, Items.BLACK_DYE, Items.GRAY_DYE, Items.PURPLE_DYE);
            asexualBuilder.offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, "pattern_asexual_" + Registries.ITEM.getId(white).getPath()));

            // Aromantic Pattern
            ShapelessRecipeJsonBuilder aromanticBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_AROMANTIC)
                    .input(Items.PAPER)
                    .input(white)
                    .input(Items.BLACK_DYE)
                    .input(Items.GRAY_DYE)
                    .input(Items.GREEN_DYE)
                    .input(Items.LIME_DYE);
            addUnlockCriteriaForItems(aromanticBuilder, Items.PAPER, white, Items.BLACK_DYE, Items.GRAY_DYE, Items.GREEN_DYE, Items.LIME_DYE);
            aromanticBuilder.offerTo(recipeExporter, Identifier.of(PrideFlags.MOD_ID, "pattern_aromantic_" + Registries.ITEM.getId(white).getPath()));
        }

        // --- Normal Recipes --- these don't have white/bone meal
        // Pride Pattern
        ShapelessRecipeJsonBuilder prideBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_PRIDE)
                .input(Items.PAPER)
                .input(Items.RED_DYE)
                .input(Items.ORANGE_DYE)
                .input(Items.YELLOW_DYE)
                .input(Items.GREEN_DYE)
                .input(Items.BLUE_DYE)
                .input(Items.PURPLE_DYE);
                addUnlockCriteriaForItems(prideBuilder, Items.PAPER, Items.RED_DYE, Items.ORANGE_DYE, Items.YELLOW_DYE, Items.GREEN_DYE, Items.BLUE_DYE, Items.PURPLE_DYE);
                prideBuilder.offerTo(recipeExporter);

        // Pansexual Pattern
        ShapelessRecipeJsonBuilder pansexualBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_PANSEXUAL)
                .input(Items.PAPER)
                .input(Items.YELLOW_DYE)
                .input(Items.CYAN_DYE)
                .input(Items.PINK_DYE);
                addUnlockCriteriaForItems(pansexualBuilder, Items.PAPER, Items.YELLOW_DYE, Items.CYAN_DYE, Items.PINK_DYE);
                pansexualBuilder.offerTo(recipeExporter);

        // Intersex Pattern
        ShapelessRecipeJsonBuilder intersexBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_INTER)
                .input(Items.PAPER)
                .input(Items.YELLOW_DYE)
                .input(Items.PURPLE_DYE);
        addUnlockCriteriaForItems(intersexBuilder, Items.PAPER, Items.YELLOW_DYE, Items.PURPLE_DYE);
        intersexBuilder.offerTo(recipeExporter);

        // Bisexual Pattern
        ShapelessRecipeJsonBuilder bisexualBuilder = ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_BI)
                .input(Items.PAPER)
                .input(Items.PINK_DYE)
                .input(Items.BLUE_DYE)
                .input(Items.PURPLE_DYE);
        addUnlockCriteriaForItems(bisexualBuilder, Items.PAPER, Items.PINK_DYE, Items.PURPLE_DYE, Items.BLUE_DYE);
        bisexualBuilder.offerTo(recipeExporter);

        // ----------- END OF PATTERNS --------------
        // Trans Shield
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SHIELD_TRANS)
//                .pattern("WIW")
//                .pattern("WPW")
//                .pattern(" W ")
//                .input('P', ModItems.PATTERN_TRANS)
//                .input('I', Items.IRON_INGOT)
//                .input('W', Items.OAK_PLANKS)
//                .criterion("has_" + ModItems.PATTERN_TRANS.asItem().getName().getString(), conditionsFromItem(ModItems.PATTERN_TRANS))
//                .offerTo(recipeExporter);
    }

    // method to automate the .criterion to D.R.Y.
    private void addUnlockCriteriaForItems(ShapelessRecipeJsonBuilder builder, Item... items) {
        for (Item item : items) {
            String path = Registries.ITEM.getId(item).getPath();
            builder.criterion("has_" + path, conditionsFromItem(item));
        }
    }

}
