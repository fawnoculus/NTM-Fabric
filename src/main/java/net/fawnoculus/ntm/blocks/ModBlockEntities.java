package net.fawnoculus.ntm.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceBE;
import net.fawnoculus.ntm.blocks.entities.SimpleEnergyConnectorBE;
import net.fawnoculus.ntm.blocks.entities.SimpleEnergyStorageBE;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
  
  public static final BlockEntityType<AlloyFurnaceBE> ALLOY_FURNACE_BE = register("alloy_furnace", AlloyFurnaceBE::new, ModBlocks.ALLOY_FURNACE);
  public static final BlockEntityType<SimpleEnergyConnectorBE> SIMPLE_ENERGY_CONNECTOR_BE = register("simple_energy_connector", SimpleEnergyConnectorBE::new, ModBlocks.TEMP_CABLE);
  public static final BlockEntityType<SimpleEnergyStorageBE> SIMPLE_ENERGY_STORAGE_BE = register("simple_energy_storage", SimpleEnergyStorageBE::new,
      ModBlocks.POTATO_BATTERY_BLOCK,
      ModBlocks.ENERGY_STORAGE_BLOCK,
      ModBlocks.LITHIUM_ION_ENERGY_STORAGE_BLOCK,
      ModBlocks.SCHRABIDIUM_ENERGY_STORAGE_BLOCK,
      ModBlocks.SPARK_ENERGY_STORAGE_BLOCK
  );
  
  private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
    Identifier id = NTM.id(name);
    return Registry.register(Registries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
  }
  
  public static void initialize() {}
}
