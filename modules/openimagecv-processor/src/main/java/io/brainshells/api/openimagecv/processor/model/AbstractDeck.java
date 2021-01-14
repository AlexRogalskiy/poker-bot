package io.brainshells.api.openimagecv.processor.model;

import java.io.Serializable;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import io.brainshells.api.openimagecv.processor.management.CardManager;
import lombok.Getter;

@Getter
public abstract class AbstractDeck implements Serializable {

    /**
     * Deck name
     */
    private String name;
    /**
     * Deck card manager
     */
    private CardManager cardManager;

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
     * @param cardManager initial input {@link CardManager}
     */
    public AbstractDeck(final CardManager cardManager) {
        this(UUID.randomUUID().toString(), cardManager);
    }

    /**
     * Creates new deck instance by input parameters
     *
     * @param name        initial input {@link String} deck name
     * @param cardManager initial input {@link CardManager}
     */
    public AbstractDeck(final String name, final CardManager cardManager) {
        this.initialize(name, cardManager);
    }

    /**
     * Initialized deck by input parameters
     *
     * @param cardManager initial input {@link CardManager}
     */
    protected final void initialize(final String name, final CardManager cardManager) {
        if (!this.init.compareAndSet(State.NEW, State.INITIALIZING)) {
            throw new IllegalStateException("Deck has already been initialized");
        }
        this.name = name;
        this.cardManager = cardManager;
        init.set(State.INITIALIZED);
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
