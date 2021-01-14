package io.brainshells.api.openimagecv.processor.enumeration;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CardPattern implements Predicate<CardPattern> {
    WHITE("W"),
    BLACK("B");

    /**
     * Card pattern
     */
    private final String value;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean test(final CardPattern pattern) {
        return Objects.equals(this, pattern);
    }

    /**
     * Returns deserialized array of {@link CardPattern}s from input pattern
     *
     * @param pattern - initial input {@link String} to deserialize
     * @return array of card patterns
     */
    public static CardPattern[] deserialize(final String pattern) {
        return Arrays.stream(pattern.split(""))
            .map(CardPattern::fromCode)
            .toArray(CardPattern[]::new);
    }

    /**
     * Returns serialized {@link String}s from input array of {@link CardPattern}s
     *
     * @param patterns - initial input array of {@link CardPattern} to serialize
     * @return serialized card pattern string
     */
    public static String serialize(final CardPattern... patterns) {
        return Arrays.stream(patterns)
            .map(CardPattern::getValue)
            .collect(Collectors.joining());
    }

    /**
     * Returns {@link CardPattern} by input {@link String} code
     *
     * @param code - initial input {@link String} code
     * @return card pattern
     */
    public static CardPattern fromCode(final String code) {
        return Arrays.stream(values())
            .filter(type -> type.getValue().equals(code))
            .findFirst()
            .orElse(null);
    }

    /**
     * Returns {@link CardPattern} by input {@code int} color
     *
     * @param color initial input {@code int} color to convert
     * @return card pattern
     */
    public static CardPattern fromColor(final int color) {
        final int red = (color >> 16) & 0xFF;
        final int green = (color >> 8) & 0xFF;
        final int blue = color & 0xFF;

        return (blue >= 120 && green >= 120 && red >= 120) ? WHITE : BLACK;
    }
}
