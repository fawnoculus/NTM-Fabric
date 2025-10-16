package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.Consumer;

public record ModifierHandler(HashMap<Identifier, @NotNull Integer> modifiers) {
  public static Builder builder(){
    return new Builder();
  }

  public void appendTooltip(Consumer<Text> tooltip) {
    if (!modifiers.isEmpty()) {
      tooltip.accept(Text.translatable("tooltip.ntm.modifier.start").formatted(Formatting.GRAY));
      for (Identifier key : modifiers.keySet()) {
        Optional<ItemModifier> modifier = ItemModifier.get(key);
        if(modifier.isEmpty()) continue;

        tooltip.accept(Text.literal("  ").append(modifier.get().getFullName(modifiers.get(key)).formatted(Formatting.RED)));
      }
    }
  }

  public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
    for (Identifier key : modifiers.keySet()) {
      Optional<ItemModifier> modifier = ItemModifier.get(key);
      if(modifier.isEmpty()) continue;

      modifier.get().postHit(stack, target, attacker, modifiers.get(key));
    }
  }

  public static class Builder {
    private final HashMap<Identifier, @NotNull Integer> modifiers = new HashMap<>();

    /**
     * Use this one if the Modifier doesn't support levels
     * @param modifier The Modifier to add
     */
    public Builder addModifier(ItemModifier modifier) {
      modifiers.put(modifier.getId(), 0);
      return this;
    }

    /**
     * Use this one if the Modifier supports levels
     * @param modifier The Modifier to add
     * @param level the level of the modifier
     */
    public Builder addModifier(ItemModifier modifier, int level) {
      modifiers.put(modifier.getId(), level);
      return this;
    }

    public ModifierHandler build() {
      return new ModifierHandler(modifiers);
    }
  }
}
