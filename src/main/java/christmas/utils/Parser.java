package christmas.utils;

import christmas.domain.Order;
import christmas.domain.Orders;
import christmas.domain.constant.Menu;
import christmas.exception.CustomException;
import christmas.exception.ErrorMessage;
import java.util.List;

public class Parser {
    private final static String COMMA = ",";
    private final static String DASH = "-";

    public static int dayToNumber(String inputDay) {
        try {
            return Integer.parseInt(inputDay);
        } catch (NumberFormatException numberFormatException) {
            throw CustomException.from(ErrorMessage.DAY_ERROR);
        }
    }

    public static Orders menuToInventory(String inputMenu) {
        List<String> inputMenus = List.of(inputMenu.split(COMMA));
        Orders orders = new Orders();
        for (String inputMenuAndCount : inputMenus) {
            orders.addOrder(checkDash(inputMenuAndCount));
        }
        return orders;
    }

    private static Order checkDash(String inputMenuAndCount) {
        List<String> menuAndCount = List.of(inputMenuAndCount.split(DASH));
        if (menuAndCount.size() != 2) {
            throw CustomException.from(ErrorMessage.ORDER_ERROR);
        }
        Menu menu = Menu.from(menuAndCount.get(0));
        int count = checkCount(menuAndCount.get(1));
        return new Order(menu, count);
    }

    private static int checkCount(String menuCount) {
        try {
            return Integer.parseInt(menuCount);
        } catch (NumberFormatException numberFormatException) {
            throw CustomException.from(ErrorMessage.ORDER_ERROR);
        }
    }
}
