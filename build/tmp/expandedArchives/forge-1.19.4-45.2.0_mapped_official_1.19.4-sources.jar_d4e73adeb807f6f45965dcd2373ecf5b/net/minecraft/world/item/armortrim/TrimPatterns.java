package net.minecraft.world.item.armortrim;

import java.util.Optional;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class TrimPatterns {
   public static final ResourceKey<TrimPattern> SENTRY = registryKey("sentry");
   public static final ResourceKey<TrimPattern> DUNE = registryKey("dune");
   public static final ResourceKey<TrimPattern> COAST = registryKey("coast");
   public static final ResourceKey<TrimPattern> WILD = registryKey("wild");
   public static final ResourceKey<TrimPattern> WARD = registryKey("ward");
   public static final ResourceKey<TrimPattern> EYE = registryKey("eye");
   public static final ResourceKey<TrimPattern> VEX = registryKey("vex");
   public static final ResourceKey<TrimPattern> TIDE = registryKey("tide");
   public static final ResourceKey<TrimPattern> SNOUT = registryKey("snout");
   public static final ResourceKey<TrimPattern> RIB = registryKey("rib");
   public static final ResourceKey<TrimPattern> SPIRE = registryKey("spire");

   public static void bootstrap(BootstapContext<TrimPattern> p_267319_) {
   }

   public static void nextUpdate(BootstapContext<TrimPattern> p_266870_) {
      register(p_266870_, Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE, SENTRY);
      register(p_266870_, Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE, DUNE);
      register(p_266870_, Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE, COAST);
      register(p_266870_, Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE, WILD);
      register(p_266870_, Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE, WARD);
      register(p_266870_, Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE, EYE);
      register(p_266870_, Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE, VEX);
      register(p_266870_, Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE, TIDE);
      register(p_266870_, Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE, SNOUT);
      register(p_266870_, Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE, RIB);
      register(p_266870_, Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE, SPIRE);
   }

   public static Optional<Holder.Reference<TrimPattern>> getFromTemplate(RegistryAccess p_267205_, ItemStack p_267001_) {
      return p_267205_.registryOrThrow(Registries.TRIM_PATTERN).holders().filter((p_266833_) -> {
         return p_267001_.is(p_266833_.value().templateItem());
      }).findFirst();
   }

   private static void register(BootstapContext<TrimPattern> p_267064_, Item p_267097_, ResourceKey<TrimPattern> p_267079_) {
      TrimPattern trimpattern = new TrimPattern(p_267079_.location(), BuiltInRegistries.ITEM.wrapAsHolder(p_267097_), Component.translatable(Util.makeDescriptionId("trim_pattern", p_267079_.location())));
      p_267064_.register(p_267079_, trimpattern);
   }

   private static ResourceKey<TrimPattern> registryKey(String p_266889_) {
      return ResourceKey.create(Registries.TRIM_PATTERN, new ResourceLocation(p_266889_));
   }
}