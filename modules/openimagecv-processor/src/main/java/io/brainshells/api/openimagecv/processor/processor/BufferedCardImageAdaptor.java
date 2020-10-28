package io.brainshells.api.openimagecv.processor.processor;

import io.brainshells.api.openimagecv.processor.enumeration.CardPattern;
import io.brainshells.api.openimagecv.processor.enumeration.CardRank;
import io.brainshells.api.openimagecv.processor.enumeration.CardSuit;
import io.brainshells.api.openimagecv.processor.enumeration.Maskable;
import io.brainshells.api.openimagecv.processor.model.CardBufferedImage;
import io.brainshells.api.openimagecv.processor.model.Point;

import java.awt.image.BufferedImage;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.brainshells.api.openimagecv.processor.management.CardConstants.CARD_SPACE_FACED_PATTERN;

/**
 * Card image processor implementation that operates on provided {@link BufferedImage}
 * instance with corresponding bounds validation
 */
public class BufferedCardImageAdaptor implements CardImageProcessor {

    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = -3132324057456043186L;

    /**
     * Card {@link BufferedImage} wrapper
     */
    private final CardBufferedImage image;

    /**
     * Buffered card image constructor
     *
     * @param image initial input {@link BufferedImage} instance
     */
    public BufferedCardImageAdaptor(final BufferedImage image) {
        this.image = new CardBufferedImage(image);
    }

    @Override
    public Optional<CardSuit> getCardSuit(final Point startPoint,
                                          final Point endPoint) {
        this.image.validatePoints(startPoint, endPoint);

        final CardPattern[] pattern = this.getCardPattern(startPoint, endPoint);
        return this.getByPattern(CardSuit.VALUES, CardPattern.serialize(pattern));
    }

    @Override
    public Optional<CardRank> getCardRank(final Point startPoint,
                                          final Point endPoint) {
        this.image.validatePoints(startPoint, endPoint);

        final CardPattern[] pattern = this.getCardPattern(startPoint, endPoint);
        return this.getByPattern(CardRank.VALUES, CardPattern.serialize(pattern));
    }

    @Override
    public int getCardsAmount(final Point startPoint,
                              final Point endPoint) {
        this.image.validatePoints(startPoint, endPoint);

        return this.getCardPatterns(startPoint, endPoint)
            .stream()
            .findFirst()
            .map(CardPattern::serialize)
            .map(CARD_SPACE_FACED_PATTERN::split)
            .map(v -> v.length)
            .orElse(0);
    }

    protected CardPattern[] getCardPattern(final Point startPoint,
                                           final Point endPoint) {
        return this.getCardPatterns(startPoint, endPoint)
            .stream()
            .flatMap(Arrays::stream)
            .toArray(CardPattern[]::new);
    }

    protected List<CardPattern[]> getCardPatterns(final Point startPoint,
                                                  final Point endPoint) {
        return IntStream.range(startPoint.getYCoord(), endPoint.getYCoord())
            .mapToObj(i -> IntStream.range(startPoint.getXCoord(), endPoint.getXCoord())
                .mapToObj(j -> this.image.getCardPattern(j, i))
                .toArray(CardPattern[]::new))
            .collect(Collectors.toList());
    }

    protected <E extends Enum<E> & Maskable> Optional<E> getByPattern(final EnumSet<E> patternSet,
                                                                      final String pattern) {
        return patternSet.stream().max(Comparator.comparingLong(p -> countMatches(p.getMask(), pattern)));
    }

    private static long countMatches(final List<Pattern> cardPatterns,
                                     final String pattern) {
        return cardPatterns.stream().filter(p -> p.matcher(pattern).matches()).count();
    }
}
