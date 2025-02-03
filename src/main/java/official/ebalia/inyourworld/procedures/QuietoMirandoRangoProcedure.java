package official.ebalia.inyourworld.procedures;

import official.ebalia.inyourworld.entity.HQuietoMirandoEntity;
import official.ebalia.inyourworld.configuration.ConfiguracionConfiguration;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class QuietoMirandoRangoProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean Found = false;
		double Range = 0;
		{
			final Vec3 _center = new Vec3((x + entity.getLookAngle().x * Range), (y + entity.getLookAngle().y * Range), (z + entity.getLookAngle().z * Range));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(((double) ConfiguracionConfiguration.DESPAWNAROUNDH.get()) / 2d), e -> true).stream()
					.sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(entityiterator == entity) && entityiterator instanceof HQuietoMirandoEntity) {
					Found = true;
					if (!entityiterator.level.isClientSide())
						entityiterator.discard();
					break;
				}
			}
		}
		Range = Range + 0.05;
	}
}
