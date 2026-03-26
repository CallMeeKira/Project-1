package akira.strayechoes.item;

import akira.strayechoes.EchoesOfTheStray;
import akira.strayechoes.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ECHOES_OF_THE_STRAY_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EchoesOfTheStray.MOD_ID, "echoes_of_the_stray"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.LUNITE.ingot()))
                    .displayName(Text.translatable("itemgroup.strayechoes.echoes_of_the_stray"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.LUNITE.ingot());
                        entries.add(ModItems.LUNITE.raw());
                        entries.add(ModItems.LUNITE.nugget());

                        entries.add(ModItems.LUNITE.helmet());
                        entries.add(ModItems.LUNITE.chestplate());
                        entries.add(ModItems.LUNITE.leggings());
                        entries.add(ModItems.LUNITE.boots());

                        entries.add(ModBlocks.LUNITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_LUNITE_ORE);
                        entries.add(ModBlocks.LUNITE_BLOCK);
                        entries.add(ModBlocks.RAW_LUNITE_BLOCK);
                        entries.add(ModBlocks.NOCTOFERN);
                        entries.add(ModBlocks.ZORDYCEPS);
                        entries.add(ModBlocks.LUNAR_VINE);

                        entries.add(ModItems.LUNITE.sword());
                        entries.add(ModItems.LUNITE.axe());
                        entries.add(ModItems.LUNITE.pickaxe());
                        entries.add(ModItems.LUNITE.shovel());
                        entries.add(ModItems.LUNITE.hoe());
                    })
                    .build());


    public static void registerItemGroups() {
        EchoesOfTheStray.LOGGER.info("Registering Item Groups for " + EchoesOfTheStray.MOD_ID);
    }
}
