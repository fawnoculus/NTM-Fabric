package net.fawnoculus.ntm.api.explosion;

import net.fawnoculus.ntm.NTMConfig;
import org.jetbrains.annotations.Range;

import java.util.ArrayDeque;
import java.util.Deque;

public class NTMExplosionSystem {
    private static final Deque<ExplosionEntry<?, ?>> EXPLOSIONS = new ArrayDeque<>(NTMConfig.MAX_EXPLOSIONS.getValue() / 8);

    public static <E, S> void addExplosion(NTMExplosionType<E, S> type, NTMExplosionData explosionData, final E extraData) {
        if (EXPLOSIONS.size() >= NTMConfig.MAX_EXPLOSIONS.getValue()) {
            return;
        }

        EXPLOSIONS.addLast(new ExplosionEntry<>(type, explosionData, extraData, type.createExplosion(explosionData, extraData)));
    }

    public static void processExplosions(@Range(from = 0, to = Long.MAX_VALUE) long maxNanos) {
        maxNanos = Math.min(maxNanos, NTMConfig.MIN_EXPLOSION_NANOS.getValue());

        final long endNanoTime = System.nanoTime() + maxNanos;
        long currentNanoTime = System.nanoTime();

        while (currentNanoTime < endNanoTime && !EXPLOSIONS.isEmpty()) {
            ExplosionEntry<?, ?> explosionEntry = EXPLOSIONS.peekFirst();
            explosionEntry.processExplosion(endNanoTime - currentNanoTime);

            if (explosionEntry.isDone()) {
                EXPLOSIONS.pollFirst();
            }

            currentNanoTime = System.nanoTime();
        }
    }


    public record ExplosionEntry<E, S>(NTMExplosionType<E, S> type, NTMExplosionData explosionData, E extraData,
                                       S explosionState) {
        void processExplosion(@Range(from = 0, to = Long.MAX_VALUE) long maxNanos) {
            type.processExplosion(maxNanos, explosionData, extraData, explosionState);
        }

        boolean isDone() {
            return type.isDone(explosionData, extraData, explosionState);
        }
    }
}
