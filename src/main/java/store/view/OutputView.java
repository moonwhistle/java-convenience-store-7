package store.view;

import java.util.List;
import store.domain.product.Product;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void showProducts(List<Product> products) {
        for(Product product : products) {
            System.out.printf(
                    "%s %,d원 %s %s", product.getName(), product.getPrice(), product.showQuantity(), product.getPromotion()
                    + LINE_SEPARATOR
            );
        }
    }
}
