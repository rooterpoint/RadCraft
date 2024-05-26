package net.project.project.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.project.project.Project;
import net.project.project.block.ModBlocks;
import net.project.project.entity.ModEntityTypes;
import net.project.project.item.custom.ModArmorItem;
import net.project.project.item.custom.ModSpawnEggItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Project.MOD_ID);

    public static final RegistryObject<Item> MUTANT_SPAWN_EGG = ITEMS.register("mutant_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.MUTANT, 0x464F56, 0x106336,
        new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> RAD_SKELETON_SPAWN_EGG = ITEMS.register("rad_skeleton_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.RAD_SKELETON, 0x464F58, 0x106333,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> RAD_HORSE_SPAWN_EGG = ITEMS.register("rad_horse_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.RAD_HORSE, 0x474F58, 0x116333,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> ZOMBON_SPAWN_EGG = ITEMS.register("zombon_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.ZOMBON, 0x464F56, 0x1D6336,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> RADIY = ITEMS.register("radiy",
            ()-> new Item(new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> SVINETS = ITEMS.register("svinets",
            ()-> new Item(new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> ASH_SAPLING = ITEMS.register("ash_sapling",
            () -> new BlockItem(ModBlocks.ASH_SAPLING.get(), new Item.Properties()
                    .group(ModItemGroup.IRON_BLOCK)));
    public static final RegistryObject<Item> ASH_LEAVES = ITEMS.register("ash_leaves",
            () -> new BlockItem(ModBlocks.ASH_LEAVES.get(), new Item.Properties()
                    .group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> RADSUIT_BOOTS = ITEMS.register("radsuit_boots",
            () -> new ArmorItem(ModArmorMaterial.RADSUIT, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));
    public static final RegistryObject<Item> RADSUIT_LEGGINGS = ITEMS.register("radsuit_leggings",
            () -> new ArmorItem(ModArmorMaterial.RADSUIT, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));
    public static final RegistryObject<Item> RADSUIT_CHESTPLATE = ITEMS.register("radsuit_chestplate",
            () -> new ArmorItem(ModArmorMaterial.RADSUIT, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));
    public static final RegistryObject<Item> RADSUIT_HELMET = ITEMS.register("radsuit_helmet",
            () -> new ModArmorItem(ModArmorMaterial.RADSUIT, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> RADIY_SWORD = ITEMS.register("radiy_sword",
            () -> new SwordItem(ModItemTier.RADIY, 2, 3f,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> RADIY_PICKAXE = ITEMS.register("radiy_pickaxe",
            () -> new PickaxeItem(ModItemTier.RADIY, 0, -1f,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> RADIY_SHOVEL = ITEMS.register("radiy_shovel",
            () -> new ShovelItem(ModItemTier.RADIY, 0, -1f,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> RADIY_AXE = ITEMS.register("radiy_axe",
            () -> new AxeItem(ModItemTier.RADIY, 4, -6f,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));

    public static final RegistryObject<Item> RADIY_HOE = ITEMS.register("radiy_hoe",
            () -> new HoeItem(ModItemTier.RADIY, 0, 0f,
                    new Item.Properties().group(ModItemGroup.IRON_BLOCK)));








    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }



}
