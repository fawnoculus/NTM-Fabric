package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

/**
 * An Empty Interface
 * <p>
 * Everything that implements this is an ItemModifier
 * <p>
 * All modifiers can be found in {@link Modifiers}
 */
public interface ItemModifier {
  String getTranslationKey();
  String getValue();
  void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker);
}
