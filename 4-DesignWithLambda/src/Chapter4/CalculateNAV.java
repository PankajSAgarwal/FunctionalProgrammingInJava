package Chapter4;

import java.math.BigDecimal;
import java.util.function.Function;

public class CalculateNAV {
    private Function<String,BigDecimal> priceFinder;

    public CalculateNAV(Function<String, BigDecimal> aPriceFinder) {
        this.priceFinder = aPriceFinder;
    }

    public BigDecimal computeStockWorth(final String ticker,
                                        final int shares){

        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }
    //... other methods that use the priceFinder ...

    public static void main(String[] args) {
        final CalculateNAV calculateNAV = new CalculateNAV(YahooFinance::getPrice);
        System.out.println(String.format("100 shares of Google worth:$%.2f",
                calculateNAV.computeStockWorth("GOOG",100) ));
    }
}
