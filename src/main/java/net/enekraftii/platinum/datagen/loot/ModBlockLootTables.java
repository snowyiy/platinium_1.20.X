package net.enekraftii.platinum.datagen.loot;

import net.enekraftii.platinum.block.ModBlocks;
import net.enekraftii.platinum.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.PLATINUM_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.add(ModBlocks.PLATINUM_ORE.get(),
                block -> createOreDrop(ModBlocks.PLATINUM_ORE.get(), ModItems.RAW_PLATINUM.get()));
        this.add(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_PLATINUM_ORE.get(), ModItems.RAW_PLATINUM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
