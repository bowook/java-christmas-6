package christmas.domain.constant;

import christmas.exception.CustomException;
import christmas.exception.ErrorMessage;
import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP(Category.APPETIZER, "양송이수프", 6000),
    TAPAS(Category.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(Category.APPETIZER, "시저샐러드", 8000),
    T_BONE_STEAK(Category.MAIN, "티본스테이크", 55000),
    BBQ_RIPS(Category.MAIN, "바비큐립", 54000),
    SEAFOOD_PASTA(Category.MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(Category.MAIN, "크리스마스파스타", 25000),
    CHOCOLATE_CATE(Category.DESSERT, "초코케이크", 15000),
    ICE_CREAM(Category.DESSERT, "아이스크림", 5000),
    ZERO_COLA(Category.DRINK, "제로콜라", 3000),
    RED_WINE(Category.DRINK, "레드와인", 60000),
    CHAMPAGNE(Category.DRINK, "샴페인", 25000),
    X(Category.X, "없음", 0);

    private final Category category;
    private final String name;
    private final int price;

    Menu(final Category category, final String name, final int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public static Menu from(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.name.equals(menuName))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.ORDER_ERROR));
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
