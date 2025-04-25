public class LaptopDisplay {
    // Enum for Laptop with a private price field for each constant
    public enum Laptop {
        HP(800),
        THINKPAD(1200),
        DELL(1000),
        LENOVO(900);
        private final int price;
        Laptop(int price) {
            this.price = price;
        }
        public int getPrice() {
            return price;
        }
    }
    public static void main(String[] args) {
        // Using foreach loop to display each enum element with price
        for (Laptop laptop : Laptop.values()) {
            System.out.println(laptop + ": $" + laptop.getPrice());
        }
    }
}