package io.brainshells.api.openimagecv.processor.model;

import static io.brainshells.api.openimagecv.processor.management.CardConstants.CARD_EXPAND_RANGE;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import io.brainshells.api.openimagecv.processor.management.CardManager;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Deck extends AbstractDeck {

    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = 6296737415157581021L;

    /**
     * Default deck constructor by input {@link BufferedImage} and {@link CardManager}
     *
     * @param name        initial input {@link String} deck
     * @param cardManager initial input {@link CardManager}
     */
    public Deck(final String name, final CardManager cardManager) {
        super(name, cardManager);
    }

    /**
     * Returns {@link List} collection of {@link Card}s
     *
     * @return collection of deck cards
     */
    public List<Card> getCards(final Range<Point> range,
                               final Range<Point> rankMask,
                               final Range<Point> suitMask) {
        return IntStream.range(0, this.getCardManager().getCardsAmount(range))
            .mapToObj(n -> this.getCardManager().getCardAt(
                rankMask.adjust(CARD_EXPAND_RANGE, n),
                suitMask.adjust(CARD_EXPAND_RANGE, n)
            ))
            .collect(Collectors.toList());
    }

    /**
     * Deck deserialization operation from {@link ObjectInputStream}
     *
     * @param inputStream initial input {@link ObjectInputStream} to operate by
     * @throws IOException            if input stream cannot be processed
     * @throws ClassNotFoundException if class is not found
     */
    private void readObject(final ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        final String name = inputStream.readUTF();
        final CardManager cardManager = (CardManager) inputStream.readObject();
        this.initialize(name, cardManager);
    }

    /**
     * Deck serialization operation from {@link ObjectOutputStream}
     *
     * @param outputStream initial input {@link ObjectOutputStream} to operate by
     * @throws IOException if input stream cannot be processed
     */
    private void writeObject(final ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(this.getName());
        outputStream.writeObject(this.getCardManager());
    }
}
