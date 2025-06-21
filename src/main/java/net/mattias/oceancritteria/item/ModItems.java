package net.mattias.oceancritteria.item;

import net.mattias.oceancritteria.OceanCritteria;
import net.mattias.oceancritteria.entity.ModEntities;
import net.mattias.oceancritteria.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OceanCritteria.MOD_ID);

    public static final RegistryObject<Item> PENGUIN_FEATHER = ITEMS.register("penguin_feather",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PENGUIN_BEAK = ITEMS.register("penguin_beak",
            () -> new PenguinBeakItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ICE_ARROW = ITEMS.register("ice_arrow",
            () -> new IceArrowItem(new Item.Properties(), 2.0f));

    public static final RegistryObject<Item> PENGUIN_SPAWN_EGG = ITEMS.register("penguin_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.PENGUIN, 0x5f6670, 0x9ba8ba, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}