package io.brainshells.api.openimagecv.processor.processor;

import java.io.Serializable;
import java.util.Optional;

import io.brainshells.api.openimagecv.processor.enumeration.CardRank;
import io.brainshells.api.openimagecv.processor.enumeration.CardSuit;
import io.brainshells.api.openimagecv.processor.model.Point;

public interface CardImageProcessor extends Serializable {
    /**
     * Returns optional {@link CardSuit} by input {@link Point} parameters
     *
     * @param startPoint initial input start {@link Point}
     * @param endPoint   initial input end {@link Point}
     * @return card suit if present
     */
    Optional<CardSuit> getCardSuit(Point startPoint,
                                   Point endPoint);

    /**
     * Returns optional {@link CardRank} by input {@link Point} parameters
     *
     * @param startPoint initial input start {@link Point}
     * @param endPoint   initial input end {@link Point}
     * @return card rank if present
     */
    Optional<CardRank> getCardRank(Point startPoint,
                                   Point endPoint);

    /**
     * Returns {@code int} number of cards by input {@link Point} parameters
     *
     * @param startPoint initial input start {@link Point}
     * @param endPoint   initial input end {@link Point}
     * @return number of cards
     */
    int getCardsAmount(Point startPoint,
                       Point endPoint);
}
