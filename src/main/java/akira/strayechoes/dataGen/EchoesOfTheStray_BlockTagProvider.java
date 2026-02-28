package akira.strayechoes.dataGen;

import akira.strayechoes.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class EchoesOfTheStray_BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public EchoesOfTheStray_BlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LUNITE_BLOCK)
                .add(ModBlocks.RAW_LUNITE_BLOCK)
                .add(ModBlocks.DEEPSLATE_LUNITE_ORE)
                .add(ModBlocks.LUNITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_LUNITE_ORE);
    }
}
