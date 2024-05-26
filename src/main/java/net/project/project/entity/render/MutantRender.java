package net.project.project.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SpiderModel;
import net.minecraft.util.ResourceLocation;
import net.project.project.Project;
import net.project.project.entity.custom.Mutant;
import net.project.project.entity.model.MutantModel;

public class MutantRender extends MobRenderer<Mutant, SpiderModel<Mutant>>
{
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(Project.MOD_ID, "textures/entity/mutant.png");

    public MutantRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MutantModel(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(Mutant entity) {
        return TEXTURE;
    }
}

