package io.brainshells.api.openimagecv.processor.management;

import io.brainshells.api.openimagecv.processor.model.Card;
import io.brainshells.api.openimagecv.processor.model.Deck;
import io.brainshells.api.openimagecv.processor.utils.ImageUtils;
import lombok.extern.slf4j.Slf4j;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.brainshells.api.openimagecv.commons.utils.ExecutorUtils.DEFAULT_COMPLETABLE_LOG_ACTION;
import static io.brainshells.api.openimagecv.commons.utils.ExecutorUtils.newScheduledExecutor;
import static io.brainshells.api.openimagecv.processor.management.CardConstants.*;

@Slf4j
public class ApplicationRunner {

    /**
     * Application runner initialization flag
     */
    private static final AtomicReference<Boolean> INIT = new AtomicReference<>(false);

    /**
     * Application executor
     */
    public static final ScheduledThreadPoolExecutor EXECUTOR = newScheduledExecutor(10, "openimagecv");

    /**
     * Image directory
     */
    private final Path imagePath;

    /**
     * Default application constructor with command arguments
     *
     * @param args input array of arguments
     */
    public ApplicationRunner(final String[] args) {
        if (!INIT.compareAndSet(false, true)) {
            throw new IllegalStateException("Application runner has been started");
        }

        log.info("Starting OpenImageCV processor with arguments: {}", Arrays.toString(args));
        if (args.length != 1) {
            log.error("Invalid arguments count: {}, (missing image directory)", args.length);
            System.exit(1);
        }
        this.imagePath = Paths.get(args[0]);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> log.info("OpenImageCV processor finished")));
    }

    /**
     * Executes image processor task
     */
    public void execute() {
        log.info("Executing printing card desk task...");

        Arrays.stream(ImageUtils.listOfFiles(this.imagePath))
            .map(this.createDeck())
            .map(this.createDeckPrinterTask())
            .map(r -> CompletableFuture.runAsync(r, EXECUTOR))
            .map(f -> f.whenCompleteAsync(DEFAULT_COMPLETABLE_LOG_ACTION))
            .forEach(CompletableFuture::join);

        EXECUTOR.shutdownNow();
    }

    /**
     * Functional operator that consumes {@link Deck} and
     * print information on cards
     *
     * @return operator to process file
     */
    private Function<Deck, Runnable> createDeckPrinterTask() {
        return deck -> () -> {
            final String deckCards = deck.getCards(CARD_RANK_RANGE, CARD_RANK_START_RANGE, CARD_SUIT_START_RANGE)
                .stream()
                .map(Card::toString)
                .collect(Collectors.joining());
            log.info("{}: {}", deck.getName(), deckCards);
        };
    }

    /**
     * Returns {@link Function} operator to convert image {@link File} to {@link Deck}
     *
     * @return functional deck operator
     */
    private Function<File, Deck> createDeck() {
        return file -> {
            final BufferedImage image = ImageUtils.loadImage(file);
            final CardManager cardManager = new CardManager(image);
            return new Deck(file.getName(), cardManager);
        };
    }
}
