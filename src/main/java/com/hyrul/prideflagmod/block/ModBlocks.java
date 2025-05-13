package com.hyrul.prideflagmod.block;

import com.hyrul.prideflagmod.PrideFlags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block FLAG_TRANS = registerBlock("flag_trans", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_GAY = registerBlock("flag_gay", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_BI = registerBlock("flag_bi", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_LESB = registerBlock("flag_lesb", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_INTER = registerBlock("flag_inter", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_PRIDE = registerBlock("flag_pride", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_PROGRESS = registerBlock("flag_progress", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_POLYAMORY = registerBlock("flag_polyamory", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_PANSEXUAL = registerBlock("flag_pansexual", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_NONBINARY = registerBlock("flag_nonbinary", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_ASEXUAL = registerBlock("flag_asexual", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_AROMANTIC = registerBlock("flag_aromantic", new WallFlagBlock(createWallFlagSettings()));
    public static final Block FLAG_GENDERFLUID = registerBlock("flag_genderfluid", new WallFlagBlock(createWallFlagSettings()));


    private static AbstractBlock.Settings createWallFlagSettings() {
        return AbstractBlock.Settings.create()
                .strength(0.5f, 1200f)
                .nonOpaque()
                .sounds(BlockSoundGroup.WOOL);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PrideFlags.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(PrideFlags.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        PrideFlags.LOGGER.info("Registering blocks for " + PrideFlags.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(entries -> {
            entries.add(ModBlocks.FLAG_BI);
            entries.add(ModBlocks.FLAG_TRANS);
            entries.add(ModBlocks.FLAG_GAY);
            entries.add(ModBlocks.FLAG_LESB);
            entries.add(ModBlocks.FLAG_INTER);
            entries.add(ModBlocks.FLAG_PRIDE);
            entries.add(ModBlocks.FLAG_PROGRESS);
            entries.add(ModBlocks.FLAG_POLYAMORY);
            entries.add(ModBlocks.FLAG_PANSEXUAL);
            entries.add(ModBlocks.FLAG_NONBINARY);
            entries.add(ModBlocks.FLAG_ASEXUAL);
            entries.add(ModBlocks.FLAG_AROMANTIC);
            entries.add(ModBlocks.FLAG_GENDERFLUID);
        });
    }

}
