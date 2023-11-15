package net.lordbrach.gachamod.item;

import net.lordbrach.gachamod.GachaMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GachaMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> GACHA_TAB = CREATIVE_MODE_TABS.register("gacha_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TEMPLATE.get()))
                    .title(Component.translatable("creativetab.gacha_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TEMPLATE.get());
                        pOutput.accept(ModItems.ROOTBEER.get());

                        pOutput.accept(Items.COMMAND_BLOCK);
                    })
                    .build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
