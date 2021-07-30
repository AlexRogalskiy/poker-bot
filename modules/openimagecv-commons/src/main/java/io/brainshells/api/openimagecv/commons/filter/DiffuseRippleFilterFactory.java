package io.brainshells.api.openimagecv.commons.filter;

import io.brainshells.api.openimagecv.commons.model.DiffuseImageOp;
import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;

public class DiffuseRippleFilterFactory extends RippleFilterFactory {

    protected DiffuseImageOp diffuse = new DiffuseImageOp();

    @Override
    protected List<BufferedImageOp> getPreRippleFilters() {
        List<BufferedImageOp> list = new ArrayList<>();
        list.add(diffuse);
        return list;
    }
}
