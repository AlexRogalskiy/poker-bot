package io.brainshells.api.openimagecv.commons.image;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.imageio.ImageIO;

import lombok.experimental.UtilityClass;

/**
 * Encapsulates reading URIs as images.
 */
@UtilityClass
public class ImageReader {

    private static final String BASE64TOKEN = "base64,";

    public static CharSequence fetch(final URI translateURI)
        throws IOException {
        final URLConnection connection = translateURI.toURL().openConnection();
        connection.connect();
        final StringBuilder translateResult = new StringBuilder(200);
        try (final BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream(),
                StandardCharsets.UTF_8))) {
            char[] buffer = new char[8192];
            int charsRead;
            while ((charsRead = in.read(buffer)) > 0) {
                translateResult.append(buffer, 0, charsRead);
            }
        }
        return translateResult;
    }

    public static BufferedImage readImage(final URI uri) throws IOException {
        if ("data".equals(uri.getScheme())) {
            return readDataURIImage(uri);
        }
        BufferedImage result;
        try {
            result = ImageIO.read(uri.toURL());
        } catch (IllegalArgumentException iae) {
            throw new IOException("Resource not found: " + uri, iae);
        }
        if (result == null) {
            throw new IOException("Could not load " + uri);
        }
        return result;
    }

    public static BufferedImage readDataURIImage(final URI uri)
        throws IOException {
        String uriString = uri.getSchemeSpecificPart();
        if (!uriString.startsWith("image/")) {
            throw new IOException("Unsupported data URI MIME type");
        }
        int base64Start = uriString.indexOf(BASE64TOKEN);
        if (base64Start < 0) {
            throw new IOException("Unsupported data URI encoding");
        }
        String base64Data =
            uriString.substring(base64Start + BASE64TOKEN.length());
        byte[] imageBytes = Base64.getDecoder().decode(base64Data);
        return ImageIO.read(new ByteArrayInputStream(imageBytes));
    }
}
