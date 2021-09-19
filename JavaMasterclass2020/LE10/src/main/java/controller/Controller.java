package controller;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.*;

import java.text.DecimalFormat;

public class Controller {

    private Drawing drawing;
    private Point start;
    private Point end;
    private Figure figure;
    private static long lastTime;
    private boolean mouseWasDraged;
    private boolean heightTextFieldWasChanged;
    private boolean widthTextFieldWasChanged;
    private boolean idTextFieldWasChanged;
    private DecimalFormat df = new DecimalFormat("#.##");

    @FXML
    private TextField xCoordField;
    @FXML
    private TextField yCoordField;
    @FXML
    private Pane surface;
    @FXML
    private Label showShapeName;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private TextField widthTextField;
    @FXML
    private Label heightLabel;
    @FXML
    private Label widthLabel;
    @FXML
    private Label showCircumference;
    @FXML
    private Label showArea;
    @FXML
    private ChoiceBox<String> chosenShape;
    @FXML
    private ColorPicker lineColorBox;
    @FXML
    private ColorPicker fillColorBox;


    @FXML
    protected void initialize() {
        lastTime = 0;
        drawing = new Drawing();
        drawing.getList().addListener(new ListChangeListener<Figure>() {
            @Override
            public void onChanged(Change<? extends Figure> change) {
                if(change.next()) {
                    surface.getChildren().clear();
                    change.getList().stream().forEach(figure -> {
                        surface.getChildren().add(figure.transformIntoShape());
                    });
                }
            }
        });
        heightTextFieldWasChanged = false;
        widthTextFieldWasChanged = false;
        idTextFieldWasChanged = false;
        heightTextField.textProperty().addListener((observable, oldText, newText) -> {
            heightTextFieldWasChanged = true;
        });
        widthTextField.textProperty().addListener((observable, oldText, newText) -> {
            widthTextFieldWasChanged = true;
        });
        idTextField.textProperty().addListener((observable, oldText, newText) -> {
            idTextFieldWasChanged = true;
        });
    }

    @FXML
    protected void handleClear() {
        figure = null;
        displayFigureInfos(figure);
        drawing.clear();
    }
    @FXML
    protected void handleOkButton() {
        int idInTextField = Integer.parseInt(idTextField.getText());
        double heightInTextField = Double.parseDouble(heightTextField.getText());
        double widthInTextField = Double.parseDouble(widthTextField.getText());
        double xCoord = Double.parseDouble(xCoordField.getText());
        double yCoord = Double.parseDouble(yCoordField.getText());
        Point newStart = new Point(xCoord, yCoord);
        if(idInTextField > Figure.getCount() || idInTextField < 1 || heightInTextField < 1 || widthInTextField < 1 ||
                xCoord < 0 || yCoord < 0) {
            return;
        }
        if(figure != null && drawing != null) {
            figure.setStart(newStart);
            if(figure.getName().equals("Circle") || figure.getName().equals("Ellipse")) {
                if(heightTextFieldWasChanged) {
                    figure.setHeight(heightInTextField);
                }
            } else {
                if(heightTextFieldWasChanged) {
                    figure.setHeight(heightInTextField);
                }
                if(widthTextFieldWasChanged) {
                    figure.setWidth(widthInTextField);
                }
            }
            if(idTextFieldWasChanged) {
                figure = drawing.getFigure(Integer.parseInt(idTextField.getText()));
            }
            drawing.update(figure);
            displayFigureInfos(figure);
        }
    }
    @FXML
    protected void handleMouseDown(MouseEvent e) {
        mouseWasDraged = false;
        if(!e.isPrimaryButtonDown()) {
            return;
        }
//        long diff = 0;
//        boolean doubleClick = false;
//        long currentTime = System.currentTimeMillis();
//        if(lastTime != 0 && currentTime != 0){
//            diff = currentTime-lastTime;
//
//            if( diff <= 215 && diff > 0) {
                Point current = new Point(e.getX(), e.getY());
                for(Figure f : drawing.getList()) {
                    if(f == null) {
//                        lastTime = 0;
                        return;
                    }
                    if(f.pointIsInFigure(current)) {
                        figure = f;
                        displayFigureInfos(f);
//                        lastTime = 0;
                        return;
                    }
                }
//            }
//            lastTime = 0;
//        } else {
            start = new Point(e.getX(), e.getY());
//            lastTime = System.currentTimeMillis();
//        }
    }

    @FXML
    protected void handleMouseReleased(MouseEvent e) {
        if (!e.getButton().equals(MouseButton.PRIMARY) || !mouseWasDraged) {
            return;
        }
        String type = chosenShape.getValue();
        end = new Point(e.getX(), e.getY());
        switch(type) {
            case "Circle":
                figure = new MCircle(fillColorBox.getValue(), lineColorBox.getValue(), start, end);
                break;
            case "Ellipse":
                figure = new MEllipse(fillColorBox.getValue(), lineColorBox.getValue(), start, end);
                break;
            case "Square" :
                figure = new MSquare(fillColorBox.getValue(), lineColorBox.getValue(), start, end);
                break;
            case "Rectangle":
                figure = new MRectangle(fillColorBox.getValue(), lineColorBox.getValue(), start, end);
                break;
            case "Triangle" :
                figure = new MTriangle(fillColorBox.getValue(), lineColorBox.getValue(), start, end);
                break;
            case "Line":
                figure = new MLine(lineColorBox.getValue(), start, end);
                break;
            case "Polygon":
                figure = new MPolygon(fillColorBox.getValue(), lineColorBox.getValue(), start, end);
                break;
            default:
                break;
        }
        if(figure != null) {
            drawing.add(figure);
            displayFigureInfos(figure);
        }
    }

    @FXML
    protected void handleMouseDrag(MouseEvent e) {
        mouseWasDraged = true;
        lastTime = 0;
    }
    private void displayFigureInfos(Figure f) {
        if(figure == null) {
            showShapeName.setText("...");
            idTextField.setText("...");
            showCircumference.setText("...");
            showArea.setText("...");
            widthTextField.setVisible(true);
            widthLabel.setText("Width:");
            widthTextField.setText("...");
            heightLabel.setText("Height:");
            heightTextField.setText("...");
            xCoordField.setText("");
            yCoordField.setText("");
            return;
        }
        showShapeName.setText(f.getName());
        idTextField.setText("" + f.getID());
        showCircumference.setText(df.format(f.getCircumference()).replace(",", "."));
        showArea.setText(df.format(f.getArea()).replace(",", "."));
        xCoordField.setText("" + f.getStart().getX());
        yCoordField.setText("" + f.getStart().getY());
        if(figure.getName().equals("Circle") || figure.getName().equals("Ellipse")) {
            widthTextField.setVisible(false);
            widthLabel.setText("");
            heightLabel.setText("Radius:");
            heightTextField.setText("" + f.getHeight());
        } else {
            widthTextField.setVisible(true);
            widthLabel.setText("Width:");
            heightLabel.setText("Height:");
            heightTextField.setText("" + f.getHeight());
            widthTextField.setText("" + f.getWidth());
        }
    }
}
