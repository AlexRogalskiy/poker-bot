package io.brainshells.api.openimagecv.processor.model;

import lombok.Getter;
import lombok.Value;

@Getter
@Value(staticConstructor = "of")
public class Range<T extends Point> {
    /**
     * Start {@link T} point
     */
    T startPoint;
    /**
     * End {@link T} point
     */
    T endPoint;

    /**
     * Returns {@code int} range width
     *
     * @return range width
     */
    public int width() {
        return this.endPoint.getXCoord() - this.startPoint.getXCoord();
    }

    /**
     * Returns {@code int} range height
     *
     * @return range height
     */
    public int height() {
        return this.endPoint.getYCoord() - this.startPoint.getYCoord();
    }

    /**
     * Returns updated {@link Range} by input {@link Range}
     *
     * @param range initial input {@link Range} to update by
     * @return updated range
     */
    public Range<Point> adjust(final Range<T> range) {
        return this.adjust(range, 1);
    }

    /**
     * Returns updated {@link Range} by input {@link Range} and {@code int} multiplier
     *
     * @param range initial input {@link Range} to update by
     * @param times initial input {@code int} multiplier to update by
     * @return updated range
     */
    public Range<Point> adjust(final Range<T> range, int times) {
        return Range.of(
            Point.of(this.startPoint.getXCoord() + times * range.width(), this.startPoint.getYCoord() + times * range.height()),
            Point.of(this.endPoint.getXCoord() + times * range.width(), this.endPoint.getYCoord() + times * range.height())
        );
    }
}
