package io.brainshells.api.openimagecv.captcha.filter;

import io.brainshells.api.openimagecv.captcha.model.MarbleImageOp;
import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;


public class MarbleRippleFilterFactory extends RippleFilterFactory {

    protected MarbleImageOp marble = new MarbleImageOp();

    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        final List<BufferedImageOp> list = new ArrayList<>();
        list.add(marble);
        return list;
    }
}
