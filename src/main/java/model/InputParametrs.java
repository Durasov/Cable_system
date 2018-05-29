package model;

public class InputParametrs {

    private int parametrsId;
    private double massFirst;
    private double massSecond;
    private double S1;
    private double S2;

    private double x1;
    private double y1;
    private double z1;

    private double x2;
    private double y2;
    private double z2;

    private double x3;
    private double y3;
    private double z3;

    private double ix1;
    private double iy1;
    private double iz1;
    private double ix2;
    private double iy2;
    private double iz2;

    private double cx1;
    private double cy1;
    private double cx2;
    private double cy2;

    private double my1;
    private double mz1;
    private double my2;
    private double mz2;

    private double w11;
    private double w12;
    private double w13;
    private double w21;
    private double w22;
    private double w23;
    private double w31;
    private double w32;
    private double w33;

    private double gamma1;
    private double alfa1;
    private double fi1;
    private double gamma2;
    private double alfa2;
    private double fi2;
    private double gamma3;
    private double alfa3;
    private double fi3;

    private double v;
    private double tetta;
    private double h;


    public InputParametrs() {
    }

    public InputParametrs(int parametrsId ,double massFirst, double massSecond, double S1, double S2,
                          double x1, double y1, double z1, double x2, double y2, double z2,
                          double x3, double y3, double z3, double ix1, double iy1, double iz1,
                          double ix2, double iy2, double iz2, double cx1, double cy1, double cx2, double cy2,
                          double my1, double mz1, double my2, double mz2, double w11, double w12, double w13,
                          double w21, double w22, double w23, double w31, double w32, double w33,
                          double gamma1, double alfa1, double fi1, double gamma2, double alfa2, double fi2,
                          double gamma3, double alfa3, double fi3, double v, double tetta, double h) {

        this.parametrsId = parametrsId;
        this.massFirst = massFirst;
        this.massSecond = massSecond;
        this.S1 = S1;
        this.S2 = S2;

        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;

        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;

        this.x3 = x3;
        this.y3 = y3;
        this.z3 = z3;

        this.ix1 = ix1;
        this.iy1 = iy1;
        this.iz1 = iz1;
        this.ix2 = ix2;
        this.iy2 = iy2;
        this.iz2 = iz2;

        this.cx1 = cx1;
        this.cy1 = cy1;
        this.cx2 = cx2;
        this.cy2 = cy2;

        this.my1 = my1;
        this.mz1 = mz1;
        this.my2 = my2;
        this.mz2 = mz2;

        this.w11 = w11;
        this.w12 = w12;
        this.w13 = w13;
        this.w21 = w21;
        this.w22 = w22;
        this.w23 = w23;
        this.w31 = w31;
        this.w32 = w32;
        this.w33 = w33;

        this.gamma1 = gamma1;
        this.alfa1 = alfa1;
        this.fi1 = fi1;
        this.gamma2 = gamma2;
        this.alfa2 = alfa2;
        this.fi2 = fi2;
        this.gamma3 = gamma3;
        this.alfa3 = alfa3;
        this.fi3 = fi3;

        this.v = v;
        this.tetta = tetta;
        this.h = h;

    }

    public int getParametrsId() {
        return parametrsId;
    }

    public void setParametrsId(int parametrsId) {
        this.parametrsId = parametrsId;
    }

    public double getMassFirst() {
        return massFirst;
    }

    public void setMassFirst(double massFirst) {
        this.massFirst = massFirst;
    }

    public double getMassSecond() {
        return massSecond;
    }

    public void setMassSecond(double massSecond) {
        this.massSecond = massSecond;
    }

    public double getS1() {
        return S1;
    }

    public void setS1(double s1) {
        S1 = s1;
    }

    public double getS2() {
        return S2;
    }

    public void setS2(double s2) {
        S2 = s2;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getZ1() {
        return z1;
    }

    public void setZ1(double z1) {
        this.z1 = z1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getZ2() {
        return z2;
    }

    public void setZ2(double z2) {
        this.z2 = z2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    public double getZ3() {
        return z3;
    }

    public void setZ3(double z3) {
        this.z3 = z3;
    }

    public double getIx1() {
        return ix1;
    }

    public void setIx1(double ix1) {
        this.ix1 = ix1;
    }

    public double getIy1() {
        return iy1;
    }

    public void setIy1(double iy1) {
        this.iy1 = iy1;
    }

    public double getIz1() {
        return iz1;
    }

    public void setIz1(double iz1) {
        this.iz1 = iz1;
    }

    public double getIx2() {
        return ix2;
    }

    public void setIx2(double ix2) {
        this.ix2 = ix2;
    }

    public double getIy2() {
        return iy2;
    }

    public void setIy2(double iy2) {
        this.iy2 = iy2;
    }

    public double getIz2() {
        return iz2;
    }

    public void setIz2(double iz2) {
        this.iz2 = iz2;
    }

    public double getCx1() {
        return cx1;
    }

    public void setCx1(double cx1) {
        this.cx1 = cx1;
    }

    public double getCy1() {
        return cy1;
    }

    public void setCy1(double cy1) {
        this.cy1 = cy1;
    }

    public double getCx2() {
        return cx2;
    }

    public void setCx2(double cx2) {
        this.cx2 = cx2;
    }

    public double getCy2() {
        return cy2;
    }

    public void setCy2(double cy2) {
        this.cy2 = cy2;
    }

    public double getMy1() {
        return my1;
    }

    public void setMy1(double my1) {
        this.my1 = my1;
    }

    public double getMz1() {
        return mz1;
    }

    public void setMz1(double mz1) {
        this.mz1 = mz1;
    }

    public double getMy2() {
        return my2;
    }

    public void setMy2(double my2) {
        this.my2 = my2;
    }

    public double getMz2() {
        return mz2;
    }

    public void setMz2(double mz2) {
        this.mz2 = mz2;
    }

    public double getW11() {
        return w11;
    }

    public void setW11(double w11) {
        this.w11 = w11;
    }

    public double getW12() {
        return w12;
    }

    public void setW12(double w12) {
        this.w12 = w12;
    }

    public double getW13() {
        return w13;
    }

    public void setW13(double w13) {
        this.w13 = w13;
    }

    public double getW21() {
        return w21;
    }

    public void setW21(double w21) {
        this.w21 = w21;
    }

    public double getW22() {
        return w22;
    }

    public void setW22(double w22) {
        this.w22 = w22;
    }

    public double getW23() {
        return w23;
    }

    public void setW23(double w23) {
        this.w23 = w23;
    }

    public double getW31() {
        return w31;
    }

    public void setW31(double w31) {
        this.w31 = w31;
    }

    public double getW32() {
        return w32;
    }

    public void setW32(double w32) {
        this.w32 = w32;
    }

    public double getW33() {
        return w33;
    }

    public void setW33(double w33) {
        this.w33 = w33;
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

    public double getGamma2() {
        return gamma2;
    }

    public void setGamma2(double gamma2) {
        this.gamma2 = gamma2;
    }

    public double getAlfa2() {
        return alfa2;
    }

    public void setAlfa2(double alfa2) {
        this.alfa2 = alfa2;
    }

    public double getFi2() {
        return fi2;
    }

    public void setFi2(double fi2) {
        this.fi2 = fi2;
    }

    public double getGamma3() {
        return gamma3;
    }

    public void setGamma3(double gamma3) {
        this.gamma3 = gamma3;
    }

    public double getAlfa3() {
        return alfa3;
    }

    public void setAlfa3(double alfa3) {
        this.alfa3 = alfa3;
    }

    public double getFi3() {
        return fi3;
    }

    public void setFi3(double fi3) {
        this.fi3 = fi3;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public double getTetta() {
        return tetta;
    }

    public void setTetta(double tetta) {
        this.tetta = tetta;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}

