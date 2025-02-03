package official.ebalia.inyourworld.init;

import official.ebalia.inyourworld.configuration.ConfiguracionConfiguration;
import official.ebalia.inyourworld.InYourWorldMod;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = InYourWorldMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class InYourWorldModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfiguracionConfiguration.SPEC, "In Your World Configuration.toml");
		});
	}
}
