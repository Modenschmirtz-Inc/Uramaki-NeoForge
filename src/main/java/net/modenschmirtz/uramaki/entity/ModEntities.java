package net.modenschmirtz.uramaki.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.modenschmirtz.uramaki.Uramaki;
import net.modenschmirtz.uramaki.entity.custom.FishProjectile;
import net.modenschmirtz.uramaki.entity.custom.TunaEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Uramaki.MOD_ID);

    public static final Supplier<EntityType<TunaEntity>> TUNA =
            ENTITY_TYPES.register("tuna", () -> EntityType.Builder.of(TunaEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.7F, 0.4F).eyeHeight(0.26f).clientTrackingRange(4).build("tuna"));

    public static final Supplier<EntityType<FishProjectile>> FISH_PROJECTILE =
            ENTITY_TYPES.register("fish_projectile", () -> EntityType.Builder.<FishProjectile>of(FishProjectile::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).eyeHeight(0.13f).clientTrackingRange(4).updateInterval(20).build("tuna"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
        Uramaki.LOGGER.info("Registering Mod Entities For :"+Uramaki.MOD_ID);
    }
}
