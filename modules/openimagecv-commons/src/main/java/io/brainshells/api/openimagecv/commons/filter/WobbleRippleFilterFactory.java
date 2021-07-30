package io.brainshells.api.openimagecv.commons.filter;

import io.brainshells.api.openimagecv.commons.model.WobbleImageOp;
import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

public class WobbleRippleFilterFactory extends RippleFilterFactory {

    protected WobbleImageOp wobble;

    public WobbleRippleFilterFactory() {
        wobble = new WobbleImageOp();
    }

    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        List<BufferedImageOp> list = new ArrayList<BufferedImageOp>();
        list.add(wobble);
        return list;
    }

}
