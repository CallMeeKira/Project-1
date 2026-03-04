package akira.strayechoes.dataGen;

import akira.strayechoes.item.ModItems;
import akira.strayechoes.utils.EchoesOfTheStray_Tags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class EchoesOfTheStray_ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public EchoesOfTheStray_ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(EchoesOfTheStray_Tags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.LUNITE.raw());


        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.LUNITE.sword());

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.LUNITE.axe());

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.LUNITE.pickaxe());

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.LUNITE.shovel());

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.LUNITE.hoe());
    }
}
