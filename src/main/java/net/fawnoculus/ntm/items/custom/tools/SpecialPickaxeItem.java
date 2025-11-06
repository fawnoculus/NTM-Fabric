package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.api.tool.AbilityHandler;
import net.fawnoculus.ntm.api.tool.ModifierHandler;
import net.minecraft.item.ToolMaterial;


public class SpecialPickaxeItem extends SpecialToolItem {
	public SpecialPickaxeItem(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
		this(settings, material, attackDamage, attackSpeed, AbilityHandler.builder().build(), ModifierHandler.builder().build(), false);
	}

	public SpecialPickaxeItem(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed, AbilityHandler abilities, ModifierHandler modifiers, boolean canBreakDepthRock) {
		super(settings.pickaxe(material, attackDamage, attackSpeed), abilities, modifiers, canBreakDepthRock);
	}
}
