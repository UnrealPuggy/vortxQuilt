package com.vortx.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.vortx.Vortx.*;

public class ModItems {


	public static final Item EXAMPLE_ITEM = registerItem("example_item",new Item(new QuiltItemSettings()));
	public static final Item EXAMPLE_SWORD = registerItem("example_sword",new ExampleSword(ExampleToolMaterial.INSTANCE,10,10,new QuiltItemSettings().maxCount(64)));

	public static final ItemGroup.Builder ITEM_GROUP = FabricItemGroup.builder()
		.icon(() -> new ItemStack(EXAMPLE_ITEM))
		.name(Text.translatable("itemGroup.vortx.vortx_group"))
		.entries((context,entries) -> {
			entries.addItem(EXAMPLE_ITEM);
			entries.addItem(EXAMPLE_SWORD);
		});



	public static void registerItems() {

		Registry.register(Registries.ITEM_GROUP, new Identifier(MODID, MODID), ITEM_GROUP.build());
		LOGGER.info("Registering Items");

	}
	private static Item registerItem(String name,Item item) {
		Item returnItem = Registry.register(Registries.ITEM, new Identifier(MODID,name), item);


		return returnItem;


	}


}
