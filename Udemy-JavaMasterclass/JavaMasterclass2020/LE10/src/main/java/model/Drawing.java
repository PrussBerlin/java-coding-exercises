package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Klasse zum Verwalten der shapes einer Zeichnung
 * 
 * THB OMSI WS 20/21
 * 
 *
 * @author friedemannrichard.pruss@th-brandenburg.de
 * 
 */
public class Drawing {
	
	private ObservableList<Figure> figures;

	public Drawing() {
		figures = FXCollections.observableArrayList();
	}
	
	public void add(Figure figure) {
		System.out.println("figure added");
		if(figure != null) {
			figures.add(figure);
		}
		
	}
	
	public int size() {
		return figures.size();
	}
	
	public boolean removeFigure(Figure figure) {
		if(figures.contains(figure)) {
			return figures.remove(figure);
		} else {
			return false;
		}
	}
	
	public Figure removeFigure(int index) {
		if(figures.get(index) != null) {
			return figures.get(index);
		} else {
			return null;
		}
	}
	
	public int getIndex(Figure figure) {
		return figures.indexOf(figure);
		}
	
	public Figure getFigure(int id) {
		for(Figure f: figures) {
			if(f.getID() == id) {
				return f;
			}
		}
		return null;
	}
	
	public void showInfo(Figure figure) {
		if(figures.contains(figure)) {
			System.out.println("index: " + getIndex(figure));
			figure.showInfo();
		}
	}
	
	public void showInfo(int index) {
		if(figures.get(index) != null) {
			showInfo(figures.get(index));
		}
		
	}
	
	public void showAllFigures() {
		Figure[] figures = new Figure[this.figures.size()];
		figures = this.figures.toArray(figures);
		for(Figure figure : figures) {
			System.out.println(figure.getName());
		}
	}
	
	public void showAllFiguresInfo() {
		Figure[] figures = new Figure[this.figures.size()];
		figures = this.figures.toArray(figures);
		for(Figure figure : figures) {
			showInfo(figure);
		}
	}

	public ObservableList<Figure> getList() {
		return figures;
	}

	public void update(Figure f) {
		figures.set(figures.indexOf(f), f);
	}

	public void clear() {
		figures.clear();
		Figure.resetCount();
	}

}
