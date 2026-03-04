package akira.strayechoes.item;

import akira.strayechoes.EchoesOfTheStray;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {
    static final Map<RegistryKey<ItemGroup>, List<Item>> _groupedItems = new HashMap<>();

    public static final Item LUNITE_INGOT = registerItem(
            "lunite_ingot",
            new Item(new Item.Settings()),
            ItemGroups.INGREDIENTS
    );

    public static final Item RAW_LUNITE = registerItem(
            "raw_lunite",
            new Item(new Item.Settings()),
            ItemGroups.INGREDIENTS
    );

    public static final Item LUNITE_NUGGET = registerItem(
            "lunite_nugget",
            new Item(new Item.Settings()),
            ItemGroups.INGREDIENTS
    );

    public static final Item LUNITE_SWORD = registerItem(
            "lunite_sword",
            new SwordItem(
                    ModToolMaterials.LUNITE,
                    new Item.Settings()
                            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.LUNITE, 3, -2.4f)))
    );

    public static final Item LUNITE_PICKAXE = registerItem(
            "lunite_pickaxe",
            new PickaxeItem(
                    ModToolMaterials.LUNITE,
                    new Item.Settings()
                            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.LUNITE, 1, -2.8f)))
    );

    public static final Item LUNITE_SHOVEL = registerItem(
            "lunite_shovel",
            new ShovelItem(
                    ModToolMaterials.LUNITE,
                    new Item.Settings()
                            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.LUNITE, 1.5f, -3.0f)))
    );

    public static final Item LUNITE_AXE = registerItem(
            "lunite_axe",
            new AxeItem(
                    ModToolMaterials.LUNITE,
                    new Item.Settings()
                            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.LUNITE, 6f, -3.2f)))
    );

    public static final Item LUNITE_HOE = registerItem(
            "lunite_hoe",
            new HoeItem(
                    ModToolMaterials.LUNITE,
                    new Item.Settings()
                            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.LUNITE, 0f, -3f)))
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EchoesOfTheStray.MOD_ID, name), item);
    }

    public static final Item LUNITE_HELMET = registerItem(
            "lunite_helmet",
            new ArmorItem(ModArmorMaterials.LUNITE, ArmorItem.Type.HELMET,
                    new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))),
            ItemGroups.COMBAT
    );

    public static final Item LUNITE_CHESTPLATE = registerItem(
            "lunite_chestplate",
            new ArmorItem(ModArmorMaterials.LUNITE, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))),
            ItemGroups.COMBAT
    );

    public static final Item LUNITE_LEGGINGS = registerItem(
            "lunite_leggings",
            new ArmorItem(ModArmorMaterials.LUNITE, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))),
            ItemGroups.COMBAT
    );

    public static final Item LUNITE_BOOTS = registerItem(
            "lunite_boots",
            new ArmorItem(ModArmorMaterials.LUNITE, ArmorItem.Type.BOOTS,
                    new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))),
            ItemGroups.COMBAT
    );

    static Item registerItem(String name, Item item, RegistryKey<ItemGroup> group) {
        Item registered = Registry.register(Registries.ITEM, Identifier.of(EchoesOfTheStray.MOD_ID, name), item);
        _groupedItems.computeIfAbsent(group, itemGroup -> new ArrayList<>()).add(registered);
        return registered;
    }

    public static void registerModItems() {
        EchoesOfTheStray.LOGGER.info("Registering Mod Items for " + EchoesOfTheStray.MOD_ID);

        for (var entry : _groupedItems.entrySet()) {
            RegistryKey<ItemGroup> group = entry.getKey();
            List<Item> items = entry.getValue();

            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {
                for (Item item : items) entries.add(item);
            });
        }
    }
}
