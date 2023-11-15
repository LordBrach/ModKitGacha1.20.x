package net.lordbrach.gachamod.item;

import net.lordbrach.gachamod.GachaMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // make lists n stuff
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GachaMod.MOD_ID);
    // add an item (here root beer)
    public static final RegistryObject<Item> ROOTBEER = ITEMS.register("rootbeer", ()-> new Item(new Item.Properties().food(ModFoods.ROOTBEER_FOOD)));
    //public static final RegistryObject<Item> ROOTBEER = ITEMS.register("rootbeer", () -> new ModDrinkableItem(new Item.Properties()));

    public static final RegistryObject<Item> TEMPLATE = ITEMS.register("template", ()-> new Item(new Item.Properties()));

    // register DeferredRegister
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
