package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Orders;
import christmas.domain.constant.Day;
import christmas.utils.Parser;

public class InputView {
    private final static String VISIT_DAY = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private final static String ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public Orders readOrderMenu() {
        System.out.println(ORDER_MENU);
        return Parser.menuToInventory(readConsole());
    }

    public Day readVisitDay() {
        System.out.println(VISIT_DAY);
        return Day.from(Parser.dayToNumber(readConsole()));
    }

    public void closeConsole() {
        Console.close();
    }

    private String readConsole() {
        return Console.readLine();
    }
}
