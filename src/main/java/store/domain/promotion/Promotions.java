package store.domain.promotion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import store.domain.vo.Name;
import store.domain.vo.Quantity;

public class Promotions {

    private final List<Promotion> promotions;

    public Promotions(List<List<String>> contents, LocalDateTime now) {
        this.promotions = makePromotions(contents, now);
    }

    public Promotion getPromotionByName(String promotionName) {
        for (Promotion promotion : promotions) {
            if (promotion.getName().equals(promotionName)) {
                return promotion;
            }
        }
        return Promotion.noPromotion();
    }

    private List<Promotion> makePromotions(List<List<String>> contents, LocalDateTime now) {
        List<Promotion> promotions = new ArrayList<>();

        for (List<String> content : contents) {
            promotions.add(Promotion.of(
                    Name.from(content.getFirst()),
                    Quantity.from(content.get(1)),
                    Quantity.from(content.get(2)),
                    content.get(3),
                    content.getLast(),
                    now
            ));
        }

        return promotions;
    }
}
