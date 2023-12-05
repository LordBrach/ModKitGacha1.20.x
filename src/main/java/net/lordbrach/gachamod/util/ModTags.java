package net.lordbrach.gachamod.util;
import com.sun.source.tree.BlockTree;
import net.lordbrach.gachamod.GachaMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(GachaMod.MOD_ID, name));
        }
    }
    public static class Items {
        public static final TagKey<Item> PULL_ITEMS = tag("gacha_pull");
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(GachaMod.MOD_ID, name));
        }
    }
}
