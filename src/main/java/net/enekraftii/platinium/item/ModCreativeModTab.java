package net.enekraftii.platinium.item;

import net.enekraftii.platinium.Platinium;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Platinium.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PLATINIUM_TAB = CREATIVE_MODE_TABS.register("platinium8_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PLATINIUM.get()))
                    .title(Component.translatable("creativetab.platinium_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.PLATINIUM.get());
                        output.accept(ModItems.RAW_PLATINIUM.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
