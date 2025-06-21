package net.mattias.oceancritteria.item;

import net.mattias.oceancritteria.OceanCritteria;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OceanCritteria.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OCEAN_CRITTERIA = CREATIVE_MODE_TABS.register("ocean_critteria_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PENGUIN_FEATHER.get()))
                    .title(Component.translatable("creativetab.ocean_critteria_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.PENGUIN_FEATHER.get());
                        pOutput.accept(ModItems.PENGUIN_BEAK.get());
                        pOutput.accept(ModItems.PENGUIN_SPAWN_EGG.get());
                        pOutput.accept(ModItems.ICE_ARROW.get());



                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}