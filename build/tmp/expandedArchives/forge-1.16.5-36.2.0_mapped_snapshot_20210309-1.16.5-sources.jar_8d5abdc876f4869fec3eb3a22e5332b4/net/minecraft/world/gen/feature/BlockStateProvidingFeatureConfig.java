package net.minecraft.world.gen.feature;

import com.mojang.serialization.Codec;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;

public class BlockStateProvidingFeatureConfig implements IFeatureConfig {
   public static final Codec<BlockStateProvidingFeatureConfig> CODEC = BlockStateProvider.CODEC.fieldOf("state_provider").xmap(BlockStateProvidingFeatureConfig::new, (p_236454_0_) -> {
      return p_236454_0_.stateProvider;
   }).codec();
   public final BlockStateProvider stateProvider;

   public BlockStateProvidingFeatureConfig(BlockStateProvider stateProvider) {
      this.stateProvider = stateProvider;
   }
}