package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

/**
 * An Empty Interface
 * <p>
 * Everything that implements this is an ItemModifier
 * <p>
 * All modifiers can be found in {@link Modifiers}
 */
public interface ItemModifier {
  default MutableText getFullName() {
    if (this.getValue() != null) {
      return Text.translatable(this.getTranslationKey()).append(Text.literal(" (" + this.getValue() + ")"));
    }
    return Text.translatable(this.getTranslationKey());
  }

  String getTranslationKey();

  @Nullable String getValue();

  void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker);
}
