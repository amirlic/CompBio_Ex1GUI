package GUI;

import core.Logic;
import core.ProbsDeterminer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
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

    @FXML
    private Text globalIndex;

    @FXML
    private Text localIndex;

    private BoardController boardController;
    private Logic logic;

    public void initialize(URL location, ResourceBundle resources) {
        ProbsDeterminer probsDeterminer = new ProbsDeterminer(0.5,0.5,0.5,0.2);
        logic = new Logic(probsDeterminer);
        logic.getAutomaton().InitialAutomaton();

        this.boardController = new BoardController();
        this.boardController.setPrefWidth(500);
        this.boardController.setPrefHeight(500);
        root.getChildren().add(this.boardController);
        this.draw();
    }

    public void draw() {
        this.boardController.draw(this.logic.getAutomaton());
        this.globalTree.setText("" + logic.getAutomaton().getGlobalTree());
        this.globalFire.setText("" + logic.getAutomaton().getGlobalFire());
        this.globalEmpty.setText("" + logic.getAutomaton().getGlobalEmpty());
        this.localIndex.setText("" + logic.getAutomaton().getLocalIndex());
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        double globalIndex = (double)(logic.getAutomaton().getGlobalTree() + 1)/(logic.getAutomaton().getGlobalEmpty() + 1);
        this.globalIndex.setText("" + df.format(globalIndex));
    }

    @FXML
    public void makeMove() {
        logic.makeMove();
        this.draw();
    }
}
