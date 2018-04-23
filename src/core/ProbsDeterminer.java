package core;

// class ProbsDeterminer
public class ProbsDeterminer {
    private double treeExistenceProb;
    private double treeGrowingProb;
    private double fireProb;
    private double spreadingProb;

    // ctor
    public ProbsDeterminer(double treeExistenceProb, double treeGrowingProb, double fireProb, double spreadingProb){
        this.fireProb = fireProb;
        this.spreadingProb = spreadingProb;
        this.treeGrowingProb = treeGrowingProb;
        this.treeExistenceProb = treeExistenceProb;
    }

    // getFireProb
    public double getFireProb() {
        return fireProb;
    }

    // getSpreadingProb
    public double getSpreadingProb() {
        return spreadingProb;
    }
    
    // getTreeGrowingProb
    public double getTreeGrowingProb() {
        return treeGrowingProb;
    }
    
    // getTreeExistenceProb
    public double getTreeExistenceProb() {
        return treeExistenceProb;
    }

    // setFireProb
    public void setFireProb(double fireProb) {
        this.fireProb = fireProb;
    }

    //setSpreadingProb
    public void setSpreadingProb(double spreadingProb) {
        this.spreadingProb = spreadingProb;
    }
    
    // setTreeGrowingProb
    public void setTreeGrowingProb(double treeGrowingProb) {
        this.treeGrowingProb = treeGrowingProb;
    }

}
