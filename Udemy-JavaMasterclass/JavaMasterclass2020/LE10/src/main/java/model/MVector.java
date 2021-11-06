package model;

import javafx.scene.paint.Paint;

/**
 * Klasse zum Erzeugen einer Linie mit einem Pfeil am Anfang oder Ende oder beidem
 * 
 * THB OMSI WS 20/21
 * 
 * @author friedemannrichard.pruss@th-brandenburg.de
 *
 */

public class MVector extends MLine {
	private boolean startArrow;
	private boolean endArrow;
	/**
	 * default Konstruktor, erzeugt eine Linie mit Pfeil am Ende
	 */
	public MVector() {
		super();
		this.endArrow = true;
	}
	/**
	 * Konstruktor, erzeugt eine Linie aus den gegebenen Punkten, mit Pfeil am Ende
	 * @param start
	 * @param end
	 */
	public MVector(Point start, Point end) {
		super(start, end);
		this.endArrow = true;
	}
	/**
	 * Konstruktor, erzeugt eine Linie aus Start- und Endpunkten, mit oder ohne Pfeilen an Anfang und/oder Ende, Farbe
	 * @param color
	 * @param start
	 * @param end
	 * @param startArrow
	 * @param endArrow
	 */
	public MVector(Paint color, Point start, Point end, boolean startArrow, boolean endArrow) {
		super(color, start, end);
		this.startArrow = startArrow;
		this.endArrow = endArrow;
	}
	/**
	 * Methode zum Anzeigen des Start- und Endpunktes und der Länge der Linie
	 */
	@Override
	public void showInfo() {
		super.showInfo();
		if(hasStartArrow()) {
			System.out.println("has start arrow");
		}
		if(hasEndArrow()) {
			System.out.println("has end arrow");
		}
	}
	/** Getters & Setters
	 * 
	 */
	public boolean hasStartArrow() {
		return startArrow;
	}

	public void setStartArrow(boolean startArrow) {
		this.startArrow = startArrow;
	}

	public boolean hasEndArrow() {
		return endArrow;
	}

	public void setEndArrow(boolean endArrow) {
		this.endArrow = endArrow;
	}
	
}
