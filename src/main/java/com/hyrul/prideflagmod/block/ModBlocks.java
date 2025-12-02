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
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block FLAG_TRANS = registerBlock("flag_trans", WallFlagBlock::new);
    public static final Block FLAG_GAY = registerBlock("flag_gay", WallFlagBlock::new);
    public static final Block FLAG_BI = registerBlock("flag_bi", WallFlagBlock::new);
    public static final Block FLAG_LESB = registerBlock("flag_lesb", WallFlagBlock::new);
    public static final Block FLAG_INTER = registerBlock("flag_inter", WallFlagBlock::new);
    public static final Block FLAG_PRIDE = registerBlock("flag_pride", WallFlagBlock::new);
    public static final Block FLAG_PROGRESS = registerBlock("flag_progress", WallFlagBlock::new);
    public static final Block FLAG_POLYAMORY = registerBlock("flag_polyamory", WallFlagBlock::new);
    public static final Block FLAG_PANSEXUAL = registerBlock("flag_pansexual", WallFlagBlock::new);
    public static final Block FLAG_NONBINARY = registerBlock("flag_nonbinary", WallFlagBlock::new);
    public static final Block FLAG_ASEXUAL = registerBlock("flag_asexual", WallFlagBlock::new);
    public static final Block FLAG_AROMANTIC = registerBlock("flag_aromantic", WallFlagBlock::new);
    public static final Block FLAG_GENDERFLUID = registerBlock("flag_genderfluid", WallFlagBlock::new);

    private static AbstractBlock.Settings createWallFlagSettings() {
        return AbstractBlock.Settings.create()
                .strength(0.5f, 0.8f)
                .nonOpaque()
                .sounds(BlockSoundGroup.WOOL);
    }

    private static Block registerBlock(String name, java.util.function.Function<AbstractBlock.Settings, Block> factory) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(PrideFlags.MOD_ID, name));
        AbstractBlock.Settings settings = AbstractBlock.Settings.create()
                .registryKey(blockKey)
                .strength(0.5f, 0.8f)
                .nonOpaque()
                .sounds(BlockSoundGroup.WOOL);

        Block block = factory.apply(settings);
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PrideFlags.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(PrideFlags.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PrideFlags.MOD_ID, name)))));
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