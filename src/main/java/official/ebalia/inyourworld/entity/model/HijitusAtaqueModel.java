package official.ebalia.inyourworld.entity.model;

import software.bernie.geckolib.model.GeoModel;

import official.ebalia.inyourworld.entity.HijitusAtaqueEntity;

import net.minecraft.resources.ResourceLocation;

public class HijitusAtaqueModel extends GeoModel<HijitusAtaqueEntity> {
	@Override
	public ResourceLocation getAnimationResource(HijitusAtaqueEntity entity) {
		return new ResourceLocation("in_your_world", "animations/hijitus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HijitusAtaqueEntity entity) {
		return new ResourceLocation("in_your_world", "geo/hijitus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HijitusAtaqueEntity entity) {
		return new ResourceLocation("in_your_world", "textures/entities/" + entity.getTexture() + ".png");
	}

}
