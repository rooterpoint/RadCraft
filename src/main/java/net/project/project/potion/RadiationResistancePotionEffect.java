package net.project.project.potion;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.potion.EffectType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effect;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RadiationResistancePotionEffect {
    @ObjectHolder("project:radiation_resistance")
    public static final Effect potion = null;

    @SubscribeEvent
    public static void registerEffect(RegistryEvent.Register<Effect> event) {
        event.getRegistry().register(new EffectCustom());
    }

    public static class EffectCustom extends Effect {
        public EffectCustom() {
            super(EffectType.BENEFICIAL, -1);
            setRegistryName("radiation_resistance");
        }

        @Override
        public String getName() {
            return "effect.radiation_resistance";
        }

        @Override
        public boolean isBeneficial() {
            return true;
        }

        @Override
        public boolean isInstant() {
            return false;
        }

        @Override
        public boolean shouldRenderInvText(EffectInstance effect) {
            return true;
        }

        @Override
        public boolean shouldRender(EffectInstance effect) {
            return true;
        }

        @Override
        public boolean shouldRenderHUD(EffectInstance effect) {
            return false;
        }

        @Override
        public boolean isReady(int duration, int amplifier) {
            return true;
        }
    }
}
