package model;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Shape;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * abstrakte Figure Ober-Klasse
 * Ich gehe davon aus, das wie in PowerPoint der Start- und der Endpunkt mit der Mouseübergeben werden
 * 
 * THB OMSI WS 20/21
 * 
 * @author friedemannrichard.pruss@th-brandenburg.de
 *
 */


public abstract class Figure {
	
	private static AtomicInteger count = new AtomicInteger(0);
	protected static final Point NULLPUNKT = new Point(0,0);
	private final int ID;
//	private static int count;
	private String name;
	private Paint fillColor;
	private Paint lineColor;
	private Point start;
	private Point end;
	protected double height;
	protected double width;
	
	/**
	 * default Konstruktor, erzeugt eine default Figure: Art(Name), weiße Füllung, blaue Linie, vom Mittelpunkt bis zum 2. Mousepunkt
	 */
	public Figure(String name) {
		this(name, Color.BLUE, Color.BLACK, NULLPUNKT, new Point(10, 10));
	}
	/**
	 * Konstruktor, erzeugt eine default Figure: Art(Name), weiße Füllung, blaue Linie, vom Start- zum Endpunkt aufgezogen wie in Powerpoint
	 * @param name
	 * @param start
	 * @param end
	 */
	public Figure(String name, Point start, Point end) {
		this(name, Color.BLUE, Color.BLACK, start, end);
	}
	/**
	 * Konstruktor
	 * @param name
	 * @param fillColor
	 * @param lineColor
	 * @param start
	 * @param end
	 */
	public Figure(String name, Paint fillColor, Paint lineColor, Point start, Point end) {
		this.ID = count.incrementAndGet();
		this.name = name;
		this.fillColor = fillColor;
		this.lineColor = lineColor;
		if(end == null) {
			this.end = new Point((start.getX() + 1), (start.getY() + 1));
		} else {
			this.end = end;
		}
		this.start = start;
		updateDimensions();
	}
	
	public abstract boolean pointIsInFigure(Point point);
	
	/**
	 * Mehtode zum umwandeln einer Figure in JavaFX.Shape
	 * @param
	 */
	public abstract Shape transformIntoShape();
	/**
	 * Methode zum Umwandeln eines javaFX.Shape in Figure
	 * @param shape
	 */
	public static Figure transformIntoFigure(Shape shape) {
		String shapeName = shape.getClass().getName().substring(19);
		switch(shapeName) {
		case "Circle":
			return MCircle.transformIntoFigure((javafx.scene.shape.Circle) shape);
		case "Ellipse":
			return MEllipse.transformIntoFigure((javafx.scene.shape.Ellipse) shape);
		case "Rectangle":
			return MRectangle.transformIntoFigure((javafx.scene.shape.Rectangle) shape);
		case "Line":
			return MLine.transformIntoFigure((javafx.scene.shape.Line) shape);
		case "Polygon":
			return MPolygon.transformIntoFigure((javafx.scene.shape.Polygon) shape);
		case "Square" :
			return MSquare.transformIntoFigure((javafx.scene.shape.Rectangle) shape);
		case "Triangle" :
			return MTriangle.transformIntoFigure((javafx.scene.shape.Polygon) shape);
		default: return null;
		}
	}
	/**
	 * Methode zum Anzeigen der Informationen der Figur
	 */
	public void showInfo() {
		System.out.println("shape: " + name);
		System.out.println("fill color: " + getFillColor());
		System.out.println("line color: " + getLineColor());
		System.out.println("startpoint at: " + getStart());
		System.out.println("endpoint at: " + getEnd());
		System.out.println("height: " + height);
		System.out.println("width: " + width);
		System.out.println("circumference: " + getCircumference());
		System.out.println("area: " + getArea());
	}
	/**
	 * toString() gibt die Höhe und die Breite wie in Powerpoint aus, muss in Linie überschrieben werden
	 * @return Höhe und Breite der Figur
	 */
	@Override
	public String toString() {
		return ("height: " + height + "\nwidth: " + width);
	}
	/**
	 * abstrakte Methoden zur Berechnung der Fläche, muss implementiert werden, um die Fläche bei show Info anzuzeigen
	 * @return
	 */
	public abstract double getArea();
	/**
	 * abstrakte Methoden zur Berechnung des Umfangs, muss implementiert werden, um den Umfang bei show Info anzuzeigen
	 * @return
	 */
	public abstract double getCircumference();
	
	/*
	 * die Dimensionen müssen nach jeder Änderung der Punkte updated werden
	 */
	protected void updateDimensions() {
		this.height = Math.abs(this.end.getY()-this.start.getY());
		this.width = Math.abs(this.end.getX()-this.start.getX());
	}
	/**
	 * Methode zum Seten der Dimensionen
	 * @param height
	 * @param width
	 */
	protected void setDimensions(double height, double width) {
		if(height <= 0 || width <= 0) {
			return;
		}
		this.height = height;
		this.width = width;
		double xOfNewEnd;
		double yOfNewEnd;
		if(this.start.getX() <= this.end.getX()) {
			xOfNewEnd = this.start.getX() + this.width;
		} else {
			xOfNewEnd = this.start.getX() - this.width;
		}
		if(this.start.getY() <= this.end.getY()) {
			yOfNewEnd = this.start.getY() + this.height;
		} else {
			yOfNewEnd = this.start.getY() - this.height;
		}
		setEnd(new Point(xOfNewEnd, yOfNewEnd));
	}
	
	//getters & setters
	
	public String getClassName() {
		return name;
	}
	public String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}

	public String getColors() {
		return "Fillcolor: " + fillColor + "\nLinecolor: " + lineColor;
	}
	
	public Paint getFillColor() {
		return fillColor;
	}
	protected void setFillColor(Paint color) {
		this.fillColor = color;
	}
	
	public Paint getLineColor() {
		return lineColor;
	}
	protected void setLineColor(Paint color) {
		this.lineColor = color;
	}

	public Point getStart() {
		return start;
	}
	public void setStart(Point start) {
		this.start = start;
		updateDimensions();
	}
	public Point getEnd() {
		return end;
	}
	public void setEnd(Point end) {
		this.end = end;
		updateDimensions();
	}
	//Höhe
	//die Höhe berechnet sich aus dem Betrag der y-Koordinate des Startpunkts plus der y-Koordinate des Endpunktes
	public void setHeight(double height) {
		setDimensions(height, this.width);
	}
	public double getHeight() {
		return height;
	}
	//Breite
	//die Breite berechnet sich aus dem Betrag der x-Koordinate des Startpunkts plus der x-Koordinate des Endpunktes
	public void setWidth(double width) {
		setDimensions(this.height, width);
	}
	public double getWidth() {
		return width;
	}
	
	public String getForm() {
		return this.name;
	}
	
	public int getID() {
		return ID;
	}
	
	public static int getCount() {
		return count.get();
	}

	public static void resetCount() {
		count.set(0);
	}
	@Override
	public int hashCode() {
		return ID/11;
	}
	@Override
	public boolean equals(Object fig) {
		if(this == fig) {
			return true;
		}
		if(!(fig instanceof Figure)) {
			return false;
		}
		Figure figure = (Figure) fig;
		return this.getID() == figure.getID();
	}
	
	public void decrementCount() {
		count.decrementAndGet();
	}
		
}
