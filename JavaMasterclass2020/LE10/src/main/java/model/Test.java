package model;

public class Test {

	public static void main(String[] args) {

		//Test mit der Drawing Klasse
		Point start = new Point(0, 0);
		Point end = new Point(15, 10);
		Point pointC = new Point(133.0, 232.3);
		//Initialisierung der Zeichnung
		Drawing drawing = new Drawing();
		//Erzeugen der shapes
//		MCircle circle = new MCircle(start, end);
		
		//Test der Tranform Methoden
		//Erzeugen eines Javafx Circle und Ausgabe der Parameter
		javafx.scene.shape.Circle javaCircle = new javafx.scene.shape.Circle(4.4, 3.4, 2.4);
		System.out.println("javaFXCircle: " + javaCircle.toString());
		
		//Umwandel in Shape in Figure
		MCircle meinCircle = (MCircle) Figure.transformIntoFigure(javaCircle);
		System.out.println("javaCircle to meinCircle: ");
		meinCircle.showInfo();
		//umwandeln Figure in shape
		javafx.scene.shape.Circle javaCircle2 = meinCircle.transformIntoShape();
		System.out.println("meinCircle to javaFXCircle: " + javaCircle2.toString());
		


	}

}
