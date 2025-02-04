package official.ebalia.inyourworld.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JugadorDiceHolaProcedure {
    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {
        execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getRawText());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, String text) {
        execute(null, world, x, y, z, entity, text);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, String text) {
        if (entity == null || text == null) return;

        // Verificar todas las variantes de saludo en una sola condición
        if (text.contains("hello") || 
            text.contains("hola") || 
            text.contains("ola") || 
            text.contains("ol\u00E1") || 
            text.contains("\u041F\u0440\u0438\u0432\u0435\u0442")) {
            
            if (entity instanceof ServerPlayer player) {
                Advancement helloAdvancement = player.server.getAdvancements()
                    .getAdvancement(new ResourceLocation("in_your_world:say_hello"));
                
                AdvancementProgress progress = player.getAdvancements()
                    .getOrStartProgress(helloAdvancement);

                // Ejecutar solo si el avance no está completado
                if (!progress.isDone()) {
                    // Otorgar todos los criterios del avance
                    for (String criteria : progress.getRemainingCriteria()) {
                        player.getAdvancements().award(helloAdvancement, criteria);
                    }

                    // Ejecutar efectos una sola vez
                    if (world instanceof ServerLevel serverLevel) {
                        CommandSourceStack commandSource = new CommandSourceStack(
                            CommandSource.NULL,
                            new Vec3(x, y, z),
                            Vec2.ZERO,
                            serverLevel,
                            4,
                            "",
                            Component.literal(""),
                            serverLevel.getServer(),
                            null
                        ).withSuppressedOutput();

                        // Ejecutar comandos consecutivos
                        serverLevel.getServer().getCommands().performPrefixedCommand(
                            commandSource, 
                            "playsound in_your_world:cueva21 hostile @a"
                        );
                        serverLevel.getServer().getCommands().performPrefixedCommand(
                            commandSource, 
                            "time set midnight"
                        );
                        serverLevel.getServer().getCommands().performPrefixedCommand(
                            commandSource, 
                            "weather thunder"
                        );
                    }
                }
            }
        }
    }
}