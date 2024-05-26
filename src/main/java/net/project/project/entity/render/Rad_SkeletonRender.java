package net.project.project.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.SkeletonModel;
import net.minecraft.util.ResourceLocation;
import net.project.project.Project;
import net.project.project.entity.custom.Rad_Skeleton;

public class Rad_SkeletonRender extends MobRenderer<Rad_Skeleton, SkeletonModel<Rad_Skeleton>> {
    protected static final ResourceLocation TEXTURE =
            new ResourceLocation(Project.MOD_ID, "textures/entity/rad_skeleton.png");

    public Rad_SkeletonRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new SkeletonModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(Rad_Skeleton entity) {
        return TEXTURE;
    }
}

