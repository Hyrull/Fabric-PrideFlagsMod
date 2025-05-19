package com.hyrul.prideflagmod.datagen;

import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.FLAG_TRANS)
                .pattern("   ")
                .pattern("N N")
                .pattern("WPW")
                .input('P', ModItems.PATTERN_TRANS)
                .input('N', Items.IRON_NUGGET)
                .input('W', Items.WHITE_WOOL)
                .criterion(hasItem(ModItems.PATTERN_TRANS), conditionsFromItem(ModItems.PATTERN_TRANS))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PATTERN_TRANS)
                .input(Items.PAPER)
                .input(Items.PINK_DYE)
                .input(Items.CYAN_DYE)
                .input(Items.WHITE_DYE)
                .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                .offerTo(recipeExporter);
    }
}
