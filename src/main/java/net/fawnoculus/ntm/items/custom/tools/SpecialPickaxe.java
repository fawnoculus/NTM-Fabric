package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.item.ToolMaterial;


public class SpecialPickaxe extends SpecialTool {
  public SpecialPickaxe(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    super(settings.pickaxe(material, attackDamage, attackSpeed));
  }
}