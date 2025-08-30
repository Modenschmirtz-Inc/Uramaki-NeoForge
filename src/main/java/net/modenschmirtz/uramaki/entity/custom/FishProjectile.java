package net.modenschmirtz.uramaki.entity.custom;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.modenschmirtz.uramaki.entity.ModEntities;
import net.modenschmirtz.uramaki.item.ModItems;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

public class FishProjectile extends AbstractArrow implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<String> VARIANT = SynchedEntityData.defineId(FishProjectile.class, EntityDataSerializers.STRING);

    public FishProjectile(EntityType<? extends FishProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public FishProjectile(Level level, LivingEntity owner, ItemStack stack, ItemStack shotFrom, String variant) {
        super(ModEntities.FISH_PROJECTILE.get(), owner, level, stack, shotFrom);
        setVariant(variant);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(VARIANT, "tuna");
    }

    public void setVariant(String value) {
        this.entityData.set(VARIANT, value);
    }

    public String getVariant() {
        return this.entityData.get(VARIANT);
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return ModItems.TUNA.toStack();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
