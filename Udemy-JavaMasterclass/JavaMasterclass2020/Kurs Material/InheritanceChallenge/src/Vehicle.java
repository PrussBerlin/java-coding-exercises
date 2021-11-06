public class Vehicle {

    private String name;
    private String size;
    private int drivingDirection;
    private int currentSpeed;

    public Vehicle(String name, String size) {

        this.name = name;
        this.size = size;

        this.drivingDirection = 0;
        this.currentSpeed = 0;

    }

    public void steering(int direction) {
        drivingDirection += direction;
        System.out.println("Vehicle.steer(): steering at " + drivingDirection + " degrees.");
    }

    public void move(int speed, int direction) {
        currentSpeed = speed;
        drivingDirection = direction;
        System.out.println(name + " Vehicle.move(): Moving at " + currentSpeed + " in direction " + drivingDirection);
    }

    public void stop() {
        this.currentSpeed = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getDrivingDirection() {
        return drivingDirection;
    }

    public void setDrivingDirection(int drivingDirection) {
        this.drivingDirection = drivingDirection;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
}
