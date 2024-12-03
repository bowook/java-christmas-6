package christmas.domain.constant;

public enum Badge {
    STAR("별"),
    TREE("트리"),
    SANTA("산타"),
    X("없음");

    private final String name;

    Badge(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Badge from(int price) {
        if (price >= 20000) {
            return SANTA;
        }
        if (price >= 10000) {
            return TREE;
        }
        if (price >= 5000) {
            return STAR;
        }
        return X;
    }
}
