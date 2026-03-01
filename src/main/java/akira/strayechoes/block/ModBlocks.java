package akira.strayechoes.block;

import akira.strayechoes.EchoesOfTheStray;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ModBlocks {
    public static final Block LUNITE_BLOCK = registerBlock("lunite_block",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));

    public static final Block RAW_LUNITE_BLOCK = registerBlock("raw_lunite_block",
            new Block(AbstractBlock.Settings.copy(Blocks.RAW_IRON_BLOCK)));

    public static final Block LUNITE_ORE = registerBlock("lunite_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.IRON_ORE)));

    public static final Block DEEPSLATE_LUNITE_ORE = registerBlock("deepslate_lunite_ore",
           new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_IRON_ORE)));

    public static final Block NOCTOFERN = registerBlock("noctofern",
            new PlantBlock(AbstractBlock.Settings.copy(Blocks.FERN))
            {
                @Override
                protected MapCodec<? extends PlantBlock> getCodec() {
                    return null;
                }

                @Override
                public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
                    return Block.createCuboidShape(2, 0, 2, 14, 13, 14);
                }
            });

    public static final Block ZORDYCEPS = registerBlock("zordyceps",
            new PlantBlock(AbstractBlock.Settings.copy(Blocks.FERN).sounds(BlockSoundGroup.NETHER_WART))
            {
                @Override
                protected MapCodec<? extends PlantBlock> getCodec() {
                    return null;
                }

                @Override
                public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
                    return Block.createCuboidShape(2, 0, 2, 14, 13, 14);
                }
            });

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(EchoesOfTheStray.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(EchoesOfTheStray.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        EchoesOfTheStray.LOGGER.info("Registering Mod Blocks for " + EchoesOfTheStray.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register(entries -> {
                    entries.add(ModBlocks.LUNITE_BLOCK);
                });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register(entries -> {
                    entries.add(ModBlocks.RAW_LUNITE_BLOCK);
                    entries.add(ModBlocks.LUNITE_ORE);
                    entries.add(ModBlocks.DEEPSLATE_LUNITE_ORE);
                    entries.add(ModBlocks.NOCTOFERN);
                    entries.add(ModBlocks.ZORDYCEPS);
                });
    }
}
