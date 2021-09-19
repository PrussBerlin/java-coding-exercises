public class DeluxeHamburger extends BaseHamburger {

    public DeluxeHamburger(String breadType, String meatType, double basePrice) {
        super(breadType, meatType, basePrice);
        super.setBurgerName("Deluxe Burger");
        super.setExtra("Chips", 0);
        super.setExtra("Drinks", 0);
    }
}
