package corgiaoc.byg.common.world.surfacebuilder;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.surfacebuilder.config.PointedSBConfig;
import corgiaoc.byg.util.noise.fastnoise.FNVector3f;
import corgiaoc.byg.util.noise.fastnoise.FastNoise;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import java.util.Random;

public class PointedSB extends SurfaceBuilder<PointedSBConfig> {

    public PointedSB(Codec<PointedSBConfig> codec) {
        super(codec);
    }

    public static FastNoise noiseGen = null;
    public static FastNoise noiseGen3D = null;

    public void generate(Random random, Chunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, PointedSBConfig config) {
        initSeed(random.nextLong());
        int xPos = x & 15;
        int zPos = z & 15;
        BlockPos.Mutable mutable = new BlockPos.Mutable(xPos, 0, zPos);

        FNVector3f fnVector3f = new FNVector3f(x, 0, z);

        noiseGen.GradientPerturb(fnVector3f);

        float sampleNoise = noiseGen.GetNoise(fnVector3f.x, fnVector3f.z);

        int groundLevel = chunkIn.sampleHeightmap(Heightmap.Type.OCEAN_FLOOR_WG, x, z);

        if (sampleNoise < 0.43) {
            int valueToReverse = (int) (Math.abs((int) (sampleNoise * 645D) * 1.8));
            int topHeight = (int) ((valueToReverse - Math.abs(((-sampleNoise * 645D) * 1.8 - valueToReverse))) + (63) * 9.5D);

            //Some magic to stop spires going over the world limit. Point should always occur under world limit(<256).
            topHeight = redistribute(topHeight, groundLevel, config.getSpikeHeight());

            if (topHeight > groundLevel) {
                mutable.move(Direction.UP, topHeight);
                for (int yPos = topHeight; yPos >= groundLevel; --yPos) {
                    if (chunkIn.getBlockState(mutable).isAir() && mutable.getY() <= chunkIn.getHeight()) {
                        if (yPos == topHeight)
                            chunkIn.setBlockState(mutable, config.getSpikeTopBlockProvider().getBlockState(random, mutable), false);
                        else
                            chunkIn.setBlockState(mutable, config.getSpikeProvider().getBlockState(random, mutable), false);
                    }
                    mutable.move(Direction.DOWN);
                }
            }
        } else
            SurfaceBuilder.DEFAULT.generate(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, new TernarySurfaceConfig(config.getTopMaterial(), config.getUnderMaterial(), config.getUnderMaterial()));
    }

    @Override
    public void initSeed(long seed) {
        if (noiseGen == null) {
            noiseGen = new FastNoise((int) seed);
            noiseGen.SetFractalType(FastNoise.FractalType.RigidMulti);
            noiseGen.SetNoiseType(FastNoise.NoiseType.SimplexFractal);
            noiseGen.SetGradientPerturbAmp(5);
            noiseGen.SetFractalOctaves(1);
            noiseGen.SetFractalGain(0.3f);
            noiseGen.SetFrequency(0.02f);
        }

        if (noiseGen3D == null) {
            noiseGen3D = new FastNoise((int) seed);
            noiseGen3D.SetNoiseType(FastNoise.NoiseType.Simplex);
            noiseGen3D.SetFractalGain(0.006f);
            noiseGen3D.SetFrequency(0.7f);
        }
    }

    private static int redistribute(float height, float groundLevel, int configHeight) {
        float halfG = groundLevel * 0.5f;
        height = (height - 125 - halfG) / 80;
        float sigmoid = height / (1 + Math.abs(height)); // or Math.abs, whichever one can return a float
        return (int) ((configHeight - groundLevel) * sigmoid + halfG + 125);
    }
}