package net.fawnoculus.ntm.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceBE;
import net.fawnoculus.ntm.blocks.entities.RenderTestBE;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
  
  public static final BlockEntityType<AlloyFurnaceBE> ALLOY_FURNACE_BE = register("alloy_furnace", AlloyFurnaceBE::new, ModBlocks.ALLOY_FURNACE);
  public static final BlockEntityType<RenderTestBE> RENDER_TEST_BE = register("render_test", RenderTestBE::new, ModBlocks.RENDER_TEST);
  
  private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
    Identifier id = NTM.id(name);
    return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
  }
  
  public static void initialize() {}
}
