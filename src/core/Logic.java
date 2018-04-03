package core;

import java.util.ArrayList;

public class Logic {
    private Otomat otomat;

    public Logic() {
        this.otomat = new Otomat(100, 1);
    }

    public void makeMove() {
        boolean isChange;
        ArrayList<Cell> nabers;
        Cell[][] matrix = this.otomat.getCopyMatrix();
        for (int i=1; i<99; i++) {
            for (int j=1; j<99; j++) {
                isChange = false;

                Cell cell = this.otomat.getMatrix()[i][j];
                Cell copyCell = matrix[i][j];
                nabers = this.otomat.getNabers(i,j, matrix);

                if (copyCell.getState() == State.EMPTE) {
                    cell.setStateByProb("P", State.TREE, this.otomat);
                    isChange = true;
                }

                if (copyCell.getState() == State.FIRE && !isChange) {
                    cell.setState(State.EMPTE, this.otomat);
                    isChange = true;
                }

                if (copyCell.getState() == State.TREE) {
                    if (!isChange) {
                        for (Cell naber : nabers) {
                            if (naber.getState() == State.FIRE) {
                                cell.setStateByProb("G", State.FIRE, this.otomat);
                                isChange = true;
                            }
                        }
                        if (!isChange) {
                            cell.setStateByProb("F", State.FIRE, this.otomat);
                        }
                    }
                }
            }
        }
    }

    public Otomat getOtomat() {
        return otomat;
    }

    public void printBoard() {
        this.otomat.printBoard();
    }
}
