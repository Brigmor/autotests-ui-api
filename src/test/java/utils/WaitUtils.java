package utils;

import org.awaitility.core.ConditionFactory;

import java.time.Duration;

import static org.awaitility.Awaitility.await;

public class WaitUtils {

    private static final Duration DEFAULT_TIMEOUT = Duration.ofMinutes(2);
    private static final Duration POLL_INTERVAL = Duration.ofSeconds(5);

    public static ConditionFactory buildAwait() {
        return buildAwait(DEFAULT_TIMEOUT);
    }

    public static ConditionFactory buildAwait(Duration timeout) {
        return await()
                .atMost(timeout)
                .pollDelay(Duration.ZERO)
                .pollInterval(POLL_INTERVAL);
    }
}
