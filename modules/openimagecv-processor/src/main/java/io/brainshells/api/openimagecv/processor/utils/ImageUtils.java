package io.brainshells.api.openimagecv.processor.utils;

import io.brainshells.api.openimagecv.processor.model.Point;
import io.brainshells.api.openimagecv.processor.model.Range;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.*;
import java.net.URLConnection;
import java.nio.file.Path;
import java.util.Base64;
import java.util.function.UnaryOperator;

import static java.awt.RenderingHints.KEY_INTERPOLATION;
import static java.awt.RenderingHints.VALUE_INTERPOLATION_BILINEAR;
import static java.awt.Transparency.OPAQUE;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;
import static java.lang.Math.max;
import static javax.imageio.ImageIO.read;

@Slf4j
@UtilityClass
public class ImageUtils {

    public static void validateFileWritable(final File f) {
        final File file = f.getAbsoluteFile();
        final File parent = file.getParentFile();

        if (file.exists()) {
            if (!file.canWrite()) {
                throw new IllegalArgumentException("Can not overwrite existing file " + file.getAbsolutePath());
            }
        } else if (parent.exists()) {
            if (!parent.canWrite()) {
                throw new IllegalArgumentException("Can not write new file to directory " + parent.getAbsolutePath());
            }
        } else if (!parent.mkdirs()) {
            throw new IllegalArgumentException("Could not create parent directory " + parent.getAbsolutePath());
        }
    }

    public static BufferedImage toBufferedImage(final byte[] content) throws IOException {
        return read(new ByteArrayInputStream(content));
    }

    public static byte[] toPng(final BufferedImage image) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(image, "png", output);
        return output.toByteArray();
    }

    public static byte[] toJpg(final BufferedImage image) throws IOException {
        // Start with a white layer to have images with an alpha layer handled correctly.
        final BufferedImage newBufferedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        newBufferedImage.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);

        // Manually get the ImageWriter to be able to adjust quality
        final ImageWriter writer = ImageIO.getImageWritersBySuffix("jpg").next();
        ImageWriteParam imageWriterParam = writer.getDefaultWriteParam();
        imageWriterParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriterParam.setCompressionQuality(1f);

        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        writer.setOutput(new MemoryCacheImageOutputStream(output));
        writer.write(null, new IIOImage(newBufferedImage, null, null), imageWriterParam);
        writer.dispose();

        return output.toByteArray();
    }

    public static BufferedImage cropImage(final BufferedImage image, final int desiredWidth, final int desiredHeight) {
        final boolean cropHorizontally = (image.getWidth() > desiredWidth);

        final int x = cropHorizontally ? (image.getWidth() - desiredWidth) / 2 : 0;
        final int y = cropHorizontally ? 0 : (image.getHeight() - desiredHeight) / 2;

        return image.getSubimage(x, y, desiredWidth, desiredHeight);
    }

    /*
     * Examples of aspect ratios:
     * 1:1 = 1.0 (will delegate to cropToSquareImage())
     * 4:3 = 1.33333
     * 3:2 = 1.5
     * 16:9 = 1.77778
     */
    public static BufferedImage cropImage(BufferedImage image, double desiredAspectRatio) {
        if (desiredAspectRatio == 1.0) {
            return cropToSquareImage(image);
        }

        double currentAspectRatio = image.getWidth() * 1.0 / image.getHeight();

        if (currentAspectRatio == desiredAspectRatio) {
            return image;
        }

        boolean cropHorizontally = (currentAspectRatio > desiredAspectRatio);

        int desiredWidth = cropHorizontally ? (int) (image.getHeight() * desiredAspectRatio) : image.getWidth();
        int desiredHeight = cropHorizontally ? image.getHeight() : (int) (image.getWidth() / desiredAspectRatio);

        return cropImage(image, desiredWidth, desiredHeight);
    }

    public static BufferedImage cropToSquareImage(BufferedImage image) {
        boolean cropHorizontally = (image.getWidth() > image.getHeight());

        int desiredSize = cropHorizontally ? image.getHeight() : image.getWidth();

        return cropImage(image, desiredSize, desiredSize);
    }

    public static BufferedImage progressiveBilinearDownscale(BufferedImage image, int desiredWidth, int desiredHeight) {
        BufferedImage rescaledImage = image;

        while (rescaledImage.getWidth() > desiredWidth || rescaledImage.getHeight() > desiredHeight) {
            int nextWidth = max(rescaledImage.getWidth() / 2, desiredWidth);
            int nextHeight = max(rescaledImage.getHeight() / 2, desiredHeight);

            final BufferedImage nextScaledImage = new BufferedImage(nextWidth, nextHeight, image.getTransparency() == OPAQUE ? TYPE_INT_RGB : TYPE_INT_ARGB);
            final Graphics2D graphics = nextScaledImage.createGraphics();
            graphics.setRenderingHint(KEY_INTERPOLATION, VALUE_INTERPOLATION_BILINEAR);
            graphics.drawImage(rescaledImage, 0, 0, nextWidth, nextHeight, null);
            graphics.dispose();

            rescaledImage = nextScaledImage;
        }

        return rescaledImage;
    }

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

    public static int average(final int oldAverageColor, final int newColor, final int multiplier) {
        if (oldAverageColor == newColor) {
            return oldAverageColor;
        }

        float red0 = (oldAverageColor >> 16) & 0xff;
        float green0 = (oldAverageColor >> 8) & 0xff;
        float blue0 = oldAverageColor & 0xff;

        float red1 = (newColor >> 16) & 0xff;
        float green1 = (newColor >> 8) & 0xff;
        float blue1 = newColor & 0xff;

        int color = (int) 255;
        color = (color << 8) + (int) ((red0 * multiplier + red1) / (multiplier + 1));
        color = (color << 8) + (int) ((green0 * multiplier + green1) / (multiplier + 1));
        color = (color << 8) + (int) ((blue0 * multiplier + blue1) / (multiplier + 1));

        return color;
    }

    public static BufferedImage convertRawRgbToImage(final int width, final int height, final int[] inputColors) {
        final BufferedImage leftImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        final int[] leftColors = ((DataBufferInt) leftImage.getRaster().getDataBuffer()).getData();
        if (width * height >= 0) {
            System.arraycopy(inputColors, 0, leftColors, 0, width * height);
        }
        return leftImage;
    }

    public static BufferedImage convertImage(BufferedImage inputImage) {
        if (inputImage.getType() != BufferedImage.TYPE_INT_ARGB) {
            final BufferedImage tempImage = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
            final Graphics g = tempImage.createGraphics();
            g.drawImage(inputImage, 0, 0, null);
            g.dispose();
            inputImage = tempImage;
        }
        return inputImage;
    }

    public static void writeImage(final String outputImageFile, final BufferedImage outputImage) throws IOException {
        ImageIO.write(outputImage, "png", new FileOutputStream(outputImageFile, false));
    }

    public static BufferedImage readImage(final String inputImageFile) throws IOException {
        final BufferedImage inputImage = ImageIO.read(new FileInputStream(inputImageFile));
        return convertImage(inputImage);
    }
}
