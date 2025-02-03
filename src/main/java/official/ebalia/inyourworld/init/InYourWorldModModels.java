
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package official.ebalia.inyourworld.init;

import official.ebalia.inyourworld.client.model.Modelinvisible;
import official.ebalia.inyourworld.client.model.Modelfalso1;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class InYourWorldModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelfalso1.LAYER_LOCATION, Modelfalso1::createBodyLayer);
		event.registerLayerDefinition(Modelinvisible.LAYER_LOCATION, Modelinvisible::createBodyLayer);
	}
}
