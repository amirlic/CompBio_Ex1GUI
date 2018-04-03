package sample;

import core.Logic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private HBox root;

    @FXML
    private Text globalTree;

    @FXML
    private Text globalFire;

    @FXML
    private Text globalEmpty;

    private BoardController boardController;
    private Logic logic;

    public void initialize(URL location, ResourceBundle resources) {

        logic = new Logic();
        logic.getOtomat().InitialOtomat();

        this.boardController = new BoardController();
        this.boardController.setPrefWidth(500);
        this.boardController.setPrefHeight(500);
        root.getChildren().add(this.boardController);
        this.draw();
    }

    public void draw() {
        this.boardController.draw(this.logic.getOtomat());
        this.globalTree.setText("" + logic.getOtomat().getGlobalTree());
        this.globalFire.setText("" + logic.getOtomat().getGlobalFire());
        this.globalEmpty.setText("" + logic.getOtomat().getGlobalEmpty());
    }

    @FXML
    public void makeMove() {
        logic.makeMove();
        this.draw();
    }
}
