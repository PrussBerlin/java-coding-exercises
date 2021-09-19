package model;

import javafx.scene.paint.Paint;

/**
 * Klasse zum Erzeugen eines Quadrats
 * 
 * THB OMSI WS 20/21
 * 
 *
 * @author friedemannrichard.pruss@th-brandenburg.de
 * 
 */
public class MSquare extends MRectangle {
	/**
	 * default Konstruktor
	 */
	public MSquare() {
		super();
		setName("Square");
//		setDimensions(this.width, this.width);
	}
	/**
	 * Konstruktor
	 * @param start
	 * @param end
	 */
	public MSquare(Point start, Point end) {
		super(start, end);
		setName("Square");
//		setDimensions(this.width, this.width);
	}
	/**
	 * 
	 * @param fillColor
	 * @param lineColor
	 * @param start
	 * @param end
	 */
	public MSquare(Paint fillColor, Paint lineColor, Point start, Point end) {
		super(fillColor, lineColor, start, end);
		setName("Square");
//		setDimensions(this.width, this.width);
	}
	@Override
	protected void setDimensions(double height, double width) {
		super.setDimensions(height, height);
	}
//	@Override
//	protected void setStart(Point start) {
//	}
	@Override
	public void setEnd(Point end) {
		super.setEnd(end);
//		setDimensions(this.width, this.width);
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
