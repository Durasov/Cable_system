package model;

public class RungeKuttaParameters {
    private int rkparameters_id;
    private int parametrsId;
    private double h;
    private double t0;
    private double nmax;

    public RungeKuttaParameters(){

    }

    public RungeKuttaParameters(int rkparameters_id,int parametrsId,double h, double t0, double nmax) {
        this.rkparameters_id = rkparameters_id;
        this.parametrsId = parametrsId;
        this.h = h;
        this.t0 = t0;
        this.nmax = nmax;
    }

    public int getRkparameters_id() {
        return rkparameters_id;
    }

    public void setRkparameters_id(int rkparameters_id) {
        this.rkparameters_id = rkparameters_id;
    }

    public int getParametrsId() {
        return parametrsId;
    }

    public void setParametrsId(int parametrsId) {
        this.parametrsId = parametrsId;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getT0() {
        return t0;
    }

    public void setT0(double t0) {
        this.t0 = t0;
    }

    public double getNmax() {
        return nmax;
    }

    public void setNmax(double nmax) {
        this.nmax = nmax;
    }
}

