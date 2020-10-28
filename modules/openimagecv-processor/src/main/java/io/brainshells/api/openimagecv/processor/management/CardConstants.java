package io.brainshells.api.openimagecv.processor.management;

import io.brainshells.api.openimagecv.processor.model.Point;
import io.brainshells.api.openimagecv.processor.model.Range;
import lombok.experimental.UtilityClass;

import java.util.regex.Pattern;

@UtilityClass
public class CardConstants {
    /**
     * Card regex pattern expressions
     */
    public static final Pattern CARD_SPACE_PATTERN = Pattern.compile("B{7,12}");
    public static final Pattern CARD_SPACE_FACED_PATTERN = Pattern.compile("B*(?<=W{55,65})?" + CARD_SPACE_PATTERN + "?(?=W{55,65})?B*");
//    public static final Pattern CARD_SPACE_FACED_PATTERN = Pattern.compile("(?<=W{60,65})?" + CARD_SPACE_PATTERN + "(?=W{60,65})?");

    /**
     * Card rank range
     */
    public static final Range<Point> CARD_RANK_RANGE = Range.of(Point.of(143, 590), Point.of(492, 616));
    /**
     * Card suit range
     */
    public static final Range<Point> CARD_SUIT_RANGE = Range.of(Point.of(143, 617), Point.of(492, 634));
    /**
     * Card face range
     */
    public static final Range<Point> CARD_FACE_RANGE = Range.of(Point.of(0, 0), Point.of(63, 0));
    /**
     * Card gap range
     */
    public static final Range<Point> CARD_GAP_RANGE = Range.of(Point.of(0, 0), Point.of(9, 0));
    /**
     * Card rank mask range
     */
    public static final Range<Point> CARD_RANK_MASK_RANGE = Range.of(Point.of(2, 0), Point.of(40, 26));
    /**
     * Card suit mask range
     */
    public static final Range<Point> CARD_SUIT_MASK_RANGE = Range.of(Point.of(2, 0), Point.of(32, 17));

    /**
     * General card image characteristics
     */
    public static final int CARD_FACE_WIDTH = CARD_FACE_RANGE.width();
    public static final int CARD_FACE_HEIGHT = CARD_FACE_RANGE.height();
    public static final int CARD_GAP_WIDTH = CARD_GAP_RANGE.width();
    public static final int CARD_GAP_HEIGHT = CARD_GAP_RANGE.height();

    public static final int CARD_RANK_MASK_WIDTH = CARD_RANK_MASK_RANGE.width();
    public static final int CARD_RANK_MASK_HEIGHT = CARD_RANK_MASK_RANGE.height();
    public static final int CARD_SUIT_MASK_WIDTH = CARD_SUIT_MASK_RANGE.width();
    public static final int CARD_SUIT_MASK_HEIGHT = CARD_SUIT_MASK_RANGE.height();

    public static final int CARD_EXPAND_WIDTH = CARD_FACE_WIDTH + CARD_GAP_WIDTH;
    public static final int CARD_EXPAND_HEIGHT = CARD_FACE_HEIGHT + CARD_GAP_HEIGHT;

    /**
     * Card rank start range
     */
    public static final Range<Point> CARD_RANK_START_RANGE = Range.of(
        Point.of(CARD_RANK_RANGE.getStartPoint().getXCoord() + CARD_RANK_MASK_RANGE.getStartPoint().getXCoord(), CARD_RANK_RANGE.getStartPoint().getYCoord() + CARD_RANK_MASK_RANGE.getStartPoint().getYCoord()),
        Point.of(CARD_RANK_RANGE.getStartPoint().getXCoord() + CARD_RANK_MASK_WIDTH, CARD_RANK_RANGE.getStartPoint().getYCoord() + CARD_RANK_MASK_HEIGHT)
    );
    /**
     * Card suit start range
     */
    public static final Range<Point> CARD_SUIT_START_RANGE = Range.of(
        Point.of(CARD_SUIT_RANGE.getStartPoint().getXCoord() + CARD_SUIT_MASK_RANGE.getStartPoint().getXCoord(), CARD_SUIT_RANGE.getStartPoint().getYCoord() + CARD_SUIT_MASK_RANGE.getStartPoint().getYCoord()),
        Point.of(CARD_SUIT_RANGE.getStartPoint().getXCoord() + CARD_SUIT_MASK_WIDTH, CARD_SUIT_RANGE.getStartPoint().getYCoord() + CARD_SUIT_MASK_HEIGHT)
    );

    /**
     * Card expand range
     */
    public static final Range<Point> CARD_EXPAND_RANGE = Range.of(
        Point.of(0, 0),
        Point.of(CARD_EXPAND_WIDTH, CARD_EXPAND_HEIGHT)
    );
}
