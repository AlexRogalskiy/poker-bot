package io.brainshells.api.openimagecv.captcha.filter;

import java.awt.image.BufferedImage;

@FunctionalInterface
public interface FilterFactory {

    BufferedImage applyFilters(BufferedImage source);
}
