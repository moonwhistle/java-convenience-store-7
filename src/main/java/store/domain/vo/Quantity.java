package store.domain.vo;

public class Quantity {

    public static final String NUMBER_DELIMITER = "^[0-9]+$";

    private final int quantity;

    public static Quantity from(String quantity) {
        validateQuantityForm(quantity);
        return new Quantity(quantity);
    }

    public static Quantity noQuantity() {
        return new Quantity("0");
    }

    private Quantity(String quantity) {
        this.quantity = Integer.parseInt(quantity);
    }

    public String showQuantity() {
        if (quantity == 0) {
            return "재고 없음";
        }
        return quantity + "개";
    }

    private static void validateQuantityForm(String quantity) {
        if (!quantity.matches(NUMBER_DELIMITER)) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
    }
}
