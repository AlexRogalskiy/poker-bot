package io.brainshells.api.openimagecv.processor.utils;

import io.brainshells.api.openimagecv.processor.model.Point;
import io.brainshells.api.openimagecv.processor.model.Range;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.function.UnaryOperator;

@Slf4j
@UtilityClass
public class ImageUtils {
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
