package net.betongoat.ogpots;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OgPots implements ClientModInitializer {
    public static final String MOD_ID = "ogpots";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("OG Pots loaded, potions are shiny again!");
    }
}
