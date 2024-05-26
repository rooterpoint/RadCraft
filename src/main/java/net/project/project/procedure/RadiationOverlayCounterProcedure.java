package net.project.project.procedure;



import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.project.project.ProjectModVariables;
import net.project.project.potion.RadiationSicknessPotionEffect;


import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class RadiationOverlayCounterProcedure {
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

        Entity entity = (Entity) dependencies.get("entity");
        double lol = 0;
        if (new Object() {
            boolean check(Entity _entity) {
                if (_entity instanceof LivingEntity) {
                    Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
                    for (EffectInstance effect : effects) {
                        if (effect.getPotion() == RadiationSicknessPotionEffect.potion)
                            return true;
                    }
                }
                return false;
            }
        }.check(entity)) {
            if ((entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ProjectModVariables.PlayerVariables())).kek == 1) {
                {
                    double _setval = 2;
                    entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.kek = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            } else if ((entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ProjectModVariables.PlayerVariables())).kek == 2) {
                {
                    double _setval = 3;
                    entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.kek = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            } else if ((entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ProjectModVariables.PlayerVariables())).kek == 3) {
                {
                    double _setval = 4;
                    entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.kek = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            } else if ((entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ProjectModVariables.PlayerVariables())).kek == 4) {
                {
                    double _setval = 5;
                    entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.kek = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            } else if ((entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ProjectModVariables.PlayerVariables())).kek == 5) {
                {
                    double _setval = 6;
                    entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.kek = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            } else if ((entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                    .orElse(new ProjectModVariables.PlayerVariables())).kek == 6) {
                {
                    double _setval = 7;
                    entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.kek = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            } else {
                {
                    double _setval = 1;
                    entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                        capability.kek = _setval;
                        capability.syncPlayerVariables(entity);
                    });
                }
            }
        } else {
            {
                double _setval = 0;
                entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
                    capability.kek = _setval;
                    capability.syncPlayerVariables(entity);
                });
            }
        }
    }
}
