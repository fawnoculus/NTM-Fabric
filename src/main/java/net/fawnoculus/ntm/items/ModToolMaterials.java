package net.fawnoculus.ntm.items;

import net.fawnoculus.ntm.util.ModItemTags;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;

public class ModToolMaterials {
  public static final ToolMaterial STEEL_TOOL_MATERIAL = new ToolMaterial(
      BlockTags.INCORRECT_FOR_IRON_TOOL,
      500,
      7.5f,
      2.0f,
      10,
      ModItemTags.STEEL_TOOL_MATERIALS
  );
  
  public static void initialize(){}
}
