package net.project.project.events;

import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.project.project.Project;
import net.project.project.entity.ModEntityTypes;
import net.project.project.entity.custom.Rad_Skeleton;
import net.project.project.item.custom.ModSpawnEggItem;


@Mod.EventBusSubscriber(modid = Project.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents1 {
    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.RAD_SKELETON.get(), Rad_Skeleton.setCustomAttributes().create());
    }


    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
        ModSpawnEggItem.initSpawnEggs();
    }
}
