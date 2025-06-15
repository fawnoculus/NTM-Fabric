package net.fawnoculus.ntm.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.ModBlockProperties;
import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceBE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;


public class AlloyFurnaceBlock extends BlockWithEntity {
  public AlloyFurnaceBlock(Settings settings) {
    super(settings);
    setDefaultState(this.getDefaultState()
        .with(LIT, false)
        .with(EXTENSION, false)
        .with(FACING, Direction.NORTH));
  }
  public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
  public static final BooleanProperty LIT = Properties.LIT;
  public static final BooleanProperty EXTENSION = ModBlockProperties.EXTENTION;
  
  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    return createCodec(AlloyFurnaceBlock::new);
  }
  
  @Override
  public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new AlloyFurnaceBE(pos, state);
  }
  
  @Override
  protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
    if(state.getBlock() == this || !(world.getBlockEntity(pos) instanceof AlloyFurnaceBE alloyFurnaceBE)) {
      super.onStateReplaced(state, world, pos, moved);
      return;
    }
    ItemScatterer.spawn(world, pos, alloyFurnaceBE.getInventory());
    world.updateComparators(pos, this);
  }
  
  @Override
  public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
    if(world.isClient) return null;
    return validateTicker(type, ModBlockEntities.AlloyFurnaceBE, AlloyFurnaceBE::tick);
  }
  
  @Override
  protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
    if (!(world.getBlockEntity(pos) instanceof AlloyFurnaceBE alloyFurnaceBE)) {
      return ActionResult.FAIL;
    }
    if(world.isClient){
      return ActionResult.SUCCESS;
    }
    
    player.openHandledScreen(alloyFurnaceBE);
    
    return ActionResult.SUCCESS_SERVER;
  }
  
  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(FACING);
    builder.add(LIT);
    builder.add(EXTENSION);
  }
  
  @Override
  public BlockState getPlacementState(ItemPlacementContext context) {
    PlayerEntity player = Objects.requireNonNull(context.getPlayer());
    if(context.getWorld().getBlockState(context.getBlockPos().up()).getBlock() instanceof AlloyFurnaceExtensionBlock){
      return this.getDefaultState()
          .with(FACING, player.getHorizontalFacing().getOpposite())
          .with(EXTENSION, true);
    }
    return this.getDefaultState().with(FACING, player.getHorizontalFacing().getOpposite());
  }
  
  @Override
  public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
    // TODO: Particles & Sounds in here
    if(world.getBlockState(pos).get(AlloyFurnaceBlock.LIT)){
      
    }
  }
}
