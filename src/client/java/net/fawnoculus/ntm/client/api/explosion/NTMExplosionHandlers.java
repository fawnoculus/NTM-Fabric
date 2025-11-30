package net.fawnoculus.ntm.client.api.explosion;

import net.fawnoculus.ntm.api.explosion.NTMExplosionTypeRegistry;
import net.fawnoculus.ntm.api.explosion.NTMExplosionTypes;
import net.fawnoculus.ntm.client.api.explosion.handlers.NoneExplosionHandler;
import net.fawnoculus.ntm.client.api.explosion.handlers.SimpleExplosionHandler;
import net.minecraft.util.Unit;

import static net.fawnoculus.ntm.client.api.explosion.NTMExplosionHandlerRegistry.register;

@SuppressWarnings("unused")
public class NTMExplosionHandlers {
    private static final NTMExplosionHandler<Unit> NONE_HANDLER = register(NTMExplosionTypeRegistry.NONE, NoneExplosionHandler::new);
    private static final NTMExplosionHandler<Float> SIMPLE_HANDLER = register(NTMExplosionTypes.SIMPLE, SimpleExplosionHandler::new);

    public static void initialize() {
    }
}
