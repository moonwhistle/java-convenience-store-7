package store.domain.product;

import java.util.Objects;
import store.domain.promotion.Promotion;
import store.domain.vo.Name;
import store.domain.vo.Price;
import store.domain.vo.Quantity;

public class Product {

    private final Name name;
    private final Price price;
    private final Quantity quantity;
    private final Promotion promotion;


    public Product(Name name, Price price, Quantity quantity, Promotion promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion;
    }

    public String getName() {
        return name.getName();
    }

    public int getPrice() {
        return price.getPrice();
    }

    public String showQuantity() {
        return quantity.showQuantity();
    }

    public String getPromotion() {
        return promotion.getName();
    }

    public boolean isPromotion() {
        return promotion.isPromotion();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Product myObject = (Product) obj;
        return Objects.equals(name, myObject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
