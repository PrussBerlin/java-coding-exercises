public class Door {

    private String material;
    private String handle;
    private String openingDirection;
    private int openOrClosed; //0 means closed

    public Door() {
        this("Holz", "Klinke", "nach innen öffnend");
    }

    public Door(String material, String handle, String openingDirection) {
        this.material = material;
        this.handle = handle;
        this.openingDirection = openingDirection;
        this.openOrClosed = 0;
    }

    public void openDoor() {
        this.openOrClosed = 1;
        System.out.println("Door opend");
    }

    public void closeDoor() {
        this.openOrClosed = 0;
        System.out.println("Door closed");
    }

    public void lockTheDoor() {
        System.out.println("Door locked");
    }

}
