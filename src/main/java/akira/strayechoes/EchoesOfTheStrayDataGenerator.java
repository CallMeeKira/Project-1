package akira.strayechoes;

import akira.strayechoes.dataGen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class EchoesOfTheStrayDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack strayechoesPack = fabricDataGenerator.createPack();

        strayechoesPack.addProvider(EchoesOfTheStray_BlockTagProvider::new);
        strayechoesPack.addProvider(EchoesOfTheStray_ItemTagProvider::new);
        strayechoesPack.addProvider(EchoesOfTheStray_LootTableProvider::new);
        strayechoesPack.addProvider(EchoesOfTheStray_ModelProvider::new);
        strayechoesPack.addProvider(EchoesOfTheStray_RecipeProvider::new);
	}
}
