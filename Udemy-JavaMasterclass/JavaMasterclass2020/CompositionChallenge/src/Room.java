

public class Room {

    private Door door;
    private Flooring flooring;
    private Window window;
    private Dimensions dimensions;
    private Couch couch;

    public Room(Door door, Flooring flooring, Window window, Dimensions dimensions, Couch couch) {
        this.door = door;
        this.flooring = flooring;
        this.window = window;
        this.dimensions = dimensions;
        this.couch = couch;
    }

    public void openDoor() {
        door.openDoor();
    }

    public Flooring getFlooring() {
        return flooring;
    }

    public Window getWindow() {
        return window;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Couch getCouch() {
        return couch;
    }
}
