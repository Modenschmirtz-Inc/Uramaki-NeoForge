package net.modenschmirtz.uramaki;

import com.mojang.logging.LogUtils;
import net.modenschmirtz.uramaki.block.ModBlocks;
import net.modenschmirtz.uramaki.item.ModCreativeModeTabs;
import net.modenschmirtz.uramaki.item.ModItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(Uramaki.MOD_ID)
public class Uramaki {
    public static final String MOD_ID = "uramaki";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Uramaki(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);
    }
}
