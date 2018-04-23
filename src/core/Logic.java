package core;

import java.util.ArrayList;

// class logic
public class Logic {
    private Automaton automaton;

    // ctor
    public Logic() {
        this.automaton = new Automaton(100);
    }
    
    // ctor
    public Logic(ProbsDeterminer probsDeterminer){
        this.automaton = new Automaton(100, probsDeterminer);
    }

    // func make the move in the game
    public void makeMove() {
        this.automaton.setLocalIndex(0);
        boolean isChange;
        ArrayList<Cell> neighbors;
        Cell[][] matrix = this.automaton.getCopyMatrix();
        for (int i=1; i<99; i++) {
            for (int j=1; j<99; j++) {
                isChange = false;

                Cell cell = this.automaton.getMatrix()[i][j];
                Cell copyCell = matrix[i][j];
                neighbors = this.automaton.getNeighbors(i,j, matrix);

                if (copyCell.getState() == State.EMPTY) {
                    cell.setStateByProb("P", State.TREE, this.automaton);
                    isChange = true;
                }

                if (copyCell.getState() == State.FIRE && !isChange) {
                    cell.setState(State.EMPTY, this.automaton);
                    isChange = true;
                }

                if (copyCell.getState() == State.TREE) {
                    if (!isChange) {
                        for (Cell neighbor : neighbors) {
                            if (neighbor.getState() == State.FIRE) {
                                cell.setStateByProb("G", State.FIRE, this.automaton);
                                isChange = true;
                                break;
                            }
                        }
                        if (!isChange) {
                            cell.setStateByProb("F", State.FIRE, this.automaton);
                        }
                    }
                }
            }
        }
        int areasTrees[][] = new int[10][10];
        int areasEmptys[][] = new int[10][10];
        for (int i=1; i<99; i++) {
            for (int j=1; j<99; j++) {
                State cellState = this.automaton.getMatrix()[i][j].getState();
                if(cellState == State.TREE) {
                    areasTrees[i / 10][j / 10]++;
                } else {
                    if (cellState == State.EMPTY){
                        areasEmptys[i / 10][j / 10]++;
                    }
                }
            }
        }
        for (int i = 0;i<10;i++){
            for(int j = 0;j<10;j++){
                if (areasTrees[i][j] > this.automaton.getMostOfArea() || areasEmptys[i][j] > this.automaton.getMostOfArea()){
                    this.automaton.incAreasCounter();
                }
            }
        }
    }

    // func make huge move in the game
    public double makeHugeMove(){
        for (int i = 0;i<200;i++){
            this.makeMove();
        }
        return this.automaton.getLocalIndex();
    }

    // func get Automaton
    public Automaton getAutomaton() {
        return automaton;
    }

    // func print Board
    public void printBoard() {
        this.automaton.printBoard();
    }
}
