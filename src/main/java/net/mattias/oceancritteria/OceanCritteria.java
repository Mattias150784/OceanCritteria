package net.mattias.oceancritteria;

import com.mojang.logging.LogUtils;
import net.mattias.oceancritteria.effect.ModEffects;
import net.mattias.oceancritteria.entity.ModEntities;
import net.mattias.oceancritteria.entity.client.PenguinRenderer;
import net.mattias.oceancritteria.item.ModCreativeModTabs;
import net.mattias.oceancritteria.item.ModItems;
import net.mattias.oceancritteria.sound.ModSounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OceanCritteria.MOD_ID)
public class OceanCritteria
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "oceancritteria";
    public static final Logger LOGGER = LogUtils.getLogger();
    public OceanCritteria()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


       ModCreativeModTabs.register(modEventBus);

       ModItems.register(modEventBus);
//        ModBlocks.register(modEventBus);

        ModEffects.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEntities.register(modEventBus);



        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);


        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.PENGUIN.get(), PenguinRenderer::new);

        }
    }
}
