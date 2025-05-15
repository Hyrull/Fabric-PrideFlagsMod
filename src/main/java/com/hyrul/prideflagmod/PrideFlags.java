package com.hyrul.prideflagmod;

import com.hyrul.prideflagmod.block.ModBlocks;
import com.hyrul.prideflagmod.item.ModItems;
import com.hyrul.prideflagmod.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrideFlags implements ModInitializer {
		public static final String MOD_ID = "prideflagmod";
		public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// registering new blocks & items
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		// adding content to the world chests
		ModLootTableModifiers.modifyLootTables();


		// Adding the patterns & flags to the merchant & wandering merchant trades list
		// define first, for loop then
		Item[] pridePatterns = {
			ModItems.PATTERN_BI,
			ModItems.PATTERN_GAY,
			ModItems.PATTERN_INTER,
			ModItems.PATTERN_LESB,
			ModItems.PATTERN_TRANS,
			ModItems.PATTERN_PRIDE,
			ModItems.PATTERN_PROGRESS,
			ModItems.PATTERN_POLYAMORY,
			ModItems.PATTERN_PANSEXUAL,
			ModItems.PATTERN_NONBINARY,
			ModItems.PATTERN_ASEXUAL,
			ModItems.PATTERN_AROMANTIC,
			ModItems.PATTERN_GENDERFLUID
		};

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

		// items (patterns)
		for (Item pattern : pridePatterns) {
			TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 1, factories -> {
				factories.add(((entity, random) -> new TradeOffer(
						new TradedItem(Items.EMERALD, 1),
						new ItemStack(pattern, 1), 10, 2, 0f)
				));
			});

			TradeOfferHelper.registerWanderingTraderOffers(1, factories -> {
				factories.add(((entity, random) -> new TradeOffer(
						new TradedItem(Items.EMERALD, 1),
						new ItemStack(pattern, 1), 5, 3, 0f)
				));
			});
		}


		// blocks (flags)
		for (Block flag : prideFlags) {
			TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 2, factories -> {
				factories.add(((entity, random) -> new TradeOffer(
						new TradedItem(Items.EMERALD, 2),
						new ItemStack(flag, 1), 10, 2, 0f)
				));
			});

			TradeOfferHelper.registerWanderingTraderOffers(2, factories -> {
				factories.add(((entity, random) -> new TradeOffer(
						new TradedItem(Items.EMERALD, 2),
						new ItemStack(flag, 1), 5, 3, 0f)
				));
			});
		}
	}
}