public class Window {

    private double height;
    private double width;
    private String type;
    private int openOrClosed;

    public Window(double height, double width, String type) {
        this.height = height;
        this.width = width;
        this.type = type;
        this.openOrClosed = 0;
    }

    public void openWindow() {
        openOrClosed = 1;
        System.out.println("Window opend");
    }

    public void closeWindow() {
        openOrClosed = 0;
        System.out.println("Window closed");
    }

}
