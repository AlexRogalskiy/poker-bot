package io.brainshells.api.openimagecv.commons.background;

import io.brainshells.api.openimagecv.commons.color.ColorFactory;
import io.brainshells.api.openimagecv.commons.color.SingleColorFactory;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class SingleColorBackgroundFactory implements BackgroundFactory {

    private ColorFactory colorFactory;

    public SingleColorBackgroundFactory() {
        this(Color.WHITE);
    }

    public SingleColorBackgroundFactory(Color color) {
        this.colorFactory = new SingleColorFactory(color);
    }

    public void setColorFactory(ColorFactory colorFactory) {
        this.colorFactory = colorFactory;
    }

    @Override
    public void fillBackground(BufferedImage dest) {
        final Graphics g = dest.getGraphics();
        g.setColor(this.colorFactory.getColor(0));
        g.fillRect(0, 0, dest.getWidth(), dest.getHeight());
    }
}
