package net.lordbrach.gachamod.item;

import net.lordbrach.gachamod.GachaMod;
import net.lordbrach.gachamod.item.custom.*;
import net.lordbrach.gachamod.sound.ModSounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // make lists n stuff
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GachaMod.MOD_ID);
    // add an item (here root beer)
    public static final RegistryObject<Item> ROOTBEER = ITEMS.register("rootbeer", ()-> new DrinkableItem(new Item.Properties()
            .food(ModFoods.ROOTBEER_FOOD)));
    //public static final RegistryObject<Item> ROOTBEER = ITEMS.register("rootbeer", () -> new ModDrinkableItem(new Item.Properties()));

    public static final RegistryObject<Item> TEMPLATE = ITEMS.register("template", ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector", ()-> new TestCustomItem(new Item.Properties()
            .durability(100)));
    public static final RegistryObject<Item> PULL1 = ITEMS.register("pull_one", ()-> new PullItem(new Item.Properties()
            .durability(1)));
    public static final RegistryObject<Item> PULL5 = ITEMS.register("pull_five", ()-> new PullItem(new Item.Properties()
            .durability(5)));

    public static final RegistryObject<Item> GREAT_CLUB = ITEMS.register("great_club", ()-> new ClubItem(
            Tiers.DIAMOND,
            10.0f,
            3.5f,
            new ClubItem.Properties()));
    public static final RegistryObject<Item> GREATSWORD = ITEMS.register("greatsword", ()-> new GreatSwordItem(
            Tiers.NETHERITE,
            15,
            5.05f,
            new ClubItem.Properties()));
    public static final RegistryObject<Item> DISC_WHISTLE = ITEMS.register("disc_whistle", ()-> new RecordItem(
            1,
            ModSounds.WHISTLE_MEME,
            new Item.Properties().stacksTo(1),
            380)); // 20 * song length in seconds

    // register DeferredRegister
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
