package io.brainshells.api.openimagecv.commons.color;

import java.awt.Color;

public class SingleColorFactory implements ColorFactory {

    private Color color;

    public SingleColorFactory() {
        color = Color.BLACK;
    }

    public SingleColorFactory(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor(int index) {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
