public class Schranktuer extends Door {

    private int guckFenster; //wieviele Fenster hat die Tür, wenn überhaupt

    public Schranktuer(int guckFenster) {
        this.guckFenster = guckFenster;
    }

    public Schranktuer(String material, int guckFenster) {
        super(material, "normaler Griff", "nach aussen öffnend");
        this.guckFenster = guckFenster;
    }

    @Override
    public void lockTheDoor() {
        System.out.println("Schluessel steckt immer, einfach umdrehen");
        super.lockTheDoor();
    }
}
