package io.brainshells.api.openimagecv.processor.enumeration;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Mask provider interface declaration
 */
@FunctionalInterface
public interface Maskable extends Supplier<List<Pattern>> {
    /**
     * Returns collection of mask {@link Pattern}s
     *
     * @return collection of mask patterns
     */
    List<Pattern> getMask();

    /**
     * Returns collection of mask {@link Pattern}s
     *
     * @return collection of mask patterns
     */
    default List<Pattern> get() {
        return this.getMask();
    }

    /**
     * Returns {@link List} of {@link Pattern} masks
     *
     * @param patterns initial input array of {@link String} patterns
     * @return collection of pattern masks
     */
    static List<Pattern> toPatterns(final String... patterns) {
        return Arrays.stream(patterns)
            .filter(Objects::nonNull)
            .map(String::trim)
            .map(Pattern::compile)
            .collect(Collectors.toList());
    }
}
