package com.hyrul.prideflagmod.block;

import com.hyrul.prideflagmod.PrideFlags;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

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

    private static BlockBehaviour.Properties createWallFlagSettings() {
        return BlockBehaviour.Properties.of()
                .destroyTime(0.5f)
                .explosionResistance(0.8f)
                .noOcclusion()
                .sound(SoundType.WOOL);
    }

    private static Block registerBlock(String name, java.util.function.Function<BlockBehaviour.Properties, Block> factory) {
        Identifier id = Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, name);
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);

        BlockBehaviour.Properties properties = BlockBehaviour.Properties.of()
                .setId(blockKey)
                .destroyTime(0.5f)
                .explosionResistance(0.8f)
                .noOcclusion()
                .sound(SoundType.WOOL);

        Block block = factory.apply(properties);
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    private static void registerBlockItem(String name, Block block) {
        Identifier id = Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, name);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);

        Registry.register(BuiltInRegistries.ITEM, id,
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(itemKey)));
    }

    public static void registerModBlocks() {
        PrideFlags.LOGGER.info("Registering blocks for " + PrideFlags.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(output -> {
            output.accept(ModBlocks.FLAG_BI);
            output.accept(ModBlocks.FLAG_TRANS);
            output.accept(ModBlocks.FLAG_GAY);
            output.accept(ModBlocks.FLAG_LESB);
            output.accept(ModBlocks.FLAG_INTER);
            output.accept(ModBlocks.FLAG_PRIDE);
            output.accept(ModBlocks.FLAG_PROGRESS);
            output.accept(ModBlocks.FLAG_POLYAMORY);
            output.accept(ModBlocks.FLAG_PANSEXUAL);
            output.accept(ModBlocks.FLAG_NONBINARY);
            output.accept(ModBlocks.FLAG_ASEXUAL);
            output.accept(ModBlocks.FLAG_AROMANTIC);
            output.accept(ModBlocks.FLAG_GENDERFLUID);
        });
    }
}