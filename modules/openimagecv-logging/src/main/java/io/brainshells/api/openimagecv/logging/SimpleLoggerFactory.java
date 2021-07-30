package io.brainshells.api.openimagecv.logging;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

/**
 * An implementation of {@link ILoggerFactory} which always returns {@link
 * SimpleLogger} instances.
 *
 * @author Ceki G&uuml;lc&uuml;
 */
public class SimpleLoggerFactory implements ILoggerFactory {

    final ConcurrentMap<String, Logger> loggerMap;

    public SimpleLoggerFactory() {
        this.loggerMap = new ConcurrentHashMap<>();
        SimpleLogger.lazyInit();
    }

    /**
     * Return an appropriate {@link SimpleLogger} instance by name.
     */
    @Override
    public Logger getLogger(String name) {
        Logger simpleLogger = loggerMap.get(name);
        if (simpleLogger != null) {
            return simpleLogger;
        } else {
            final Logger newInstance = new SimpleLogger(name);
            final Logger oldInstance = this.loggerMap.putIfAbsent(name, newInstance);

            return oldInstance == null ? newInstance : oldInstance;
        }
    }

    /**
     * Clear the internal impl cache.
     * <p>
     * This method is intended to be called by classes (in the same package)
     * for testing purposes. This method is internal. It can be modified,
     * renamed or removed at any time without notice.
     * <p>
     * You are strongly discouraged from calling this method in production
     * code.
     */
    void reset() {
        this.loggerMap.clear();
    }
}
