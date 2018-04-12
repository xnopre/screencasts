import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {

    @Test
    public void test_calculate() {
        PriceCalculator priceCalculator = new PriceCalculator();

        String result = priceCalculator
                .withQuantity(3)
                .withUnitPrice(1.21)
                .getTotalPrice();

        assertEquals("3.63 €", result);
    }

}
