package io.brainshells.api.openimagecv.processor.model;

import io.brainshells.api.openimagecv.processor.enumeration.CardRank;
import io.brainshells.api.openimagecv.processor.enumeration.CardSuit;
import lombok.Getter;
import lombok.Value;

@Getter
@Value(staticConstructor = "of")
public class Card {
    /**
     * Card suit
     */
    CardSuit suit;
    /**
     * Card rank
     */
    CardRank rank;

    @Override
    public String toString() {
        return String.format("%s%s", this.rank, this.suit);
    }
}
