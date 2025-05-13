package com.hyrul.prideflagmod.item;

import com.hyrul.prideflagmod.PrideFlags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PATTERN_BI = registerItem("pattern_bi", new Item(new Item.Settings()));
    public static final Item PATTERN_GAY = registerItem("pattern_gay", new Item(new Item.Settings()));
    public static final Item PATTERN_INTER = registerItem("pattern_inter", new Item(new Item.Settings()));
    public static final Item PATTERN_LESB = registerItem("pattern_lesb", new Item(new Item.Settings()));
    public static final Item PATTERN_TRANS = registerItem("pattern_trans", new Item(new Item.Settings()));
    public static final Item PATTERN_PRIDE = registerItem("pattern_pride", new Item(new Item.Settings()));
    public static final Item PATTERN_PROGRESS = registerItem("pattern_progress", new Item(new Item.Settings()));
    public static final Item PATTERN_POLYAMORY = registerItem("pattern_polyamory", new Item(new Item.Settings()));
    public static final Item PATTERN_PANSEXUAL = registerItem("pattern_pansexual", new Item(new Item.Settings()));
    public static final Item PATTERN_NONBINARY = registerItem("pattern_nonbinary", new Item(new Item.Settings()));
    public static final Item PATTERN_ASEXUAL = registerItem("pattern_asexual", new Item(new Item.Settings()));
    public static final Item PATTERN_AROMANTIC = registerItem("pattern_aromantic", new Item(new Item.Settings()));
    public static final Item PATTERN_GENDERFLUID = registerItem("pattern_genderfluid", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PrideFlags.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PrideFlags.LOGGER.info("Registering items for " + PrideFlags.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PATTERN_BI);
            entries.add(PATTERN_GAY);
            entries.add(PATTERN_INTER);
            entries.add(PATTERN_LESB);
            entries.add(PATTERN_TRANS);
            entries.add(PATTERN_PRIDE);
            entries.add(PATTERN_PROGRESS);
            entries.add(PATTERN_POLYAMORY);
            entries.add(PATTERN_PANSEXUAL);
            entries.add(PATTERN_NONBINARY);
            entries.add(PATTERN_ASEXUAL);
            entries.add(PATTERN_AROMANTIC);
            entries.add(PATTERN_GENDERFLUID);
        });
    }
}
