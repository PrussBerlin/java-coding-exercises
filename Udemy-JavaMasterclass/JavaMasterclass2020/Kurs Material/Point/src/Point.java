public class Point {

    private int x;
    private int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance() {

        double distance = Math.pow(this.x, 2) + Math.pow(this.y, 2);
        distance = Math.sqrt(distance);
        return distance;
    }

    public double distance(int x, int y) {
        double sideA = y - this.y;
        sideA = Math.pow(sideA, 2);
        double sideB = x - this.x;
        sideB = Math.pow(sideB, 2);
        double distance = sideA + sideB;
        distance = Math.sqrt(distance);
        return distance;
    }

    public double distance(Point another) {
        return distance(another.x, another.y);

    }
}
