package official.ebalia.inyourworld.entity.model;

import software.bernie.geckolib.model.GeoModel;

import official.ebalia.inyourworld.entity.HQuietoMirandoEntity;

import net.minecraft.resources.ResourceLocation;

public class HQuietoMirandoModel extends GeoModel<HQuietoMirandoEntity> {
	@Override
	public ResourceLocation getAnimationResource(HQuietoMirandoEntity entity) {
		return new ResourceLocation("in_your_world", "animations/agachadoh.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HQuietoMirandoEntity entity) {
		return new ResourceLocation("in_your_world", "geo/agachadoh.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HQuietoMirandoEntity entity) {
		return new ResourceLocation("in_your_world", "textures/entities/" + entity.getTexture() + ".png");
	}

}
