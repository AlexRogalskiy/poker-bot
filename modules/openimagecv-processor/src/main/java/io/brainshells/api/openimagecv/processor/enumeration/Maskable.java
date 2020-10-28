package io.brainshells.api.openimagecv.processor.enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Mask interface declaration
 *
 * @param <T> type of configurable mask
 */
@FunctionalInterface
public interface Maskable<T> {
    /**
     * Returns {@link T} mask pattern
     *
     * @return {@link T} mask pattern
     */
    T getMask();

    /**
     * Returns {@link List} of {@link Pattern} masks
     *
     * @param patterns initial input array of {@link String} patterns
     * @return collection of pattern masks
     */
    static List<Pattern> toPatternMask(final String... patterns) {
        return Arrays.stream(patterns)
            .filter(Objects::nonNull)
            .map(String::trim)
            .map(Pattern::compile)
            .collect(Collectors.toList());
    }
}
