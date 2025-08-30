package net.modenschmirtz.uramaki.entity.render;

import net.minecraft.resources.ResourceLocation;
import net.modenschmirtz.uramaki.Uramaki;
import net.modenschmirtz.uramaki.entity.custom.FishProjectile;
import software.bernie.geckolib.model.GeoModel;

public class FishProjectileModel extends GeoModel<FishProjectile> {
    @Override
    public ResourceLocation getModelResource(FishProjectile entity) {
        return switch (entity.getVariant()) {
            case "cod" -> ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "geo/entity/cod.geo.json");
            case "salmon" -> ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "geo/entity/salmon.geo.json");
            default -> ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "geo/entity/tuna.geo.json");
        };
    }

    @Override
    public ResourceLocation getTextureResource(FishProjectile entity) {
        return switch (entity.getVariant()) {
            case "cod" -> ResourceLocation.withDefaultNamespace("textures/entity/fish/cod.png");
            case "salmon" -> ResourceLocation.withDefaultNamespace("textures/entity/fish/salmon.png");
            default -> ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "textures/entity/tuna.png");
        };
    }

    @Override
    public ResourceLocation getAnimationResource(FishProjectile animatable) {
        return null;
    }
}
