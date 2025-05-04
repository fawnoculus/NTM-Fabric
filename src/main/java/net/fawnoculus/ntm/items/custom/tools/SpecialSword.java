package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.item.ToolMaterial;



public class SpecialSword extends SpecialTool {
  public SpecialSword(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    super(settings.sword(material, attackDamage, attackSpeed));
  }
}
