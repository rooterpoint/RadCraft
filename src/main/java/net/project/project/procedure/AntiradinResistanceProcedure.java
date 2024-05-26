package net.project.project.procedure;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;


import java.util.Map;

public class AntiradinResistanceProcedure {

    public static void executeProcedure(Map<String, Object> dependencies) {

        Entity entity = (Entity) dependencies.get("entity");
        if (entity instanceof LivingEntity)
            ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 600, (int) 1));
    }
}