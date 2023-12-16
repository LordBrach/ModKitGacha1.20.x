package net.lordbrach.gachamod.sound;

import net.lordbrach.gachamod.GachaMod;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GachaMod.MOD_ID);
    // Metal weapons
    public static final RegistryObject<SoundEvent> SOUND_METAL_STRIKE = registerSoundEvents("sound_metal_strike");
    // sus block
    public static final RegistryObject<SoundEvent> SOUND_SUS_BREAK = registerSoundEvents("sound_sus_break");
    public static final RegistryObject<SoundEvent> SOUND_SUS_STEP = registerSoundEvents("sound_sus_step");
    public static final RegistryObject<SoundEvent> SOUND_SUS_FALL = registerSoundEvents("sound_sus_fall");
    public static final RegistryObject<SoundEvent> SOUND_SUS_PLACE = registerSoundEvents("sound_sus_place");
    public static final RegistryObject<SoundEvent> SOUND_SUS_HIT = registerSoundEvents("sound_sus_hit");

    // link sounds to block values
    public static final ForgeSoundType SOUND_SUS_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.SOUND_SUS_BREAK, ModSounds.SOUND_SUS_STEP,
            ModSounds.SOUND_SUS_PLACE, ModSounds.SOUND_SUS_HIT, ModSounds.SOUND_SUS_FALL);
    // register sound method

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(
                new ResourceLocation(GachaMod.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
