class Holden extends Car {

    public Holden(String name, int cylinders) {
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

