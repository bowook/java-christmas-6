package christmas.service;

import christmas.domain.ChristmasDDayDiscount;
import christmas.domain.Orders;
import christmas.domain.ProvideDiscount;
import christmas.domain.SpecialDiscount;
import christmas.domain.WeekDiscount;
import christmas.domain.constant.Badge;
import christmas.domain.constant.Day;
import christmas.domain.constant.Menu;

public class PromotionService {
    private int totalDiscount = 0;
    private int expectPayment = 0;

    public Menu provideMenu(Orders orders) {
        expectPayment = orders.calculateTotalPrice();
        if (expectPayment >= 120000) {
            return Menu.CHAMPAGNE;
        }
        return Menu.X;
    }

    public Badge badge() {
        return Badge.from(totalDiscount);
    }

    public int expectPayment() {
        return expectPayment;
    }

    public int totalDiscount() {
        return totalDiscount;
    }

    public String benefitHistory(Day day, Orders orders) {
        return discountChristmasDDay(day)
                + discountWeek(day, orders)
                + discountSpecial(day)
                + discountProvide(orders);
    }

    private String discountChristmasDDay(Day day) {
        ChristmasDDayDiscount christmasDDayDiscount = new ChristmasDDayDiscount();
        int discount = christmasDDayDiscount.calculate(day);
        totalDiscount += discount;
        expectPayment -= discount;
        return christmasDDayDiscount.toString();
    }

    private String discountWeek(Day day, Orders orders) {
        WeekDiscount weekDiscount = new WeekDiscount(day);
        int discount = weekDiscount.calculate(orders);
        totalDiscount += discount;
        expectPayment -= discount;
        return weekDiscount.toString();
    }

    private String discountSpecial(Day day) {
        SpecialDiscount specialDiscount = new SpecialDiscount(day);
        int discount = specialDiscount.calculateDiscount();
        totalDiscount += discount;
        expectPayment -= discount;
        return specialDiscount.toString();
    }

    private String discountProvide(Orders orders) {
        ProvideDiscount provideDiscount = new ProvideDiscount();
        totalDiscount += provideDiscount.calculate(orders);
        return provideDiscount.toString();
    }
}
