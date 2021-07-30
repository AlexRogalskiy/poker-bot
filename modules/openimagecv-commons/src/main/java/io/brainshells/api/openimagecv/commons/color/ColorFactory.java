package io.brainshells.api.openimagecv.commons.color;

import java.awt.Color;

@FunctionalInterface
public interface ColorFactory {

    Color getColor(int index);
}
