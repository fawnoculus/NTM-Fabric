package net.fawnoculus.ntm.client.api.explosion;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.api.explosion.NTMExplosionType;
import net.fawnoculus.ntm.api.explosion.NTMExplosionTypeRegistry;
import net.fawnoculus.ntm.network.s2c.NTMExplosionPayload;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

@ApiStatus.NonExtendable
public class NTMExplosionHandlerRegistry {
    private static final HashMap<Identifier, NTMExplosionHandler<?>> EXPLOSION_IDENTIFIERS = new HashMap<>();

    public static <T> NTMExplosionHandler<T> register(NTMExplosionType<T> type, Function<NTMExplosionType<T>, NTMExplosionHandler<T>> handlerFactory) {
        return register(type, handlerFactory.apply(type));
    }

    public static <T> NTMExplosionHandler<T> register(NTMExplosionType<T> type, NTMExplosionHandler<T> handler) {
        EXPLOSION_IDENTIFIERS.put(NTMExplosionTypeRegistry.idFromType(type), handler);
        return handler;
    }

    @SuppressWarnings("unchecked")
    public static <T> Optional<NTMExplosionHandler<T>> get(NTMExplosionType<T> type) {
        NTMExplosionHandler<?> handler = EXPLOSION_IDENTIFIERS.get(NTMExplosionTypeRegistry.idFromType(type));
        try {
            // I fucking hate this, why does instanceof not work with generics
            return Optional.ofNullable((NTMExplosionHandler<T>) handler);
        } catch (ClassCastException | NullPointerException ignored) {
            return Optional.empty();
        }
    }


    public static <T> void handleExplosionPacket(NTMExplosionPayload<T> payload, @NotNull ClientPlayNetworking.Context context) {
        get(payload.explosionType()).ifPresent(handler -> handler.onExplosion(context, payload.pos(), payload.extraData()));
    }
}
