package christmas.domain.constant;

public enum Category {
    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    DRINK("음료"),
    X("없음");

    private final String name;

    Category(final String name) {
        this.name = name;
    }

}
