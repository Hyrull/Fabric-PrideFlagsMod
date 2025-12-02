package com.hyrul.prideflagmod.item;

import com.hyrul.prideflagmod.PrideFlags;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item PATTERN_BI = registerItem("pattern_bi", Item::new);
    public static final Item PATTERN_GAY = registerItem("pattern_gay", Item::new);
    public static final Item PATTERN_INTER = registerItem("pattern_inter", Item::new);
    public static final Item PATTERN_LESB = registerItem("pattern_lesb", Item::new);
    public static final Item PATTERN_TRANS = registerItem("pattern_trans", Item::new);
    public static final Item PATTERN_PRIDE = registerItem("pattern_pride", Item::new);
    public static final Item PATTERN_PROGRESS = registerItem("pattern_progress", Item::new);
    public static final Item PATTERN_POLYAMORY = registerItem("pattern_polyamory", Item::new);
    public static final Item PATTERN_PANSEXUAL = registerItem("pattern_pansexual", Item::new);
    public static final Item PATTERN_NONBINARY = registerItem("pattern_nonbinary", Item::new);
    public static final Item PATTERN_ASEXUAL = registerItem("pattern_asexual", Item::new);
    public static final Item PATTERN_AROMANTIC = registerItem("pattern_aromantic", Item::new);
    public static final Item PATTERN_GENDERFLUID = registerItem("pattern_genderfluid", Item::new);

/*
    public static final Item SHIELD_TRANS = registerItem("shield_trans",
            setting -> new ModShieldItem(setting.maxDamage(336).maxCount(1)));
*/

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(PrideFlags.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(PrideFlags.MOD_ID, name)))));
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

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
//            entries.add(SHIELD_TRANS);
//        });
    }
}