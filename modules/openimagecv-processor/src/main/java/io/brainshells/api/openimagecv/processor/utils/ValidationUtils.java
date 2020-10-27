package io.brainshells.api.openimagecv.processor.utils;

import lombok.experimental.UtilityClass;

import java.util.function.Function;
import java.util.function.IntPredicate;

import static java.lang.String.format;

@UtilityClass
public class ValidationUtils {
    /**
     * Returns {@link Function} operator whether {@link Integer} value is in range between
     * input {@code int} minimum and {@code int} maximum bounds
     *
     * @param minBound          - initial input {@code int} minimum bound
     * @param maxBound          - initial input {@code int} maximum bound
     * @param minBoundInclusive - initial input {@code boolean} min inclusive bound flag
     * @param maxBoundInclusive - initial input {@code boolean} max inclusive bound flag
     * @return {@link Function} operator
     */
    public static IntPredicate checkRange(final int minBound,
                                          final int maxBound,
                                          final boolean minBoundInclusive,
                                          final boolean maxBoundInclusive) {
        return value -> {
            final boolean minBit = (minBoundInclusive) ? value >= minBound : value > minBound;
            final boolean maxBit = (maxBoundInclusive) ? value <= maxBound : value < maxBound;
            return minBit && maxBit;
        };
    }

    /**
     * Validates whether input {@code int} value is in range between
     * input {@code int} minimum and {@code int} maximum bounds (inclusive)
     *
     * @param minBound - initial input {@code int} minimum bound
     * @param maxBound - initial input {@code int} maximum bound
     */
    public static void checkRange(final int value,
                                  final int minBound,
                                  final int maxBound) {
        final boolean flag = checkRange(minBound, maxBound, true, true).test(value);
        checkTrue(flag, format("Point: {%d} should be in range: {%d}-{%d}", value, minBound, maxBound));
    }

    /**
     * Validates that the value is true
     *
     * @param value        - initial input value to check
     * @param errorMessage - initial input message {@link String}
     * @throws IllegalArgumentException if {@code value} is {@code false}
     */
    public static void checkTrue(final boolean value,
                                 final String errorMessage) {
        if (!value) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
