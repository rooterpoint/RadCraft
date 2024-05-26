package net.project.project.world.gen;

import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;
import net.project.project.block.ModBlocks;

public enum OreType {

    RADIUM(Lazy.of(ModBlocks.RADIUM), 8, 25, 50, 3),
    LEAD(Lazy.of(ModBlocks.LEAD), 7, 10, 80, 8);

        private final Lazy<Block> block;
        private final int maxVeinSize;
        private final int minHeight;
        private final int maxHeight;
        private final int veinsPerChunk;

        OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight, int veinsPerChunk) {
            this.block = block;
            this.maxVeinSize = maxVeinSize;
            this.minHeight = minHeight;
            this.maxHeight = maxHeight;
            this.veinsPerChunk = veinsPerChunk;
        }


        public int getVeinsPerChunk() {
            return veinsPerChunk;
        }

        public Lazy<Block> getBlock() {
            return block;
        }

        public int getMaxVeinSize() {
            return maxVeinSize;
        }

        public int getMinHeight() {
            return minHeight;
        }

        public int getMaxHeight() {
            return maxHeight;
        }

        public static OreType get(Block block) {
            for (OreType ore : values()) {
                if(block == ore.block) {
                    return ore;
                }
            }
            return null;
        }
    }
