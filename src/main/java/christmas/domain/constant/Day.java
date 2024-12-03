package christmas.domain.constant;

import christmas.exception.CustomException;
import christmas.exception.ErrorMessage;
import java.util.Arrays;

public enum Day {
    DAY_1("주말", 1, false), DAY_2("주말", 2, false), DAY_3("평일", 3, true),
    DAY_4("평일", 4, false), DAY_5("평일", 5, false), DAY_6("평일", 6, false),
    DAY_7("평일", 7, false), DAY_8("주말", 8, false), DAY_9("주말", 9, false),
    DAY_10("평일", 10, true), DAY_11("평일", 11, false), DAY_12("평일", 12, false),
    DAY_13("평일", 13, false), DAY_14("평일", 14, false), DAY_15("주말", 15, false),
    DAY_16("주말", 16, false), DAY_17("평일", 17, true), DAY_18("평일", 18, false),
    DAY_19("평일", 19, false), DAY_20("평일", 20, false), DAY_21("평일", 21, false),
    DAY_22("주말", 22, false), DAY_23("주말", 23, false), DAY_24("평일", 24, true),
    DAY_25("평일", 25, true), DAY_26("평일", 26, false), DAY_27("평일", 27, false),
    DAY_28("평일", 28, false), DAY_29("주말", 29, false), DAY_30("주말", 30, false),
    DAY_31("평일", 31, true);

    private final String week;
    private final int value;
    private final boolean star;

    Day(final String week, final int value, final boolean star) {
        this.week = week;
        this.value = value;
        this.star = star;
    }

    public static Day from(int input) {
        return Arrays.stream(Day.values())
                .filter(day -> day.value == input)
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.DAY_ERROR));
    }

    public boolean isStar() {
        return star;
    }

    public String getWeek() {
        return week;
    }

    public int getValue() {
        return value;
    }
}
