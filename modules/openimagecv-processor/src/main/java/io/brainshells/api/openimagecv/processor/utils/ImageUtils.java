package io.brainshells.api.openimagecv.processor.utils;

import io.brainshells.api.openimagecv.processor.model.Point;
import io.brainshells.api.openimagecv.processor.model.Range;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Path;
import java.util.Base64;
import java.util.function.UnaryOperator;

@Slf4j
@UtilityClass
public class ImageUtils {

    /**
     * Gets the content of an image as a Base64 encoded string.
     *
     * @param file a File pointing to an image
     * @return a Base64 encoded version of that image
     * @throws IOException if there is an error reading the file
     */
    public static String getImageAsBase64(final File file, final String contentType) throws IOException {
        final BufferedImage bufferedImage = ImageIO.read(file);
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, contentType.split("/")[1], bos);
        final byte[] imageBytes = bos.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    /**
     * Gets the content type of the specified file representing an image.
     *
     * @param file a File pointing to an image
     * @return a content type (e.g. "image/png")
     * @throws IOException if there is an error reading the file
     */
    public static String getContentType(final File file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("A file must be specified.");
        } else if (!file.exists()) {
            throw new IllegalArgumentException(file.getCanonicalPath() + " does not exist.");
        } else if (!file.isFile()) {
            throw new IllegalArgumentException(file.getCanonicalPath() + " is not a file.");
        }

        final String contentType = getRawContentType(file);
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new IllegalArgumentException(file.getCanonicalPath() + " is not a supported image file.");
        }

        return contentType;
    }

    /**
     * Gets the content of an image as a data URI; e.g. "data:image/png;base64,iVBORw0KGgoAA..."
     *
     * @param file a File pointing to an image
     * @return a data URI
     * @throws IOException if there is an error reading the file
     */
    public static String getImageAsDataUri(final File file) throws IOException {
        final String contentType = getContentType(file);
        final String base64Content = getImageAsBase64(file, contentType);
        return String.format("data:{%s};base64,{%s}", contentType, base64Content);
    }

    /**
     * Returns {@link String} content type by input {@link File}
     *
     * @param file initial input {@link File} to operate by
     * @return {@link String} content type
     */
    private static String getRawContentType(final File file) {
        try {
            final URLConnection connection = file.toURI().toURL().openConnection();
            return connection.getContentType();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Validates color code by input {@link String} color
     *
     * @param colorAsString initial input {@link String} color to validate by
     * @return true - if color is hex, false - otherwise
     */
    public static boolean isHexColorCode(final String colorAsString) {
        return colorAsString != null && colorAsString.matches("^#[A-Fa-f0-9]{6}");
    }

    /**
     * Returns loaded {@link BufferedImage} from input {@link File}
     *
     * @param file initial input {@link File} to load from
     * @return loaded image
     */
    public static BufferedImage loadImage(final File file) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            log.error("Cannot read image from file: {}, message: {}", file, e.getMessage());
            throw new IllegalArgumentException(e);
        }
        return bufferedImage;
    }

    /**
     * Returns array of {@link File}s from input {@link Path}
     *
     * @param path initial input {@link Path} to read from
     * @return list of subdirectory files
     */
    public static File[] listOfFiles(final Path path) {
        final File[] retVal;

        final File file = path.normalize().toAbsolutePath().toFile();
        if (file.exists()
            && file.isDirectory()
            && file.listFiles() != null) {
            retVal = file.listFiles();
        } else {
            retVal = new File[0];
        }

        return retVal;
    }

    /**
     * Function operator to crop input {@link BufferedImage} by parameters
     *
     * @param range initial input {@link Range} to operate by
     * @return cropped image
     */
    public static UnaryOperator<BufferedImage> cropImage(final Range<Point> range) {
        return image -> image.getSubimage(
            range.getStartPoint().getXCoord(),
            range.getStartPoint().getYCoord(),
            range.getEndPoint().getXCoord() - range.getStartPoint().getXCoord(),
            range.getEndPoint().getYCoord() - range.getStartPoint().getYCoord()
        );
    }
}
