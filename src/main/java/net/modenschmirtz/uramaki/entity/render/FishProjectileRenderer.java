package net.modenschmirtz.uramaki.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.modenschmirtz.uramaki.entity.custom.FishProjectile;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FishProjectileRenderer extends GeoEntityRenderer<FishProjectile> {
    public FishProjectileRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FishProjectileModel());
    }

    @Override
    protected void applyRotations(FishProjectile entity, PoseStack poseStack, float ageInTicks, float rotationYaw, float partialTick, float nativeScale) {
        super.applyRotations(entity, poseStack, ageInTicks, rotationYaw, partialTick, nativeScale);

        poseStack.mulPose(Axis.YP.rotationDegrees(entity.getViewYRot(partialTick)));
        poseStack.mulPose(Axis.XP.rotationDegrees(entity.getViewXRot(partialTick)));

        float s = entity.shakeTime - partialTick;
        if (s > 0.0F) {
            float t = -Mth.sin(s * 3.0F) * s;
            poseStack.mulPose(Axis.XP.rotationDegrees(t));
        }
    }
}
