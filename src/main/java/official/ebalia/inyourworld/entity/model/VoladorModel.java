package official.ebalia.inyourworld.entity.model;

import software.bernie.geckolib.model.GeoModel;

import official.ebalia.inyourworld.entity.VoladorEntity;

import net.minecraft.resources.ResourceLocation;

public class VoladorModel extends GeoModel<VoladorEntity> {
	@Override
	public ResourceLocation getAnimationResource(VoladorEntity entity) {
		return new ResourceLocation("in_your_world", "animations/paohco.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(VoladorEntity entity) {
		return new ResourceLocation("in_your_world", "geo/paohco.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(VoladorEntity entity) {
		return new ResourceLocation("in_your_world", "textures/entities/" + entity.getTexture() + ".png");
	}

}
