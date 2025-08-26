package net.modenschmirtz.uramaki.datagen;

import net.minecraft.data.PackOutput;
import net.modenschmirtz.uramaki.Uramaki;
import net.modenschmirtz.uramaki.item.ModItems;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Uramaki.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TUNA.get());
//        basicItem(ModItems.COOKED_TUNA.get());

        basicItem(ModItems.COD_FILLET.get());
        basicItem(ModItems.SALMON_FILLET.get());
        basicItem(ModItems.TUNA_FILLET.get());

//        basicItem(ModItems.COOKED_COD_FILLET.get());
//        basicItem(ModItems.COOKED_SALMON_FILLET.get());
//        basicItem(ModItems.COOKED_TUNA_FILLET.get());
    }
}
