package official.ebalia.inyourworld.procedures;

import official.ebalia.inyourworld.network.InYourWorldModVariables;
import official.ebalia.inyourworld.init.InYourWorldModEntities;
import official.ebalia.inyourworld.entity.AtaqueEntidadEntity;
import official.ebalia.inyourworld.configuration.ConfiguracionConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AtaqueExisteONoProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (ConfiguracionConfiguration.HABILITARATAQUE.get()) {
			if (InYourWorldModVariables.MapVariables.get(world).tiempoAtaque == 0) {
				if (world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z)) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dripstone_caves"))
						|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves"))) {
					if (!(!world.getEntitiesOfClass(AtaqueEntidadEntity.class, AABB.ofSize(new Vec3(x, y, z), 4000, 4000, 4000), e -> true).isEmpty())) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new AtaqueEntidadEntity(InYourWorldModEntities.ATAQUE_ENTIDAD.get(), _level);
							entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, _level.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
