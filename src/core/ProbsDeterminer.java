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

    // get fire prob
    // return double
    public double getFireProb() {
        return fireProb;
    }

    // get Spreading Prob
    // return double
    public double getSpreadingProb() {
        return spreadingProb;
    }
    
    // get TreeGrowing Prob
    // return double
    public double getTreeGrowingProb() {
        return treeGrowingProb;
    }
    
    // get TreeExistence Prob
    // return double
    public double getTreeExistenceProb() {
        return treeExistenceProb;
    }

    // set Fire Prob
    // parm double
    public void setFireProb(double fireProb) {
        this.fireProb = fireProb;
    }

    //set Spreading Prob
    // parm double
    public void setSpreadingProb(double spreadingProb) {
        this.spreadingProb = spreadingProb;
    }
    
    // set TreeGrowing Prob
    // parm double
    public void setTreeGrowingProb(double treeGrowingProb) {
        this.treeGrowingProb = treeGrowingProb;
    }

}
