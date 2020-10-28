package io.brainshells.api.openimagecv.processor.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Point {
    /**
     * X-axis coordinate
     */
    private final int xCoord;
    /**
     * Y-axis coordinate
     */
    private final int yCoord;

    /**
     * Returns new {@link Point} by input coordinates
     *
     * @param xCoord initial input {@code int} x-coordinate
     * @param yCoord initial input {@code int} y-coordinate
     * @return new point
     */
    public static Point of(final int xCoord, final int yCoord) {
        return new Point(xCoord, yCoord);
    }
}
