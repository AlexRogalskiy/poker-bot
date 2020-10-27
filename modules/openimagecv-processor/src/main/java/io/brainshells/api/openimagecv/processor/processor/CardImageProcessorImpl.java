package io.brainshells.api.openimagecv.processor.processor;

import io.brainshells.api.openimagecv.processor.enumeration.CardPattern;
import io.brainshells.api.openimagecv.processor.enumeration.CardRank;
import io.brainshells.api.openimagecv.processor.enumeration.CardSuit;
import io.brainshells.api.openimagecv.processor.enumeration.Maskable;
import io.brainshells.api.openimagecv.processor.model.Point;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.awt.image.BufferedImage;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.brainshells.api.openimagecv.processor.management.CardImageConstants.CARD_SPACE_FACED_PATTERN;
import static io.brainshells.api.openimagecv.processor.utils.ValidationUtils.checkRange;

@Slf4j
@RequiredArgsConstructor
public class CardImageProcessorImpl implements CardImageProcessor {

    private final BufferedImage image;

    @Override
    public Optional<CardSuit> getCardSuit(final Point startPoint,
                                          final Point endPoint) {
        validatePoints(startPoint, endPoint).accept(this.image);

        final CardPattern[] pattern = this.getCardPattern(startPoint, endPoint);
        return this.getByPattern(EnumSet.allOf(CardSuit.class), CardPattern.serialize(pattern));
    }

    @Override
    public Optional<CardRank> getCardRank(final Point startPoint,
                                          final Point endPoint) {
        validatePoints(startPoint, endPoint).accept(this.image);

        final CardPattern[] pattern = this.getCardPattern(startPoint, endPoint);
        return this.getByPattern(EnumSet.allOf(CardRank.class), CardPattern.serialize(pattern));
    }

    @Override
    public int getCardsAmount(final Point startPoint,
                              final Point endPoint) {
        validatePoints(startPoint, endPoint).accept(this.image);

        return this.getCardPatternList(startPoint, endPoint)
            .stream()
            .findFirst()
            .map(CardPattern::serialize)
            .map(CARD_SPACE_FACED_PATTERN::split)
            .map(v -> v.length)
            .orElse(0);
    }

    public CardPattern[] getCardPattern(final Point startPoint,
                                           final Point endPoint) {
        return this.getCardPatternList(startPoint, endPoint)
            .stream()
            .flatMap(Arrays::stream)
            .toArray(CardPattern[]::new);
    }

    protected List<CardPattern[]> getCardPatternList(final Point startPoint,
                                                     final Point endPoint) {
        return IntStream.range(startPoint.getYCoord(), endPoint.getYCoord())
            .mapToObj(i -> IntStream.range(startPoint.getXCoord(), endPoint.getXCoord())
                .map(j -> image.getRGB(j, i))
                .mapToObj(CardPattern::fromColor)
                .toArray(CardPattern[]::new))
            .collect(Collectors.toList());
    }

    protected <E extends Enum<E> & Maskable<List<Pattern>>> Optional<E> getByPattern(final EnumSet<E> patternSet,
                                                                                     final String pattern) {
        return patternSet.stream().max(Comparator.comparingLong(v -> countMatches(v.getMask(), pattern)));
    }

    private static long countMatches(final List<Pattern> cardPatterns,
                                     final String pattern) {
        return cardPatterns.stream().filter(p -> p.matcher(pattern).matches()).count();
    }

    private static Consumer<BufferedImage> validatePoints(final Point... points) {
        return image -> Arrays.stream(points).forEach(p -> {
            checkRange(p.getXCoord(), 0, image.getWidth());
            checkRange(p.getYCoord(), 0, image.getHeight());
        });
    }
}
