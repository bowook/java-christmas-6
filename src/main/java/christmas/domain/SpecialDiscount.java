package christmas.domain;

import christmas.domain.constant.Day;

public class SpecialDiscount {
    private int discountAmount = 0;
    private final Day day;

    public SpecialDiscount(final Day day) {
        this.day = day;
    }

    public int calculateDiscount() {
        if (day.isStar()) {
            discountAmount = 1000;
        }
        return discountAmount;
    }

    @Override
    public String toString() {
        if (discountAmount == 0) {
            return "";
        }
        return String.format("특별 할인: -%,d원" + System.lineSeparator(), discountAmount);
    }
}
