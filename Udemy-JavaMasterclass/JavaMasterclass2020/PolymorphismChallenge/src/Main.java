import java.time.LocalDate;
import java.time.Month;

class Porsche extends Car {

    public Porsche(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "Porsche -> starting";
    }

    @Override
    public String accelerate() {
        return "Porsche -> accelerating";
    }

    @Override
    public String brake() {
        return "Porsche -> braking";
    }
}

class Volvo extends Car {

    public Volvo(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "Volvo -> starting";
    }

    @Override
    public String accelerate() {
        return "Volvo -> accelerating";
    }

    @Override
    public String brake() {
        return "Volvo -> braking";
    }
}
class MercedesLimousine extends  Car {

    public MercedesLimousine(String name, int cylinders) {
        super(name, cylinders);
    }

    @Override
    public String startEngine() {
        return "MercedesLimousine -> starting";
    }

    @Override
    public String accelerate() {
        return "MercedesLimousine -> accelerating";
    }

    @Override
    public String brake() {
        return "MercedesLimousine -> braking";
    }
}

class Car {

    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
    }

    public String startEngine() {
        return getClass().getSimpleName() + " -> Engine started";
    }

    public String accelerate() {
        return "Car -> accelerate";
    }

    public String brake() {
        return "Car -> brake";
    }

    public String getName() {
        return name;
    }

    public int getCylinders() {
        return cylinders;
    }
}

public class Main {

    public static void main(String[] args) {

//        Car car1 = new Car("Base Car", 8);
//        System.out.println(car1.startEngine());
//        System.out.println(car1.accelerate());
//        System.out.println(car1.brake());
//
//        Porsche porsche = new Porsche("911", 6);
//        System.out.println(porsche.startEngine());
//        System.out.println(porsche.accelerate());
//        System.out.println(porsche.brake());
//
//        MercedesLimousine merdedes = new MercedesLimousine("M60", 6);
//        System.out.println(merdedes.startEngine());
//        System.out.println(merdedes.accelerate());
//        System.out.println(merdedes.brake());
//
//        Volvo volvo = new Volvo("V40", 6);
//        System.out.println(volvo.startEngine());
//        System.out.println(volvo.accelerate());
//        System.out.println(volvo.brake());

        System.out.println(LocalDate.of(2019, Month.FEBRUARY, 22));


    }
}
