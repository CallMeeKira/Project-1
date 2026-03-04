package akira.strayechoes.item;

import net.minecraft.item.Item;

public record MetalSet(
        Item ingot,
        Item raw,
        Item nugget,
        Item sword,
        Item pickaxe,
        Item shovel,
        Item axe,
        Item hoe,
        Item helmet,
        Item chestplate,
        Item leggings,
        Item boots
) {}