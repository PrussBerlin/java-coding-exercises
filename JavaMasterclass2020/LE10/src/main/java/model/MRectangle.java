package model;

import javafx.scene.paint.Paint;

/**
 * Klasse zum Erzeugen eines Rechtecks
 * 
 * THB OMSI WS 20/21
 * 
 *
 * @author friedemannrichard.pruss@th-brandenburg.de
 * 
 */
public class MRectangle extends Figure {
	
	/**
	 * default Konstruktor
	 */
	public MRectangle() {
		super("Rectangle");
	}
	/**
	 * Konstruktor, Ekce links oben ist Startpunkt, Ecke links unten Endpunkt
	 * @param start
	 * @param end
	 */
	public MRectangle(Point start, Point end) {
		super("Rectangle", start, end);
	}
	/**
	 * 
	 * @param fillColor
	 * @param lineColor
	 * @param start
	 * @param end
	 */
	public MRectangle(Paint fillColor, Paint lineColor, Point start, Point end) {
		super("Rectangle", fillColor, lineColor, start, end);
	}
	
	@Override
	public javafx.scene.shape.Rectangle transformIntoShape() {
		javafx.scene.shape.Rectangle rectangle = new javafx.scene.shape.Rectangle(getStart().getX(), getStart().getY(), getWidth(), getHeight());
		rectangle.setFill(this.getFillColor());
		rectangle.setStroke(this.getLineColor());
		return rectangle;
	}
	
	public static MRectangle transformIntoFigure(javafx.scene.shape.Rectangle shape) {
		Point start = new Point(shape.getX(), (shape.getY()+shape.getHeight()));
		Point end = new Point((shape.getX()+shape.getWidth()), shape.getY());
		
		MRectangle rectangle = new MRectangle(shape.getFill(), shape.getStroke(), start, end);
		
		return rectangle;
	}
	@Override
	public boolean pointIsInFigure(Point point) {
		if(point.getX() >= getStart().getX() && point.getX() <= getEnd().getX() && 
			point.getY() >= getStart().getY() && point.getY() <= getEnd().getY()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Methode zum berechnen des Umfangs
	 * @return double circumference
	 */
	@Override
	public double getCircumference() {
		return 2 * (getHeight() + getWidth());
	}
	/**
	 * Methode zum berechnen der Fläche
	 * @return double area
	 */
	@Override
	public double getArea() {
		return getHeight() * getWidth();
	}
}
