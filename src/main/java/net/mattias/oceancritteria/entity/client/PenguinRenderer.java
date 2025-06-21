package net.mattias.oceancritteria.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.mattias.oceancritteria.OceanCritteria;
import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
    public PenguinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PenguinModel<>(pContext.bakeLayer(ModModelLayers.PENGUIN_LAYER)), 0.6f);
    }

    @Override
    public ResourceLocation getTextureLocation(PenguinEntity pEntity) {
        String texture = pEntity.isBaby()
                ? "textures/entity/penguin_baby.png"
                : "textures/entity/penguin.png";
        return new ResourceLocation(OceanCritteria.MOD_ID, texture);
    }

    @Override
    public void render(PenguinEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pMatrixStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}