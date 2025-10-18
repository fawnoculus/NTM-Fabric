package net.fawnoculus.ntm.items.custom.tools;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.fawnoculus.ntm.NTM;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.*;

/**
 * <br> All Abilities can be found at {@link Abilities}
 */
public abstract class ItemAbility {
  public static final HashMap<Identifier, ItemAbility> ID_TO_ABILITY = new HashMap<>();
  public static final List<ItemAbility> TOP_ABILITIES = new ArrayList<>();
  public static final List<ItemAbility> BOTTOM_ABILITIES = new ArrayList<>();
  public static final Identifier NONE_ID = NTM.id("none");
  public static final ItemAbility NONE = new ItemAbility(NONE_ID, false, false, true){};
  public static final Codec<ItemAbility> CODEC = Identifier.CODEC.flatXmap(
    identifier -> get(identifier).map(DataResult::success).orElse(DataResult.error(() -> "Identifier not Found")),
    ability -> DataResult.success(ability.getId())
  );

  private final Identifier ID;
  private final Identifier ENABLED_TEXTURE;
  private final Identifier DISABLED_TEXTURE;
  private final @Nullable Identifier CROSSHAIR_EXTENSION;
  private final boolean IS_BOTTOM;
  private final boolean DISABLES_OTHER_ROW;

  protected ItemAbility(Identifier id, boolean isBottom){
    this(id, isBottom, false, false);
  }

  protected ItemAbility(Identifier id, boolean isBottom, boolean disablesOtherRow){
    this(id, isBottom, disablesOtherRow, false);
  }

  private ItemAbility(Identifier id, boolean isBottom, boolean disablesOtherRow, boolean isNone){
    this.ID = id;
    this.IS_BOTTOM = isBottom;
    this.DISABLES_OTHER_ROW = disablesOtherRow;
    this.ENABLED_TEXTURE = Identifier.of(id.getNamespace(), "textures/gui/ability/" + id.getPath() + "_enabled.png");
    this.DISABLED_TEXTURE = Identifier.of(id.getNamespace(), "textures/gui/ability/" + id.getPath() + "_disabled.png");

   if(!isBottom && !isNone){
      this.CROSSHAIR_EXTENSION = Identifier.of(id.getNamespace(), "textures/gui/ability/" + id.getPath() + "_crosshair.png");
    }else {
     this.CROSSHAIR_EXTENSION = null;
   }

    ID_TO_ABILITY.put(id, this);

    if(!isBottom || isNone){
      TOP_ABILITIES.add(this);
    }
    if(isBottom || isNone){
      BOTTOM_ABILITIES.add(this);
    }
  }

  public static Optional<ItemAbility> get(Identifier identifier){
    return Optional.ofNullable(ID_TO_ABILITY.get(identifier));
  }

  public Identifier getId(){
    return this.ID;
  }

  public Identifier getEnabledTexture(){
    return this.ENABLED_TEXTURE;
  }

  public Identifier getDisabledTexture(){
    return this.DISABLED_TEXTURE;
  }

  public @Nullable Identifier getCrosshairExtension(){
    return this.CROSSHAIR_EXTENSION;
  }

  // UWU
  public boolean isBottom(){
    return this.IS_BOTTOM;
  }

  public boolean isTop(){
    return !this.IS_BOTTOM;
  }

  public boolean disablesOtherRow(){
    return this.DISABLES_OTHER_ROW;
  }

  public boolean isNone(){
    return Objects.equals(this.ID, NONE_ID);
  }

  public boolean isNotNone(){
    return !Objects.equals(this.ID, NONE_ID);
  }

  public MutableText getFullName(@Range(from = 0, to = 10) int level) {
    if (level == 0) {
      return getName();
    }
    return getName().append(" ").append(getLevelText(level));
  }

  public MutableText getName(){
    return Text.translatable("tooltip." + getId().getNamespace() + ".ability." + getId().getPath());
  }

  public MutableText getLevelText(@Range(from = 0, to = 10) int level){
    return Text.literal("(" + level + ")");
  }

  /**
   * Called for every block broken by this tool, including extra blocks from other abilities
   * @return whether to do regular block drops
   */
  public boolean onBreakBlock(ItemStack stack, World world, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level){
    return !miner.shouldSkipBlockDrops();
  }


  /**
   * Add Extra Blocks to be broken
   */
  public void addExtraBlocks(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level, ArrayList<BlockPos> extraBlocks){
  }

  /**
   * Called before braking any blocks
   */
  public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level){
  }

  @Override
  public String toString() {
    return "ItemAbility{" + ID + '}';
  }
}
