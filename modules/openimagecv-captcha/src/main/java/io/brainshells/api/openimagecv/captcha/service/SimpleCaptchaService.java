package io.brainshells.api.openimagecv.captcha.service;

import io.brainshells.api.openimagecv.commons.background.SingleColorBackgroundFactory;
import io.brainshells.api.openimagecv.commons.color.SingleColorFactory;
import io.brainshells.api.openimagecv.captcha.filter.FilterFactory;
import io.brainshells.api.openimagecv.commons.font.RandomFontFactory;
import io.brainshells.api.openimagecv.captcha.renderer.BestFitTextRenderer;
import io.brainshells.api.openimagecv.captcha.word.AdaptiveRandomWordFactory;
import java.awt.Color;

public class SimpleCaptchaService extends AbstractCaptchaService {

    public SimpleCaptchaService(int width, int height, Color textColor,
        Color backgroundColor, int fontSize, FilterFactory ff) {
        this.backgroundFactory = new SingleColorBackgroundFactory(
            backgroundColor);
        this.wordFactory = new AdaptiveRandomWordFactory();
        this.fontFactory = new RandomFontFactory();
        this.textRenderer = new BestFitTextRenderer();
        this.colorFactory = new SingleColorFactory(textColor);
        this.filterFactory = ff;
        this.width = width;
        this.height = height;
    }

    public SimpleCaptchaService(int width, int height, Color textColor,
        Color backgroundColor, int fontSize, String[] fontNames,
        FilterFactory ff) {
        this.backgroundFactory = new SingleColorBackgroundFactory(
            backgroundColor);
        this.wordFactory = new AdaptiveRandomWordFactory();
        this.fontFactory = new RandomFontFactory(fontNames);
        this.textRenderer = new BestFitTextRenderer();
        this.colorFactory = new SingleColorFactory(textColor);
        this.filterFactory = ff;
        this.width = width;
        this.height = height;
    }

    @Override
    public Captcha getCaptcha() {
        return null;
    }
}
