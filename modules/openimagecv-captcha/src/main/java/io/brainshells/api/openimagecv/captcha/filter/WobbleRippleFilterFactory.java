package io.brainshells.api.openimagecv.captcha.filter;

import io.brainshells.api.openimagecv.captcha.model.WobbleImageOp;
import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

public class WobbleRippleFilterFactory extends RippleFilterFactory {

    protected WobbleImageOp wobble;

    public WobbleRippleFilterFactory() {
        this.wobble = new WobbleImageOp();
    }

    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        final List<BufferedImageOp> list = new ArrayList<>();
        list.add(this.wobble);
        return list;
    }
}
