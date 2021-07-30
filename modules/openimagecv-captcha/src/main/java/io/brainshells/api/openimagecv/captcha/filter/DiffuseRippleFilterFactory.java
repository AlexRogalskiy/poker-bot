package io.brainshells.api.openimagecv.captcha.filter;

import io.brainshells.api.openimagecv.captcha.model.DiffuseImageOp;
import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

public class DiffuseRippleFilterFactory extends RippleFilterFactory {

    protected DiffuseImageOp diffuse = new DiffuseImageOp();

    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        final List<BufferedImageOp> list = new ArrayList<>();
        list.add(diffuse);

        return list;
    }
}
