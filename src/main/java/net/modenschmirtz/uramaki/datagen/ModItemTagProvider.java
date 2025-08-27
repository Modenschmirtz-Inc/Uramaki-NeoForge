package net.modenschmirtz.uramaki.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.modenschmirtz.uramaki.Uramaki;
import net.modenschmirtz.uramaki.item.ModItems;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Uramaki.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.FISHES).add(ModItems.TUNA.get()).add(ModItems.COOKED_TUNA.get()).add(ModItems.GOLDEN_FISH.get());
        tag(Tags.Items.FOODS_RAW_FISH).add(ModItems.TUNA.get());
        tag(Tags.Items.FOODS_COOKED_FISH).add(ModItems.COOKED_TUNA.get());
        tag(ItemTags.OCELOT_FOOD).add(ModItems.TUNA.get());
        tag(ItemTags.CAT_FOOD).add(ModItems.TUNA.get());
    }
}
