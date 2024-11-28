package store;

import java.time.LocalDateTime;
import store.controller.MainController;
import store.view.OutputView;

public class Application {
    public static void main(String[] args) {
        final String productsFilePath = "./src/main/resources/products.md";
        final String promotionsFilePath = "./src/main/resources/promotions.md";
        final LocalDateTime now = LocalDateTime.now();
        final OutputView outputView = new OutputView();
        final MainController controller = new MainController(productsFilePath, promotionsFilePath, now, outputView);
        controller.run();
        // TODO: 프로그램 구현
    }
}
