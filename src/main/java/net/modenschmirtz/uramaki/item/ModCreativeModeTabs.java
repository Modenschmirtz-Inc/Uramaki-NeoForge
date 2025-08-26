package net.modenschmirtz.uramaki.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.modenschmirtz.uramaki.Uramaki;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Uramaki.MOD_ID);

    public static final Supplier<CreativeModeTab> URAMAKI_CREATIVE_MODE_TAB = CREATIVE_MODE_TAB.register("uramaki_items",
            () -> CreativeModeTab.builder().icon(ModItems.TUNA::toStack).title(Component.translatable("itemgroup.uramaki.uramaki_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.TUNA);
                        output.accept(ModItems.COOKED_TUNA);

                        output.accept(ModItems.COD_FILLET);
                        output.accept(ModItems.SALMON_FILLET);
                        output.accept(ModItems.TUNA_FILLET);

                        output.accept(ModItems.COOKED_COD_FILLET);
                        output.accept(ModItems.COOKED_SALMON_FILLET);
                        output.accept(ModItems.COOKED_TUNA_FILLET);
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
        Uramaki.LOGGER.info("Registering Creative Mode Tabs For :"+Uramaki.MOD_ID);
    }
}
