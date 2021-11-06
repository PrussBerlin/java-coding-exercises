package model;

import javafx.scene.paint.Paint;

/**
 * Klasse zum Erzeugen eines Dreiecks
 * 
 * THB OMSI WS 20/21
 * 
 *
 * @author friedemannrichard.pruss@th-brandenburg.de
 * 
 */
public class MTriangle extends Figure {

	//Point end in Figure is Point B in Triangle, point start is top left corner of a imaginary rectangle arround the triangle
	private Point pointA;
	private Point pointC;

	/**
	 * Konstruktor, Point end ist Point B = EckPunkt rechts unten
	 * @param start
	 * @param pointB (Mouse Click oben links: Math.abs(y dieses Punktes - Y des endpunktes) = height
	 * dementsprechend auch für width
	 */
	public MTriangle(Point start, Point pointB) {
		super("Triangle", start, pointB);
		updatePoints();
	}
	/**
	 * Konstruktor
	 * @param fillColor
	 * @param lineColor
	 * @param start
	 * @param pointB
	 */
	public MTriangle(Paint fillColor, Paint lineColor, Point start, Point pointB) {
		super("Triangle", fillColor, lineColor, start, pointB);
		updatePoints();
	}
	
	@Override
	public javafx.scene.shape.Polygon transformIntoShape() {
		javafx.scene.shape.Polygon triangle = new javafx.scene.shape.Polygon(pointA.getX(), pointA.getY(), getEnd().getX(), getEnd().getY(), pointC.getX(), pointC.getY());
		triangle.setFill(this.getFillColor());
		triangle.setStroke(this.getLineColor());
		return triangle;
	}
	
	public static MTriangle transformIntoFigure(javafx.scene.shape.Polygon shape) {
		Double[] d = new Double[shape.getPoints().size()];
		d = shape.getPoints().toArray(d);
		if(d.length < 3) {
			System.out.println("Not a Triangle");
			return null;
		}
		
		return new MTriangle(shape.getFill(), shape.getStroke(), new Point(d[0], d[1]), new Point(d[2], d[5]));
	}
	
	@Override
	public boolean pointIsInFigure(Point point) {
		double xAB = pointA.getX() - getStart().getX();
		double yAB = pointA.getY() - getStart().getY();
		double xBC = pointC.getX() - pointA.getX();
		double yBC = pointC.getY() - pointA.getY();
		double xCA = getStart().getX() - pointC.getX();
		double yCA = getStart().getX() - pointC.getY();
		double xAP = point.getX() - getStart().getX();
		double yAP = point.getY() - getStart().getY();
		double xBP = point.getX() - pointA.getX();
		double yBP = point.getY() - pointA.getY();
		double xCP = point.getX() - pointC.getX();
		double yCP = point.getY() - pointC.getY();
		
		double detABAP = (xAB * yAP) - (yAB * yAP);
		double detBCBP = (xBC * yBP) - (yBC * yBP);
		double detCACP = (xCA * yCP) - (yCA * yCP);
		if(Math.signum(detABAP) == Math.signum(detBCBP) && Math.signum(detBCBP) == Math.signum(detCACP)) {
			return true;
		}
		return false;
	}
	/*
	 * private Methode zum updaten der Eckpunkte, nachdem ein neuer Endpunkt gesetzt wurde
	 * oder die Height oder Width geändert wurde
	 */
	private void updatePoints() {
		this.pointA = new Point(getStart().getX(), getEnd().getY());
		double xOfPointC = getStart().getX() + (this.width / 2);
		this.pointC = new Point(xOfPointC, getStart().getY());
	}
	/**
	 * Methode zum Anzeigen der Koordinaten der Eckpunkte, des Umfangs und der Fläche
	 */
	@Override
	public void showInfo() {
		System.out.println("shape: triangle");
		System.out.println("Point A: " + getStart());
		System.out.println("Point B: " + this.pointA);
		System.out.println("Point C: " + this.pointC);
		System.out.println("height: " + getHeight());
		System.out.println("width: " + getWidth());
		System.out.println("circumference: " + getCircumference());
		System.out.println("area: " + getArea());
	}
	/**
	 * Methode zum berechnen des Umfangs
	 * @return double circumference
	 */
	@Override
	public double getCircumference() {
		MLine sideB = new MLine(getStart(), pointC);
		decrementCount();
		MLine sideA = new MLine(pointA, pointC);
		decrementCount();
		return getWidth() + sideB.getLength() + sideA.getLength();
	}
	/**
	 * Methode zum berechnen der Fläche
	 * @return double area
	 */
	public double getArea() {
		return (getWidth() * getHeight()) / 2.0;
	}
	/** 
	 *
	 * @param height
	 * @param width
	 */
	@Override
	public void setDimensions(double height, double width) {
		super.setDimensions(height, width);
		updatePoints();
	}
	/**
	 * getter und setter, nach dem Setzen eines Punktes müssen die Punkte geupdated werde und
	 * die Dimensionen neu ausgerechnet und geupdated werdenß
	 */
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	public Point getPointA() {
		return this.pointA;
	}
	public void setPointB(Point pointB) {
		setEnd(pointB);
//		this.pointB.setY(pointA.getY());
//		double xOfPointC = getStart().getX() + (this.width / 2);
//		double yOfPointC = getStart().getY() + (this.height);
//		this.pointC = new Point(xOfPointC, yOfPointC);

	}
	public Point getPointB() {
		return getEnd();
	}
	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	public Point getPointC() {
		return pointC;
	}
	/*setEnd() der Klasse Figure muss überschrieben werden, da die Punkte des Dreiecks danach geupdated
	 * werden müssen und danach wieder die Dimensionen ausgerechnet werden müssen*/
	@Override
	public void setEnd(Point end) {
		super.setEnd(end);
		updatePoints();
	}
}
