package Chapter1;

import java.math.BigDecimal;
import static Chapter1.Prices.prices;

public class DiscountingImperative {


    public static void main(String[] args) {
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
        for (BigDecimal price : prices) {
            if(price.compareTo(BigDecimal.valueOf(20))>0){
                totalOfDiscountedPrices = totalOfDiscountedPrices.add(
                        price.multiply(BigDecimal.valueOf(0.9))
                );
            }

        }
        System.out.println("totalOfDiscountedPrices = " + totalOfDiscountedPrices);
    }
}
