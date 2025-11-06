package net.fawnoculus.ntm.api.tool;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Optional;

/**
 * An Empty Interface
 * <p>
 * Everything that implements this is an ItemModifier
 * <p>
 * All modifiers can be found in {@link Modifiers}
 */
public abstract class ItemModifier {
	public static final HashMap<Identifier, ItemModifier> ID_TO_MODIFIER = new HashMap<>();
	private final Identifier ID;

	public ItemModifier(Identifier id) {
		this.ID = id;

		ID_TO_MODIFIER.put(id, this);
	}

	public static Optional<ItemModifier> get(Identifier id) {
		return Optional.ofNullable(ID_TO_MODIFIER.get(id));
	}

	public Identifier getId() {
		return ID;
	}

	public MutableText getFullName(int level) {
		if (level == 0) {
			return getName();
		}
		return getName().append(" ").append(getLevelText(level));
	}

	public MutableText getName() {
		return Text.translatable("tooltip." + getId().getNamespace() + ".modifier." + getId().getPath());
	}

	public MutableText getLevelText(int level) {
		return Text.literal("(" + level + ")");
	}

	public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker, int level) {
	}
}
