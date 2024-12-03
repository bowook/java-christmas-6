package christmas.domain;

import christmas.domain.constant.Menu;

public class Order {
    private final Menu menu;
    private final int count;

    public Order(final Menu menu, final int count) {
        this.menu = menu;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public Menu getMenu() {
        return menu;
    }

    public int calculatePrice() {
        return menu.getPrice() * count;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + count + "개";
    }
}
