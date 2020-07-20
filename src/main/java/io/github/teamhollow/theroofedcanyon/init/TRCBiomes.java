package io.github.teamhollow.theroofedcanyon.init;

import io.github.teamhollow.theroofedcanyon.TheRoofedCanyon;
import io.github.teamhollow.theroofedcanyon.world.biome.*;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class TRCBiomes {
    public static final Biome ROOFED_CANYON = register("roofed_canyon", new RoofedCanyonBiome());
    public static final Biome ROOFED_CANYON_EDGE = register("roofed_canyon_edge", new RoofedCanyonEdgeBiome());

    public TRCBiomes() {
        OverworldBiomes.addEdgeBiome(ROOFED_CANYON, ROOFED_CANYON_EDGE, 1);
    }

    private static Biome register(String id, Biome biome) {
        return Registry.register(Registry.BIOME, new Identifier(TheRoofedCanyon.MOD_ID, id), biome);
    }
}
