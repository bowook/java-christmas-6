package christmas.domain;

import christmas.domain.constant.Category;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Order order : orders) {
            stringBuilder.append(order.toString());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public int calculateTotalPrice() {
        int price = 0;
        for (Order order : orders) {
            price += order.calculatePrice();
        }
        return price;
    }

    public int findMenu(Category category) {
        int amount = 0;
        for (Order order : orders) {
            if (order.getMenu().getCategory().equals(category)) {
                amount += order.getCount();
            }
        }
        return amount;
    }
}
