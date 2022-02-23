package lotto;

import java.util.Scanner;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // Shop shop = AppConfig.getLottoShop();
        // shop.operate();
        LottoController controller = new LottoController(new InputView(new Scanner(System.in)), new OutputView());

        controller.run();
    }
}
