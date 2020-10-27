package io.brainshells.api.openimagecv.processor.model;

import io.brainshells.api.openimagecv.processor.management.CardManager;
import lombok.Getter;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Getter
public abstract class AbstractDeck implements Serializable {

    /**
     * Deck image
     */
    private BufferedImage image;
    /**
     * Deck card manager
     */
    private CardManager cardManager;
    /**
     * Deck name
     */
    private String name;

    /**
     * Deck initialization status
     */
    private enum State {NEW, INITIALIZING, INITIALIZED}

    /**
     * Atomic {@link State} initialization flag
     */
    private final AtomicReference<State> init = new AtomicReference<>(State.NEW);

    /**
     * Creates new deck instance by input parameters
     *
     * @param image       initial input {@link BufferedImage}
     * @param cardManager initial input {@link CardManager}
     */
    public AbstractDeck(final BufferedImage image,
                        final CardManager cardManager) {
        this(UUID.randomUUID().toString(), image, cardManager);
    }

    /**
     * Creates new deck instance by input parameters
     *
     * @param image       initial input {@link BufferedImage}
     * @param cardManager initial input {@link CardManager}
     */
    public AbstractDeck(final String name,
                        final BufferedImage image,
                        final CardManager cardManager) {
        this.name = name;
        this.initialize(image, cardManager);
    }

    /**
     * Initialized deck by input parameters
     *
     * @param image       initial input {@link BufferedImage}
     * @param cardManager initial input {@link CardManager}
     */
    protected final void initialize(final BufferedImage image,
                                    final CardManager cardManager) {
        if (!this.init.compareAndSet(State.NEW, State.INITIALIZING)) {
            throw new IllegalStateException("Deck has already been initialized");
        }
        this.image = image;
        this.cardManager = cardManager;
        init.set(State.INITIALIZED);
    }

    /**
     * Returns deck {@link BufferedImage}
     *
     * @return deck image
     */
    protected final BufferedImage getImage() {
        this.checkInit();
        return this.image;
    }

    /**
     * Returns deck {@link CardManager}
     *
     * @return deck card manager
     */
    protected final CardManager getCardManager() {
        this.checkInit();
        return this.cardManager;
    }

    /**
     * Checks whether deck is initialized
     */
    private void checkInit() {
        if (this.init.get() != State.INITIALIZED) {
            throw new IllegalStateException("Deck is not initialized");
        }
    }
}
