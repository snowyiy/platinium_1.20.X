package net.enekraftii.platinium.item;

import net.enekraftii.platinium.Platinium;
import net.enekraftii.platinium.item.custom.PlatiniumDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Platinium.MOD_ID);

    public static final RegistryObject<Item> PLATINIUM_INGOT = ITEMS.register("platinium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_PLATINIUM = ITEMS.register("raw_platinium",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PLATINIUM_DETECTOR = ITEMS.register("platinium_detector",
            () -> new PlatiniumDetectorItem(new Item.Properties().durability(150)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
