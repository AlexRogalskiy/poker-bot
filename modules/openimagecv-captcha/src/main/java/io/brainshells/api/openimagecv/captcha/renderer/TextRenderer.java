package io.brainshells.api.openimagecv.captcha.renderer;

import io.brainshells.api.openimagecv.commons.color.ColorFactory;
import io.brainshells.api.openimagecv.commons.font.FontFactory;
import java.awt.image.BufferedImage;

public interface TextRenderer {

    void setLeftMargin(int leftMargin);

    void setRightMargin(int rightMargin);

    void setTopMargin(int topMargin);

    void setBottomMargin(int bottomMargin);

    void draw(String text, BufferedImage canvas, FontFactory fontFactory,
        ColorFactory colorFactory);
}
