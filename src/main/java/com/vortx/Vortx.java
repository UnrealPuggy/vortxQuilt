package com.vortx;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.vortx.items.ModItems.registerItems;

public class Vortx implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Vortx");
	public static final String MODID = "vortx";

    @Override
    public void onInitialize(ModContainer mod) {
        LOGGER.info("Hello Quilt world from {}! Stay fresh!", mod.metadata().name());
		registerItems();
    }
}
