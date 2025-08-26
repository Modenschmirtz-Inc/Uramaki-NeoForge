package net.modenschmirtz.uramaki;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = Uramaki.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Uramaki.MOD_ID, value = Dist.CLIENT)
public class UramakiClient {
    public UramakiClient(ModContainer container) {
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
    }
}
