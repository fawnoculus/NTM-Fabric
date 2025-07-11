package net.fawnoculus.ntm.items.custom.tools;


import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.items.ModDataComponentTypes;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.network.custom.AdvancedMessageS2CPayload;
import net.fawnoculus.ntm.misc.messages.AdvancedMessage;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;

public interface SpecialTool {
  Identifier ADVANCED_MESSAGE_ID = NTM.id("tool_ability");
  
  SpecialTool addAbility(ItemAbility ability);
  SpecialTool addModifier(ItemModifier modifier);
  SpecialTool addCanBreakDepthRock();
  
  List<ItemAbility> getAbilities();
  List<ItemModifier> getModifiers();
  boolean canBreakDepthRock();
  
  default void processMakerModifiers(ItemStack stack, LivingEntity target, LivingEntity attacker) {
    for (ItemModifier modifier : getModifiers()){
      modifier.postHit(stack, target, attacker);
    }
  }
  
  default void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner){
    if(world.isClient()){
      return;
    }
    if(!(miner instanceof PlayerEntity player)){
      return;
    }
    
    ItemAbility ability = getSelectedAbility(stack);
    if(ability != null){
      ability.preMine(stack, world, state, pos, player);
    }
  }
  
  default ItemAbility getSelectedAbility(ItemStack stack){
    int selectedAbility = stack.getOrDefault(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT_TYPE, -1);
    if(selectedAbility < 0){return null;}
    return this.getAbilities().get(selectedAbility);
  }
  
  default void cycleAbility(ItemStack stack, ServerPlayerEntity player) {
    List<ItemAbility> abilities = getAbilities();
    int AbilityAmount = abilities.size();
    if (abilities.isEmpty()) {
      return;
    }
    
    int NewAbilityIndex = stack.getOrDefault(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT_TYPE, -1);
    NewAbilityIndex++;
    
    if (NewAbilityIndex >= AbilityAmount || player.isSneaking() || NewAbilityIndex < -1) {
      // Ability Unselected
      stack.set(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT_TYPE, -1);
      stack.remove(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE);
      player.playSoundToPlayer(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.25f, 0.75f);
      
      ServerPlayNetworking.send(player, new AdvancedMessageS2CPayload(new AdvancedMessage(
          ADVANCED_MESSAGE_ID,
          Text.translatable("message.ntm.ability.unselect").formatted(Formatting.GOLD),
          1000.0f)));
    } else {
      // Ability switched
      stack.set(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT_TYPE, NewAbilityIndex);
      stack.set(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true);
      player.playSoundToPlayer(SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 0.25f, 1.25f);
      
      ServerPlayNetworking.send(player, new AdvancedMessageS2CPayload(new AdvancedMessage(
          ADVANCED_MESSAGE_ID,
          Text.translatable("message.ntm.ability.select", getSelectedAbility(stack).getFullName()).formatted(Formatting.YELLOW),
          1000.0f)));
    }
  }
  
  default void processTooltip(ItemStack stack, Consumer<Text> tooltip) {
    List<ItemAbility> abilities = getAbilities();
    List<ItemModifier> modifiers = getModifiers();
    
    if(!abilities.isEmpty()) {
      tooltip.accept(Text.translatable("tooltip.ntm.ability.start").formatted(Formatting.GRAY));
      for (int i = 0; i < abilities.size(); i++) {
        ItemAbility ability = abilities.get(i);
        
        MutableText prefix = Text.literal("  ");
        if (i == stack.getOrDefault(ModDataComponentTypes.SELECTED_ABILITY_COMPONENT_TYPE, -1)) {
          prefix = Text.literal(" >").formatted(Formatting.GRAY);
        }
        
        tooltip.accept(prefix.append(ability.getFullName().formatted(Formatting.GOLD)));
      }
      tooltip.accept(Text.translatable("tooltip.ntm.ability.end1").formatted(Formatting.GRAY));
      tooltip.accept(Text.translatable("tooltip.ntm.ability.end2").formatted(Formatting.GRAY));
    }
    
    if(!modifiers.isEmpty()) {
      tooltip.accept(Text.translatable("tooltip.ntm.modifier.start").formatted(Formatting.GRAY));
      for (ItemModifier modifier : modifiers) {
        tooltip.accept(Text.literal("  ").append(modifier.getFullName().formatted(Formatting.RED)));
      }
    }
    
    if(canBreakDepthRock()) {
      tooltip.accept(Text.of(""));
      tooltip.accept(Text.translatable("tooltip.ntm.canbreakdepthrock").formatted(Formatting.RED));
    }
  }
}
