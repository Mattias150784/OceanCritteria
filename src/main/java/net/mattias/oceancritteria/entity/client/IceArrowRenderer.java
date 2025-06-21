package net.mattias.oceancritteria.entity.client;

import net.mattias.oceancritteria.OceanCritteria;
import net.mattias.oceancritteria.entity.custom.projectile.IceArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IceArrowRenderer extends ArrowRenderer<IceArrow> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(
            OceanCritteria.MOD_ID,
            "textures/entity/projectiles/ice_arrow.png"
    );

    public IceArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(IceArrow pEntity) {
        return TEXTURE;
    }
}