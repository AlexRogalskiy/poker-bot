package io.brainshells.api.openimagecv.commons.color;

import java.awt.Color;
import java.util.Random;

public class RandomColorFactory implements ColorFactory {

    private Color min;
    private Color max;
    private Color color;

    public RandomColorFactory() {
        this.min = new Color(20, 40, 80);
        this.max = new Color(21, 50, 140);
    }

    public void setMin(Color min) {
        this.min = min;
    }

    public void setMax(Color max) {
        this.max = max;
    }

    @Override
    public Color getColor(int index) {
        if (color == null) {
            Random r = new Random();
            color = new Color(
                min.getRed() + r.nextInt((max.getRed() - min.getRed())),
                min.getGreen() + r.nextInt((max.getGreen() - min.getGreen())),
                min.getBlue() + r.nextInt((max.getBlue() - min.getBlue())));
        }

        return color;
    }
}
