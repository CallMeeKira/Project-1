package akira.strayechoes.item;

import akira.strayechoes.EchoesOfTheStray;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModItems {
    static final Map<RegistryKey<ItemGroup>, List<Item>> _groupedItems = new HashMap<>();

    public static final MetalSet LUNITE = registerMetalSet("lunite", ModToolMaterials.LUNITE, ModArmorMaterials.LUNITE, 15);

    private static MetalSet registerMetalSet(String name, ToolMaterial toolMat, RegistryEntry<ArmorMaterial> armorMat, int armorDurability) {
        return new MetalSet(
                registerItem(name + "_ingot",     new Item(new Item.Settings()),                                                                                                         ItemGroups.INGREDIENTS),
                registerItem("raw_" + name,       new Item(new Item.Settings()),                                                                                                         ItemGroups.INGREDIENTS),
                registerItem(name + "_nugget",    new Item(new Item.Settings()),                                                                                                         ItemGroups.INGREDIENTS),
                registerItem(name + "_sword",     new SwordItem(toolMat,   new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(toolMat,    3,    -2.4f))), ItemGroups.COMBAT),
                registerItem(name + "_pickaxe",   new PickaxeItem(toolMat, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(toolMat,  1,    -2.8f))), ItemGroups.TOOLS),
                registerItem(name + "_shovel",    new ShovelItem(toolMat,  new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(toolMat,   1.5f, -3.0f))), ItemGroups.TOOLS),
                registerItem(name + "_axe",       new AxeItem(toolMat,     new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(toolMat,      6f,   -3.2f))), ItemGroups.TOOLS),
                registerItem(name + "_hoe",       new HoeItem(toolMat,     new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(toolMat,      0f,   -3f))), ItemGroups.TOOLS),
                registerItem(name + "_helmet",     new ArmorItem(armorMat, ArmorItem.Type.HELMET,     new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(armorDurability))),     ItemGroups.COMBAT),
                registerItem(name + "_chestplate", new ArmorItem(armorMat, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(armorDurability))), ItemGroups.COMBAT),
                registerItem(name + "_leggings",   new ArmorItem(armorMat, ArmorItem.Type.LEGGINGS,   new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(armorDurability))),   ItemGroups.COMBAT),
                registerItem(name + "_boots",      new ArmorItem(armorMat, ArmorItem.Type.BOOTS,      new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(armorDurability))),      ItemGroups.COMBAT)
        );
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EchoesOfTheStray.MOD_ID, name), item);
    }

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