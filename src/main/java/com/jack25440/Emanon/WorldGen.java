package com.jack25440.Emanon;

import java.util.Random;

import com.jack25440.Emanon.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        switch (world.provider.dimensionId) {

            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);

            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);

            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);

        }
    }

    public void generateSurface(World world, Random random, int x, int z) {
        this.addOreSpawn(ModBlocks.eterealOre, world, random, x, z, 16, 16, 1 + random.nextInt(5), 10, 0, 45);
    }

    public void generateNether(World world, Random random, int x, int z) {
        // TODO Auto-generated method stub

    }

    public void generateEnd(World world, Random random, int x, int z) {
        // TODO Auto-generated method stub

    }

    public void addOreSpawn(Block block, World world, Random random, int xPos, int zPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {

        for (int i = 0; i < chanceToSpawn; i++) {

            int posX = xPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = zPos + random.nextInt(maxZ);
            (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }
}