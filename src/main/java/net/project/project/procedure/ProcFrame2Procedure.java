package net.project.project.procedure;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.project.project.ProjectModVariables;


import java.util.Map;
import java.util.HashMap;

public class ProcFrame2Procedure {
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

    public static boolean executeProcedure(Map<String, Object> dependencies) {

        Entity entity = (Entity) dependencies.get("entity");
        if ((entity.getCapability(ProjectModVariables.PLAYER_VARIABLES_CAPABILITY, null)
                .orElse(new ProjectModVariables.PlayerVariables())).kek == 2) {
            return true;
        }
        return false;
    }
}
