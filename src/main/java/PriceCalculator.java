public class PriceCalculator {
    public HelperWithQuantity withQuantity(int quantity) {
        return new HelperWithQuantity(quantity);
    }

    public class HelperWithQuantity {
        private int quantity;

        public HelperWithQuantity(int quantity) {
            this.quantity = quantity;
        }

        public HelperWithQuantityAndUnitPrice withUnitPrice(double unitPrice) {
            return new HelperWithQuantityAndUnitPrice(quantity, unitPrice);
        }
    }

    public class HelperWithQuantityAndUnitPrice {
        private int quantity;
        private double unitPrice;

        public HelperWithQuantityAndUnitPrice(int quantity, double unitPrice) {

            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        public String getTotalPrice() {
            return (quantity * unitPrice)+" €";
        }
    }
}
