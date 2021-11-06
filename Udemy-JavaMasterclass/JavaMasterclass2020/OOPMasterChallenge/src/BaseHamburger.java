import java.math.BigDecimal;
import java.text.NumberFormat;

public class BaseHamburger {

    NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private String burgerName = "Hamburger";
    private String breadType = "Weissbrot";
    private String meatType = "Rindfleisch";
    private BigDecimal basePrice;
    private String[] extraName = new String[6];
    private BigDecimal[] extraPrice = new BigDecimal[6];
    private BigDecimal extraPriceTotal = new BigDecimal(0);;
    private BigDecimal finalPrice;

    public BaseHamburger(double basePrice) {

        this.basePrice = new BigDecimal(basePrice);
        this.finalPrice = new BigDecimal(basePrice);
    }

    public BaseHamburger(String breadType, String meatType, double basePrice) {
        this.breadType = breadType;
        this.meatType = meatType;
        this.basePrice = new BigDecimal(basePrice);
        this.finalPrice = new BigDecimal(basePrice);
    }

    public void getInfo() {

        System.out.println("\t*****");
        System.out.println(burgerName + ":");
        System.out.println("Bread: " + breadType);
        System.out.println("Meat: " + meatType);
        for(int i = 0; i < 6; i++) {
            if(extraName[i] != null) {
                System.out.println("Extra #" + (i+1) + ": " + extraName[i] + " = " + formatter.format(extraPrice[i]));
            }
        }
        System.out.println("\t*****\nBase Price = " + formatter.format(basePrice));
        System.out.println("Extras Price = " + formatter.format(extraPriceTotal));
        System.out.println("Total Price = " + formatter.format(finalPrice) + "\n\t*****");
    }

    public void setBurgerName(String name) {
        this.burgerName = name;
    }

    public void setExtra(String name, double price) {
        int limit = 4;
        if(burgerName == "Healthy Burger") {
            limit = 6;
        }
        if(burgerName == "Deluxe Burger") {
            limit = 2;
        }
        for(int i = 0; i < limit; i++) {
            if(extraName[i] == null) {
                extraName[i] = name;
                extraPrice[i] = new BigDecimal(price);
                System.out.println("Extra #" + (i+1) + ": " + name + " added (" + formatter.format(extraPrice[i]) + ")");
                this.extraPriceTotal = this.extraPriceTotal.add(extraPrice[i]);
                this.finalPrice = this.finalPrice.add(extraPrice[i]);
                return;
            }
        }
        System.out.println("All Extra Spots are full\n\t*****");
        return;
    }
}
