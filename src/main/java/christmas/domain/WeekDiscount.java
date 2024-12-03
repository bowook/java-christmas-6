package christmas.domain;

import christmas.domain.constant.Category;
import christmas.domain.constant.Day;

public class WeekDiscount {
    private final static int discountStandard = 2023;
    private int discountAmount = 0;
    private final Day day;

    public WeekDiscount(Day day) {
        this.day = day;
    }

    public int calculate(Orders orders) {
        if (day.getWeek().equals("평일")) {
            discountAmount += orders.findMenu(Category.DESSERT) * discountStandard;
            return discountAmount;
        }
        discountAmount += orders.findMenu(Category.MAIN) * discountStandard;
        return discountAmount;
    }

    @Override
    public String toString() {
        if (discountAmount == 0) {
            return "";
        }
        return String.format("%s 할인: -%,d원" + System.lineSeparator(), day.getWeek(), discountAmount);
    }
}
