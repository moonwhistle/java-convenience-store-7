package store.controller;

import java.time.LocalDateTime;
import store.domain.file.FileReader;
import store.domain.product.Products;
import store.domain.promotion.Promotions;
import store.view.OutputView;

public class MainController {

    private final String productsFilePath;
    private final String promotionsFilePath;
    private final LocalDateTime now;
    private final OutputView outputView;

    public MainController(String productsFilePath, String promotionsFilePath, LocalDateTime now, OutputView outputView) {
        this.productsFilePath = productsFilePath;
        this.promotionsFilePath = promotionsFilePath;
        this.now = now;
        this.outputView = outputView;
    }

    public void run() {
        Promotions promotions = getPromotions();
        Products products = getProducts(promotions);
        outputView.showProducts(products.getProducts());
    }

    private Products getProducts(Promotions promotions) {
        FileReader productsReader = new FileReader(productsFilePath);
        return new Products(productsReader.getContents(), promotions);
    }

    private Promotions getPromotions() {
        FileReader promotionsReader = new FileReader(promotionsFilePath);
        return new Promotions(promotionsReader.getContents(), now);
    }
}
