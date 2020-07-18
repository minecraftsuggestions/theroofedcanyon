package io.github.teamhollow.theroofedcanyon.world.biome;

import com.google.common.collect.ImmutableList;

import io.github.teamhollow.theroofedcanyon.init.TRCDecorators;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.RandomFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public final class RoofedCanyonBiome extends Biome {
    public RoofedCanyonBiome() {
        super((new Biome.Settings()).configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
                .precipitation(Biome.Precipitation.RAIN).category(Biome.Category.FOREST).depth(0.1F).scale(0.2F)
                .temperature(0.7F).downfall(0.8F).effects((new BiomeEffects.Builder()).waterColor(4159204)
                        .waterFogColor(329011).fogColor(12638463).moodSound(BiomeMoodSound.CAVE).build())
                .parent(null));
        DefaultBiomeFeatures.addDefaultUndergroundStructures(this);
        DefaultBiomeFeatures.addLandCarvers(this);
        DefaultBiomeFeatures.addDefaultLakes(this);
        DefaultBiomeFeatures.addDungeons(this);
        this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION,
                Feature.RANDOM_SELECTOR.configure(new RandomFeatureConfig(ImmutableList.of(
                        Feature.HUGE_BROWN_MUSHROOM.configure(DefaultBiomeFeatures.HUGE_BROWN_MUSHROOM_CONFIG)
                                .withChance(0.025F),
                        Feature.HUGE_RED_MUSHROOM.configure(DefaultBiomeFeatures.HUGE_RED_MUSHROOM_CONFIG)
                                .withChance(0.05F),
                        Feature.TREE.configure(TRCDecorators.TURFWOOD_TREE_CONFIG).withChance(0.6666667F),
                        Feature.TREE.configure(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).withChance(0.2F),
                        Feature.TREE.configure(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.1F)),
                        Feature.TREE.configure(DefaultBiomeFeatures.OAK_TREE_CONFIG))));
        DefaultBiomeFeatures.addForestFlowers(this);
        DefaultBiomeFeatures.addMineables(this);
        DefaultBiomeFeatures.addDefaultOres(this);
        DefaultBiomeFeatures.addDefaultDisks(this);
        DefaultBiomeFeatures.addDefaultFlowers(this);
        DefaultBiomeFeatures.addForestGrass(this);
        DefaultBiomeFeatures.addDefaultMushrooms(this);
        DefaultBiomeFeatures.addDefaultVegetation(this);
        DefaultBiomeFeatures.addFrozenTopLayer(this);
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(SpawnGroup.MONSTER, new Biome.SpawnEntry(EntityType.SLIME, 100, 4, 4));
    }

    @Environment(EnvType.CLIENT)
    public int getGrassColorAt(double x, double z) {
        int i = super.getGrassColorAt(x, z);
        return (i & 16711422) + 2634762 >> 1;
    }
}