package core;

import java.util.Random;

public class Cell {
    private State state;

    private double Gprob;
    private double Fprob;
    private double Pprob;


    public Cell(State state, double Gprob, double Fprob, double Pprob) {
        this.state = state;

        this.Gprob = Gprob;
        this.Fprob = Fprob;
        this.Pprob = Pprob;
    }

    public Cell copy() {
        return new Cell(this.getState(), this.Gprob, this.Fprob, this.Pprob);
    }


    public State getState() {
        return state;
    }


    public void setState(State state, Otomat otomat) {
        this.state = state;
        otomat.setGlobalEmpty();
    }

    public void setStateByProb(String prob, State state, Otomat otomat) {
        Random rnd = new Random();
        int probability;
        probability = rnd.nextInt(100);
        double probKind = this.getProb(prob);
        if (probability <= probKind*100) {
            this.state = state;
            otomat.setGlobal(this.state);
        }
    }

    public double getProb(String prob) {
        switch (prob) {
            case "G" :
                return this.Gprob;
            case "F":
                return this.Fprob;
            case "P":
                return this.Pprob;
            default:
                return 0.5;
        }
    }
}
