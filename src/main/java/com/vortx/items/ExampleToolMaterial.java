package com.vortx.items;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ExampleToolMaterial implements ToolMaterial {
	public static final ExampleToolMaterial INSTANCE = new ExampleToolMaterial();

	@Override
	public int getDurability() {
		return -1;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 0;
	}

	@Override
	public float getAttackDamage() {
		return 0;
	}

	@Override
	public int getMiningLevel() {
		return 0;
	}

	@Override
	public int getEnchantability() {
		return 20;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ModItems.EXAMPLE_ITEM);
	}
}
