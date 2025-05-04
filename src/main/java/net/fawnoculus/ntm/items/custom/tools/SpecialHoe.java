package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.items.ModDataComponentTypes;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;


public class SpecialHoe extends HoeItem {
  public SpecialHoe(Settings settings, ToolMaterial material, float attackDamage, float attackSpeed) {
    super(material, attackDamage, attackSpeed, settings.component(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT, -1));
  }
}
