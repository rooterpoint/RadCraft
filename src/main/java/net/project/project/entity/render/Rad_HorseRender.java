package net.project.project.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.util.ResourceLocation;
import net.project.project.Project;
import net.project.project.entity.custom.Rad_Horse;
import net.project.project.entity.model.Rad_HorseModel;

public class Rad_HorseRender extends MobRenderer<Rad_Horse, HorseModel<Rad_Horse>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(Project.MOD_ID, "textures/entity/rad_horse.png");

    public Rad_HorseRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new Rad_HorseModel(1), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(Rad_Horse entity) {
        return TEXTURE;
    }
}

