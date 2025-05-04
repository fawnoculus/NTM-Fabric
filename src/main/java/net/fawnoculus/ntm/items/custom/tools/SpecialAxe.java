package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.items.ModDataComponentTypes;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;


public class SpecialAxe extends AxeItem {
  public SpecialAxe(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    super(material, attackDamage, attackSpeed, settings.component(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT, -1));
  }
}
