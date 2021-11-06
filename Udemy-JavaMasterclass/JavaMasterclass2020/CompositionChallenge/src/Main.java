public class Main {

    public static void main(String[] args) {

//        Flooring bodenbelag = new Flooring("beige", "wood");
//        Door door1 = new Door("Kunststoff", "normale Klinke", "nach innen schwingend");
//        Door door2 = new Door("Holz", "Knauf", "nach aussen schwingend");
//        Window fenster1 = new Window(1.5, 3.3, "Termofenster");
//        Window fenster2 = new Window(3.2, 5.2, "Riesenfenster");
//        Dimensions dimensions = new Dimensions(2.8, 7.2, 5.0);
//        Couch couch = new Couch(3.0, "gelb", 5);
//
//        Room raum1 = new Room(door1, bodenbelag, fenster1, dimensions, couch);
//
//        raum1.openDoor();
//        raum1.getWindow().openWindow();
//        raum1.getCouch().getDamagepoints();
//        for(int i = 0; i < 5; i++){
//            raum1.getCouch().jumpOnCouch();
//        }

        //creating the basic objects that we can pass to the bedroom, to create/compose it

        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("East");
        Wall wall3 = new Wall("South");
        Wall wall4 = new Wall("North");

        Ceiling ceiling = new Ceiling(12, 55);

        Bed bed = new Bed("Modern", 4, 3, 2, 1);

        Lamp lamp = new Lamp("Classic", false, 75);

        //creating the bedroom
        Bedroom bedroom = new Bedroom("Tims", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
        bedroom.makeBed();

        bedroom.getLamp().turnOn();
    }
}
