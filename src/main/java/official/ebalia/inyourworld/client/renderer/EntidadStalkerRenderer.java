
package official.ebalia.inyourworld.client.renderer;

import official.ebalia.inyourworld.entity.EntidadStalkerEntity;
import official.ebalia.inyourworld.client.model.Modelinvisible;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class EntidadStalkerRenderer extends MobRenderer<EntidadStalkerEntity, Modelinvisible<EntidadStalkerEntity>> {
	public EntidadStalkerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelinvisible(context.bakeLayer(Modelinvisible.LAYER_LOCATION)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(EntidadStalkerEntity entity) {
		return new ResourceLocation("in_your_world:textures/entities/invisible.png");
	}
}
