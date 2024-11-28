package store.domain.vo;

public class Price {

    public static final String NUMBER_DELIMITER = "^[0-9]+$";

    private final int price;

    public Price(String price) {
        validatePriceFrom(price);
        this.price = Integer.parseInt(price);
    }

    public Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    private void validatePriceFrom(String price) {
        if (!price.matches(NUMBER_DELIMITER)) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
    }
}
