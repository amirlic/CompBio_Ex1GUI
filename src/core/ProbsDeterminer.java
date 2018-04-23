package core;

public class ProbsDeterminer {
    private double treeExistenceProb;
    private double treeGrowingProb;
    private double fireProb;
    private double spreadingProb;

    public ProbsDeterminer(double treeExistenceProb, double treeGrowingProb, double fireProb, double spreadingProb){
        this.fireProb = fireProb;
        this.spreadingProb = spreadingProb;
        this.treeGrowingProb = treeGrowingProb;
        this.treeExistenceProb = treeExistenceProb;
    }

    public double getFireProb() {
        return fireProb;
    }

    public double getSpreadingProb() {
        return spreadingProb;
    }

    public double getTreeGrowingProb() {
        return treeGrowingProb;
    }

    public double getTreeExistenceProb() {
        return treeExistenceProb;
    }

    public void setFireProb(double fireProb) {
        this.fireProb = fireProb;
    }

    public void setSpreadingProb(double spreadingProb) {
        this.spreadingProb = spreadingProb;
    }

    public void setTreeGrowingProb(double treeGrowingProb) {
        this.treeGrowingProb = treeGrowingProb;
    }

}
