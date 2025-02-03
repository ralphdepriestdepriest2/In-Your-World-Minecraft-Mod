package official.ebalia.inyourworld.procedures;

import official.ebalia.inyourworld.entity.HijitusAtaqueEntity;
import official.ebalia.inyourworld.configuration.ConfiguracionConfiguration;
import official.ebalia.inyourworld.InYourWorldMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HijitusADespawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (ConfiguracionConfiguration.DESPAWNHIJITUSTIMER.get()) {
			if (entity instanceof HijitusAtaqueEntity) {
				InYourWorldMod.queueServerWork(Mth.nextInt(RandomSource.create(), (int) (double) ConfiguracionConfiguration.DESPAWNHMIN.get(), (int) (double) ConfiguracionConfiguration.DESPAWNHMAX.get()), () -> {
					if (!entity.level.isClientSide())
						entity.discard();
				});
			}
		}
	}
}
