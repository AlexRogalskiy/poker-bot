package io.brainshells.api.openimagecv.processor.model;

import static io.brainshells.api.openimagecv.processor.utils.ValidationUtils.checkNotNull;
import static io.brainshells.api.openimagecv.processor.utils.ValidationUtils.checkRange;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

import javax.imageio.ImageIO;

import io.brainshells.api.openimagecv.processor.enumeration.CardPattern;

/**
 * Buffered image wrapper that provides operations on cards
 */
public class CardBufferedImage implements Serializable {

    /**
     * Default explicit serialVersionUID for interoperability
     */
    private static final long serialVersionUID = -416963886066633033L;

    private transient BufferedImage image;

    /**
     * Default card buffered image constructor with input image {@link InputStream}
     *
     * @param stream - content of the image as {@link InputStream}
     */
    public CardBufferedImage(final InputStream stream) throws IOException {
        this(ImageIO.read(stream));
    }

    /**
     * Default card buffered image constructor with input image {@link BufferedImage}
     *
     * @param image - content of the image as {@link BufferedImage}
     */
    public CardBufferedImage(final BufferedImage image) {
        checkNotNull(image, "Image should not be null");

        this.image = image;
    }

    /**
     * Returns image {@code int} width
     *
     * @return {@code int} width
     */
    public int getWidth() {
        return this.image.getWidth();
    }

    /**
     * Returns image {@code int} height
     *
     * @return {@code int} height
     */
    public int getHeight() {
        return this.image.getHeight();
    }

    /**
     * Returns {@link CardPattern} by input coordinates
     *
     * @param x initial input {@code int} x-coordinate
     * @param y initial input {@code int} y-coordinate
     * @return card pattern
     */
    public CardPattern getCardPattern(int x, int y) {
        final int rgb = this.image.getRGB(x, y);
        return CardPattern.fromColor(rgb);
    }

    /**
     * Validates input array of {@link Point}s
     *
     * @param points initial input array of {@link Point}s
     */
    public void validatePoints(final Point... points) {
        Arrays.stream(points).forEach(p -> {
            checkRange(p.getXCoord(), 0, this.image.getWidth());
            checkRange(p.getYCoord(), 0, this.image.getHeight());
        });
    }

    /**
     * Card image deserialization operation from {@link ObjectInputStream}
     *
     * @param inputStream initial input {@link ObjectInputStream} to operate by
     * @throws IOException            if input stream cannot be processed
     * @throws ClassNotFoundException if class is not found
     */
    private void readObject(final ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        this.image = ImageIO.read(inputStream);
    }

    /**
     * Card image serialization operation from {@link ObjectOutputStream}
     *
     * @param outputStream initial input {@link ObjectOutputStream} to operate by
     * @throws IOException if input stream cannot be processed
     */
    private void writeObject(final ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        ImageIO.write(this.image, "png", outputStream);
    }
}
