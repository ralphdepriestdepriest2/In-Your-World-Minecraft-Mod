
package official.ebalia.inyourworld.client.renderer;

import official.ebalia.inyourworld.entity.EstructuraFalsa2Entity;
import official.ebalia.inyourworld.client.model.Modelfalso1;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class EstructuraFalsa2Renderer extends MobRenderer<EstructuraFalsa2Entity, Modelfalso1<EstructuraFalsa2Entity>> {
	public EstructuraFalsa2Renderer(EntityRendererProvider.Context context) {
		super(context, new Modelfalso1(context.bakeLayer(Modelfalso1.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(EstructuraFalsa2Entity entity) {
		return new ResourceLocation("in_your_world:textures/entities/texture0999.png");
	}
}
