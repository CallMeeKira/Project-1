package akira.strayechoes.item;

import akira.strayechoes.EchoesOfTheStray;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public final class ModArmorMaterials {
    public static final TagKey<Item> REPAIRS_LUNITE_ARMOR =
            TagKey.of(RegistryKeys.ITEM, Identifier.of(EchoesOfTheStray.MOD_ID, "repairs_lunite_armor"));

    public static final RegistryEntry<ArmorMaterial> LUNITE = Registry.registerReference(
            Registries.ARMOR_MATERIAL,
            Identifier.of(EchoesOfTheStray.MOD_ID, "lunite"),
            new ArmorMaterial(
                    Map.of(
                            ArmorItem.Type.HELMET, 2,
                            ArmorItem.Type.CHESTPLATE, 6,
                            ArmorItem.Type.LEGGINGS, 5,
                            ArmorItem.Type.BOOTS, 2
                    ),
                    14,
                    SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                    () -> Ingredient.fromTag(REPAIRS_LUNITE_ARMOR),
                    List.of(new ArmorMaterial.Layer(Identifier.of(EchoesOfTheStray.MOD_ID, "lunite"))), 0.0F, 0.0F)
    );

    private ModArmorMaterials() {

    }
}