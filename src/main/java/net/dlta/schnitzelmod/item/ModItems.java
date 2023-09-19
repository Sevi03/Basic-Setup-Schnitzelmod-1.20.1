package net.dlta.schnitzelmod.item;

import net.dlta.schnitzelmod.SchnitzelMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SchnitzelMod.MOD_ID);

    public static final RegistryObject<Item> SCHNITZEL =
            ITEMS.register("schnitzel", () -> new Item(new Item.Properties().food(ModFoods.SCHNITZEL)));

    public static final RegistryObject<Item> SCHNITZEL_RAW =
            ITEMS.register("schnitzel_raw", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FLEISCHKLOPFER =
            ITEMS.register("fleischklopfer", () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
