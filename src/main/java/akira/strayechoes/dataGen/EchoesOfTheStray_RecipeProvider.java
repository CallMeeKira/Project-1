package akira.strayechoes.dataGen;

import akira.strayechoes.block.ModBlocks;
import akira.strayechoes.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EchoesOfTheStray_RecipeProvider extends FabricRecipeProvider {
    public EchoesOfTheStray_RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        //FURNACE BASED RECIPES
            //Smelting
            List<ItemConvertible> LUNITE_SMELTABLES = List.of(ModItems.RAW_LUNITE, ModBlocks.LUNITE_ORE, ModBlocks.DEEPSLATE_LUNITE_ORE);

            offerSmelting(recipeExporter, LUNITE_SMELTABLES, RecipeCategory.MISC, ModItems.LUNITE_INGOT, 0.25f, 200, "Echoes_Of_The_Stray_Group");
            offerBlasting(recipeExporter, LUNITE_SMELTABLES, RecipeCategory.MISC, ModItems.LUNITE_INGOT, 0.25f, 100, "Echoes_Of_The_Stray_Group");


        //CRAFTING TABLE BASED RECIPES
            //Reversible Compacts
            offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.LUNITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.LUNITE_BLOCK);

    }
}
