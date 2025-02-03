package official.ebalia.inyourworld.entity.model;

import software.bernie.geckolib.model.GeoModel;

import official.ebalia.inyourworld.entity.ChickenEntity;

import net.minecraft.resources.ResourceLocation;

public class ChickenModel extends GeoModel<ChickenEntity> {
	@Override
	public ResourceLocation getAnimationResource(ChickenEntity entity) {
		return new ResourceLocation("in_your_world", "animations/chicken.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ChickenEntity entity) {
		return new ResourceLocation("in_your_world", "geo/chicken.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ChickenEntity entity) {
		return new ResourceLocation("in_your_world", "textures/entities/" + entity.getTexture() + ".png");
	}

}
