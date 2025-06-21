package net.mattias.oceancritteria.effect;

import net.mattias.oceancritteria.OceanCritteria;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, OceanCritteria.MOD_ID);

    public static final RegistryObject<MobEffect> FROZEN_BY_ARROW =
            MOB_EFFECTS.register("frozen_by_arrow", FrozenArrowEffect::new);

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}