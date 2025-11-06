package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.api.tool.AbilityHandler;
import net.fawnoculus.ntm.api.tool.ModifierHandler;
import net.fawnoculus.ntm.misc.tags.NTMBlockTags;
import net.minecraft.item.ToolMaterial;


public class SpecialBigAxeItem extends SpecialToolItem {
	public SpecialBigAxeItem(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
		this(settings, material, attackDamage, attackSpeed, AbilityHandler.builder().build(), ModifierHandler.builder().build(), false);
	}

	public SpecialBigAxeItem(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed, AbilityHandler abilities, ModifierHandler modifiers, boolean canBreakDepthRock) {
		super(settings.tool(material, NTMBlockTags.BIG_AXE_MINEABLE, attackDamage, attackSpeed, 5.0F), abilities, modifiers, canBreakDepthRock);
	}
}
