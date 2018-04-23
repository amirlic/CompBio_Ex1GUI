package core;

import java.util.ArrayList;
import java.util.Random;

public class Automaton {
    private int size;
    private Cell[][] matrix;

    private int globalTree;
    private int globalFire;
    private int globalEmpty;
    private int mostOfArea;
    private ProbsDeterminer probsDeterminer;
    private int localIndex;

    public Automaton(int size) {
        this.size = size;
        this.matrix = new Cell[size][size];
        this.probsDeterminer = new ProbsDeterminer(1,0,0,0);
        this.mostOfArea = (int)(0.67 * size);
        this.globalTree = 0;
        this.globalFire = 0;
        this.globalEmpty = 0;
    }

    public Automaton(int size, ProbsDeterminer probsDeterminer) {
        this.size = size;
        this.matrix = new Cell[size][size];
        this.mostOfArea = (int)(0.67 * size);
        this.globalTree = 0;
        this.globalFire = 0;
        this.globalEmpty = 0;
        this.probsDeterminer = probsDeterminer;
    }

    public void InitialAutomaton() {
        Random rnd = new Random();
        float prob;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                prob = rnd.nextFloat();
//                if (j == 1 && (i != 99 && i != 0)){
//                    this.matrix[i][j] = new Cell(State.FIRE,  this.probsDeterminer.getSpreadingProb(),
//                            this.probsDeterminer.getFireProb(), this.probsDeterminer.getTreeGrowingProb());
//                    this.globalFire++;
//                    continue;
//                }
                if ((prob <= this.probsDeterminer.getTreeExistenceProb()) && (i < 99 && i > 0) && (j < 99 && j > 0)) {
                    this.matrix[i][j] = new Cell(State.TREE, this.probsDeterminer.getSpreadingProb(),
                            this.probsDeterminer.getFireProb(), this.probsDeterminer.getTreeGrowingProb());
                    this.globalTree++;
                }
                else {
                    this.matrix[i][j] = new Cell(State.EMPTY,  this.probsDeterminer.getSpreadingProb(),
                            this.probsDeterminer.getFireProb(), this.probsDeterminer.getTreeGrowingProb());
                    this.globalEmpty++;
                }
            }
        }
    }

    public ArrayList<Cell> getNeighbors(int i, int j, Cell[][] matrix) {
        ArrayList neighbors = new ArrayList<Cell>();
        neighbors.add(matrix[i][j+1]);
        neighbors.add(matrix[i+1][j]);
        neighbors.add(matrix[i][j-1]);
        neighbors.add(matrix[i-1][j]);
//        neighbors.add(matrix[i-1][j-1]);
//        neighbors.add(matrix[i+1][j+1]);
//        neighbors.add(matrix[i-1][j+1]);
//        neighbors.add(matrix[i+1][j-1]);
        return neighbors;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public Cell[][] getCopyMatrix() {
        Cell[][] newMatrix = new Cell[size][size];
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                newMatrix[i][j] = this.matrix[i][j].copy();
            }
        }
        return newMatrix;
    }

    public void printBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(this.matrix[i][j].getState().toString().charAt(0) + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public int getGlobalEmpty() {
        return globalEmpty;
    }

    public int getGlobalFire() {
        return globalFire;
    }

    public int getGlobalTree() {
        return globalTree;
    }

    public void setGlobalEmpty() {
        this.globalEmpty++;
        this.globalFire--;
    }

    public void incAreasCounter() {
        localIndex++;
    }

    public int getLocalIndex() {
        return localIndex;
    }

    public void setLocalIndex(int localIndex) {
        this.localIndex = localIndex;
    }

    public int getMostOfArea() {
        return mostOfArea;
    }

    public void setGlobal(State next) {
        if (next == State.TREE) {
            this.globalEmpty--;
            this.globalTree++;
        }
        if (next == State.EMPTY) {
            this.globalFire--;
            this.globalEmpty++;
        }
        if (next == State.FIRE) {
            this.globalTree--;
            this.globalFire++;
        }
    }

    public double getGlobalIndex(){
        return (double)(this.globalTree + 1)/(this.globalEmpty + 1);
    }
}
