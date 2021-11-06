package model;

import javafx.scene.paint.Paint;

/**
 * Klasse zum Erzeugen einer Linie
 * 
 * THB OMSI WS 20/21
 * 
 * @author friedemannrichard.pruss@th-brandenburg.de
 *
 */
public class MLine extends Figure {
	
	private double length;
	/**
	 * default Konstruktor, inklusive Hilfsmethode zum updaten der Länge
	 */
	public MLine() {
		super("Line");
		updateLength();
	}

	public MLine(Point start, Point end) {
		super("Line", start, end);
		updateLength();
	}
	/**
	 * Konstruktor
	 * @param color, eine Linie kann nur eine Farbe haben, deswegen wird diese für die fill-
	 * ebenso wie für die LineColor übergeben
	 * @param start
	 * @param end
	 */
	public MLine(Paint color, Point start, Point end) {
		super("Line", color, color, start, end);
		updateLength();
	}
	
	@Override
	public javafx.scene.shape.Line transformIntoShape() {
		javafx.scene.shape.Line line = new javafx.scene.shape.Line(getStart().getX(), getStart().getY(), getEnd().getX(), getEnd().getY());
		line.setFill(this.getFillColor());
		line.setStroke(this.getLineColor());
		return line;
	}
	
	public static MLine transformIntoFigure(javafx.scene.shape.Line shape) {


		return new MLine(shape.getStroke(),
				new Point(shape.getStartX(), shape.getStartY()),
				new Point(shape.getEndX(), shape.getEndY()));
	}
	@Override
	public boolean pointIsInFigure(Point point) {
		double startX = getStart().getX();
		double startY = getStart().getY();
		double endX = getEnd().getX();
		double endY = getEnd().getY();
		
		double det = (point.getX()-startX) * (endY-startY);
		det -= (point.getY()-startY) * (endX-startX);
		return (det == 0);
		
	}
	/** Methode zum Berechnen und aktualisieren der Länge der Linie
	 * 
	 */
	private void updateLength() {
		length = Math.pow((getEnd().getX()-getStart().getX()), 2);
		length += Math.pow((getEnd().getY()-getStart().getY()), 2);
		length = Math.sqrt(length);
	}
	/**
	 * Anzeige der parameter wie in Powerpoint
	 * @return Länge der Linie
	 */
	@Override
	public String toString() {
		return ("length: " + length);
	}
	/**
	 * getArea() und getCircumference werden zo überschrieben, dass sie 0 zurückgeben
	 */
	@Override
	public double getArea() {
		return 0;
	}
	@Override
	public double getCircumference() {
		return 0;
	}
	
	
	/*setDiemensions muss nicht überschrieben werden, da die setDimensions in der Klasse
	 * Figure den endpunkt neu setzt und dann die setend methode der Linie aufgerufen wird,
	 * die die länge updated*/

	/** Getters & Setters
	 * 
	 */
	//nach dem Setten eines neuen Startpunktes muss die Länge neu berechnet und aktualisiert werden
	@Override
	public void setStart(Point start) {
		super.setStart(start);
		updateLength();
	}
	//nach dem Setten eines neuen Endpunktes muss die Länge neu berechnet und aktualisiert werden
	@Override
	public void setEnd(Point end) {
		super.setEnd(end);
		updateLength();
	}
	public double getLength() {
		return length;
	}

	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		updateLength();
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		updateLength();
	}
	/**
	 * Methode zum Anzeigen des Start- und Endpunktes und der Länge der Linie
	 */
	@Override
	public void showInfo() {
		System.out.println("shape: line");
		System.out.println("color: " + getLineColor());
		System.out.println("startpoint: " + getStart());
		System.out.println("endpoint: " + getEnd());
		System.out.println("length: " + getLength());
	}
	
}
