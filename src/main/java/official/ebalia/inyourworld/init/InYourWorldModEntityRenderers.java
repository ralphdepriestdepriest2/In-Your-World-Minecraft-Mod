
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package official.ebalia.inyourworld.init;

import official.ebalia.inyourworld.client.renderer.VoladorRenderer;
import official.ebalia.inyourworld.client.renderer.InvisibleCobblestoneRenderer;
import official.ebalia.inyourworld.client.renderer.HijitusRenderer;
import official.ebalia.inyourworld.client.renderer.HijitusAtaqueRenderer;
import official.ebalia.inyourworld.client.renderer.HQuietoMirandoRenderer;
import official.ebalia.inyourworld.client.renderer.EstructuraFalsa2Renderer;
import official.ebalia.inyourworld.client.renderer.EstructuraFalsa1Renderer;
import official.ebalia.inyourworld.client.renderer.EntidadStalkerRenderer;
import official.ebalia.inyourworld.client.renderer.ChickenRenderer;
import official.ebalia.inyourworld.client.renderer.AtaqueEntidadRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class InYourWorldModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(InYourWorldModEntities.HIJITUS_ATAQUE.get(), HijitusAtaqueRenderer::new);
		event.registerEntityRenderer(InYourWorldModEntities.HIJITUS.get(), HijitusRenderer::new);
		event.registerEntityRenderer(InYourWorldModEntities.CHICKEN.get(), ChickenRenderer::new);
		event.registerEntityRenderer(InYourWorldModEntities.VOLADOR.get(), VoladorRenderer::new);
		event.registerEntityRenderer(InYourWorldModEntities.H_QUIETO_MIRANDO.get(), HQuietoMirandoRenderer::new);
		event.registerEntityRenderer(InYourWorldModEntities.INVISIBLE_COBBLESTONE.get(), InvisibleCobblestoneRenderer::new);
		event.registerEntityRenderer(InYourWorldModEntities.ATAQUE_ENTIDAD.get(), AtaqueEntidadRenderer::new);
		event.registerEntityRenderer(InYourWorldModEntities.ENTIDAD_STALKER.get(), EntidadStalkerRenderer::new);
		event.registerEntityRenderer(InYourWorldModEntities.ESTRUCTURA_FALSA_1.get(), EstructuraFalsa1Renderer::new);
		event.registerEntityRenderer(InYourWorldModEntities.ESTRUCTURA_FALSA_2.get(), EstructuraFalsa2Renderer::new);
	}
}
