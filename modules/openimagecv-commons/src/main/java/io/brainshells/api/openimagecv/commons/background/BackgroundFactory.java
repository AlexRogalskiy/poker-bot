package io.brainshells.api.openimagecv.commons.background;

import java.awt.image.BufferedImage;

@FunctionalInterface
public interface BackgroundFactory {

    void fillBackground(BufferedImage dest);
}
