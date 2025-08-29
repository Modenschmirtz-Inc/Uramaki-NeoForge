package net.modenschmirtz.uramaki.event;

import net.minecraft.world.entity.animal.AbstractFish;
import net.modenschmirtz.uramaki.Uramaki;
import net.modenschmirtz.uramaki.entity.ModEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Uramaki.MOD_ID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TUNA.get(), AbstractFish.createAttributes().build());
    }
}
