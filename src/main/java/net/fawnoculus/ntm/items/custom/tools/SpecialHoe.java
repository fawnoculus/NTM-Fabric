package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.item.ToolMaterial;


public class SpecialHoe extends SpecialTool {
  public SpecialHoe(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    super(settings.hoe(material, attackDamage, attackSpeed));
  }
}
