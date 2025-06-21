package net.mattias.oceancritteria.event;

import net.mattias.oceancritteria.OceanCritteria;
import net.mattias.oceancritteria.entity.ModEntities;
import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OceanCritteria.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.PENGUIN.get(), PenguinEntity.createAttributes().build());
    }
}