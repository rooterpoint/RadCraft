package net.project.project.world.gen;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;
import net.project.project.block.ModBlocks;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ASH =
            register("ash", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.ASH_LOG.get().getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.ASH_LEAVES.get().getDefaultState()),
                            new BlobFoliagePlacer(FeatureSpread.create(0), FeatureSpread.create(0), 0),
                            new StraightTrunkPlacer(4, 4, 4),
                            new TwoLayerFeature(5, 3, 3))).setIgnoreVines().build()));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}
