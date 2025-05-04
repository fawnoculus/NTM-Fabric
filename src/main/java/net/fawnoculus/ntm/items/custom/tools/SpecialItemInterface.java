package net.fawnoculus.ntm.items.custom.tools;

import java.util.ArrayList;
import java.util.List;

public interface SpecialItemInterface {
  
  boolean canBreakDepthRock = false;
  List<ItemAbility> abilities = new ArrayList<>();
  List<ItemModifier> modifiers = new ArrayList<>();
  
  SpecialItemInterface addAbility(ItemAbility ability);
  SpecialItemInterface addModifier(ItemModifier modifier);
}
