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
        add(ModItems.TUNA.get(), "Tuna");
        add(ModItems.COOKED_TUNA.get(), "Cooked Tuna");

        add(ModItems.COD_FILLET.get(), "Cod Fillet");
        add(ModItems.SALMON_FILLET.get(), "Salmon Fillet");
        add(ModItems.TUNA_FILLET.get(), "Tuna Fillet");

        add(ModItems.COOKED_COD_FILLET.get(), "Cooked Cod Fillet");
        add(ModItems.COOKED_SALMON_FILLET.get(), "Cooked Salmon Fillet");
        add(ModItems.COOKED_TUNA_FILLET.get(), "Cooked Tuna Fillet");

        add(ModCreativeModeTabs.URAMAKI_CREATIVE_MODE_TAB.get().getDisplayName().getString(), "Uramaki");
    }
}
