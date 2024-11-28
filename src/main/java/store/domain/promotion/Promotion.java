package store.domain.promotion;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import store.domain.vo.Name;
import store.domain.vo.Quantity;

public class Promotion {

    private final Name name;
    private final Quantity buyQuantity;
    private final Quantity freeQuantity;
    private final boolean isPromotion;

    public static Promotion of(Name name, Quantity buyQuantity, Quantity freeQuantity, String startDate, String endDate,
                               LocalDateTime now) {
        return new Promotion(name, buyQuantity, freeQuantity, isPromotion(startDate, endDate, now));
    }

    public static Promotion noPromotion() {
        return new Promotion(
                Name.noName(),
                Quantity.noQuantity(),
                Quantity.noQuantity(),
                false
        );
    }

    public Promotion(Name name, Quantity buyQuantity, Quantity freeQuantity, boolean isPromotion) {
        this.name = name;
        this.buyQuantity = buyQuantity;
        this.freeQuantity = freeQuantity;
        this.isPromotion = isPromotion;
    }

    public boolean isPromotion() {
        return isPromotion;
    }

    public String getName() {
        return name.getName();
    }

    private static boolean isPromotion(String startDate, String endDate, LocalDateTime now) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate promotionStartDate = LocalDate.parse(startDate, formatter);
        LocalDate promotionEndDate = LocalDate.parse(endDate, formatter);
        return now.isAfter(promotionStartDate.atStartOfDay()) && now.isBefore(promotionEndDate.atTime(LocalTime.MAX));
    }
}
