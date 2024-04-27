package net.exitstudios.lbd;

import net.exitstudios.lbd.block.ModBlocks;
import net.exitstudios.lbd.item.ModItemGroups;
import net.exitstudios.lbd.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LBD implements ModInitializer {

    public static final String MOD_ID = "lbd";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }

}