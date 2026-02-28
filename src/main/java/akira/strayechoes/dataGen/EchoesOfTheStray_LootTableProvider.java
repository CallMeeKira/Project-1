package akira.strayechoes.dataGen;

import akira.strayechoes.block.ModBlocks;
import akira.strayechoes.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EchoesOfTheStray_LootTableProvider extends FabricBlockLootTableProvider {
    public EchoesOfTheStray_LootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        //Block Drops
        addDrop(ModBlocks.LUNITE_BLOCK);
        addDrop(ModBlocks.RAW_LUNITE_BLOCK);

        //Ore Drops
        addDrop(ModBlocks.LUNITE_ORE, oreDrops(ModBlocks.LUNITE_ORE, ModItems.RAW_LUNITE));
        addDrop(ModBlocks.DEEPSLATE_LUNITE_ORE, oreDrops(ModBlocks.DEEPSLATE_LUNITE_ORE, ModItems.RAW_LUNITE));
    }
}
