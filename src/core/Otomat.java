package core;

import java.util.ArrayList;
import java.util.Random;

public class Otomat {
    private int size;
    private Cell[][] matrix;
    private double probability;

    private int globalTree;
    private int globalFire;
    private int globalEmpty;

    public Otomat(int size, double probability) {
        this.size = size;
        this.matrix = new Cell[size][size];
        this.probability = probability;

        this.globalTree = 0;
        this.globalFire = 0;
        this.globalEmpty = 0;
    }

    public void InitialOtomat() {
        Random rnd = new Random();
        int prob;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                prob = rnd.nextInt(100);
                if ((prob <= this.probability*100) && (i < 99 && i > 0) && (j < 99 && j > 0)) {
                    this.matrix[i][j] = new Cell(State.TREE, 0.1, 0, 0);
                    this.globalTree++;
                }
                else {
                    this.matrix[i][j] = new Cell(State.EMPTE, 0, 0, 0);
                    this.globalEmpty++;
                }
            }
        }
    }

    public ArrayList<Cell> getNabers(int i, int j, Cell[][] matrix) {
        ArrayList nabers = new ArrayList<Cell>();
        nabers.add(matrix[i][j+1]);
        nabers.add(matrix[i+1][j]);
        nabers.add(matrix[i][j-1]);
        nabers.add(matrix[i-1][j]);
        return nabers;
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

    public void setGlobal(State next) {
        if (next == State.TREE) {
            this.globalEmpty--;
            this.globalTree++;
        }
        if (next == State.EMPTE) {
            this.globalFire--;
            this.globalEmpty++;
        }
        if (next == State.FIRE) {
            this.globalTree--;
            this.globalFire++;
        }
    }
}
