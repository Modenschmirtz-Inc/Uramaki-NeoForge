package net.modenschmirtz.uramaki.mixin;

import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.modenschmirtz.uramaki.Uramaki;
import net.modenschmirtz.uramaki.item.ModItems;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemModelShaper.class)
public class ItemModelShaperMixin {
    @Shadow @Final private ModelManager modelManager;

    @Inject(method = "getItemModel(Lnet/minecraft/world/item/ItemStack;)Lnet/minecraft/client/resources/model/BakedModel;", at = @At("HEAD"), cancellable = true)
    private void Injected(ItemStack stack, CallbackInfoReturnable<BakedModel> cir){
        if (stack.getItem() == Items.CROSSBOW && stack.get(DataComponents.CHARGED_PROJECTILES) instanceof ChargedProjectiles component) {
            if (component.contains(ModItems.TUNA.get())) cir.setReturnValue(modelManager.getModel(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "crossbow_tuna"))));
            if (component.contains(ModItems.GOLDEN_FISH.get())) cir.setReturnValue(modelManager.getModel(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "crossbow_golden_fish"))));
            if (component.contains(Items.COD)) cir.setReturnValue(modelManager.getModel(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "crossbow_cod"))));
            if (component.contains(Items.SALMON)) cir.setReturnValue(modelManager.getModel(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "crossbow_salmon"))));
        }
    }
}
