package net.lordbrach.gachamod.item.custom;
import net.lordbrach.gachamod.sound.ModSounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.registries.RegistryObject;

public class GreatSwordItem extends SwordItem {

    public GreatSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 500, 3), pAttacker);
        //pAttacker.playSound(, 1.0f, 1.2f);
        // Custom sound event
        RegistryObject<SoundEvent> customSound = ModSounds.SOUND_METAL_STRIKE;

        // Play the custom sound
        pAttacker.level().playSound(null, pAttacker.getX(), pAttacker.getY(), pAttacker.getZ(), customSound.get(), SoundSource.PLAYERS, 1.0F, 1.0F);

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
