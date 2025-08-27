package net.modenschmirtz.uramaki.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.modenschmirtz.uramaki.Uramaki;
import net.modenschmirtz.uramaki.item.components.ModFoodProperties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Uramaki.MOD_ID);

    public static final DeferredItem<Item> TUNA = ITEMS.register("tuna",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TUNA)));
    public static final DeferredItem<Item> COOKED_TUNA = ITEMS.register("cooked_tuna",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_TUNA)));
    public static final DeferredItem<Item> GOLDEN_FISH = ITEMS.register("golden_fish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GOLDEN_FISH).rarity(Rarity.RARE)));

    public static final DeferredItem<Item> COD_FILLET = ITEMS.register("cod_fillet",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COD_FILLET)));
    public static final DeferredItem<Item> SALMON_FILLET = ITEMS.register("salmon_fillet",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SALMON_FILLET)));
    public static final DeferredItem<Item> TUNA_FILLET = ITEMS.register("tuna_fillet",
            () -> new Item(new Item.Properties().food(ModFoodProperties.TUNA_FILLET)));

    public static final DeferredItem<Item> COOKED_COD_FILLET = ITEMS.register("cooked_cod_fillet",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_COD_FILLET)));
    public static final DeferredItem<Item> COOKED_SALMON_FILLET = ITEMS.register("cooked_salmon_fillet",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_SALMON_FILLET)));
    public static final DeferredItem<Item> COOKED_TUNA_FILLET = ITEMS.register("cooked_tuna_fillet",
            () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_TUNA_FILLET)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
        Uramaki.LOGGER.info("Registering Mod Items For :"+Uramaki.MOD_ID);
    }
}
