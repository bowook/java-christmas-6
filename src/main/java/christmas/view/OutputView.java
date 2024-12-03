package christmas.view;

import christmas.domain.Orders;
import christmas.domain.constant.Badge;
import christmas.domain.constant.Day;
import christmas.domain.constant.Menu;

public class OutputView {
    private final static String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private final static String PREVIEW_EVENT = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final static String ORDER_MENU = "<주문 메뉴>";
    private final static String BEFORE_DISCOUNT_TOTAL_AMOUNT = "<할인 전 총주문 금액>";
    private final static String PROVIDE_MENU = "<증정 메뉴>";
    private final static String BENEFIT_HISTORY = "<혜택 내역>";
    private final static String TOTAL_BENEFIT_AMOUNT = "<총혜택 금액>";
    private final static String EXPECT_PAYMENT = "<할인 후 예상 결제 금액>";
    private final static String EVENT_BADGE = "<12월 이벤트 배지>";
    private final static String NOT_MINUS_AMOUNT_FORMAT = "%,d원";
    private final static String MINUS_AMOUNT_FORMAT = "-%,d원";

    public void printEventBadge(Badge badge) {
        System.out.print(System.lineSeparator());
        System.out.println(EVENT_BADGE);
        System.out.println(badge.getName());
    }

    public void printExpectAmount(int amount) {
        System.out.print(System.lineSeparator());
        System.out.println(EXPECT_PAYMENT);
        System.out.printf(NOT_MINUS_AMOUNT_FORMAT, amount);
    }

    public void printTotalDiscount(int discount) {
        System.out.println(TOTAL_BENEFIT_AMOUNT);
        if (discount == 0) {
            System.out.println("없음");
            return;
        }
        System.out.printf(MINUS_AMOUNT_FORMAT, discount);
    }

    public void printBenefitHistory(String history) {
        System.out.print(System.lineSeparator());
        System.out.println(BENEFIT_HISTORY);
        if (history.isBlank()) {
            System.out.println("없음");
            return;
        }
        System.out.println(history);
    }

    public void printProvideMenu(Menu menu) {
        System.out.print(System.lineSeparator());
        System.out.println(PROVIDE_MENU);
        if (menu.getName().equals(Menu.X.getName())) {
            System.out.println(menu.getName());
            return;
        }
        System.out.println(menu.getName() + "1개");
    }

    public void printPrevDiscountTotalAmount(Orders orders) {
        System.out.println(BEFORE_DISCOUNT_TOTAL_AMOUNT);
        System.out.printf(NOT_MINUS_AMOUNT_FORMAT, orders.calculateTotalPrice());
        System.out.print(System.lineSeparator());
    }

    public void printOrderMenu(Orders orders) {
        System.out.println(ORDER_MENU);
        System.out.println(orders.toString());
    }

    public void printPreviewMessage(Day day) {
        System.out.printf(PREVIEW_EVENT, day.getValue());
        System.out.print(System.lineSeparator());
        System.out.print(System.lineSeparator());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }
}
