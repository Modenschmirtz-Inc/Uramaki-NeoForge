package net.modenschmirtz.uramaki.entity.custom;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.modenschmirtz.uramaki.item.ModItems;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class TunaEntity extends AbstractSchoolingFish implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public TunaEntity(EntityType<? extends TunaEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public int getMaxSchoolSize() {
        return 5;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SALMON_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SALMON_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return SoundEvents.SALMON_HURT;
    }

    @Override
    protected @NotNull SoundEvent getFlopSound() {
        return SoundEvents.SALMON_FLOP;
    }

    @Override
    public @NotNull ItemStack getBucketItemStack() {
        return ModItems.TUNA_BUCKET.get().getDefaultInstance();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 5, this::animController));
    }

    private <E extends TunaEntity> PlayState animController(final AnimationState<E> event) {
        if (this.wasTouchingWater) {
            event.getController().setAnimation(RawAnimation.begin().then("swim", Animation.LoopType.LOOP));
            if (event.isMoving()) {
                event.getController().setAnimationSpeed(1f);
            }else{
                event.getController().setAnimationSpeed(0.25f);
            }
        }else {
            event.getController().setAnimation(RawAnimation.begin().then("flop", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }
}
