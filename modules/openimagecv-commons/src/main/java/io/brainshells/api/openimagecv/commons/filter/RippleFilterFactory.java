package io.brainshells.api.openimagecv.commons.filter;

import io.brainshells.api.openimagecv.commons.model.RippleImageOp;
import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;


public class RippleFilterFactory extends AbstractFilterFactory {

    protected List<BufferedImageOp> filters;
    protected RippleImageOp ripple;

    public RippleFilterFactory() {
        ripple = new RippleImageOp();
    }

    protected List<BufferedImageOp> getPreRippleFilters() {
        return new ArrayList<BufferedImageOp>();
    }

    protected List<BufferedImageOp> getPostRippleFilters() {
        return new ArrayList<BufferedImageOp>();

    }

    @Override
    public List<BufferedImageOp> getFilters() {
        if (filters == null) {
            ArrayList<BufferedImageOp> tmp = new ArrayList<BufferedImageOp>();
            tmp.addAll(getPreRippleFilters());
            tmp.add(ripple);
            tmp.addAll(getPostRippleFilters());
            filters = tmp;
        }
        return filters;
    }


}
