package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.items.ModDataComponentTypes;
import net.minecraft.item.ToolMaterial;


public class SpecialAxe extends SpecialTool {
  public SpecialAxe(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    super(settings.component(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT, -1).axe(material, attackDamage, attackSpeed));
  }
}
