package io.brainshells.api.openimagecv.processor.management;

import io.brainshells.api.openimagecv.processor.model.Card;
import io.brainshells.api.openimagecv.processor.model.Deck;
import io.brainshells.api.openimagecv.processor.processor.BufferedCardImageAdaptor;
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
            .map(this.createDeckTask())
            .map(r -> CompletableFuture.runAsync(r, EXECUTOR))
            .map(f -> f.whenCompleteAsync(DEFAULT_COMPLETABLE_LOG_ACTION))
            .forEach(CompletableFuture::join);

        EXECUTOR.shutdownNow();
    }

    public void reinit2() {
        Arrays.stream(ImageUtils.listOfFiles(this.imagePath))
            .forEach(file -> {
                final BufferedCardImageAdaptor cardImageProcessor = new BufferedCardImageAdaptor(ImageUtils.loadImage(file));
                final int count = cardImageProcessor.getCardsAmount(CARD_RANK_RANGE.getStartPoint(), CARD_RANK_RANGE.getEndPoint());
                log.info("Count: {}", count);
            });
    }

    public String compress(final String str) {
        String input = str;

        int count = 1;

        char last = input.charAt(0);

        StringBuilder output = new StringBuilder();

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == last) {
                count++;
            } else {
                if (count > 1) {
                    output.append(last + "{" + (count - 3) + "," + (count + 3) + "}");
                } else {
                    output.append(last);
                }
                count = 1;
                last = input.charAt(i);
            }
        }
        if (count > 1) {
            output.append(last + "{" + (count - 3) + "," + (count + 3) + "}");
        } else {
            output.append(last);
        }
        return "^B*" + output.toString() + "B*$";
    }

    public void reinit() {
//        Arrays.stream(ImageUtils.listOfFiles(this.imagePath))
//            .forEach(file -> {
//                final CardImageProcessorImpl cardImageProcessor = new CardImageProcessorImpl(ImageUtils.loadImage(file));
//                final CardPattern[] pattern = cardImageProcessor.getCardPattern(CARD_SUIT_START_RANGE.expand(CARD_EXPAND_RANGE, 2).getStartPoint(), CARD_SUIT_START_RANGE.expand(CARD_EXPAND_RANGE, 2).getEndPoint());
//                log.info("{} - {}", file.getName(), this.compress(CardPattern.serialize(pattern)));
//            });
//        Arrays.stream(ImageUtils.listOfFiles(this.imagePath))
//            .forEach(file -> {
//                final CardImageProcessorImpl cardImageProcessor = new CardImageProcessorImpl(ImageUtils.loadImage(file));
//                log.info(">>> {}", cardImageProcessor.getCardRank(CARD_RANK_START_RANGE.expand(CARD_EXPAND_RANGE).getStartPoint(), CARD_RANK_START_RANGE.expand(CARD_EXPAND_RANGE).getEndPoint()));
//                final CardPattern[] pattern = cardImageProcessor.getCardPattern(CARD_RANK_RANGE.getStartPoint(), CARD_RANK_RANGE.getEndPoint());
//                log.info(CardPattern.serialize(pattern));
//            });
    }

    /**
     * Functional operator that consumes {@link Deck} and
     * print information on cards
     *
     * @return operator to process file
     */
    private Function<Deck, Runnable> createDeckTask() {
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