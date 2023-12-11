package net.lordbrach.gachamod.datagen;

import net.lordbrach.gachamod.block.ModBlocks;
import net.lordbrach.gachamod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TEST_BLOCK.get())
                .pattern("SSS")
                .pattern("SOS")
                .pattern("SSS")
                .define('S', ModItems.TEMPLATE.get())
                .define('O', ModItems.ROOTBEER.get())
                .unlockedBy(getHasName(ModItems.TEMPLATE.get()), has(ModItems.TEMPLATE.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TEMPLATE.get(), 8)
                .requires(ModBlocks.TEST_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TEST_BLOCK.get()), has(ModBlocks.TEST_BLOCK.get()))
                .save(pWriter);
    }
}
