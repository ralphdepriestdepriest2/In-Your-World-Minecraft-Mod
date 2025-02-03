package official.ebalia.inyourworld.procedures;

import official.ebalia.inyourworld.network.InYourWorldModVariables;
import official.ebalia.inyourworld.configuration.ConfiguracionConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class NocheGlobalProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (ConfiguracionConfiguration.ACTIVATENIGHT.get()) {
			if (InYourWorldModVariables.MapVariables.get(world).tiempoNoche == 0) {
				InYourWorldModVariables.MapVariables.get(world).tiempoNoche = Mth.nextInt(RandomSource.create(), (int) (double) ConfiguracionConfiguration.NIGHTMIN.get(), (int) (double) ConfiguracionConfiguration.NIGHTMAX.get());
				InYourWorldModVariables.MapVariables.get(world).syncData(world);
			} else {
				InYourWorldModVariables.MapVariables.get(world).tiempoNoche = InYourWorldModVariables.MapVariables.get(world).tiempoNoche - 1;
				InYourWorldModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
