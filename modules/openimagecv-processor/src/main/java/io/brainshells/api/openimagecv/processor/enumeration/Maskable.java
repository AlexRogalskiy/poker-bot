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
    static List<Pattern> toMask(final String... patterns) {
        return toMask("", "", patterns);
    }

    /**
     * Returns {@link List} of {@link Pattern} masks
     *
     * @param prefix   initial input {@link String} prefix
     * @param suffix   initial input {@link String} suffix
     * @param patterns initial input array of {@link String} patterns
     * @return collection of pattern masks
     */
    static List<Pattern> toMask(final String prefix,
                                final String suffix,
                                final String... patterns) {
        return Arrays.stream(patterns)
            .filter(Objects::nonNull)
            .map(String::trim)
            .map(value -> String.join("", prefix, value, suffix))
            .map(Pattern::compile)
            .collect(Collectors.toList());
    }
}
