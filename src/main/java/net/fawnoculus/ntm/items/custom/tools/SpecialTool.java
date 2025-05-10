package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.items.ModDataComponentTypes;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.*;
import java.util.function.Consumer;

public class SpecialTool extends Item implements SpecialItemInterface {
  public SpecialTool(Settings settings) {
    super(settings.component(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT, -1));
  }
  
  public final boolean canBreakDepthRock = false;
  public final List<ItemAbility> abilities = new ArrayList<>();
  public final List<ItemModifier> modifiers = new ArrayList<>();
  
  public SpecialTool addAbility(ItemAbility ability) {
    abilities.add(ability);
    return this;
  }
  
  public SpecialTool addModifier(ItemModifier modifier) {
    modifiers.add(modifier);
    return this;
  }
  
  public ItemAbility getSelectedAbility(ItemStack stack) {
    int selectedAbility = stack.getOrDefault(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT, -1);
    if(selectedAbility < 0){return null;}
    return this.abilities.get(selectedAbility);
  }
  
  @Override
  public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
    if(world.isClient()){
      return super.postMine(stack, world, state, pos, miner);
    }
    getSelectedAbility(stack).postMine(stack, world, state, pos, miner);
    
    return super.postMine(stack, world, state, pos, miner);
  }
  
  @Override
  public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    for (ItemModifier modifier :modifiers){
      modifier.postHit(stack, target, attacker);
    }
    super.postHit(stack, target, attacker);
  }
  
  @Override
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    
    if(!abilities.isEmpty()) {
      tooltip.accept(Text.translatable("tooltip.ntm.ability.start").formatted(Formatting.GRAY));
      for (int i = 0; i < abilities.size(); i++) {
        ItemAbility ability = abilities.get(i);
        
        MutableText prefix = Text.literal("  ");
        if (i == stack.getOrDefault(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT, -1)) {
          prefix = Text.literal(" >").formatted(Formatting.GRAY);
        }
        
        String translationKey = ability.getTranslationKey();
        String value = ability.getValue();
        if (value != null) {
          tooltip.accept(prefix.append(Text.translatable(translationKey, value).formatted(Formatting.GOLD)));
        } else {
          tooltip.accept(prefix.append(Text.translatable(translationKey).formatted(Formatting.GOLD)));
        }
      }
      tooltip.accept(Text.translatable("tooltip.ntm.ability.end1").formatted(Formatting.GRAY));
      tooltip.accept(Text.translatable("tooltip.ntm.ability.end2").formatted(Formatting.GRAY));
    }
    
    if(!modifiers.isEmpty()) {
      tooltip.accept(Text.translatable("tooltip.ntm.modifier.start").formatted(Formatting.GRAY));
      for (ItemModifier modifier : modifiers) {
        MutableText prefix = Text.literal("  ");
        
        String translationKey = modifier.getTranslationKey();
        String value = modifier.getValue();
        if (value != null){
          tooltip.accept(prefix.append(Text.translatable(translationKey, value).formatted(Formatting.RED)));
        }else {
          tooltip.accept(prefix.append(Text.translatable(translationKey).formatted(Formatting.RED)));
        }
      }
    }
    
    if (this.canBreakDepthRock){
      tooltip.accept(Text.of(""));
      tooltip.accept(Text.translatable("tooltip.ntm.canbreakdepthrock").formatted(Formatting.RED));
    }
  }
  
  @Override
  public ActionResult use(World world, PlayerEntity player, Hand hand) {
    if (world.isClient()) {
      return super.use(world, player, hand);
    }
    
    cycleAbility(player.getStackInHand(hand), player);
    
    return super.use(world, player, hand);
  }
  
  public void cycleAbility(ItemStack stack, PlayerEntity player) {
    int AbilityAmount = abilities.size();
    if (abilities.isEmpty()) {
      return;
    }
    
    int PreviousAbility = stack.getOrDefault(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT, -1);
    
    int NewAbility = (PreviousAbility + 1) % (AbilityAmount+1);
    if (NewAbility >= AbilityAmount || player.isSneaking()) {
      // Ability Unselected
      stack.set(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT, -1);
      player.playSoundToPlayer(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.25f, 0.75f);
      
      player.sendMessage(Text.translatable("info.ntm.ability.unselect").formatted(Formatting.GOLD), true);
    } else {
      // Ability switched
      stack.set(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT, NewAbility);
      player.playSoundToPlayer(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.25f, 1.25f);
      
      String translationKey = getSelectedAbility(stack).getTranslationKey();
      String value = getSelectedAbility(stack).getValue();
      if (value != null){
        player.sendMessage(Text.translatable("info.ntm.ability.select", Text.translatable(translationKey, value)).formatted(Formatting.YELLOW), true);
      }else {
        player.sendMessage(Text.translatable("info.ntm.ability.select", Text.translatable(translationKey)).formatted(Formatting.YELLOW), true);
      }
    }
    
  }
}