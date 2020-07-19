package io.github.teamhollow.theroofedcanyon;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.teamhollow.theroofedcanyon.init.*;

public class TheRoofedCanyon implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "theroofedcanyon";
    public static final String MOD_NAME = "The Roofed Canyon";

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
        new Identifier(MOD_ID, "item_group"),
        () -> new ItemStack(TRCBlocks.TURFWOOD.LOG)
    );

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");

        new TRCItems();
        new TRCBlocks();

        new TRCDecorators();
        new TRCBiomes();

        TRCParticleTypes.registerFactories();

        log(Level.INFO, "Initialized");
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }
}
