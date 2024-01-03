package net.lordbrach.gachamod.item.custom;
import net.lordbrach.gachamod.item.ModItems;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class PullItem extends Item {
    // List of spawnable items
    private static final List<DropEntry> DROP_ITEMS = new ArrayList<>();
    private static final Random RANDOM = new Random();

    static {
        // Add items to the drop list with respective stack sizes and probabilities
        DROP_ITEMS.add(new DropEntry(Items.APPLE));
        DROP_ITEMS.add(new DropEntry(Items.TNT));
        DROP_ITEMS.add(new DropEntry(ModItems.ROOTBEER.get()));
        DROP_ITEMS.add(new DropEntry(ModItems.GREATSWORD.get()));
        DROP_ITEMS.add(new DropEntry(ModItems.GREAT_CLUB.get()));
        DROP_ITEMS.add(new DropEntry(ModItems.DISC_WHISTLE.get()));
    }
    public static final int MAX_DRAW_DURATION = 20;
    public PullItem(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.gachamod.pull_one.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    public void releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            if (!pLevel.isClientSide) {
                // logic here
                // decide which item to get
                DropEntry dropEntry = getRandomDropEntry();

                // convert the dropEntry to an itemStack
                ItemStack droppedItemStack = new ItemStack(dropEntry._item, dropEntry._stackSize);
                // Give the player the item
                if (!player.getInventory().add(droppedItemStack)) {
                    // If the player's inventory is full, drop the apple at their feet
                    player.spawnAtLocation(droppedItemStack, 0.5F);
                }
                // decrease durability from item
                pStack.hurtAndBreak(1, player, (p_289501_) -> {
                    p_289501_.broadcastBreakEvent(player.getUsedItemHand());
                });
            }
            // Play used sound
            pLevel.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) * 0.5F);
        }
    }

    private DropEntry getRandomDropEntry() {
        // Use weighted random selection based on probabilities
        double totalWeight = DROP_ITEMS.stream().mapToDouble(DropEntry::getProbability).sum();
        double randomValue = RANDOM.nextDouble() * totalWeight;

        for (DropEntry dropEntry : DROP_ITEMS) {
            randomValue -= dropEntry.getProbability();
            if (randomValue <= 0) {
                return dropEntry;
            }
        }

        // Fallback to the first entry in the list if something goes wrong
        return DROP_ITEMS.get(0);
    }

    // Class for the random item drops
    private static class DropEntry {
        private final Item _item;
        private int _stackSize;
        private double _probability;
        public DropEntry(Item item) {
            this._item = item;
            setProbaAndStacks();
        }

        public void setProbaAndStacks() {
            if (_item.equals(Items.APPLE)) {
                this._stackSize = 16;
                this._probability = 1.0;
            } else if (_item.equals(Items.TNT)) {
                this._stackSize = 64;
                this._probability = 0.2;
            } else if (_item.equals(ModItems.ROOTBEER.get())) {
                this._stackSize = 3;
                this._probability = 0.2;
            } else if (_item.equals(ModItems.GREATSWORD.get())) {
                this._stackSize = 1;
                this._probability = 0.2;
            } else if (_item.equals(ModItems.GREAT_CLUB.get())) {
                this._stackSize = 1;
                this._probability = 0.2;
            } else if (_item.equals(ModItems.DISC_WHISTLE.get())) {
                this._stackSize = 1;
                this._probability = 0.1;
            } else {
                System.out.println("Unknown item");
            }
        }
        public Item getItem() {
            return _item;
        }

        public int getStackSize() {
            return _stackSize;
        }

        public double getProbability() {
            return _probability;
        }
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getUseDuration(ItemStack pStack) {
        return 720; // was 72000
    }

    /**
     * Returns the action that specifies what animation to play when the item is being used.
     */
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.BOW;
    }

    /**
     * Called to trigger the item's "innate" right click behavior. To handle when this item is used on a Block, see
     */
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.consume(itemstack);
    }
}
