package christmas.domain;

import christmas.domain.constant.Menu;

public class ProvideDiscount {
    private int discountAmount = 0;

    public int calculate(Orders orders) {
        int beforeDiscountTotalAmount = orders.calculateTotalPrice();
        if (beforeDiscountTotalAmount >= 120000) {
            discountAmount = Menu.CHAMPAGNE.getPrice();
        }
        return discountAmount;
    }

    @Override
    public String toString() {
        if (discountAmount == 0) {
            return "";
        }
        return String.format("증정 이벤트: -%,d원" + System.lineSeparator(), discountAmount);
    }
}
