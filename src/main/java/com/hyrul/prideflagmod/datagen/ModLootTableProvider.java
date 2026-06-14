package com.hyrul.prideflagmod.datagen;

import com.hyrul.prideflagmod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootSubProvider {
    public ModLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

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

        for (Block flag : prideFlags) {
            dropSelf(flag);
        }
    }
}