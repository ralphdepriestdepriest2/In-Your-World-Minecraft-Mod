
package official.ebalia.inyourworld.client.renderer;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import official.ebalia.inyourworld.entity.model.HijitusAtaqueModel;
import official.ebalia.inyourworld.entity.HijitusAtaqueEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class HijitusAtaqueRenderer extends GeoEntityRenderer<HijitusAtaqueEntity> {
	public HijitusAtaqueRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new HijitusAtaqueModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(HijitusAtaqueEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, HijitusAtaqueEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(HijitusAtaqueEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
