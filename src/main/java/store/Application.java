package store;

import store.controller.MainController;

public class Application {
    public static void main(String[] args) {
        final String filePath = "./src/main/resources/products.md";
        final MainController controller = new MainController(filePath);
        controller.run();
        // TODO: 프로그램 구현
    }
}
