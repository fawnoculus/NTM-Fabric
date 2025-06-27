package net.fawnoculus.ntm.blocks.custom.node;

public interface NodeType {
  record Connector() implements NodeType{}
  record Provider(long maxEnergy, long maxTransfer, long Priority) implements NodeType{}
  record Consumer(long maxEnergy, long maxTransfer, long Priority) implements NodeType{}
  record Storge(long maxEnergy, long maxTransfer, long Priority, StorageMode mode) implements NodeType{
    enum StorageMode{
      Provide,
      Consume,
      Share,
      None
    }
  }
}
