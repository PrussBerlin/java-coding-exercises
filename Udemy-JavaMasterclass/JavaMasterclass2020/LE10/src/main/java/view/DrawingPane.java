package view;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * DrawingPane, ESA LE10
 * 
 * THB OMSI WS 20/21
 * 
 *
 * @author friedemannrichard.pruss@th-brandenburg.de
 * @version 1.0
 * 
 */

public class DrawingPane extends Group {
	
	//Zeichenfläche erstellen
	public static Pane surface;
	
	//Index der Figur
	private int index;
	
	//Koordinaten der Mouse-Events
	private double xStart;
	private double yStart;
	private double xEnd;
	private double yEnd;
	
	
	/*
	 * Konstruktor
	 */
	public DrawingPane() {
		
		surface = new Pane();
		//background color
		surface.setStyle("-fx-background-color: white;");
		
		
//		Circle circle = new Circle(3, 4, 43);
//		getChildren().add(circle);
		getChildren().add(surface);
	}

	
	public void setPrefSize(BorderPane root) {
		surface.prefWidthProperty().bind(root.widthProperty());
		surface.prefWidthProperty().bind(root.heightProperty());
	}
	
}
