package net.mattias.oceancritteria.event;

import net.mattias.oceancritteria.OceanCritteria;
import net.mattias.oceancritteria.entity.ModEntities;
import net.mattias.oceancritteria.entity.client.IceArrowRenderer;
import net.mattias.oceancritteria.entity.client.ModModelLayers;
import net.mattias.oceancritteria.entity.client.PenguinModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OceanCritteria.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {

    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.PENGUIN_LAYER, PenguinModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.ICE_ARROW.get(), IceArrowRenderer::new);
    }
}