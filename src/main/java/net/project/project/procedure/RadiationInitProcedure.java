package net.project.project.procedure;


import net.minecraft.potion.Effect;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;


import net.project.project.potion.RadiationResistancePotionEffect;
import net.project.project.potion.RadiationSicknessPotionEffect;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class RadiationInitProcedure {
    @Mod.EventBusSubscriber
    private static class GlobalTrigger {
        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            if (event.phase == TickEvent.Phase.END) {
                Entity entity = event.player;
                World world = entity.world;
                double i = entity.getPosX();
                double j = entity.getPosY();
                double k = entity.getPosZ();
                Map<String, Object> dependencies = new HashMap<>();
                dependencies.put("x", i);
                dependencies.put("y", j);
                dependencies.put("z", k);
                dependencies.put("world", world);
                dependencies.put("entity", entity);
                dependencies.put("event", event);
                executeProcedure(dependencies);
            }
        }
    }

    public static void executeProcedure(Map<String, Object> dependencies) {

        IWorld world = (IWorld) dependencies.get("world");
        double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
        double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
        double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
        Entity entity = (Entity) dependencies.get("entity");
        if (world.func_241828_r().getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))) != null && world.func_241828_r()
                .getRegistry(Registry.BIOME_KEY).getKey(world.getBiome(new BlockPos(x, y, z))).equals(new ResourceLocation("project:wasteland"))
                && !(new Object() {
            boolean check(Entity _entity) {
                if (_entity instanceof LivingEntity) {
                    Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
                    for (EffectInstance effect : effects) {
                        if (effect.getPotion() == Effects.RESISTANCE)
                            return true;

                    }
                }
                return false;
            }
        }.check(entity))) {
            if (entity instanceof LivingEntity)
                ((LivingEntity) entity).addPotionEffect(new EffectInstance(RadiationSicknessPotionEffect.potion, (int) 300, (int) 0));

        }
    }
}
