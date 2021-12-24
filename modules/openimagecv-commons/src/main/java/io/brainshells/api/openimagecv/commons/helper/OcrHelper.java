package io.brainshells.api.openimagecv.commons.helper;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

@Slf4j
public class OcrHelper {

    private final byte[] bytes;
    private String result;

    public OcrHelper(final byte[] b) {
        this.bytes = b;
    }

    public String run() throws IOException {
        final String serverName = "localhost";
        final int port = 10000;

        final Socket socket = new Socket(serverName, port);
        final BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String input;

        while ((input = in.readLine()) != null) {
            if ("Connected".equals(input)) {
                out.writeInt(this.bytes.length);
                out.write(this.bytes);
            } else {
                socket.close();
                this.result = input;
                return input;
            }
        }

        this.result = "";
        return "Could not get output";
    }

    public String getResult() {
        return this.result;
    }

    public byte[] getBytes() throws IOException {
        return this.compress(this.bytes);
    }

    private byte[] compress(final byte[] b) throws IOException {
        final ByteArrayOutputStream compressed = new ByteArrayOutputStream();
        final ImageOutputStream outputStream = ImageIO.createImageOutputStream(compressed);

        final ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName("jpg").next();

        final ImageWriteParam jpgWriterParam = jpgWriter.getDefaultWriteParam();
        jpgWriterParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpgWriterParam.setCompressionQuality(0.1f);

        jpgWriter.setOutput(outputStream);
        jpgWriter.write(null, new IIOImage(ImageIO.read(new ByteArrayInputStream(b)), null, null), jpgWriterParam);
        jpgWriter.dispose();

        return resizeImage(convertToBuffered(compressed.toByteArray()), 400, 320);
    }

    private byte[] resizeImage(final BufferedImage originalImage, final int width, final int height) throws IOException {
        final BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        return this.convertToByte(resizedImage);
    }

    private BufferedImage convertToBuffered(final byte[] b) throws IOException {
        final InputStream is = new ByteArrayInputStream(b);
        return ImageIO.read(is);
    }

    private byte[] convertToByte(final BufferedImage b) throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(b, "jpg", baos);
        baos.flush();
        baos.close();

        return baos.toByteArray();
    }
}
