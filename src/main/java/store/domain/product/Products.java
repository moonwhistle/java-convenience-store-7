package store.domain.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import store.domain.promotion.Promotion;
import store.domain.promotion.Promotions;
import store.domain.vo.Name;
import store.domain.vo.Price;
import store.domain.vo.Quantity;

public class Products {

    private final List<Product> products;


    public Products(List<List<String>> contents, Promotions promotions) {
        this.products = makeProducts(contents, promotions);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    private List<Product> makeProducts(List<List<String>> contents, Promotions promotions) {
        List<Product> products = new ArrayList<>();

        for (List<String> content : contents) {
            Promotion promotion = promotions.getPromotionByName(content.getLast());
            products.add(new Product(
                    Name.from(content.getFirst()),
                    new Price(content.get(1)),
                    Quantity.from(content.get(2)),
                    promotion
            ));
        }
        addGeneralProducts(products);

        return products;
    }

    private void addGeneralProducts(List<Product> products) {
        for(int i = 0; i< products.size(); i++) {
            Product product = products.get(i);
            List<Product> sameProducts = getSameProducts(products, product);
            addGeneralProduct(products, product, sameProducts, i);
        }
    }

    private void addGeneralProduct(List<Product> products, Product product, List<Product> sameProducts, int i) {
        if(product.isPromotion() && sameProducts.size() < 2) {
            products.add(i +1, new Product(
                    Name.from(product.getName()),
                    new Price(product.getPrice()),
                    Quantity.noQuantity(),
                    Promotion.noPromotion()
            ));
        }
    }

    private List<Product> getSameProducts(List<Product> products, Product product) {
        List<Product> sameProducts = new ArrayList<>();
        for(Product existProduct : products) {
            if(existProduct.equals(product)) {
                sameProducts.add(existProduct);
            }
        }
        return sameProducts;
    }
}
