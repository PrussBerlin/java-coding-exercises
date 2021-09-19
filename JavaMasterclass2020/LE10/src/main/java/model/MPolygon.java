package model;

import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.Arrays;



/**
 * Klasse zum Erzeugen eines regelmäßigen Polygons
 * 
 * THB OMSI WS 20/21
 * 
 *
 * @author friedemannrichard.pruss@th-brandenburg.de
 * 
 */
public class MPolygon extends Figure {
	//Anzahl der Ecken, nur eine Seitenlänge, da regelmäßiges Polygon und Startpunkt
	private Point[] points;
	
	public MPolygon() {
		super("Polygon");
	}
	/**
	 * Konstruktor
	 * @param fillColor
	 * @param lineColor
	 * @param start
	 * @param end
	 */
	public MPolygon(Paint fillColor, Paint lineColor, Point start, Point end) {
		super("Polygon");
		//pointA == start
		Point pointB = new Point(end.getX(), start.getY());
		//pointC == end
		Point pointD = new Point(((start.getX()+end.getX())/2), end.getY()+start.getY());
		Point pointE = new Point(start.getX(), pointB.getY());
		this.points = new Point[5];
		this.points[0]= start;
		this.points[1]= pointB;
		this.points[2]= end;
		this.points[3]= pointD;
		this.points[4]= pointE;
	}
	
	@Override
	public javafx.scene.shape.Polygon transformIntoShape() {
		double[] coord = new double[points.length];
		for(int i = 0; i < coord.length; i++) {
			double x = points[i].getX();
			double y = points[i].getY();
			coord[i] = x;
			coord[++i] = y;
		}
		return new javafx.scene.shape.Polygon(coord);
	}
	
	public static MPolygon transformIntoFigure(javafx.scene.shape.Polygon shape) {
		Double[] pointsInShape = new Double[shape.getPoints().size()];
		//die Punkte des JavaFX Shapes als Array
		pointsInShape = shape.getPoints().toArray(pointsInShape);

		Point[] pointArr = new Point[pointsInShape.length];

		for(int i = 0, j = 0; i < (pointArr.length); i++) {
			pointArr[i] = new Point(pointsInShape[j], pointsInShape[++j]);
			j++;
		}
		Arrays.sort(pointArr);
		MPolygon polygon = new MPolygon(shape.getFill(), shape.getStroke(), pointArr[0], pointArr[4]);
		
		return polygon;
	}
	
	@Override
	public boolean pointIsInFigure(Point point) {
		double px = point.getX();
		double py = point.getY();
		double xMin = points[0].getX();
		double xMax = points[points.length-1].getX();
		double yMin = points[0].getY();
		double yMax = points[points.length-1].getY();
		
		if(px < xMin || px > xMax || py < yMin || py > yMax) {
			return false;
		}
		int corners = points.length;
		double[] vertx = new double[corners];
		double[] verty = new double[corners];
		for(int k = 0; k < corners; k++) {
			vertx[k] = points[k].getX();
			verty[k] = points[k].getY();
		}
		
		int i, j, c = 0;
		  for (i = 0, j = corners-1; i < corners; j = i++) {
		    if ( ((verty[i]>py) != (verty[j]>py)) &&
		     (px < (vertx[j]-vertx[i]) * (py-verty[i]) / (verty[j]-verty[i]) + vertx[i]) )
		       c = ~c;
		  }
		  return (c == 1);
	}
	/**
	 * Methode zum berechnen des Umfangs
	 * @return double circumference
	 */
	public double getCircumference() {
		//TODO Linien als Attribute, um die Längen der Seiten zu ermitteln und Umfang
		return 0;
	}
	/**
	 * Methode zum berechnen des Flächeninhalts
	 * @return double area
	 */
	public double getArea() {
		//TODO Linien als Attribute, um die Längen der Seiten zu ermitteln und Area
		return 0;
	}
	/**
	 * Methode zum Anzeigen der Anzahl der Ecken, der Seitenlänge, des Umfangs und der Fläche
	 */
	@Override
	public String toString() {
		return super.toString() + "\nPoints:" + points + 
				"\nSeitenlänge : " +
				"\ncircumference = " + getCircumference() +
				"\narea = " + getArea();
	}
	/**
	 * Methode zum Anzeigen der Informationen der Figur
	 */
	public void showInfo() {
		System.out.println("shape: Polygon");
		System.out.println("Points: " + points);
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
	 * getter und setter
	 */
	public Point[] getPoints() {
		return points;
	}
	
	
	
	
	

}
