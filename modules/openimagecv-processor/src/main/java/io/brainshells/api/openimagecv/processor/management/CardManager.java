package io.brainshells.api.openimagecv.processor.management;

import static io.brainshells.api.openimagecv.processor.utils.ValidationUtils.checkNotNull;

import java.awt.image.BufferedImage;
import java.io.Serializable;

import io.brainshells.api.openimagecv.processor.enumeration.CardRank;
import io.brainshells.api.openimagecv.processor.enumeration.CardSuit;
import io.brainshells.api.openimagecv.processor.exception.UnresolvableCardRankException;
import io.brainshells.api.openimagecv.processor.exception.UnresolvableCardSuitException;
import io.brainshells.api.openimagecv.processor.model.Card;
import io.brainshells.api.openimagecv.processor.model.Point;
import io.brainshells.api.openimagecv.processor.model.Range;
import io.brainshells.api.openimagecv.processor.processor.BufferedCardImageAdaptor;
import io.brainshells.api.openimagecv.processor.processor.CardImageProcessor;

public class CardManager implements Serializable {

    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = -5065377759493488299L;

    /**
     * {@link CardImageProcessor} instance
     */
    private final CardImageProcessor cardImageProcessor;

    /**
     * Card manager constructor with input {@link BufferedImage} parameter
     *
     * @param image) initial input {@link BufferedImage} to operate by
     */
    public CardManager(final BufferedImage image) {
        this(new BufferedCardImageAdaptor(image));
    }

    /**
     * Card manager constructor with input {@link CardImageProcessor} parameter
     *
     * @param cardImageProcessor) initial input {@link CardImageProcessor} to operate by
     */
    public CardManager(final CardImageProcessor cardImageProcessor) {
        checkNotNull(cardImageProcessor, "Card image processor should not be null");

        this.cardImageProcessor = cardImageProcessor;
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
        return this.cardImageProcessor.getCardsAmount(
            range.getStartPoint(),
            range.getEndPoint()
        );
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
