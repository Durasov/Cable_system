package model;

public class Results {
    private int result_id;
    private int parametrsId;
    private double gamma1;
    private double alfa1;
    private double fi1;
    private double n;

    public Results(){

    }

    public Results(int result_id, int parametrsId, double gamma1, double alfa1, double fi1, double n){
        this.result_id = result_id;
        this.parametrsId = parametrsId;
        this.gamma1 = gamma1;
        this.alfa1 = alfa1;
        this.fi1 = fi1;
        this.n = n;
    }

    public int getResult_id() {
        return result_id;
    }

    public void setResult_id(int result_id) {
        this.result_id = result_id;
    }

    public int getParametrsId() {
        return parametrsId;
    }

    public void setParametrsId(int parametrsId) {
        this.parametrsId = parametrsId;
    }

    public double getGamma1() {
        return gamma1;
    }

    public void setGamma1(double gamma1) {
        this.gamma1 = gamma1;
    }

    public double getAlfa1() {
        return alfa1;
    }

    public void setAlfa1(double alfa1) {
        this.alfa1 = alfa1;
    }

    public double getFi1() {
        return fi1;
    }

    public void setFi1(double fi1) {
        this.fi1 = fi1;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }
}
