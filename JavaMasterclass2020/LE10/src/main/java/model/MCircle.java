package model;

import javafx.scene.paint.Paint;

/**
 * Klasse zum Erzeugen eines Kreises
 * 
 * THB OMSI WS 20/21
 * 
 *
 * @author friedemannrichard.pruss@th-brandenburg.de
 * 
 */
public class MCircle extends Figure {
	/**
	 * default Konstruktor, weiße Füllung, blaue Linie, im Mittelpunkt
	 */
	public MCircle() {
		super("Circle");
		updateRadius(NULLPUNKT, new Point(10, 10));
	}
	/**
	 * Konstruktor, weiße Füllung, blaue Linie, startpunkt ist der Mittelpunkt (center)
	 * @param center
	 * @param end
	 */
	public MCircle(Point center, Point end) {
		super("Circle", center, end);
		updateRadius(center, end);

	}
	/**
	 * Konstruktor
	 * @param fillColor
	 * @param lineColor
	 * @param center
	 * @param end
	 */
	public MCircle(Paint fillColor, Paint lineColor, Point center, Point end) {
		super("Circle", fillColor, lineColor, center, end);
		updateRadius(center, end);
	}
	
	
	@Override
	public javafx.scene.shape.Circle transformIntoShape() {
		javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(getStart().getX(), getStart().getY(), (height/2));
		circle.setFill(this.getFillColor());
		circle.setStroke(this.getLineColor());
		return circle;
	}
	
	public static MCircle transformIntoFigure(javafx.scene.shape.Circle shape) {
		Point center = new Point(shape.getCenterX(), shape.getCenterY());
		Point end = new Point((shape.getCenterX()+shape.getRadius()), shape.getCenterY());
		MCircle circle = new MCircle(shape.getFill(), shape.getStroke(), center, end);
		
		return circle;
	}
	
	@Override
	public boolean pointIsInFigure(Point point) {
		
		MLine distFromCenter = new MLine(getStart(), point);
		decrementCount();
		if(distFromCenter.getLength() <= height/2) {
			return true;
		}
		return false;
	}

	@Override
	protected void updateDimensions() {
		//Do nothing
	}
	private void updateRadius(Point center, Point end) {
		MLine radius = new MLine(center, end);
		decrementCount();
		this.height = radius.getLength() * 2;
		this.width = this.height;
	}
	
	/**
	 * Methode zum berechnen des Umfangs
	 * @return double circumference
	 */
	@Override
	public double getCircumference() {
		return 2 * Math.PI * getHeight()/2;
	}
	/**
	 * Methode zum berechnen der Fläche
	 * @return double area
	 */
	@Override
	public double getArea() {
		return Math.PI * getHeight()/2 * getHeight()/2;
	}
	/**
	 * Methode zum Anzeigen des Mittelpunkts, Radius, Umfangs, Fläche eines Kreises
	 */
	@Override
	public void showInfo() {
		System.out.println("shape: Circle");
		System.out.println("fill color: " + getFillColor());
		System.out.println("line color: " + getLineColor());
		System.out.println("centerpoint at: " + getStart());
		System.out.println("radius: " + (getHeight()/2));
		System.out.println("circumference: " + getCircumference());
		System.out.println("area: " + getArea());
	}
	
	@Override
	protected void setDimensions(double height, double width) {
		this.height = height;
		this.width = width;
	}
	@Override
	public void setStart(Point start) {
		updateRadius(start, this.getEnd());
		super.setStart(start);
	}
	@Override
	public void setEnd(Point end) {
		updateRadius(this.getStart(), end);
		super.setEnd(end);
	}
	@Override
	public void setHeight(double height) {
		setDimensions(height, height);
	}
	@Override
	public void setWidth(double width) {
		setDimensions(width, width);
	}
	
	
}
