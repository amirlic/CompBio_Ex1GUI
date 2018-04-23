package core;

import java.util.Random;

// class cell
public class Cell {
    private State state;

    private double Gprob;
    private double Fprob;
    private double Pprob;
    //private double updatePprob;


    // ctor
    public Cell(State state, double Gprob, double Fprob, double Pprob) {
        this.state = state;

        this.Gprob = Gprob;
        this.Fprob = Fprob;
        this.Pprob = Pprob;
        //this.updatePprob = Pprob;
    }

    // copy ctor
    public Cell copy() {
        return new Cell(this.getState(), this.Gprob, this.Fprob, this.Pprob);
    }


    // func get state
    public State getState() {
        return state;
    }

    // func set state
    public void setState(State state, Automaton automaton) {
        this.state = state;
        automaton.setGlobalEmpty();
    }

    // func set State By Prob
    public void setStateByProb(String prob, State state, Automaton automaton) {
        Random rnd = new Random();
        float probability;
        probability = rnd.nextFloat();
        double probKind = this.getProb(prob);
        if (probability <= probKind) {
//            if(this.state == State.EMPTY){
//                this.updatePprob = this.Pprob;
//            }
            this.state = state;
            automaton.setGlobal(this.state);
        } //else{
//            if (this.state == State.EMPTY){
//                this.updatePprob *= 1.1;
//            }
        //}
    }

    // func get prob
    public double getProb(String prob) {
        switch (prob) {
            case "G" :
                return this.Gprob;
            case "F":
                return this.Fprob;
            case "P":
                //return this.updatePprob;
                return this.Pprob;
            default:
                return 0.5;
        }
    }
}
