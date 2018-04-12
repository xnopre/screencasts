import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {

    @Test
    public void test_calculate() {
        // Préparation
        PriceCalculator priceCalculator = new PriceCalculator();

        // Test
        String result = priceCalculator.calculate(3, 1.21);

        // Vérification
        assertEquals("3.63 €", result);
    }
}
