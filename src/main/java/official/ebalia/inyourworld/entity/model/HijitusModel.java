package official.ebalia.inyourworld.entity.model;

import software.bernie.geckolib.model.GeoModel;

import official.ebalia.inyourworld.entity.HijitusEntity;

import net.minecraft.resources.ResourceLocation;

public class HijitusModel extends GeoModel<HijitusEntity> {
	@Override
	public ResourceLocation getAnimationResource(HijitusEntity entity) {
		return new ResourceLocation("in_your_world", "animations/hijitus.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HijitusEntity entity) {
		return new ResourceLocation("in_your_world", "geo/hijitus.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HijitusEntity entity) {
		return new ResourceLocation("in_your_world", "textures/entities/" + entity.getTexture() + ".png");
	}

}
