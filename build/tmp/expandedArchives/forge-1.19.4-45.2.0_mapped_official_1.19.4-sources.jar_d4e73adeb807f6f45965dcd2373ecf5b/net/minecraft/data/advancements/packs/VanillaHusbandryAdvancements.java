package net.minecraft.data.advancements.packs;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.stream.Stream;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.BeeNestDestroyedTrigger;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.BredAnimalsTrigger;
import net.minecraft.advancements.critereon.ConsumeItemTrigger;
import net.minecraft.advancements.critereon.EffectsChangedTrigger;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.EntityPredicate;
import net.minecraft.advancements.critereon.EntitySubPredicate;
import net.minecraft.advancements.critereon.FilledBucketTrigger;
import net.minecraft.advancements.critereon.FishingRodHookedTrigger;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemInteractWithBlockTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.PickedUpItemTrigger;
import net.minecraft.advancements.critereon.PlacedBlockTrigger;
import net.minecraft.advancements.critereon.PlayerInteractTrigger;
import net.minecraft.advancements.critereon.StartRidingTrigger;
import net.minecraft.advancements.critereon.TameAnimalTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.HoneycombItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;

public class VanillaHusbandryAdvancements implements AdvancementSubProvider {
   public static final List<EntityType<?>> BREEDABLE_ANIMALS = List.of(EntityType.HORSE, EntityType.DONKEY, EntityType.MULE, EntityType.SHEEP, EntityType.COW, EntityType.MOOSHROOM, EntityType.PIG, EntityType.CHICKEN, EntityType.WOLF, EntityType.OCELOT, EntityType.RABBIT, EntityType.LLAMA, EntityType.CAT, EntityType.PANDA, EntityType.FOX, EntityType.BEE, EntityType.HOGLIN, EntityType.STRIDER, EntityType.GOAT, EntityType.AXOLOTL);
   public static final List<EntityType<?>> INDIRECTLY_BREEDABLE_ANIMALS = List.of(EntityType.TURTLE, EntityType.FROG);
   private static final Item[] FISH = new Item[]{Items.COD, Items.TROPICAL_FISH, Items.PUFFERFISH, Items.SALMON};
   private static final Item[] FISH_BUCKETS = new Item[]{Items.COD_BUCKET, Items.TROPICAL_FISH_BUCKET, Items.PUFFERFISH_BUCKET, Items.SALMON_BUCKET};
   private static final Item[] EDIBLE_ITEMS = new Item[]{Items.APPLE, Items.MUSHROOM_STEW, Items.BREAD, Items.PORKCHOP, Items.COOKED_PORKCHOP, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE, Items.COD, Items.SALMON, Items.TROPICAL_FISH, Items.PUFFERFISH, Items.COOKED_COD, Items.COOKED_SALMON, Items.COOKIE, Items.MELON_SLICE, Items.BEEF, Items.COOKED_BEEF, Items.CHICKEN, Items.COOKED_CHICKEN, Items.ROTTEN_FLESH, Items.SPIDER_EYE, Items.CARROT, Items.POTATO, Items.BAKED_POTATO, Items.POISONOUS_POTATO, Items.GOLDEN_CARROT, Items.PUMPKIN_PIE, Items.RABBIT, Items.COOKED_RABBIT, Items.RABBIT_STEW, Items.MUTTON, Items.COOKED_MUTTON, Items.CHORUS_FRUIT, Items.BEETROOT, Items.BEETROOT_SOUP, Items.DRIED_KELP, Items.SUSPICIOUS_STEW, Items.SWEET_BERRIES, Items.HONEY_BOTTLE, Items.GLOW_BERRIES};
   private static final Item[] WAX_SCRAPING_TOOLS = new Item[]{Items.WOODEN_AXE, Items.GOLDEN_AXE, Items.STONE_AXE, Items.IRON_AXE, Items.DIAMOND_AXE, Items.NETHERITE_AXE};

   public void generate(HolderLookup.Provider p_255680_, Consumer<Advancement> p_251389_) {
      Advancement advancement = Advancement.Builder.advancement().display(Blocks.HAY_BLOCK, Component.translatable("advancements.husbandry.root.title"), Component.translatable("advancements.husbandry.root.description"), new ResourceLocation("textures/gui/advancements/backgrounds/husbandry.png"), FrameType.TASK, false, false, false).addCriterion("consumed_item", ConsumeItemTrigger.TriggerInstance.usedItem()).save(p_251389_, "husbandry/root");
      Advancement advancement1 = Advancement.Builder.advancement().parent(advancement).display(Items.WHEAT, Component.translatable("advancements.husbandry.plant_seed.title"), Component.translatable("advancements.husbandry.plant_seed.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).requirements(RequirementsStrategy.OR).addCriterion("wheat", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.WHEAT)).addCriterion("pumpkin_stem", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.PUMPKIN_STEM)).addCriterion("melon_stem", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.MELON_STEM)).addCriterion("beetroots", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.BEETROOTS)).addCriterion("nether_wart", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.NETHER_WART)).addCriterion("torchflower", PlacedBlockTrigger.TriggerInstance.placedBlock(Blocks.TORCHFLOWER_CROP)).save(p_251389_, "husbandry/plant_seed");
      Advancement advancement2 = Advancement.Builder.advancement().parent(advancement).display(Items.WHEAT, Component.translatable("advancements.husbandry.breed_an_animal.title"), Component.translatable("advancements.husbandry.breed_an_animal.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).requirements(RequirementsStrategy.OR).addCriterion("bred", BredAnimalsTrigger.TriggerInstance.bredAnimals()).save(p_251389_, "husbandry/breed_an_animal");
      createBreedAllAnimalsAdvancement(advancement2, p_251389_, BREEDABLE_ANIMALS.stream(), INDIRECTLY_BREEDABLE_ANIMALS.stream());
      this.addFood(Advancement.Builder.advancement()).parent(advancement1).display(Items.APPLE, Component.translatable("advancements.husbandry.balanced_diet.title"), Component.translatable("advancements.husbandry.balanced_diet.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(100)).save(p_251389_, "husbandry/balanced_diet");
      Advancement.Builder.advancement().parent(advancement1).display(Items.NETHERITE_HOE, Component.translatable("advancements.husbandry.netherite_hoe.title"), Component.translatable("advancements.husbandry.netherite_hoe.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(100)).addCriterion("netherite_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(Items.NETHERITE_HOE)).save(p_251389_, "husbandry/obtain_netherite_hoe");
      Advancement advancement3 = Advancement.Builder.advancement().parent(advancement).display(Items.LEAD, Component.translatable("advancements.husbandry.tame_an_animal.title"), Component.translatable("advancements.husbandry.tame_an_animal.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("tamed_animal", TameAnimalTrigger.TriggerInstance.tamedAnimal()).save(p_251389_, "husbandry/tame_an_animal");
      Advancement advancement4 = this.addFish(Advancement.Builder.advancement()).parent(advancement).requirements(RequirementsStrategy.OR).display(Items.FISHING_ROD, Component.translatable("advancements.husbandry.fishy_business.title"), Component.translatable("advancements.husbandry.fishy_business.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).save(p_251389_, "husbandry/fishy_business");
      Advancement advancement5 = this.addFishBuckets(Advancement.Builder.advancement()).parent(advancement4).requirements(RequirementsStrategy.OR).display(Items.PUFFERFISH_BUCKET, Component.translatable("advancements.husbandry.tactical_fishing.title"), Component.translatable("advancements.husbandry.tactical_fishing.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).save(p_251389_, "husbandry/tactical_fishing");
      Advancement advancement6 = Advancement.Builder.advancement().parent(advancement5).requirements(RequirementsStrategy.OR).addCriterion(BuiltInRegistries.ITEM.getKey(Items.AXOLOTL_BUCKET).getPath(), FilledBucketTrigger.TriggerInstance.filledBucket(ItemPredicate.Builder.item().of(Items.AXOLOTL_BUCKET).build())).display(Items.AXOLOTL_BUCKET, Component.translatable("advancements.husbandry.axolotl_in_a_bucket.title"), Component.translatable("advancements.husbandry.axolotl_in_a_bucket.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).save(p_251389_, "husbandry/axolotl_in_a_bucket");
      Advancement.Builder.advancement().parent(advancement6).addCriterion("kill_axolotl_target", EffectsChangedTrigger.TriggerInstance.gotEffectsFrom(EntityPredicate.Builder.entity().of(EntityType.AXOLOTL).build())).display(Items.TROPICAL_FISH_BUCKET, Component.translatable("advancements.husbandry.kill_axolotl_target.title"), Component.translatable("advancements.husbandry.kill_axolotl_target.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).save(p_251389_, "husbandry/kill_axolotl_target");
      this.addCatVariants(Advancement.Builder.advancement()).parent(advancement3).display(Items.COD, Component.translatable("advancements.husbandry.complete_catalogue.title"), Component.translatable("advancements.husbandry.complete_catalogue.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(50)).save(p_251389_, "husbandry/complete_catalogue");
      Advancement advancement7 = Advancement.Builder.advancement().parent(advancement).addCriterion("safely_harvest_honey", ItemInteractWithBlockTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(BlockTags.BEEHIVES).build()).setSmokey(true), ItemPredicate.Builder.item().of(Items.GLASS_BOTTLE))).display(Items.HONEY_BOTTLE, Component.translatable("advancements.husbandry.safely_harvest_honey.title"), Component.translatable("advancements.husbandry.safely_harvest_honey.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).save(p_251389_, "husbandry/safely_harvest_honey");
      Advancement advancement8 = Advancement.Builder.advancement().parent(advancement7).display(Items.HONEYCOMB, Component.translatable("advancements.husbandry.wax_on.title"), Component.translatable("advancements.husbandry.wax_on.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("wax_on", ItemInteractWithBlockTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(HoneycombItem.WAXABLES.get().keySet()).build()), ItemPredicate.Builder.item().of(Items.HONEYCOMB))).save(p_251389_, "husbandry/wax_on");
      Advancement.Builder.advancement().parent(advancement8).display(Items.STONE_AXE, Component.translatable("advancements.husbandry.wax_off.title"), Component.translatable("advancements.husbandry.wax_off.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("wax_off", ItemInteractWithBlockTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(HoneycombItem.WAX_OFF_BY_BLOCK.get().keySet()).build()), ItemPredicate.Builder.item().of(WAX_SCRAPING_TOOLS))).save(p_251389_, "husbandry/wax_off");
      Advancement advancement9 = Advancement.Builder.advancement().parent(advancement).addCriterion(BuiltInRegistries.ITEM.getKey(Items.TADPOLE_BUCKET).getPath(), FilledBucketTrigger.TriggerInstance.filledBucket(ItemPredicate.Builder.item().of(Items.TADPOLE_BUCKET).build())).display(Items.TADPOLE_BUCKET, Component.translatable("advancements.husbandry.tadpole_in_a_bucket.title"), Component.translatable("advancements.husbandry.tadpole_in_a_bucket.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).save(p_251389_, "husbandry/tadpole_in_a_bucket");
      Advancement advancement10 = this.addLeashedFrogVariants(Advancement.Builder.advancement()).parent(advancement9).display(Items.LEAD, Component.translatable("advancements.husbandry.leash_all_frog_variants.title"), Component.translatable("advancements.husbandry.leash_all_frog_variants.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).save(p_251389_, "husbandry/leash_all_frog_variants");
      Advancement.Builder.advancement().parent(advancement10).display(Items.VERDANT_FROGLIGHT, Component.translatable("advancements.husbandry.froglights.title"), Component.translatable("advancements.husbandry.froglights.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).addCriterion("froglights", InventoryChangeTrigger.TriggerInstance.hasItems(Items.OCHRE_FROGLIGHT, Items.PEARLESCENT_FROGLIGHT, Items.VERDANT_FROGLIGHT)).save(p_251389_, "husbandry/froglights");
      Advancement.Builder.advancement().parent(advancement).addCriterion("silk_touch_nest", BeeNestDestroyedTrigger.TriggerInstance.destroyedBeeNest(Blocks.BEE_NEST, ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))), MinMaxBounds.Ints.exactly(3))).display(Blocks.BEE_NEST, Component.translatable("advancements.husbandry.silk_touch_nest.title"), Component.translatable("advancements.husbandry.silk_touch_nest.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).save(p_251389_, "husbandry/silk_touch_nest");
      Advancement.Builder.advancement().parent(advancement).display(Items.OAK_BOAT, Component.translatable("advancements.husbandry.ride_a_boat_with_a_goat.title"), Component.translatable("advancements.husbandry.ride_a_boat_with_a_goat.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("ride_a_boat_with_a_goat", StartRidingTrigger.TriggerInstance.playerStartsRiding(EntityPredicate.Builder.entity().vehicle(EntityPredicate.Builder.entity().of(EntityType.BOAT).passenger(EntityPredicate.Builder.entity().of(EntityType.GOAT).build()).build()))).save(p_251389_, "husbandry/ride_a_boat_with_a_goat");
      Advancement.Builder.advancement().parent(advancement).display(Items.GLOW_INK_SAC, Component.translatable("advancements.husbandry.make_a_sign_glow.title"), Component.translatable("advancements.husbandry.make_a_sign_glow.description"), (ResourceLocation)null, FrameType.TASK, true, true, false).addCriterion("make_a_sign_glow", ItemInteractWithBlockTrigger.TriggerInstance.itemUsedOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(BlockTags.ALL_SIGNS).build()), ItemPredicate.Builder.item().of(Items.GLOW_INK_SAC))).save(p_251389_, "husbandry/make_a_sign_glow");
      Advancement advancement11 = Advancement.Builder.advancement().parent(advancement).display(Items.COOKIE, Component.translatable("advancements.husbandry.allay_deliver_item_to_player.title"), Component.translatable("advancements.husbandry.allay_deliver_item_to_player.description"), (ResourceLocation)null, FrameType.TASK, true, true, true).addCriterion("allay_deliver_item_to_player", PickedUpItemTrigger.TriggerInstance.thrownItemPickedUpByPlayer(EntityPredicate.Composite.ANY, ItemPredicate.ANY, EntityPredicate.Composite.wrap(EntityPredicate.Builder.entity().of(EntityType.ALLAY).build()))).save(p_251389_, "husbandry/allay_deliver_item_to_player");
      Advancement.Builder.advancement().parent(advancement11).display(Items.NOTE_BLOCK, Component.translatable("advancements.husbandry.allay_deliver_cake_to_note_block.title"), Component.translatable("advancements.husbandry.allay_deliver_cake_to_note_block.description"), (ResourceLocation)null, FrameType.TASK, true, true, true).addCriterion("allay_deliver_cake_to_note_block", ItemInteractWithBlockTrigger.TriggerInstance.allayDropItemOnBlock(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(Blocks.NOTE_BLOCK).build()), ItemPredicate.Builder.item().of(Items.CAKE))).save(p_251389_, "husbandry/allay_deliver_cake_to_note_block");
   }

   public static Advancement createBreedAllAnimalsAdvancement(Advancement p_267284_, Consumer<Advancement> p_266923_, Stream<EntityType<?>> p_266961_, Stream<EntityType<?>> p_266751_) {
      return addBreedable(Advancement.Builder.advancement(), p_266961_, p_266751_).parent(p_267284_).display(Items.GOLDEN_CARROT, Component.translatable("advancements.husbandry.breed_all_animals.title"), Component.translatable("advancements.husbandry.breed_all_animals.description"), (ResourceLocation)null, FrameType.CHALLENGE, true, true, false).rewards(AdvancementRewards.Builder.experience(100)).save(p_266923_, "husbandry/bred_all_animals");
   }

   private Advancement.Builder addLeashedFrogVariants(Advancement.Builder p_249739_) {
      BuiltInRegistries.FROG_VARIANT.holders().forEach((p_249424_) -> {
         p_249739_.addCriterion(p_249424_.key().location().toString(), PlayerInteractTrigger.TriggerInstance.itemUsedOnEntity(ItemPredicate.Builder.item().of(Items.LEAD), EntityPredicate.Composite.wrap(EntityPredicate.Builder.entity().of(EntityType.FROG).subPredicate(EntitySubPredicate.variant(p_249424_.value())).build())));
      });
      return p_249739_;
   }

   private Advancement.Builder addFood(Advancement.Builder p_248532_) {
      for(Item item : EDIBLE_ITEMS) {
         p_248532_.addCriterion(BuiltInRegistries.ITEM.getKey(item).getPath(), ConsumeItemTrigger.TriggerInstance.usedItem(item));
      }

      return p_248532_;
   }

   private static Advancement.Builder addBreedable(Advancement.Builder p_266978_, Stream<EntityType<?>> p_267147_, Stream<EntityType<?>> p_267091_) {
      p_267147_.forEach((p_266621_) -> {
         p_266978_.addCriterion(EntityType.getKey(p_266621_).toString(), BredAnimalsTrigger.TriggerInstance.bredAnimals(EntityPredicate.Builder.entity().of(p_266621_)));
      });
      p_267091_.forEach((p_266619_) -> {
         p_266978_.addCriterion(EntityType.getKey(p_266619_).toString(), BredAnimalsTrigger.TriggerInstance.bredAnimals(EntityPredicate.Builder.entity().of(p_266619_).build(), EntityPredicate.Builder.entity().of(p_266619_).build(), EntityPredicate.ANY));
      });
      return p_266978_;
   }

   private Advancement.Builder addFishBuckets(Advancement.Builder p_249285_) {
      for(Item item : FISH_BUCKETS) {
         p_249285_.addCriterion(BuiltInRegistries.ITEM.getKey(item).getPath(), FilledBucketTrigger.TriggerInstance.filledBucket(ItemPredicate.Builder.item().of(item).build()));
      }

      return p_249285_;
   }

   private Advancement.Builder addFish(Advancement.Builder p_248725_) {
      for(Item item : FISH) {
         p_248725_.addCriterion(BuiltInRegistries.ITEM.getKey(item).getPath(), FishingRodHookedTrigger.TriggerInstance.fishedItem(ItemPredicate.ANY, EntityPredicate.ANY, ItemPredicate.Builder.item().of(item).build()));
      }

      return p_248725_;
   }

   private Advancement.Builder addCatVariants(Advancement.Builder p_249232_) {
      BuiltInRegistries.CAT_VARIANT.entrySet().stream().sorted(Entry.comparingByKey(Comparator.comparing(ResourceKey::location))).forEach((p_249721_) -> {
         p_249232_.addCriterion(p_249721_.getKey().location().toString(), TameAnimalTrigger.TriggerInstance.tamedAnimal(EntityPredicate.Builder.entity().subPredicate(EntitySubPredicate.variant(p_249721_.getValue())).build()));
      });
      return p_249232_;
   }
}