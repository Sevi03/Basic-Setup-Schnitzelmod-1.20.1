package net.dlta.schnitzelmod.block.custom;

import net.dlta.schnitzelmod.SchnitzelMod;
import net.dlta.schnitzelmod.block.ModBlocks;
import net.dlta.schnitzelmod.blockentity.PlateBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, SchnitzelMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PlateBlockEntity>> PLATE_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("plate_block",
                    () -> BlockEntityType.Builder.of(PlateBlockEntity::new, ModBlocks.PLATE_BLOCK.get())
                            .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
