package net.project.project.gui.overlay;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;



import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;
import net.project.project.procedure.*;

@Mod.EventBusSubscriber
public class RadiationOverlay {
    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void eventHandler(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
            int w = event.getWindow().getScaledWidth();
            int h = event.getWindow().getScaledHeight();
            int posX = w / 2;
            int posY = h / 2;
            World _world = null;
            double _x = 0;
            double _y = 0;
            double _z = 0;
            PlayerEntity entity = Minecraft.getInstance().player;
            if (entity != null) {
                _world = entity.world;
                _x = entity.getPosX();
                _y = entity.getPosY();
                _z = entity.getPosZ();
            }
            World world = _world;
            double x = _x;
            double y = _y;
            double z = _z;
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                    GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.disableAlphaTest();
            if (true) {

                if (ProcFrame1Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
                    Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("project:textures/screens/ka1.png"));
                    Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -480, posY + -480, 0, 0, 960, 960, 960, 960);
                }
                if (ProcFrame2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
                    Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("project:textures/screens/ka2.png"));
                    Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -480, posY + -480, 0, 0, 960, 960, 960, 960);
                }
                if (ProcFrame3Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
                    Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("project:textures/screens/ka3.png"));
                    Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -480, posY + -480, 0, 0, 960, 960, 960, 960);
                }
                if (ProcFrame4Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
                    Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("project:textures/screens/ka4.png"));
                    Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -480, posY + -480, 0, 0, 960, 960, 960, 960);
                }
                if (ProcFrame5Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
                    Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("project:textures/screens/ka5.png"));
                    Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -480, posY + -480, 0, 0, 960, 960, 960, 960);
                }
                if (ProcFrame6Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
                    Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("project:textures/screens/ka6.png"));
                    Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -480, posY + -480, 0, 0, 960, 960, 960, 960);
                }
                if (ProcFrame7Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
                        (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
                    Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("project:textures/screens/ka7.png"));
                    Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -480, posY + -480, 0, 0, 960, 960, 960, 960);
                }
            }
            RenderSystem.depthMask(true);
            RenderSystem.enableDepthTest();
            RenderSystem.enableAlphaTest();
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
