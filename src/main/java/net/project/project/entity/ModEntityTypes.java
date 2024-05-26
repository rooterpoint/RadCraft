package net.project.project.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.project.project.Project;
import net.project.project.entity.custom.Mutant;
import net.project.project.entity.custom.Rad_Horse;
import net.project.project.entity.custom.Rad_Skeleton;
import net.project.project.entity.custom.Zombon;

public class ModEntityTypes
{
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, Project.MOD_ID);

    public static final RegistryObject<EntityType<Rad_Skeleton>> RAD_SKELETON =
            ENTITY_TYPES.register("rad_skeleton",()-> EntityType.Builder.create(Rad_Skeleton::new,
                            EntityClassification.MONSTER).size(1f,1f)
                    .build(new ResourceLocation(Project.MOD_ID, "rad_skeleton").toString()));

    public static final RegistryObject<EntityType<Mutant>> MUTANT =
            ENTITY_TYPES.register("mutant",()-> EntityType.Builder.create(Mutant::new,
                            EntityClassification.MONSTER).size(1f,1f)
                    .build(new ResourceLocation(Project.MOD_ID, "mutant").toString()));

    public static final RegistryObject<EntityType<Rad_Horse>> RAD_HORSE =
            ENTITY_TYPES.register("rad_horse",()-> EntityType.Builder.create(Rad_Horse::new,
                            EntityClassification.MONSTER).size(1f,1f)
                    .build(new ResourceLocation(Project.MOD_ID, "rad_horse").toString()));

    public static final RegistryObject<EntityType<Zombon>> ZOMBON =
            ENTITY_TYPES.register("zombon", () -> EntityType.Builder.create(Zombon::new,
                            EntityClassification.MONSTER).size(1f, 1f)
                            .build(new ResourceLocation(Project.MOD_ID, "zombon").toString()));





    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}