package christmas.domain;

import christmas.domain.constant.Day;

public class ChristmasDDayDiscount {
    private int discountAmount = 0;

    public int calculate(Day day) {
        if (!(day.getValue() > Day.DAY_25.getValue())) {
            discountAmount = 1000 + (day.getValue() - 1) * 100;
        }
        return discountAmount;
    }

    @Override
    public String toString() {
        if (discountAmount == 0) {
            return "";
        }
        return String.format("크리스마스 디데이 할인: -%,d" + System.lineSeparator(), discountAmount);
    }
}
