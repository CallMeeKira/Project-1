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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.LUNITE_INGOT))
                    .displayName(Text.translatable("itemgroup.strayechoes.echoes_of_the_stray"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.LUNITE_INGOT);
                        entries.add(ModItems.RAW_LUNITE);
                        entries.add(ModItems.LUNITE_NUGGET);

                        entries.add(ModBlocks.LUNITE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_LUNITE_ORE);
                        entries.add(ModBlocks.LUNITE_BLOCK);
                        entries.add(ModBlocks.RAW_LUNITE_BLOCK);
                    })
                    .build());

    public static void registerItemGroups() {
        EchoesOfTheStray.LOGGER.info("Registering Item Groups for " + EchoesOfTheStray.MOD_ID);
    }
}
