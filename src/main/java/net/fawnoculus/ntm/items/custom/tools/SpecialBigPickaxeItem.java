package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.api.tool.AbilityHandler;
import net.fawnoculus.ntm.api.tool.ModifierHandler;
import net.fawnoculus.ntm.misc.tags.NTMBlockTags;
import net.minecraft.world.item.ToolMaterial;


public class SpecialBigPickaxeItem extends SpecialToolItem {
    public SpecialBigPickaxeItem(Properties settings, ToolMaterial material, float attackDamage, float attackSpeed) {
        this(settings, material, attackDamage, attackSpeed, AbilityHandler.builder().build(), ModifierHandler.builder().build(), false);
    }

    public SpecialBigPickaxeItem(Properties settings, ToolMaterial material, float attackDamage, float attackSpeed, AbilityHandler abilities, ModifierHandler modifiers, boolean canBreakDepthRock) {
        super(settings.tool(material, NTMBlockTags.BIG_PICKAXE_MINEABLE, attackDamage, attackSpeed, 0.0F), abilities, modifiers, canBreakDepthRock);
    }
}
