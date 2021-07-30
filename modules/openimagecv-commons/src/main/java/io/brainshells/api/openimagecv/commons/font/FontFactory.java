package io.brainshells.api.openimagecv.commons.font;

import java.awt.Font;

@FunctionalInterface
public interface FontFactory {

    Font getFont(int index);
}
