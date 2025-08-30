package net.modenschmirtz.uramaki.misc;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.modenschmirtz.uramaki.Uramaki;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, Uramaki.MOD_ID);

    public static final Supplier<SoundEvent> FISH_SPLAT = register("fish_splat");

    private static Supplier<SoundEvent> register(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Uramaki.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
        Uramaki.LOGGER.info("Registering Mod Sounds For :"+Uramaki.MOD_ID);
    }
}