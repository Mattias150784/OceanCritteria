package net.mattias.oceancritteria.entity;

import net.mattias.oceancritteria.OceanCritteria;
import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.mattias.oceancritteria.entity.custom.projectile.IceArrow;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, OceanCritteria.MOD_ID);

    public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN =
            ENTITY_TYPES.register("penguin", () -> EntityType.Builder.of(PenguinEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("penguin"));

    public static final RegistryObject<EntityType<IceArrow>> ICE_ARROW =
            ENTITY_TYPES.register("ice_arrow",
                    () -> EntityType.Builder.<IceArrow>of((type, world) -> new IceArrow(type, world), MobCategory.MISC)
                            .sized(0.5F, 0.5F)
                            .clientTrackingRange(4)
                            .updateInterval(20)
                            .build("ice_arrow")
            );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}