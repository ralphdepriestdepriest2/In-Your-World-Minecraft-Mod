package official.ebalia.inyourworld.procedures;

import official.ebalia.inyourworld.network.InYourWorldModVariables;
import official.ebalia.inyourworld.configuration.ConfiguracionConfiguration;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.ArrayList;

@Mod.EventBusSubscriber
public class SonidosProcedure {
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
		double SelectorSonidos3 = 0;
		double SelectorSonidos2 = 0;
		double SelectorSonidos = 0;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (InYourWorldModVariables.MapVariables.get(world).tiempoSonidos == 0) {
				if (entityiterator instanceof Player) {
					if (Math.random() < (double) ConfiguracionConfiguration.FRECUENCIASONIDOS.get() && world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))) {
						SelectorSonidos2 = Mth.nextInt(RandomSource.create(), 0, 3);
						if (SelectorSonidos2 == 0) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:caminartierra")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos2 == 1) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:caminarpiedra")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos2 == 2) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:corriendo")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos2 == 3) {
							if (Math.random() < 0.1) {
								if (world instanceof Level)
									((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.AMBIENT, 1, 1);
							}
						}
					}
					if (Math.random() < (double) ConfiguracionConfiguration.FRECUENCIASONIDOS2.get() && (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
							|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dripstone_caves")))) {
						SelectorSonidos = Mth.nextInt(RandomSource.create(), 0, 9);
						if (SelectorSonidos == 0) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:cave-sound-5")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos == 1) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:cave-sound-4")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos == 2) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:cave-sound-14")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos == 3) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:cave-sound-19")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos == 4) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:cave-sound-12")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos == 5) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:cave-sound-11")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos == 6) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:cave-sound-7")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos == 7) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:cueva21")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos == 8) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:caminarpiedra")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos == 9) {
							if (Math.random() < 0.1) {
								if (world instanceof Level)
									((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.AMBIENT, 1, 1);
							}
						}
					}
					if (Math.random() < (double) ConfiguracionConfiguration.FRECUENCIASONIDOS3.get() && (!world.canSeeSkyFromBelowWater(BlockPos.containing(x, y, z))
							|| world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("lush_caves")) || world.getBiome(BlockPos.containing(x, y, z)).is(new ResourceLocation("dripstone_caves")))) {
						SelectorSonidos3 = Mth.nextInt(RandomSource.create(), 0, 3);
						if (SelectorSonidos3 == 0) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:caminarpiedra")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos3 == 1) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:caminartierra")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos3 == 2) {
							if (world instanceof Level)
								((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("in_your_world:corriendo")), SoundSource.AMBIENT, 1, 1);
						}
						if (SelectorSonidos3 == 3) {
							if (Math.random() < 0.1) {
								if (world instanceof Level)
									((Level) world).playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.AMBIENT, 1, 1);
							}
						}
					}
				}
			}
		}
	}
}
