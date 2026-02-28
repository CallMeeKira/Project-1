package akira.strayechoes.utils;

import akira.strayechoes.EchoesOfTheStray;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class EchoesOfTheStray_Tags {
    public static class Blocks{

        private static TagKey<Block> createTag(String name){
           return TagKey.of(RegistryKeys.BLOCK, Identifier.of(EchoesOfTheStray.MOD_ID, name));
        }
    }

    public static class Items{
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(EchoesOfTheStray.MOD_ID, name));
        }
    }
}
