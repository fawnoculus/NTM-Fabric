package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.item.ToolMaterial;


public class SpecialSwordItem extends SpecialToolItem {
  public SpecialSwordItem(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    this(settings, material, attackDamage, attackSpeed, AbilityHandler.builder().build(), ModifierHandler.builder().build(), false);
  }
  public SpecialSwordItem(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed, AbilityHandler abilities, ModifierHandler modifiers, boolean canBreakDepthRock) {
    super(settings.sword(material, attackDamage, attackSpeed), abilities, modifiers, canBreakDepthRock);
  }
}
