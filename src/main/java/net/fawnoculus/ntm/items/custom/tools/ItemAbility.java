package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.NTM;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
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

  private final Identifier ID;
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

  // UWU
  public boolean isBottom(){
    return this.IS_BOTTOM;
  }

  public boolean disablesOtherRow(){
    return this.DISABLES_OTHER_ROW;
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

  public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level){
  }

  public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level){
  }
}
