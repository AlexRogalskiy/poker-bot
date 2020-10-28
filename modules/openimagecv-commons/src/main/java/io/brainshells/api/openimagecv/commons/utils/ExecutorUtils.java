package io.brainshells.api.openimagecv.commons.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;

import static java.lang.String.format;

@Slf4j
@UtilityClass
public class ExecutorUtils {

    private static final Thread.UncaughtExceptionHandler exceptionHandler = defaultExceptionHandler();
    private static final AtomicLong count = new AtomicLong(0);

    /**
     * Default {@link BiConsumer} completable action operator
     */
    public static final BiConsumer<? super Object, ? super Throwable> DEFAULT_COMPLETABLE_LOG_ACTION = (response, error) -> {
        try {
            if (Objects.nonNull(error)) {
                log.info("Canceled completable future request [response={}, error={}]", response, error.getMessage());
            }
        } catch (RuntimeException e) {
            log.error("Cannot process completable future request", e);
        }
    };

    /**
     * Creates new fail safe {@link ScheduledThreadPoolExecutor}
     *
     * @return new fail safe {@link ScheduledThreadPoolExecutor}
     */
    public static ScheduledThreadPoolExecutor newScheduledExecutor(final int corePoolSize,
                                                                   final String threadPoolPrefix) {
        final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(corePoolSize, newThreadFactory(threadPoolPrefix));
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
        return scheduledThreadPoolExecutor;
    }

    public static ThreadFactory newThreadFactory(final String threadPoolPrefix) {
        return runnable -> {
            final Thread thread = new Thread(runnable);
            thread.setName(format("%s-%d", threadPoolPrefix, count.getAndIncrement()));
            thread.setDaemon(false);
            thread.setUncaughtExceptionHandler(exceptionHandler);
            return thread;
        };
    }

    private static Thread.UncaughtExceptionHandler defaultExceptionHandler() {
        return (t, e) -> log.error("Handler got exception for thread: {}, message: {}", t.getName(), e.getMessage());
    }
}
