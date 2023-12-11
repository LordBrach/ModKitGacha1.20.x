package net.lordbrach.gachamod.datagen;

import net.lordbrach.gachamod.GachaMod;
import net.lordbrach.gachamod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GachaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.PULL1);
        simpleItem(ModItems.PULL5);
        simpleItem(ModItems.ROOTBEER);

        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.TEMPLATE);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(GachaMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
