package net.fawnoculus.ntm.blocks.custom.node;

import net.fawnoculus.ntm.blocks.custom.node.network.EnergyNetwork;
import net.fawnoculus.ntm.blocks.custom.node.network.NodeNetwork;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class EnergyNode extends BlockEntity implements Node<EnergyNode> {
  public EnergyNode(BlockEntityType<?> type, BlockPos pos, BlockState state) {
    super(type, pos, state);
  }
  
  private EnergyNetwork network;
  private NodeType nodeType = new NodeType.Connector();
  
  @Override
  public void onBlockReplaced(BlockPos pos, BlockState oldState) {
    super.onBlockReplaced(pos, oldState);
  }
  
  @Override
  public EnergyNetwork getNetwork() {
    if(this.network == null){
      this.assignNetwork();
    }
    return this.network;
  }
  
  @Override
  public void setNetwork(NodeNetwork<EnergyNode> network) {
    this.network = (EnergyNetwork) network;
  }
  
  @Override
  public NodeType getNodeType() {
    return nodeType;
  }
  
  public void setNodeType(NodeType nodeType) {
    this.nodeType = nodeType;
  }
  
  @Override
  public void assignNetwork() {
    EnergyNetwork detectedNetwork = this.findAndMergeNetwork(this.getPos().up(), null);
    detectedNetwork = this.findAndMergeNetwork(this.getPos().down(), detectedNetwork);
    detectedNetwork = this.findAndMergeNetwork(this.getPos().north(), detectedNetwork);
    detectedNetwork = this.findAndMergeNetwork(this.getPos().east(), detectedNetwork);
    detectedNetwork = this.findAndMergeNetwork(this.getPos().south(), detectedNetwork);
    detectedNetwork = this.findAndMergeNetwork(this.getPos().west(), detectedNetwork);
    if(detectedNetwork == null){
      detectedNetwork = new EnergyNetwork();
    }
    
    this.setNetwork(detectedNetwork);
  }
  
  private EnergyNetwork findAndMergeNetwork(BlockPos blockPos, @Nullable EnergyNetwork detectedNetwork) {
    assert this.world != null;
    BlockEntity bl = this.world.getBlockEntity(blockPos);
    if (!(bl instanceof EnergyNode node) || node.network == null) {
      return detectedNetwork;
    }
    if(detectedNetwork != null){
      node.getNetwork().mergeWithNetwork(detectedNetwork);
    }
    return node.getNetwork();
  }
}
