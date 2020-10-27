package io.brainshells.api.openimagecv.processor.model;

import lombok.Getter;
import lombok.Value;

@Getter
@Value(staticConstructor = "of")
public class Point {
    /**
     * X-axis coordinate
     */
    int xCoord;
    /**
     * Y-axis coordinate
     */
    int yCoord;
}
