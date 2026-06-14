package com.hyrul.prideflagmod.item;

import com.hyrul.prideflagmod.PrideFlags;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

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
            properties -> new ModShieldItem(properties.durability(336).stacksTo(1)));
*/

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        Identifier id = Identifier.fromNamespaceAndPath(PrideFlags.MOD_ID, name);
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, id);
        return Registry.register(BuiltInRegistries.ITEM, id, function.apply(new Item.Properties().setId(key)));
    }

    public static void registerModItems() {
        PrideFlags.LOGGER.info("Registering items for " + PrideFlags.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(PATTERN_BI);
            output.accept(PATTERN_GAY);
            output.accept(PATTERN_INTER);
            output.accept(PATTERN_LESB);
            output.accept(PATTERN_TRANS);
            output.accept(PATTERN_PRIDE);
            output.accept(PATTERN_PROGRESS);
            output.accept(PATTERN_POLYAMORY);
            output.accept(PATTERN_PANSEXUAL);
            output.accept(PATTERN_NONBINARY);
            output.accept(PATTERN_ASEXUAL);
            output.accept(PATTERN_AROMANTIC);
            output.accept(PATTERN_GENDERFLUID);
        });

//        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> {
//            output.accept(SHIELD_TRANS);
//        });
    }
}