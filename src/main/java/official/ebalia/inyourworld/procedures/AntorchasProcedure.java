package official.ebalia.inyourworld.procedures;

import official.ebalia.inyourworld.configuration.ConfiguracionConfiguration;
import official.ebalia.inyourworld.InYourWorldMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.Map;

@Mod.EventBusSubscriber
public class AntorchasProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if (ConfiguracionConfiguration.TORCH.get()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.TORCH || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.WALL_TORCH) {
				if (Math.random() < (double) ConfiguracionConfiguration.RANDOMTORCH.get()) {
					InYourWorldMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), (double) ConfiguracionConfiguration.RANDOMTORCHTIMEMIN.get(), (double) ConfiguracionConfiguration.RANDOMTORCHTIMEMAX.get()), () -> {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = Blocks.VOID_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					});
				}
			}
		}
		if (ConfiguracionConfiguration.BLOCKS.get()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DARK_OAK_PLANKS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_PLANKS
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DARK_OAK_PLANKS || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.OAK_DOOR
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.DARK_OAK_DOOR) {
				if (Math.random() < (double) ConfiguracionConfiguration.RANDOMBLOCK.get()) {
					InYourWorldMod.queueServerWork((int) Mth.nextDouble(RandomSource.create(), (double) ConfiguracionConfiguration.RANDOMBLOCKTIMEMIN.get(), (double) ConfiguracionConfiguration.RANDOMBLOCKTIMEMAX.get()), () -> {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = Blocks.VOID_AIR.defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					});
				}
			}
		}
	}
}
