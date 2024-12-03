package christmas.controller;

import christmas.domain.Orders;
import christmas.domain.constant.Day;
import christmas.domain.constant.Menu;
import christmas.exception.CustomException;
import christmas.service.PromotionService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class PromotionController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PromotionService promotionService;

    public PromotionController(final InputView inputView, final OutputView outputView, final PromotionService service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.promotionService = service;
    }

    public void start() {
        outputView.printWelcomeMessage();
        Day visitDay = readVisitDay();
        Orders orders = readOrders();
        outputView.printPreviewMessage(visitDay);
        outputView.printOrderMenu(orders);
        outputView.printPrevDiscountTotalAmount(orders);
        Menu proiveMenu = promotionService.provideMenu(orders);
        outputView.printProvideMenu(proiveMenu);
        outputView.printBenefitHistory(promotionService.benefitHistory(visitDay, orders));
        outputView.printTotalDiscount(promotionService.totalDiscount());
        outputView.printExpectAmount(promotionService.expectPayment());
        outputView.printEventBadge(promotionService.badge());
        inputView.closeConsole();
    }

    private Orders readOrders() {
        while (true) {
            try {
                return inputView.readOrderMenu();
            } catch (CustomException customException) {
                outputView.printErrorMessage(customException.getMessage());
            }
        }
    }

    private Day readVisitDay() {
        while (true) {
            try {
                return inputView.readVisitDay();
            } catch (CustomException customException) {
                outputView.printErrorMessage(customException.getMessage());
            }
        }
    }
}
