package net.minecraft.data.loot.packs;

import java.util.List;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class VanillaLootTableProvider {
   public static LootTableProvider create(PackOutput p_250807_) {
      return new LootTableProvider(p_250807_, BuiltInLootTables.all(), List.of(new LootTableProvider.SubProviderEntry(VanillaFishingLoot::new, LootContextParamSets.FISHING), new LootTableProvider.SubProviderEntry(VanillaChestLoot::new, LootContextParamSets.CHEST), new LootTableProvider.SubProviderEntry(VanillaEntityLoot::new, LootContextParamSets.ENTITY), new LootTableProvider.SubProviderEntry(VanillaBlockLoot::new, LootContextParamSets.BLOCK), new LootTableProvider.SubProviderEntry(VanillaPiglinBarterLoot::new, LootContextParamSets.PIGLIN_BARTER), new LootTableProvider.SubProviderEntry(VanillaGiftLoot::new, LootContextParamSets.GIFT)));
   }
}