package Chapter1;
import java.math.BigDecimal;

import static Chapter1.Prices.prices;

public class DiscountingFunctional {
    public static void main(String[] args) {
        final BigDecimal totalOfDiscountedPrices = prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total of Discounted Prices = " + totalOfDiscountedPrices);
    }
    

}
