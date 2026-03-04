package akira.strayechoes.dataGen;

import akira.strayechoes.block.ModBlocks;
import akira.strayechoes.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class EchoesOfTheStray_ModelProvider extends FabricModelProvider {
    public EchoesOfTheStray_ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_LUNITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LUNITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUNITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LUNITE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.LUNITE.ingot(), Models.GENERATED);
        itemModelGenerator.register(ModItems.LUNITE.nugget(), Models.GENERATED);
        itemModelGenerator.register(ModItems.LUNITE.raw(), Models.GENERATED);

        itemModelGenerator.register(ModItems.LUNITE.sword(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUNITE.axe(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUNITE.shovel(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUNITE.pickaxe(), Models.HANDHELD);
        itemModelGenerator.register(ModItems.LUNITE.hoe(), Models.HANDHELD);
    }
}
