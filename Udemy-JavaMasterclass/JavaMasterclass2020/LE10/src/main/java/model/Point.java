package model;
/**
 * Klasse zum Erzeugen eines Punktes
 * Grundlage für jede Form ist der Punkt an den die Mouse zuerst klickt (Ursprung) und der Punkt an den die Mouse zuletzt klickt
 * THB OMSI WS 20/21
 * 
 * @author friedemannrichard.pruss@th-brandenburg.de
 *
 */
public class Point implements Comparable<Point> {
	
	private double x;
	private double y;
	
	/**
	 * Point-Konstruktor
	 * @param x-Koordinate
	 * @param y-Koordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * gibt den Punkt als String zurück
	 * @return Punkt als String
	 */
	@Override
	public String toString() {
		return ("(" + x + ", " + y + ")");
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point point = (Point) obj;
			return (point.getX() == this.x) && (point.getY() == this.y);
		}
		return false;
		
	}

	@Override
	public int compareTo(Point point2) {
		if(point2.getX() == this.getX() && point2.getY() == this.getY()) {
			return 0;
		}
		if(this.getX() <= point2.getX() && this.getY() <= point2.getY()) {
			return -1;
		}
		return 1;
	}
	
	
}
