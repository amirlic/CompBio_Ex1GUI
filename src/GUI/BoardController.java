package GUI;

import core.Cell;
import core.Automaton;
import core.State;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoardController extends GridPane {

    public BoardController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Board.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
    }

    public void draw(Automaton otomat) {

        this.getChildren().clear();

        int height = (int)this.getPrefHeight();
        int width = (int)this.getPrefWidth();

        int cellHeight = height / otomat.getSize();
        int cellWidth = width / otomat.getSize();

        for (int i = 0; i < otomat.getSize(); i++) {
            for (int j = 0; j < otomat.getSize(); j++) {
                Cell cell = otomat.getMatrix()[i][j];

                if (cell.getState() == State.FIRE) {
                    Rectangle rect = new Rectangle(cellWidth, cellHeight, Color.RED);
                    rect.setStroke(Color.BLACK);
                    this.add(rect, j, i);
                }

                if (cell.getState() == State.TREE) {
                    Rectangle rect = new Rectangle(cellWidth, cellHeight, Color.GREEN);
                    rect.setStroke(Color.BLACK);
                    this.add(rect, j, i);
                }

                if (cell.getState() == State.EMPTY) {
                    Rectangle rect = new Rectangle(cellWidth, cellHeight, Color.GRAY);
                    rect.setStroke(Color.BLACK);
                    this.add(rect, j, i);
                }
            }
        }


    }
}
