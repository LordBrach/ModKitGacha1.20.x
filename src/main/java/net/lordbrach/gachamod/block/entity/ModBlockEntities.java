package net.lordbrach.gachamod.block.entity;

import net.lordbrach.gachamod.GachaMod;
import net.lordbrach.gachamod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GachaMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<GachaStationBlockEntity>> GACHA_STATION_BE =
            BLOCK_ENTITIES.register("gacha_station_be", () ->
                    BlockEntityType.Builder.of(GachaStationBlockEntity::new,
                            ModBlocks.GACHA_STATION.get()).build(null));
    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
