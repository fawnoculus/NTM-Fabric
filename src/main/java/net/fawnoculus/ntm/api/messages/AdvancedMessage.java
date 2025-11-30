package net.fawnoculus.ntm.api.messages;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.Objects;

public class AdvancedMessage {
    public static final PacketCodec<ByteBuf, AdvancedMessage> PACKET_CODEC = new PacketCodec<>() {
        @Override
        public AdvancedMessage decode(ByteBuf byteBuf) {
            return AdvancedMessage.decode(Objects.requireNonNull(RegistryByteBuf.readNbt(byteBuf)));
        }

        @Override
        public void encode(ByteBuf byteBuf, AdvancedMessage message) {
            RegistryByteBuf.writeNbt(byteBuf, AdvancedMessage.encode(message));
        }
    };
    private static final float BLEND_TIME = 500.0f;
    private final Identifier IDENTIFIER;
    private final Text TEXT;
    private float millisLeft;

    /**
     * @param identifier    Identifier of the Message (can override other messages if the Identifier is the same)
     * @param text          Text to be displayed
     * @param millisSeconds Amount of Milliseconds the Message should be displayed for;
     */
    public AdvancedMessage(Identifier identifier, Text text, float millisSeconds) {
        if (text.getStyle().getColor() == null) {
            text = text.copy().formatted(Formatting.WHITE);
        }
        this.IDENTIFIER = identifier;
        this.TEXT = text;
        this.millisLeft = millisSeconds;
    }

    public static NbtCompound encode(AdvancedMessage message) {
        NbtCompound nbt = new NbtCompound();
        nbt.put("identifier", Identifier.CODEC, message.IDENTIFIER);
        nbt.put("millis_left", Codec.FLOAT, message.millisLeft);
        nbt.put("text", TextCodecs.CODEC, message.TEXT);
        return nbt;
    }

    public static AdvancedMessage decode(NbtCompound nbt) {
        Identifier identifier = nbt.get("identifier", Identifier.CODEC).orElseThrow();
        float millisLeft = nbt.get("millis_left", Codec.FLOAT).orElseThrow();
        Text text = nbt.get("text", TextCodecs.CODEC).orElseThrow();
        return new AdvancedMessage(identifier, text, millisLeft);
    }

    public Identifier getID() {
        return IDENTIFIER;
    }

    public Text getText() {
        return this.TEXT;
    }

    public float getMillisLeft() {
        return this.millisLeft;
    }

    public void setMillisLeft(float millisLeft) {
        this.millisLeft = millisLeft;
    }

    public int getOpacity() {
        if (this.millisLeft > BLEND_TIME) return 255;
        return (int) Math.clamp(this.millisLeft / BLEND_TIME * 255, 0, 255);
    }
}
