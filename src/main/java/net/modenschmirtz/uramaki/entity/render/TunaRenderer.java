package net.modenschmirtz.uramaki.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.modenschmirtz.uramaki.entity.custom.TunaEntity;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TunaRenderer extends GeoEntityRenderer<TunaEntity> {
    public TunaRenderer(EntityRendererProvider.Context context) {
        super(context, new TunaModel());
    }
}
