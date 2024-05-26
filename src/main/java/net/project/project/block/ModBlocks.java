package net.project.project.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.project.project.Project;
import net.project.project.block.custom.AshBlock;
import net.project.project.block.custom.AshBlockRotate;
import net.project.project.block.custom.AshLeaves;
import net.project.project.block.custom.AshSaplings;
import net.project.project.block.custom.trees.AshTree;
import net.project.project.item.ModItemGroup;
import net.project.project.item.ModItems;
import org.lwjgl.system.CallbackI;

import java.util.function.Supplier;

public class ModBlocks extends Blocks {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, Project.MOD_ID);

    public static final RegistryObject<Block> RADIUM = registerBlock("radium",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()
                    .hardnessAndResistance(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> LEAD = registerBlock("lead",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK).harvestTool(ToolType.PICKAXE).harvestLevel(1).setRequiresTool()
                    .hardnessAndResistance(2).sound(SoundType.STONE)));

    public static final RegistryObject<Block> ASH_WOOD = registerBlock("ash_wood",
            () -> new AshBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ASH_LOG = registerBlock("ash_log",
            () -> new AshBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> STRIPPED_ASH_WOOD = registerBlock("stripped_ash_wood",
            () -> new AshBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> STRIPPED_ASH_LOG = registerBlock("stripped_ash_log",
            () -> new AshBlockRotate(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ASH_PLANKS = registerBlock("ash_planks",
            () -> new AshBlock(AbstractBlock.Properties.create(Material.WOOD)
                    .hardnessAndResistance(2).sound(SoundType.WOOD).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> ASH_LEAVES = BLOCKS.register("ash_leaves",
            () -> new AshLeaves(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f)
                    .sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> ASH_SAPLING = BLOCKS.register("ash_sapling",
            () -> new AshSaplings(new AshTree(), AbstractBlock.Properties.create(Material.LEAVES)
                    .sound(SoundType.PLANT).doesNotBlockMovement().tickRandomly().zeroHardnessAndResistance()));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        registerBlockItem(name, toReturn);

        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.IRON_BLOCK)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
