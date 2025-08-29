package net.modenschmirtz.uramaki.entity.render;

import net.minecraft.resources.ResourceLocation;
import net.modenschmirtz.uramaki.Uramaki;
import net.modenschmirtz.uramaki.entity.custom.TunaEntity;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class TunaModel extends DefaultedEntityGeoModel<TunaEntity> {
    public TunaModel() {
        super(ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "tuna"), false);
    }
}
