
package official.ebalia.inyourworld.client.renderer;

import official.ebalia.inyourworld.entity.EstructuraFalsa1Entity;
import official.ebalia.inyourworld.client.model.Modelfalso1;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class EstructuraFalsa1Renderer extends MobRenderer<EstructuraFalsa1Entity, Modelfalso1<EstructuraFalsa1Entity>> {
	public EstructuraFalsa1Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelfalso1(context.bakeLayer(Modelfalso1.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(EstructuraFalsa1Entity entity) {
		return new ResourceLocation("in_your_world:textures/entities/texture01119.png");
	}
}
