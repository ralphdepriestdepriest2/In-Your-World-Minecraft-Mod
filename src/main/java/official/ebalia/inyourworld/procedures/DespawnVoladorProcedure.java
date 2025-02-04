package official.ebalia.inyourworld.procedures;

import official.ebalia.inyourworld.entity.VoladorEntity;
import official.ebalia.inyourworld.configuration.ConfiguracionConfiguration;
import official.ebalia.inyourworld.InYourWorldMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class DespawnVoladorProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (ConfiguracionConfiguration.ENABLEDESPAWN.get()) {
			if (entity instanceof VoladorEntity) {
				InYourWorldMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), (double) ConfiguracionConfiguration.INVISIBLESTALKDESPAWNMIN.get(), (double) ConfiguracionConfiguration.INVISIBLESTALKDESPAWNMAX.get()), () -> {
					if (!entity.level().isClientSide())
						entity.discard();
				});
			}
		}
	}
}
