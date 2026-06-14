package com.hyrul.prideflagmod.datagen;

import com.hyrul.prideflagmod.PrideFlags;
import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("NullabilityAnnotations")
public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public String getName() {
        return "PrideFlagsMod Recipes";
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput exporter) {
        return new RecipeProvider(provider, exporter) {

            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = provider.lookupOrThrow(Registries.ITEM);

                Map<ItemLike, Block> flagRecipes = Map.ofEntries(
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

                for (Map.Entry<ItemLike, Block> entry : flagRecipes.entrySet()) {
                    ItemLike pattern = entry.getKey();
                    Block flag = entry.getValue();
                    String patternName = BuiltInRegistries.ITEM.getKey(pattern.asItem()).getPath();

                    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.DECORATIONS, flag.asItem())
                            .pattern("N N")
                            .pattern("WPW")
                            .pattern("   ")
                            .define('P', pattern)
                            .define('N', Items.IRON_NUGGET)
                            .define('W', Items.WHITE_WOOL)
                            .unlockedBy("has_" + patternName, this.has(pattern))
                            .save(exporter, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, getFlagId(flag) + "_top")));

                    ShapedRecipeBuilder.shaped(itemLookup, RecipeCategory.DECORATIONS, flag.asItem())
                            .pattern("   ")
                            .pattern("N N")
                            .pattern("WPW")
                            .define('P', pattern)
                            .define('N', Items.IRON_NUGGET)
                            .define('W', Items.WHITE_WOOL)
                            .unlockedBy("has_" + patternName, this.has(pattern))
                            .save(exporter, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, getFlagId(flag) + "_bottom")));
                }

                Item[] whiteMaterial = { Items.WHITE_DYE, Items.BONE_MEAL };

                for (Item white : whiteMaterial) {
                    String whitePath = BuiltInRegistries.ITEM.getKey(white).getPath();

                    createPatternRecipe(exporter, itemLookup, ModItems.PATTERN_TRANS, "pattern_trans_", whitePath, Items.PAPER, white, Items.CYAN_DYE, Items.PINK_DYE);
                    createPatternRecipe(exporter, itemLookup, ModItems.PATTERN_PROGRESS, "pattern_progress_", whitePath, Items.PAPER, white, Items.CYAN_DYE, Items.PINK_DYE, Items.BLACK_DYE, Items.BROWN_DYE);
                    createPatternRecipe(exporter, itemLookup, ModItems.PATTERN_POLYAMORY, "pattern_polyamory_", whitePath, Items.PAPER, white, Items.YELLOW_DYE, Items.CYAN_DYE, Items.PINK_DYE, Items.PURPLE_DYE);
                    createPatternRecipe(exporter, itemLookup, ModItems.PATTERN_NONBINARY, "pattern_nonbinary_", whitePath, Items.PAPER, white, Items.YELLOW_DYE, Items.BLACK_DYE, Items.PURPLE_DYE);
                    createPatternRecipe(exporter, itemLookup, ModItems.PATTERN_LESB, "pattern_lesbian_", whitePath, Items.PAPER, white, Items.PINK_DYE, Items.MAGENTA_DYE, Items.ORANGE_DYE, Items.RED_DYE);
                    createPatternRecipe(exporter, itemLookup, ModItems.PATTERN_GENDERFLUID, "pattern_genderfluid_", whitePath, Items.PAPER, white, Items.PINK_DYE, Items.PURPLE_DYE, Items.BLACK_DYE, Items.BLUE_DYE);
                    createPatternRecipe(exporter, itemLookup, ModItems.PATTERN_GAY, "pattern_gay_", whitePath, Items.PAPER, white, Items.GREEN_DYE, Items.LIME_DYE, Items.BLUE_DYE, Items.LIGHT_BLUE_DYE);
                    createPatternRecipe(exporter, itemLookup, ModItems.PATTERN_ASEXUAL, "pattern_asexual_", whitePath, Items.PAPER, white, Items.BLACK_DYE, Items.GRAY_DYE, Items.PURPLE_DYE);
                    createPatternRecipe(exporter, itemLookup, ModItems.PATTERN_AROMANTIC, "pattern_aromantic_", whitePath, Items.PAPER, white, Items.BLACK_DYE, Items.GRAY_DYE, Items.GREEN_DYE, Items.LIME_DYE);
                }

                saveShapeless(exporter, itemLookup, ModItems.PATTERN_PRIDE, Items.PAPER, Items.RED_DYE, Items.ORANGE_DYE, Items.YELLOW_DYE, Items.GREEN_DYE, Items.BLUE_DYE, Items.PURPLE_DYE);
                saveShapeless(exporter, itemLookup, ModItems.PATTERN_PANSEXUAL, Items.PAPER, Items.YELLOW_DYE, Items.CYAN_DYE, Items.PINK_DYE);
                saveShapeless(exporter, itemLookup, ModItems.PATTERN_INTER, Items.PAPER, Items.YELLOW_DYE, Items.PURPLE_DYE);
                saveShapeless(exporter, itemLookup, ModItems.PATTERN_BI, Items.PAPER, Items.PINK_DYE, Items.BLUE_DYE, Items.PURPLE_DYE);
            }

            private void createPatternRecipe(RecipeOutput output, HolderLookup.RegistryLookup<Item> itemLookup, Item result, String baseName, String suffix, ItemLike... ingredients) {
                ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.MISC, result);
                for (ItemLike i : ingredients) builder.requires(i);
                for (ItemLike i : ingredients) builder.unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(i.asItem()).getPath(), this.has(i));
                builder.save(output, ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, baseName + suffix)));
            }

            private void saveShapeless(RecipeOutput output, HolderLookup.RegistryLookup<Item> itemLookup, Item result, ItemLike... ingredients) {
                ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(itemLookup, RecipeCategory.MISC, result);
                for (ItemLike i : ingredients) builder.requires(i);
                for (ItemLike i : ingredients) builder.unlockedBy("has_" + BuiltInRegistries.ITEM.getKey(i.asItem()).getPath(), this.has(i));
                builder.save(output);
            }
        };
    }

    private static String getFlagId(Block flag) {
        return BuiltInRegistries.BLOCK.getKey(flag).getPath();
    }
}