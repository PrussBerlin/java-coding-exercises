public class DeluxeBurger extends Hamburger {

    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", 14.54, "White");
        super.addHamburgerAddtion1("Chips", 2.75);
        super.addHamburgerAddtion2("Drink", 1.81);
    }

    @Override
    public void addHamburgerAddtion1(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe Burger");
    }

    @Override
    public void addHamburgerAddtion2(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe Burger");
    }

    @Override
    public void addHamburgerAddtion3(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe Burger");
    }

    @Override
    public void addHamburgerAddtion4(String name, double price) {
        System.out.println("Cannot add additional items to a deluxe Burger");
    }
}
