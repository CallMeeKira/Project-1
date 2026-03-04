package akira.strayechoes.dataGen;

import akira.strayechoes.EchoesOfTheStray;
import akira.strayechoes.block.ModBlocks;
import akira.strayechoes.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

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
                //ITEM_TO_INGOT
                List<ItemConvertible> LUNITE_INGOT_SMELTABLES = List.of(
                        //ITEMS
                        ModItems.RAW_LUNITE,

                        //BLOCKS
                        ModBlocks.LUNITE_ORE,
                        ModBlocks.DEEPSLATE_LUNITE_ORE);

                offerSmelting(recipeExporter, LUNITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.LUNITE_INGOT, 0.25f, 200, "Echoes_Of_The_Stray_Group");
                offerBlasting(recipeExporter, LUNITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.LUNITE_INGOT, 0.25f, 100, "Echoes_Of_The_Stray_Group");

                //ITEM_TO_NUGGET
                List<ItemConvertible> LUNITE_NUGGET_SMELTABLES = List.of(
                        //ITEMS
                        ModItems.LUNITE_SHOVEL,
                        ModItems.LUNITE_AXE,
                        ModItems.LUNITE_SWORD,
                        ModItems.LUNITE_PICKAXE,
                        ModItems.LUNITE_HOE);

                offerSmelting(recipeExporter, LUNITE_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.LUNITE_NUGGET, 0.25f, 200, "Echoes_Of_The_Stray_Group");
                offerBlasting(recipeExporter, LUNITE_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.LUNITE_NUGGET, 0.25f, 100, "Echoes_Of_The_Stray_Group");


        //CRAFTING TABLE BASED RECIPES
            //Reversible Compacts
            offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.LUNITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.LUNITE_BLOCK);

            //Below recipe currently returns a "Duplicate recipe" error, looking into it
            //offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.LUNITE_NUGGET, RecipeCategory.MISC, ModItems.LUNITE_INGOT);

            //Shapeless decomposition
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUNITE_NUGGET, 9)
                    .input(ModItems.LUNITE_INGOT)
                    .criterion(hasItem(ModItems.LUNITE_INGOT), conditionsFromItem(ModItems.LUNITE_INGOT))
                    .offerTo(recipeExporter);

            //Shaped (Tools)
                //Category Tools
                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LUNITE_PICKAXE)
                        .pattern("NNN")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.LUNITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE_INGOT), conditionsFromItem(ModItems.LUNITE_INGOT))
                        .offerTo(recipeExporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LUNITE_SHOVEL)
                        .pattern(" N ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.LUNITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE_INGOT), conditionsFromItem(ModItems.LUNITE_INGOT))
                        .offerTo(recipeExporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LUNITE_AXE)
                        .pattern("NN ")
                        .pattern("NS ")
                        .pattern(" S ")
                        .input('N', ModItems.LUNITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE_INGOT), conditionsFromItem(ModItems.LUNITE_INGOT))
                        .offerTo(recipeExporter, Identifier.of(EchoesOfTheStray.MOD_ID, "lunite_axe_category_tools"));

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LUNITE_HOE)
                        .pattern("NN ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.LUNITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE_INGOT), conditionsFromItem(ModItems.LUNITE_INGOT))
                        .offerTo(recipeExporter);

                //Category Combat
                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUNITE_SWORD)
                        .pattern("N  ")
                        .pattern(" N ")
                        .pattern("  S")
                        .input('N', ModItems.LUNITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE_INGOT), conditionsFromItem(ModItems.LUNITE_INGOT))
                        .offerTo(recipeExporter, Identifier.of(EchoesOfTheStray.MOD_ID, "lunite_sword_diagonal"));

                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUNITE_SWORD)
                    .pattern(" N ")
                    .pattern(" N ")
                    .pattern(" S ")
                    .input('N', ModItems.LUNITE_INGOT)
                    .input('S', Items.STICK)
                    .criterion(hasItem(ModItems.LUNITE_INGOT), conditionsFromItem(ModItems.LUNITE_INGOT))
                    .offerTo(recipeExporter, Identifier.of(EchoesOfTheStray.MOD_ID, "lunite_sword_vertical"));

                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUNITE_AXE)
                        .pattern("NN ")
                        .pattern("NS ")
                        .pattern(" S ")
                        .input('N', ModItems.LUNITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE_INGOT), conditionsFromItem(ModItems.LUNITE_INGOT))
                        .offerTo(recipeExporter, Identifier.of(EchoesOfTheStray.MOD_ID, "lunite_axe_category_combat"));
    }
}
