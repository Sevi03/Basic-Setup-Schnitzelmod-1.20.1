package net.dlta.schnitzelmod.item;

import net.dlta.schnitzelmod.SchnitzelMod;
import net.dlta.schnitzelmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SchnitzelMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> SCHNITZEL_TAB = CREATIVE_MODE_TABS.register("schnitzel_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SCHNITZEL.get()))
                    .title(Component.translatable("creativetab.schnitzel_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SCHNITZEL.get());
                        pOutput.accept(ModItems.SCHNITZEL_RAW.get());
                        pOutput.accept(ModItems.FLEISCHKLOPFER.get());
                        pOutput.accept(ModItems.REIBE.get());
                        pOutput.accept(ModItems.SEMMELBROESEL.get());
                        pOutput.accept(ModItems.FLOUR_WHEAT.get());
                        pOutput.accept(ModItems.MORTAR.get());
                        pOutput.accept(ModItems.UNFIRED_PLATE.get());
                        pOutput.accept(ModItems.PLATE.get());
                        pOutput.accept(ModItems.PORK_HAMMERED.get());
                        pOutput.accept(ModItems.PORK_FLOUR.get());
                        pOutput.accept(ModItems.PORK_EGG.get());

                        //Blocks
                        pOutput.accept(ModBlocks.PLATE_BLOCK.get());
                    })
                    .build());
    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
