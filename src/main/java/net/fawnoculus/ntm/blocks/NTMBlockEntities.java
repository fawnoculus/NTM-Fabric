package net.fawnoculus.ntm.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceBE;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceExtensionBE;
import net.fawnoculus.ntm.blocks.entities.ElectricFurnaceBE;
import net.fawnoculus.ntm.blocks.entities.container.energy.EnergyConnectorBE;
import net.fawnoculus.ntm.blocks.entities.container.energy.SimpleEnergyStorageBE;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class NTMBlockEntities {

  public static final BlockEntityType<AlloyFurnaceBE> ALLOY_FURNACE_BE = register("alloy_furnace", AlloyFurnaceBE::new, NTMBlocks.ALLOY_FURNACE);
  public static final BlockEntityType<AlloyFurnaceExtensionBE> ALLOY_FURNACE_EXTENSION_BE = register("alloy_furnace_extension", AlloyFurnaceExtensionBE::new, NTMBlocks.ALLOY_FURNACE_EXTENSION);
  public static final BlockEntityType<ElectricFurnaceBE> ELECTRIC_FURNACE_BE = register("electric_furnace", ElectricFurnaceBE::new, NTMBlocks.ELECTRIC_FURNACE);
  public static final BlockEntityType<EnergyConnectorBE> SIMPLE_ENERGY_CONNECTOR_BE = register("simple_energy_connector", EnergyConnectorBE::new, NTMBlocks.TEMP_CABLE);
  public static final BlockEntityType<SimpleEnergyStorageBE> SIMPLE_ENERGY_STORAGE_BE = register("simple_energy_storage", SimpleEnergyStorageBE::new,
    NTMBlocks.POTATO_BATTERY_BLOCK,
    NTMBlocks.ENERGY_STORAGE_BLOCK,
    NTMBlocks.LITHIUM_ION_ENERGY_STORAGE_BLOCK,
    NTMBlocks.SCHRABIDIUM_ENERGY_STORAGE_BLOCK,
    NTMBlocks.SPARK_ENERGY_STORAGE_BLOCK
  );

  private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
    return Registry.register(
      Registries.BLOCK_ENTITY_TYPE,
      NTM.id(name),
      FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build()
    );
  }

  public static void initialize() {
  }
}
