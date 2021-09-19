public class Couch {

    private double width;
    private String color;
    private int cusions;
    private int damagepoints;

    public Couch(double width, String color, int cusions) {
        this.width = width;
        this.color = color;
        this.cusions = cusions;
        this.damagepoints = 100;
    }

    public void jumpOnCouch() {
        System.out.println("Jumping Hui!");
        damagepoints--;
        getDamagepoints();
        if(damagepoints <= 0) {
            System.out.println("You broke the freakin couch");
        }
    }

    public void throwCushion() {
        System.out.println("Your cusion hits the window");
        cusions--;
        if(cusions <= 0) {
            System.out.println("Out of cusions");
        }
    }

    public double getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public int getCusions() {
        return cusions;
    }

    public int getDamagepoints() {
        System.out.println(damagepoints + " damagepoints left");
        return damagepoints;
    }
}
