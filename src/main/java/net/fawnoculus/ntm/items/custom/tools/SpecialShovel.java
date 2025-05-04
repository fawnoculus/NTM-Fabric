package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.items.ModDataComponentTypes;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;


public class SpecialShovel extends ShovelItem {
  public SpecialShovel(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    super(material, attackDamage, attackSpeed, settings.component(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT, -1));
  }
}
