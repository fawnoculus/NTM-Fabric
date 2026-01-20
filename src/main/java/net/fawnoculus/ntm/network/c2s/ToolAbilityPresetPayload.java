package net.fawnoculus.ntm.network.c2s;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.tool.AbilityHandler;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record ToolAbilityPresetPayload(AbilityHandler.StackData stackData) implements CustomPacketPayload {
    public static final Identifier TOOL_ABILITY_PRESET_PAYLOAD_ID = NTM.id("tool_ability_preset");
    public static final CustomPacketPayload.Type<ToolAbilityPresetPayload> ID = new CustomPacketPayload.Type<>(TOOL_ABILITY_PRESET_PAYLOAD_ID);

    public static final StreamCodec<RegistryFriendlyByteBuf, ToolAbilityPresetPayload> PACKET_CODEC = StreamCodec.composite(
      AbilityHandler.StackData.PACKET_CODEC, ToolAbilityPresetPayload::stackData,
      ToolAbilityPresetPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}
