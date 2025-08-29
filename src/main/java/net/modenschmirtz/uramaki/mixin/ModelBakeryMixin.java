package net.modenschmirtz.uramaki.mixin;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.resources.model.BlockStateModelLoader;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.profiling.ProfilerFiller;
import net.modenschmirtz.uramaki.Uramaki;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(ModelBakery.class)
public abstract class ModelBakeryMixin {
    @Shadow protected abstract void loadSpecialItemModelAndDependencies(ModelResourceLocation modelLocation);

    @Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/ModelBakery;loadSpecialItemModelAndDependencies(Lnet/minecraft/client/resources/model/ModelResourceLocation;)V", ordinal = 1))
    private void Injected(BlockColors blockColors, ProfilerFiller profilerFiller, Map<ResourceLocation, BlockModel> modelResources,
                          Map<ResourceLocation, List<BlockStateModelLoader.LoadedJson>> blockStateResources, CallbackInfo ci){
        loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "crossbow_tuna")));
        loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "crossbow_golden_fish")));
        loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "crossbow_cod")));
        loadSpecialItemModelAndDependencies(ModelResourceLocation.inventory(ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, "crossbow_salmon")));
    }
}
