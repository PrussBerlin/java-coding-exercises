package model;

import javafx.scene.paint.Paint;

/**
 * Klasse zum Erzeugen eine Ellipse
 * 
 * THB OMSI WS 20/21
 * 
 * @author friedemannrichard.pruss@th-brandenburg.de
 *
 */
public class MEllipse extends Figure {
	
	/**
	 * default Konstruktor, weiße Füllung, blaue Linie
	 */
	public MEllipse() {
		super("Ellipse");
		this.width *= 2;
		this.height *= 2;
	}
	/**
	 * Konstruktor, weiße Füllung, blaue Linie, Startpunkt ist der Mittelpunkt (center)
	 * @param center
	 * @param end
	 * @param
	 */
	public MEllipse(Point center, Point end) {
		super("Ellipse", center, end);
		this.width *= 2;
		this.height *= 2;
	}
	/**
	 * Konstruktor
	 * @param fillColor
	 * @param lineColor
	 * @param center
	 * @param end
	 */
	public MEllipse(Paint fillColor, Paint lineColor, Point center, Point end) {
		super("Ellipse", fillColor, lineColor, center, end);
		this.width *= 2;
		this.height *= 2;
	}
	
	@Override
	public javafx.scene.shape.Ellipse transformIntoShape() {
		javafx.scene.shape.Ellipse ellipse = new javafx.scene.shape.Ellipse(getStart().getX(), getStart().getY(), (getWidth()/2), (getHeight()/2));
		ellipse.setFill(this.getFillColor());
		ellipse.setStroke(this.getLineColor());
		return ellipse;
	}
	
	public static MEllipse transformIntoFigure(javafx.scene.shape.Ellipse shape) {
		Point center = new Point(shape.getCenterX(), shape.getCenterY());
		Point end = new Point((shape.getCenterX()+shape.getRadiusX()), (shape.getCenterY()+shape.getRadiusY()));
		MEllipse ellipse = new MEllipse(shape.getFill(), shape.getStroke(), center, end);
		
		return ellipse;
	}
	
	@Override
	public boolean pointIsInFigure(Point point) {
		double px = point.getX();
		double py = point.getY();
		double cx = getStart().getX();
		double cy = getStart().getY();
		double rx = width / 2;
		double ry = height / 2;
		double calc = Math.pow( ((px-cx) / rx), 2);
		calc += Math.pow( ((py-cy) / ry), 2);
		return calc <= 1;
	}

	/**
	 * Methode zum berechnen des Umfangs, nur Näherungsformel
	 * eine genauere Näherungsformel ist die kompliziertere Formel von Ramanujan
	 * @return double circumference
	 */
	@Override
	public double getCircumference() {
		double circumference = (getWidth()/2) * (getWidth()/2);
		circumference += (getHeight()/2) * (getHeight()/2);
		circumference = Math.PI * Math.sqrt(2*circumference);
		return circumference;
	}
	/**
	 * Methode zum berechnen der Fläche
	 * @return double area
	 */
	@Override
	public double getArea() {
		return getWidth()/2 * getHeight()/2 * Math.PI;
	}
	/**
	 * Methode zum Anzeigen des Mittelpunktes, der Halbachsen, des Umfangs und der Fläche der Ellipse
	 */
	@Override
	public void showInfo() {
		System.out.println("shape: Ellipse");
		System.out.println("fill color: " + getFillColor());
		System.out.println("line color: " + getLineColor());
		System.out.println("centerpoint at: " + getStart());
		System.out.println("semiMajorAxis: " + (getWidth()/2));
		System.out.println("semiMinorAxis: " + (getHeight()/2));
		System.out.println("circumference: " + getCircumference());
		System.out.println("area: " + getArea());
	}
}
