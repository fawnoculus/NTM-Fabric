package net.fawnoculus.ntm.network.c2s;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.items.custom.tools.AbilityHandler;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

public record ToolAbilityPresetPayload(AbilityHandler.StackData stackData) implements CustomPayload {
  public static final Identifier TOOL_ABILITY_PRESET_PAYLOAD_ID = NTM.id("tool_ability_preset");
  public static final CustomPayload.Id<ToolAbilityPresetPayload> ID = new CustomPayload.Id<>(TOOL_ABILITY_PRESET_PAYLOAD_ID);

  public static PacketCodec<RegistryByteBuf, ToolAbilityPresetPayload> PACKET_CODEC = PacketCodec.tuple(
    AbilityHandler.StackData.PACKET_CODEC, ToolAbilityPresetPayload::stackData,
    ToolAbilityPresetPayload::new
  );

  @Override
  public Id<? extends CustomPayload> getId() {
    return ID;
  }
}
