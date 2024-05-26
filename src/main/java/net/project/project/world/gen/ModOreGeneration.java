package net.project.project.world.gen;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.Dimension;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.project.project.world.biome.ModBiomes;

import java.util.Arrays;

public class ModOreGeneration{
        public static void generateOres(final BiomeLoadingEvent event) {
            spawnOreInSpecificBiome(ModBiomes.WASTELAND, OreType.RADIUM, event, Dimension.OVERWORLD.toString());
            spawnOreInAllBiomes(OreType.LEAD, event, Dimension.OVERWORLD.toString());
        }


        private static OreFeatureConfig getOverworldFeatureConfig(OreType ore) {
            return new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                    ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());
        }


        // Currently only supports vanilla Dimensions
        private static ConfiguredFeature<?, ?> makeOreFeature(OreType ore, String dimensionToSpawnIn) {
            OreFeatureConfig oreFeatureConfig = null;

            if(dimensionToSpawnIn.equals(Dimension.OVERWORLD.toString())) {
                oreFeatureConfig = getOverworldFeatureConfig(ore);
            }

            ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
                    new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));

            return registerOreFeature(ore, oreFeatureConfig, configuredPlacement);
        }

        private static void spawnOreInOverworldInGivenBiomes(OreType ore, final BiomeLoadingEvent event, Biome... biomesToSpawnIn) {
            OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                    ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());

            ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
                    new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));

            ConfiguredFeature<?, ?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);

            if (Arrays.stream(biomesToSpawnIn).anyMatch(b -> b.getRegistryName().equals(event.getName()))) {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
            }
        }

        private static void spawnOreInOverworldInAllBiomes(OreType ore, final BiomeLoadingEvent event) {
            OreFeatureConfig oreFeatureConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                    ore.getBlock().get().getDefaultState(), ore.getMaxVeinSize());

            ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
                    new TopSolidRangeConfig(ore.getMinHeight(), ore.getMinHeight(), ore.getMaxHeight()));

            ConfiguredFeature<?, ?> oreFeature = registerOreFeature(ore, oreFeatureConfig, configuredPlacement);

            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
        }

        private static void spawnOreInSpecificModBiome(Biome biomeToSpawnIn, OreType currentOreType,
                                                       final BiomeLoadingEvent event, String dimension) {
            if(event.getName().toString().contains(biomeToSpawnIn.getRegistryName().toString())) {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, makeOreFeature(currentOreType, dimension));
            }
        }

        private static void spawnOreInSpecificBiome(RegistryKey<Biome> biomeToSpawnIn, OreType currentOreType,
                                                    final BiomeLoadingEvent event, String dimension) {
            if(event.getName().toString().contains(biomeToSpawnIn.getLocation().toString())) {
                event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, makeOreFeature(currentOreType, dimension));
            }
        }

        private static void spawnOreInAllBiomes(OreType currentOreType, final BiomeLoadingEvent event, String dimension) {
            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    makeOreFeature(currentOreType, dimension));
        }

        private static ConfiguredFeature<?, ?> registerOreFeature(OreType ore, OreFeatureConfig oreFeatureConfig,
                                                                  ConfiguredPlacement configuredPlacement) {
            return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, ore.getBlock().get().getRegistryName(),
                    Feature.ORE.withConfiguration(oreFeatureConfig).withPlacement(configuredPlacement)
                            .square().count(ore.getVeinsPerChunk()));
        }
}