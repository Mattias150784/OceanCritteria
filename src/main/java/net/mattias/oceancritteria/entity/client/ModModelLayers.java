package net.mattias.oceancritteria.entity.client;

import net.mattias.oceancritteria.OceanCritteria;
import net.mattias.oceancritteria.entity.ModEntities;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;

public class ModModelLayers {


    public static final ModelLayerLocation PENGUIN_LAYER = new ModelLayerLocation(
            new ResourceLocation(OceanCritteria.MOD_ID, "penguin_layer"), "main");


}