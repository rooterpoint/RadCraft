package net.project.project.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.project.project.Project;
import net.project.project.entity.custom.Zombon;
import net.project.project.entity.model.ZombonModel;


public class ZombonRender extends MobRenderer<Zombon, ZombonModel<Zombon>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(Project.MOD_ID, "textures/entity/zombon.png");

    public ZombonRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ZombonModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(Zombon entity) {
        return TEXTURE;
    }
}
