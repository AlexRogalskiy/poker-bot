package io.brainshells.api.openimagecv.processor.management;

import io.brainshells.api.openimagecv.processor.enumeration.CardRank;
import io.brainshells.api.openimagecv.processor.enumeration.CardSuit;
import io.brainshells.api.openimagecv.processor.exception.UnresolvableCardRankException;
import io.brainshells.api.openimagecv.processor.exception.UnresolvableCardSuitException;
import io.brainshells.api.openimagecv.processor.model.Card;
import io.brainshells.api.openimagecv.processor.model.Point;
import io.brainshells.api.openimagecv.processor.model.Range;
import io.brainshells.api.openimagecv.processor.processor.CardImageProcessor;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.brainshells.api.openimagecv.processor.management.CardImageConstants.*;
import static io.brainshells.api.openimagecv.processor.utils.ValidationUtils.checkTrue;

public class CardManager implements Serializable {

    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = 6296737415157581021L;

    /**
     * {@link CardImageProcessor} instance
     */
    private final CardImageProcessor cardImageProcessor;

    /**
     * Card manager constructor with input {@link CardImageProcessor}
     *
     * @param cardImageProcessor initial input {@link CardImageProcessor} to operate by
     */
    public CardManager(final CardImageProcessor cardImageProcessor) {
        checkTrue(Objects.nonNull(cardImageProcessor), "Card image processor should not be null");

        this.cardImageProcessor = cardImageProcessor;
    }

    /**
     * Returns {@link List} collection of available {@link Card}s by input parameters
     *
     * @param rankRange initial input rank {@link Range}
     * @param suitRange initial input suit {@link Range}
     * @return collection of cards
     */
    public List<Card> getCards(final Range<Point> rankRange,
                               final Range<Point> suitRange) {
        return IntStream.range(0, this.cardImageProcessor.getCardsAmount(rankRange.getStartPoint(), rankRange.getEndPoint()))
            .mapToObj(n -> this.getCardByRange(
                CARD_RANK_START_RANGE.expand(CARD_EXPAND_RANGE, n),
                CARD_SUIT_START_RANGE.expand(CARD_EXPAND_RANGE, n)
            ))
            .collect(Collectors.toList());
    }

    /**
     * Returns available {@link Card} by input range parameters
     *
     * @param rankRange initial input rank {@link Range}
     * @param suitRange initial input suit {@link Range}
     * @return available card
     */
    public Card getCardAt(final Range<Point> rankRange,
                          final Range<Point> suitRange) {
        return this.getCardByRange(rankRange, suitRange);
    }

    /**
     * Returns {@code long} cards amount by input {@link Range}
     *
     * @param range initial input {@link Range} to operate by
     * @return card amount in range
     */
    public int getCardsAmount(final Range<Point> range) {
        return this.cardImageProcessor.getCardsAmount(range.getStartPoint(), range.getEndPoint());
    }

    /**
     * Functional mapper to convert input {@link Range} to {@link Card}
     *
     * @param rankRange initial input rank {@link Range}
     * @param suitRange initial input suit {@link Range}
     * @return functional converter to {@link Card}
     */
    private Card getCardByRange(final Range<Point> rankRange,
                                final Range<Point> suitRange) {
        final CardRank cardRank = this.cardImageProcessor
            .getCardRank(rankRange.getStartPoint(), rankRange.getEndPoint())
            .orElseThrow(UnresolvableCardRankException::new);
        final CardSuit cardSuit = this.cardImageProcessor
            .getCardSuit(suitRange.getStartPoint(), suitRange.getEndPoint())
            .orElseThrow(UnresolvableCardSuitException::new);
        return Card.of(cardSuit, cardRank);
    }
}
