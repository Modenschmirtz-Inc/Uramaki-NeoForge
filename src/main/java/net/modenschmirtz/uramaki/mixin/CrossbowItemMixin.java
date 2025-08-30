package net.modenschmirtz.uramaki.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.modenschmirtz.uramaki.entity.custom.FishProjectile;
import net.modenschmirtz.uramaki.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Mixin(CrossbowItem.class)
public class CrossbowItemMixin {
    @Inject(method = "createProjectile", at = @At("HEAD"), cancellable = true)
    private void Injected(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit, CallbackInfoReturnable<Projectile> cir){
        if (ammo.is(ModItems.TUNA)){
            cir.setReturnValue(new FishProjectile(level, shooter, ammo, weapon, "tuna"));
        } else if (ammo.is(Items.COD)){
            cir.setReturnValue(new FishProjectile(level, shooter, ammo, weapon, "cod"));
        } else if (ammo.is(Items.SALMON)){
            cir.setReturnValue(new FishProjectile(level, shooter, ammo, weapon, "salmon"));
        }
    }

    @Inject(method = "getSupportedHeldProjectiles", at = @At("RETURN"), cancellable = true)
    private void Injected2(CallbackInfoReturnable<Predicate<ItemStack>> cir){
        cir.setReturnValue(cir.getReturnValue()
                .or(stack -> stack.is(ModItems.TUNA))
                .or(stack -> stack.is(ModItems.GOLDEN_FISH))
                .or(stack -> stack.is(Items.COD))
                .or(stack -> stack.is(Items.SALMON)));
    }
}
