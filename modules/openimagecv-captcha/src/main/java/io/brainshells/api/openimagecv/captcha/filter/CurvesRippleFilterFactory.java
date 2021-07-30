package io.brainshells.api.openimagecv.captcha.filter;

import io.brainshells.api.openimagecv.captcha.model.CurvesImageOp;
import io.brainshells.api.openimagecv.commons.color.ColorFactory;
import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

public class CurvesRippleFilterFactory extends RippleFilterFactory {

    protected CurvesImageOp curves = new CurvesImageOp();

    public CurvesRippleFilterFactory() {
    }

    public CurvesRippleFilterFactory(ColorFactory colorFactory) {
        this.setColorFactory(colorFactory);
    }

    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        final List<BufferedImageOp> list = new ArrayList<>();
        list.add(this.curves);
        return list;
    }

    public void setStrokeMin(float strokeMin) {
        this.curves.setStrokeMin(strokeMin);
    }

    public void setStrokeMax(float strokeMax) {
        this.curves.setStrokeMax(strokeMax);
    }

    public void setColorFactory(ColorFactory colorFactory) {
        this.curves.setColorFactory(colorFactory);
    }
}
