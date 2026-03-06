package akira.strayechoes.block;

import akira.strayechoes.EchoesOfTheStray;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModBlocks {
    static final Map<RegistryKey<ItemGroup>, List<Block>> _groupedBlocks = new HashMap<>();

    public static final Block NOCTOFERN = registerBlock("noctofern",
            new ShortPlantBlock(AbstractBlock.Settings.create().noCollision().breakInstantly().sounds(BlockSoundGroup.GRASS)),
            ItemGroups.NATURAL);

    public static final Block ZORDYCEPS = registerBlock("zordyceps",
            new ShortPlantBlock(AbstractBlock.Settings.create().noCollision().breakInstantly().sounds(BlockSoundGroup.NETHER_WART)),
            ItemGroups.NATURAL);

    public static final Block LUNITE_BLOCK = registerBlock("lunite_block",
            new Block(AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.METAL)),
            ItemGroups.BUILDING_BLOCKS);

    public static final Block RAW_LUNITE_BLOCK = registerBlock("raw_lunite_block",
            new Block(AbstractBlock.Settings.create().strength(5f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ItemGroups.NATURAL);

    public static final Block LUNITE_ORE = registerBlock("lunite_ore",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)),
            ItemGroups.NATURAL);

    public static final Block DEEPSLATE_LUNITE_ORE = registerBlock("deepslate_lunite_ore",
            new Block(AbstractBlock.Settings.create().strength(4.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)),
            ItemGroups.NATURAL);

    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        _groupedBlocks.computeIfAbsent(group, g -> new ArrayList<>()).add(block);
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EchoesOfTheStray.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(EchoesOfTheStray.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        EchoesOfTheStray.LOGGER.info("Registering Mod Blocks for " + EchoesOfTheStray.MOD_ID);

        for (var entry : _groupedBlocks.entrySet()) {
            RegistryKey<ItemGroup> group = entry.getKey();
            List<Block> blocks = entry.getValue();

            ItemGroupEvents.modifyEntriesEvent(group).register(entries -> {
                for (Block block : blocks) entries.add(block);
            });
        }
    }
}
