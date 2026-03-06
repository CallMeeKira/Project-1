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
            // !! XP values have been adjusted in the recipe files to match vanilla. Not sure what to do here, so im leaving this alone. -Akira
            //Smelting
                //ITEM_TO_INGOT
                List<ItemConvertible> LUNITE_INGOT_SMELTABLES = List.of(
                        //ITEMS
                        ModItems.LUNITE.raw(),

                        //BLOCKS
                        ModBlocks.LUNITE_ORE,
                        ModBlocks.DEEPSLATE_LUNITE_ORE);

                offerSmelting(recipeExporter, LUNITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.LUNITE.ingot(), 0.25f, 200, "Echoes_Of_The_Stray_Group");
                offerBlasting(recipeExporter, LUNITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.LUNITE.ingot(), 0.25f, 100, "Echoes_Of_The_Stray_Group");

                //ITEM_TO_NUGGET
                List<ItemConvertible> LUNITE_NUGGET_SMELTABLES = List.of(
                        //ITEMS
                        ModItems.LUNITE.shovel(),
                        ModItems.LUNITE.axe(),
                        ModItems.LUNITE.sword(),
                        ModItems.LUNITE.pickaxe(),
                        ModItems.LUNITE.hoe());

                offerSmelting(recipeExporter, LUNITE_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.LUNITE.nugget(), 0.25f, 200, "Echoes_Of_The_Stray_Group");
                offerBlasting(recipeExporter, LUNITE_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.LUNITE.nugget(), 0.25f, 100, "Echoes_Of_The_Stray_Group");


        //CRAFTING TABLE BASED RECIPES
            //Reversible Compacts
            offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.LUNITE.ingot(), RecipeCategory.DECORATIONS, ModBlocks.LUNITE_BLOCK);

            //Below recipe currently returns a "Duplicate recipe" error, looking into it
            //offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.LUNITE.nugget(), RecipeCategory.MISC, ModItems.LUNITE.ingot());
                    // !! Ingots have been moved to Misc and the block to Building Blocks, as those are their vanilla categories. -Akira


            //Shapeless decomposition
            ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LUNITE.nugget(), 9)
                    .input(ModItems.LUNITE.ingot())
                    .criterion(hasItem(ModItems.LUNITE.ingot()), conditionsFromItem(ModItems.LUNITE.ingot()))
                    .offerTo(recipeExporter);

            //Shaped (Tools)
                //Category Tools
                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LUNITE.pickaxe())
                        .pattern("NNN")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.LUNITE.ingot())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE.ingot()), conditionsFromItem(ModItems.LUNITE.ingot()))
                        .offerTo(recipeExporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LUNITE.shovel())
                        .pattern(" N ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.LUNITE.ingot())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE.ingot()), conditionsFromItem(ModItems.LUNITE.ingot()))
                        .offerTo(recipeExporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LUNITE.axe())
                        .pattern("NN ")
                        .pattern("NS ")
                        .pattern(" S ")
                        .input('N', ModItems.LUNITE.ingot())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE.ingot()), conditionsFromItem(ModItems.LUNITE.ingot()))
                        .offerTo(recipeExporter, Identifier.of(EchoesOfTheStray.MOD_ID, "lunite_axe_category_tools"));

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LUNITE.hoe())
                        .pattern("NN ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('N', ModItems.LUNITE.ingot())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE.ingot()), conditionsFromItem(ModItems.LUNITE.ingot()))
                        .offerTo(recipeExporter);

                //Category Combat
                    // !! Removed diagonal from recipes, not available as an option in vanilla. Renamed vertical to just lunite_sword. Did not touch advancements. -Akira
                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUNITE.sword())
                        .pattern("N  ")
                        .pattern(" N ")
                        .pattern("  S")
                        .input('N', ModItems.LUNITE.ingot())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE.ingot()), conditionsFromItem(ModItems.LUNITE.ingot()))
                        .offerTo(recipeExporter, Identifier.of(EchoesOfTheStray.MOD_ID, "lunite_sword_diagonal"));

                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUNITE.sword())
                    .pattern(" N ")
                    .pattern(" N ")
                    .pattern(" S ")
                    .input('N', ModItems.LUNITE.ingot())
                    .input('S', Items.STICK)
                    .criterion(hasItem(ModItems.LUNITE.ingot()), conditionsFromItem(ModItems.LUNITE.ingot()))
                    .offerTo(recipeExporter, Identifier.of(EchoesOfTheStray.MOD_ID, "lunite_sword_vertical"));

                ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.LUNITE.axe())
                        .pattern("NN ")
                        .pattern("NS ")
                        .pattern(" S ")
                        .input('N', ModItems.LUNITE.ingot())
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.LUNITE.ingot()), conditionsFromItem(ModItems.LUNITE.ingot()))
                        .offerTo(recipeExporter, Identifier.of(EchoesOfTheStray.MOD_ID, "lunite_axe_category_combat"));
    }
}
