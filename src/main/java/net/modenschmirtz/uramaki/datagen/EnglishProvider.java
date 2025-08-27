package net.modenschmirtz.uramaki.datagen;

import net.minecraft.data.PackOutput;
import net.modenschmirtz.uramaki.Uramaki;
import net.modenschmirtz.uramaki.item.ModCreativeModeTabs;
import net.modenschmirtz.uramaki.item.ModItems;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class EnglishProvider extends LanguageProvider {
    public EnglishProvider(PackOutput output) {
        super(output, Uramaki.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.TUNA.get(), "Raw Tuna");
        add(ModItems.COOKED_TUNA.get(), "Cooked Tuna");
        add(ModItems.GOLDEN_FISH.get(), "Golden Fish");

        add(ModItems.COD_FILLET.get(), "Raw Cod Fillet");
        add(ModItems.SALMON_FILLET.get(), "Raw Salmon Fillet");
        add(ModItems.TUNA_FILLET.get(), "Raw Tuna Fillet");

        add(ModItems.COOKED_COD_FILLET.get(), "Cooked Cod Fillet");
        add(ModItems.COOKED_SALMON_FILLET.get(), "Cooked Salmon Fillet");
        add(ModItems.COOKED_TUNA_FILLET.get(), "Cooked Tuna Fillet");

        add(ModCreativeModeTabs.URAMAKI_CREATIVE_MODE_TAB.get().getDisplayName().getString(), "Uramaki");
    }
}
