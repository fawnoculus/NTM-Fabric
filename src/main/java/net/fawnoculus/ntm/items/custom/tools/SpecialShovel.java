package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.item.ToolMaterial;


public class SpecialShovel extends SpecialTool {
  public SpecialShovel(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    super(settings.shovel(material, attackDamage, attackSpeed));
  }
}
