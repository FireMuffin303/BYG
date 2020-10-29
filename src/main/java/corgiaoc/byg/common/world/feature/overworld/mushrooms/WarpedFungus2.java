package corgiaoc.byg.common.world.feature.overworld.mushrooms;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGMushroomConfig;
import corgiaoc.byg.common.world.feature.overworld.mushrooms.util.BYGAbstractMushroomFeature;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;

import java.util.Random;

public class WarpedFungus2 extends BYGAbstractMushroomFeature<BYGMushroomConfig> {

    public WarpedFungus2(Codec<BYGMushroomConfig> configIn) {
        super(configIn);
    }

    protected boolean placeMushroom(StructureWorldAccess worldIn, Random rand, BlockPos pos, boolean isMushroom, BYGMushroomConfig config) {
        BlockState STEM = config.getStemProvider().getBlockState(rand, pos);
        BlockState MUSHROOM = config.getMushroomProvider().getBlockState(rand, pos);
        BlockState MUSHROOM2 = config.getMushroom2Provider().getBlockState(rand, pos);
        BlockState MUSHROOM3 = config.getMushroom3Provider().getBlockState(rand, pos);
        BlockState POLLEN = config.getPollenProvider().getBlockState(rand, pos);
        int randTreeHeight = 10 + rand.nextInt(5);
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE)) {
                return false;
            } else if (!this.isAnotherMushroomLikeThisNearby(worldIn, pos, randTreeHeight, 0, STEM.getBlock(), MUSHROOM.getBlock(), isMushroom)) {
                return false;
            } else if (!this.doesMushroomHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isMushroom)) {
                return false;
            } else {
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 0, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 0, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 1, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 1, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 2, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 2, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 3, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 3, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 3, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 4, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 4, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 4, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 4, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 5, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 5, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 5, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 6, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 6, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 6, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 6, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 7, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 7, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 7, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 7, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 8, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 8, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 8, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 8, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 9, 0));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(-1, 9, 1));
                placeStem(STEM, worldIn, mainmutable.set(pos).move(0, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 7, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 8, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 8, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 8, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 8, 1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-6, 9, 1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-6, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 9, 4));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-3, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 9, 4));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-2, 9, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 9, 5));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 9, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 9, 4));
                this.shroomlight(worldIn, mainmutable.set(pos).move(2, 9, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 9, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 9, 2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(5, 9, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(5, 9, 0));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-6, 10, 1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-6, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 10, 4));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-3, 10, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 10, 5));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-2, 10, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 10, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, -2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 10, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 10, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 10, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 10, 5));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 10, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 10, 5));
                this.shroomlight(worldIn, mainmutable.set(pos).move(2, 10, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 10, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 10, 3));
                this.shroomlight(worldIn, mainmutable.set(pos).move(5, 10, -1));
                this.shroomlight(worldIn, mainmutable.set(pos).move(5, 10, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-5, 11, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, -3));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-4, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-4, 11, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, -4));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-3, 11, 3));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-3, 11, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-3, 11, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, -4));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-2, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-2, 11, 5));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-2, 11, 6));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(-1, 11, 5));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 11, 6));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 11, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(0, 11, 5));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 11, -5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(1, 11, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(2, 11, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, -4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, -3));
                this.shroomlight(worldIn, mainmutable.set(pos).move(3, 11, 2));
                this.shroomlight(worldIn, mainmutable.set(pos).move(3, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, 4));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(3, 11, 5));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 11, -3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 11, -2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 11, -1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 11, 0));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 11, 1));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 11, 2));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 11, 3));
                placeMushroom(MUSHROOM, worldIn, mainmutable.set(pos).move(4, 11, 4));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-4, 12, 4));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-2, 12, 5));
                this.shroomlight(worldIn, mainmutable.set(pos).move(-1, 12, 6));
                this.shroomlight(worldIn, mainmutable.set(pos).move(0, 12, -4));
                this.shroomlight(worldIn, mainmutable.set(pos).move(1, 12, -5));
                this.shroomlight(worldIn, mainmutable.set(pos).move(3, 12, 3));
                this.shroomlight(worldIn, mainmutable.set(pos).move(4, 12, 2));
            }
        }
        return true;
    }

    private void shroomlight(StructureWorldAccess reader, BlockPos pos) {
        if (isAir(reader, pos)) {
            this.setFinalBlockState(reader, pos, Blocks.SHROOMLIGHT.getDefaultState());
        }
    }
}