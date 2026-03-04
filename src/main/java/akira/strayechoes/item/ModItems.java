package akira.strayechoes.item;

import akira.strayechoes.EchoesOfTheStray;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LUNITE_INGOT = registerItem("lunite_ingot", new Item(new Item.Settings()));
    public static final Item RAW_LUNITE = registerItem("raw_lunite", new Item(new Item.Settings()));
    public static final Item LUNITE_NUGGET = registerItem("lunite_nugget", new Item(new Item.Settings()));

    //Tools
    public static final Item LUNITE_SWORD = registerItem("lunite_sword", new SwordItem(ModToolMaterials.LUNITE, new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.LUNITE, 3, -2.4f))));
    public static final Item LUNITE_PICKAXE = registerItem("lunite_pickaxe", new PickaxeItem(ModToolMaterials.LUNITE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.LUNITE, 1, -2.8f))));
    public static final Item LUNITE_SHOVEL = registerItem("lunite_shovel", new ShovelItem(ModToolMaterials.LUNITE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.LUNITE, 1.5f, -3.0f))));
    public static final Item LUNITE_AXE = registerItem("lunite_axe", new AxeItem(ModToolMaterials.LUNITE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.LUNITE, 6f, -3.2f))));
    public static final Item LUNITE_HOE = registerItem("lunite_hoe", new HoeItem(ModToolMaterials.LUNITE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.LUNITE, 0f, -3f))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EchoesOfTheStray.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EchoesOfTheStray.LOGGER.info("Registering Mod Items for " + EchoesOfTheStray.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(LUNITE_INGOT);
            entries.add(RAW_LUNITE);
            entries.add(LUNITE_NUGGET);
        });
    }
}
