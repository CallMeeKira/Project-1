package akira.strayechoes.item;

import akira.strayechoes.EchoesOfTheStray;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item LUNITE_INGOT = registerItem("lunite_ingot", new Item(new Item.Settings()));
    public static final Item RAW_LUNITE = registerItem("raw_lunite", new Item(new Item.Settings()));
    public static final Item LUNITE_NUGGET = registerItem("lunite_nugget", new Item(new Item.Settings()));
    public static final Item LUNITE_HELMET = registerItem("lunite_helmet", new ArmorItem(ModArmorMaterials.LUNITE, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15)))
    );

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