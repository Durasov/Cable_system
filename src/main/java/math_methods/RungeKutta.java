package math_methods;

import java.util.ArrayList;
import java.util.List;

public class RungeKutta {
    private static double g0 = 9.80665;
    private static double R3 = 6371020;
    private static final double PI = 3.14;
    private static double[] RA1 = new double[3];
    private static double[] RA2 = new double[3];
    private static double [][] Lx = new double[3][3];
    private static double[][] L1T = new double[3][3];
    private static double[][] L2T = new double[3][3];
    private static double[][] L3T = new double[3][3];
    private static double m1m2;
    private static double m1m;
    private static double m2m;
    //Массы 1 и 2 тел соответственно
    private static double mass1;
    private static double mass2;
    private static double[][] a1 = new double[8][9];
    private static double Ix1;
    private static double Iy1;
    private static double Iz1;
    private static double Ix2;
    private static double Iy2;
    private static double Iz2;
    private static double my1;
    private static double mz1;
    private static double mz2;
    private static double my2;
    private static double x1,y1,z1,x2,y2,z2,x3,y3,z3;
    private static double[] omega1 = new double[3];
    private static double[] omega2 = new double[3];
    private static double[] omega3 = new double[3];
    private static double[] r1 = new double[3];
    private static double[] r2 = new double[3];
    private static double[] r3 = new double[3];
    private static double[] WxR = new double[3];
    private static double[] WxR1 = new double[3];
    private static double[] WxR2 = new double[3];
    private static double[] WxR3 = new double[3];
    private static double[] WxWxR1 = new double[3];
    private static double[] WxWxR2 = new double[3];
    private static double[] WxWxR3 = new double[3];
    private static double[] R1W = new double[3];
    private static double[] R2W = new double[3];
    private static double[][] L13 = new double[3][3];
    private static double ro;
    private static double g; //ускорение свободного падения
    private static double Cx1;
    private static double Cy1;
    private static double Cx2;
    private static double Cy2;
    private static double S1;
    private static double S2;
    private static double Cyp1;
    private static double Cx1p;
    private static double Cyp2;
    private static double Cx2p;
    private static double Rx1;
    private static double Rx2;
    private static double Ry1;
    private static double Ry2;
    private static double Rxv;
    private static double Cyv2;
    private static double Cyv1;
    private static double q;
    private static double[] r1R2 = new double[3];
    private static double[] r1R1 = new double[3];
    private static double[] r2R1 = new double[3];
    private static double[] r2R2 = new double[3];
    //private static double[] b1 = new double [17];
    private static double[] rad1 = new double[3];
    private static double[] rad2 = new double[3];
    private static double[] rad3 = new double[3];
    private static double[] w1r1 = new double[3];
    private static double[] w2r2 = new double[3];
    private static double[] w3r3 = new double[3];
    private static double[] d_omega1 = new double[3];
    private static double[] d_omega2 = new double[3];
    private static double[] w1w1r1 = new double[3];
    private static double[] w2w2r2 = new double[3];
    private static double[] dw1r1 = new double[3];
    private static double[] dw2r2 = new double[3];
    private static double[] N1 = new double[3];
    private static double[] N1_1 = new double[3];
    private static double[] N1_2 = new double[3];
    private static double[] N1_3 = new double[3];
    private static double ModR1;
    private static double ModR2;
    private static double ModV1;
    private static double ModV2;
    private static double cosA1;
    private static double cosA2;
    private static double AL1;
    private static double AL2;
    private static double[] VC = new double[3];
    private static double[] V1C = new double[3];
    private static double[] V2C = new double[3];
    private static double[] R3W = new double[3];
    private static double[] RA1p = new double[3];
    private static double[] RA2p = new double[3];
    private static double N1abs;

    private static List <Double> f = new ArrayList<Double>(17);
    private static List <Double> x0 = new ArrayList<Double>(20);

    private static List<Double> NList = new ArrayList<Double>(15);

    private static List<Double> XList = new ArrayList<Double>(15);

    private static List<Double> X0 = new ArrayList<Double>(15);
    private static List<Double> Y0 = new ArrayList<Double>(15);
    private static List<Double> k11 = new ArrayList<Double>(15);
    private static List<Double> k22 = new ArrayList<Double>(15);
    private static List<Double> k33 = new ArrayList<Double>(15);
    private static List<Double> k44 = new ArrayList<Double>(15);
    private static List<Double> Alfa1 = new ArrayList<Double>(15);
    private static List<Double> Gamma1 = new ArrayList<Double>(15);
    private static List<Double> Fi1 = new ArrayList<Double>(15);
    private static List<Double> H = new ArrayList<Double>(15);
    private static List<Double> R0 = new ArrayList<Double>(15);
    private static List<Double> qList = new ArrayList<Double>(15);

    public static void ReadInitialParameters(double massFirst, double massSecond, double s1, double s2, double X1, double Y1,
                                             double Z1, double X2, double Y2, double Z2, double X3, double Y3, double Z3,
                                             double ix1, double iy1, double iz1, double ix2, double iy2, double iz2,
                                             double cx1, double cy1, double cx2, double cy2, double My1, double Mz1, double My2, double Mz2,
                                             double w11, double w12, double w13, double w21, double w22, double w23,
                                             double w31, double w32, double w33, double gamma1, double alfa1, double fi1,
                                             double gamma2, double alfa2, double fi2, double gamma3, double alfa3, double fi3,
                                             double v, double tetta, double h){

        if(k11.size() > 0){
            k11.clear();
        }

        if(k22.size() > 0){
            k22.clear();
        }

        if(k33.size() > 0){
            k33.clear();
        }

        if(k44.size() > 0){
            k44.clear();
        }

        if(f.size() > 0){
            f.clear();
        }

        if(x0.size() > 0){
            x0.clear();
        }

        if(Y0.size() > 0){
            Y0.clear();
        }

        if (XList.size() > 0){
            XList.clear();
        }

        if (Alfa1.size() > 0){
            Alfa1.clear();
        }

        if (NList.size() > 0){
            NList.clear();
        }

        if(H.size() > 0){
            H.clear();
        }

        if(R0.size() > 0){
            R0.clear();
        }

        if(qList.size() > 0){
            qList.clear();
        }
        //Всё что выше делаем для того, чтобы при повторном вызове списки не были заполнены.

        mass1 = massFirst;
        mass2 = massSecond;

        S1 = s1;
        S2 = s2;

        x1 = X1;
        y1 = Y1;
        z1 = Z1;
        x2 = X2;
        y2 = Y2;
        z2 = Z2;
        x3 = X3;
        y3 = Y3;
        z3 = Z3;

        Ix1 =  ix1;
        Iy1 = iy1;
        Iz1 =  iz1;
        Ix2 =  ix2;
        Iy2 = iy2;
        Iz2 =  iz2;

        Cx1 = cx1;
        Cy1 = cy1;
        Cx2 = cx2;
        Cy2 = cy2;

        my1 = My1;
        mz1 = Mz1;
        my2 = My2;
        mz2 = Mz2;


        Y0.add(0,w11);
        Y0.add(1,w12);
        Y0.add(2,w13);
        Y0.add(3,w21);
        Y0.add(4,w22);
        Y0.add(5,w23);
        Y0.add(6,w32);
        Y0.add(7,w33);
        Y0.add(8,gamma1);
        Y0.add(9,alfa1);
        Y0.add(10,fi1);
        Y0.add(11,gamma2);
        Y0.add(12,alfa2);
        Y0.add(13,fi2);
        Y0.add(14,gamma3);
        Y0.add(15,alfa3);
        Y0.add(16,fi3);
        Y0.add(17,v);
        Y0.add(18,tetta);
        Y0.add(19,h);

        for(int i = 8;i<17;i++){
            Y0.set(i,Y0.get(i)*Math.PI/180);
        }
        Y0.set(18,Y0.get(18)*Math.PI/180);

        for(int i = 0; i < 20; i++){
            k11.add(i,0.0);
            k22.add(i,0.0);
            k33.add(i,0.0);
            k44.add(i,0.0);
            f.add(i,0.0);
        }
    }

    static double arccos(double x){
        double b;
        if (x >= 1){
            x = 1.-1e-10;
        }
        if (x <= -1){
            x = -1.+1e-10;
        }
        b = Math.sqrt(1-x*x)/x;
        b = Math.atan(b);
        if ( x < 0){
            b = -b + Math.PI;

        }
        return b;
    }

    static void PROF (double t, List<Double> x, List<Double> f) {
        double[] b1 = new double [17];
        //Вычисление матрицы L
        //Матрицы элементарных поворотов
        double [][] Lg1 = {
                { 1, 0, 0 },
                { Math.cos(x.get(8)), Math.sin(x.get(8)), 0 },
                { 0, -Math.sin(x.get(8)), Math.cos(x.get(8)) }
        };

        double [][] La1 = {
                { Math.cos(x.get(9)), Math.sin(x.get(9)), 0 },
                { -Math.sin(x.get(9)), Math.cos(x.get(9)), 0 },
                { 0, 0, 1 }
        };

        double [][] Lf1 = {
                { 1, 0, 0 },
                { 0, Math.cos(x.get(10)), Math.sin(x.get(10)) },
                { 0, -Math.sin(x.get(10)), Math.cos(x.get(10)) }
        };

        double [][] Lg2 = {
                { 1, 0, 0 },
                { 0, Math.cos(x.get(11)), Math.sin(x.get(11)) },
                { 0, -Math.sin(x.get(11)), Math.cos(x.get(11)) }
        };

        double [][] La2 = {
                { Math.cos(x.get(12)), Math.sin(x.get(12)), 0 },
                { -Math.sin(x.get(12)), Math.cos(x.get(12)), 0 },
                { 0, 0, 1 }
        };

        double [][] Lf2 = {
                { 1, 0, 0 },
                { 0, Math.cos(x.get(13)), Math.sin(x.get(13)) },
                { 0, -Math.sin(x.get(13)), Math.cos(x.get(13)) }
        };

        double [][] Lg3 = {
                { 1, 0, 0 },
                { 0, Math.cos(x.get(14)), Math.sin(x.get(14)) },
                { 0, -Math.sin(x.get(14)), Math.cos(x.get(14)) }
        };

        double [][] La3 = {
                { Math.cos(x.get(15)), Math.sin(x.get(15)), 0 },
                { -Math.sin(x.get(15)), Math.cos(x.get(15)), 0 },
                { 0, 0, 1 }
        };

        double [][] Lf3 = {
                { 1, 0, 0 },
                { 0, Math.cos(x.get(16)), Math.sin(x.get(16)) },
                { 0, -Math.sin(x.get(16)), Math.cos(x.get(16)) }
        };

        //Матрица L1<-TP
        double[][] La1Lg1 = MatrixOperations.Mul_Matr_33_33(La1,Lg1);
        double[][] L1 = MatrixOperations.Mul_Matr_33_33(Lf1,La1Lg1); //Матрица перехода от траекторной с.к. к с.к, связанной с первым телом

        //Матрица L2<-TP
        double[][] La2Lg2 = MatrixOperations.Mul_Matr_33_33(La2,Lg2);
        double[][] L2 = MatrixOperations.Mul_Matr_33_33(Lf2,La2Lg2); //Матрица перехода от траекторной с.к. к с.к, связанной со вторым телом

        //Матрица L3<-TP
        double[][] La3Lg3 = MatrixOperations.Mul_Matr_33_33(La3,Lg3);
        double[][] L3 = MatrixOperations.Mul_Matr_33_33(Lf3,La3Lg3); ////Матрица перехода от траекторной с.к. к с.к, связанной со вторым телом

        //L1  - от траекторной к связанной СК1
        //L2  - от траекторной к связанной СК2
        //L3  - от траекторной к связанной СК3

        L1T = MatrixOperations.New_Transp_Matr_33(L1); //L1T - от СК1 к траекторной
        L2T = MatrixOperations.New_Transp_Matr_33(L2); //L2T - от СК2 к траекторной
        L3T = MatrixOperations.New_Transp_Matr_33(L3); //L3T - от СК3 к траекторной

        double[][] L11 = MatrixOperations.Mul_Matr_33_33(L1,L1T);
        double[][] L12 = MatrixOperations.Mul_Matr_33_33(L2,L1T);
        double[][] L13 = MatrixOperations.Mul_Matr_33_33(L3,L1T);

        double[][] L21 = MatrixOperations.Mul_Matr_33_33(L1,L2T);
        double[][] L22 = MatrixOperations.Mul_Matr_33_33(L2,L2T);
        double[][] L23 = MatrixOperations.Mul_Matr_33_33(L3,L2T);

        double[][] L31 = MatrixOperations.Mul_Matr_33_33(L1,L3T);
        double[][] L32 = MatrixOperations.Mul_Matr_33_33(L2,L3T);
        double[][] L33 = MatrixOperations.Mul_Matr_33_33(L3,L3T);

        //L21 - от СК2 к СК1}
        //L12 - от СК1 к СК2}
        //L31 - от СК3 к СК1}
        //L32 - от СК3 к СК2}
        //L23 - от СК2 к СК3}

        m1m2 = mass1*mass2/(mass1+mass2);
        m1m = mass1/(mass1+mass2);
        m2m = mass2/(mass1+mass2);

        //Матрица переменных коэффициентов, зависящих от углового положения и угловых скоростей каждого тела.
        a1[0][0] = Ix1+m1m2*(y1*y1+z1*z1);
        a1[0][1] = -m1m2*x1*y1;
        a1[0][2] = -m1m2*x1*z1;
        a1[1][0] = -m1m2*x1*y1;
        a1[1][1] = Iy1+m1m2*(x1*x1+z1*z1);
        a1[1][2] = -m1m2*y1*z1;
        a1[2][0] = -m1m2*x1*z1;
        a1[2][1] = -m1m2*y1*z1;
        a1[2][2] = Iz1+m1m2*(x1*x1+y1*y1);

        //Матрица сделана как в книге (стр. 105) От 2 к 1 (L21)
        a1[0][3] = -m1m2*((y1*L21[2][1]-z1*L21[1][1])*z2-(y1*L21[2][2]-z1*L21[1][2])*y2);
        a1[0][4] = -m1m2*((y1*L21[2][2]-z1*L21[1][2])*x2-(y1*L21[2][0]-z1*L21[1][0])*z2);
        a1[0][5] = -m1m2*((y1*L21[2][0]-z1*L21[1][0])*y2-(y1*L21[2][1]-z1*L21[1][1])*x2);
        a1[1][3] = -m1m2*((z1*L21[0][2]-x1*L21[2][2])*z2-(z1*L21[0][1]-x1*L21[2][1])*y2); //!
        a1[1][4] = -m1m2*((z1*L21[0][0]-x1*L21[2][0])*x2-(z1*L21[0][2]-x1*L21[2][2])*z2); //!
        a1[1][5] = -m1m2*((z1*L21[0][1]-x1*L21[2][1])*y2-(z1*L21[0][0]-x1*L21[2][0])*x2);
        a1[2][3] = -m1m2*((x1*L21[1][2]-y1*L21[0][2])*z2-(x1*L21[1][1]-y1*L21[0][1])*y2);
        a1[2][4] = -m1m2*((x1*L21[1][0]-y1*L21[0][0])*x2-(x1*L21[1][2]-y1*L21[0][2])*z2);
        a1[2][5] = -m1m2*((x1*L21[1][1]-y1*L21[0][1])*y2-(x1*L21[1][0]-y1*L21[0][0])*x2);

        //Матрица сделана как в книге (стр. 105)
        a1[3][0] = -m1m2*((y1*L21[2][2]-z1*L21[1][2])*y2-(y1*L21[2][1]-z1*L21[1][1])*z2);
        a1[3][1] = -m1m2*((z1*L21[0][2]-x1*L21[2][2])*y2-(z1*L21[0][1]-x1*L21[2][1])*z2);
        a1[3][2] = -m1m2*((x1*L21[1][2]-y1*L21[0][2])*y2-(x1*L21[1][1]-y1*L21[0][1])*z2);
        a1[4][0] = -m1m2*((y1*L21[2][0]-z1*L21[1][0])*z2-(y1*L21[2][2]-z1*L21[1][2])*x2);
        a1[4][1] = -m1m2*((z1*L21[0][0]-x1*L21[2][0])*z2-(z1*L21[0][2]-x1*L21[2][2])*x2);
        a1[4][2] = -m1m2*((x1*L21[1][0]-y1*L21[0][0])*z2-(x1*L21[1][2]-y1*L21[0][2])*x2);
        a1[5][0] = -m1m2*((y1*L21[2][1]-z1*L21[1][1])*x2-(y1*L21[2][0]-z1*L21[1][0])*y2);
        a1[5][1] = -m1m2*((z1*L21[0][1]-x1*L21[2][1])*x2-(z1*L21[0][0]-x1*L21[2][0])*y2);
        a1[5][2] = -m1m2*((x1*L21[1][1]-y1*L21[0][1])*x2-(x1*L21[1][0]-y1*L21[0][0])*y2);

        //Матрица сделана как в книге (стр. 105)
        a1[3][3] = Ix2+m1m2*(y2*y2+z2*z2);
        a1[3][4] = -m1m2*x2*y2;
        a1[3][5] = -m1m2*x2*z2;
        a1[4][3] = -m1m2*x2*y2;
        a1[4][4] = Iy2+m1m2*(x2*x2+z2*z2);
        a1[4][5] = -m1m2*y2*z2;
        a1[5][3] = -m1m2*x2*z2;
        a1[5][4] = -m1m2*y2*z2;
        a1[5][5] = Iz2+m1m2*(x2*x2+y2*y2);

        //Матрица сделана как в книге (стр. 105)
        a1[0][6] = -m1m2*(L31[1][2]*z1-L31[2][2]*y1)*x3;
        a1[0][7] = -m1m2*(L31[2][1]*y1-L31[1][1]*z1)*x3;
        a1[1][6] = -m1m2*(L31[2][2]*x1-L31[0][2]*z1)*x3; //gde eto?
        a1[1][7] = -m1m2*(L31[0][1]*z1-L31[2][1]*x1)*x3;
        a1[2][6] = -m1m2*(L31[0][2]*y1-L31[1][2]*x1)*x3;
        a1[2][7] = -m1m2*(L31[1][1]*x1-L31[0][1]*y1)*x3;

        //Матрица сделана как в книге (стр. 105)
        a1[6][0] = -m1m2*(L13[2][2]*y1-L13[2][1]*z1);
        a1[6][1] = -m1m2*(L13[2][0]*z1-L13[2][2]*x1);//gde eto?
        a1[6][2] = -m1m2*(L13[2][1]*x1-L13[2][0]*y1);
        a1[6][3] = -m1m2*(L23[2][2]*y2-L23[2][1]*z2);
        a1[6][4] = -m1m2*(L23[2][0]*z2-L23[2][2]*x2);
        a1[6][5] = -m1m2*(L23[2][1]*x2-L23[2][0]*y2);
        a1[6][6] = m1m2*x3; //!!
        a1[6][7] = 0.0;

        //Матрица сделана как в книге (стр. 105)
        a1[3][6] = -m1m2*(L32[1][2]*z2-L32[2][2]*y2)*x3;
        a1[3][7] = -m1m2*(L32[2][1]*y2-L32[1][1]*z2)*x3;
        a1[4][6] = -m1m2*(L32[2][2]*x2-L32[0][2]*z2)*x3;
        a1[4][7] = -m1m2*(L32[0][1]*z2-L32[2][1]*x2)*x3;
        a1[5][6] = -m1m2*(L32[0][2]*y2-L32[1][2]*x2)*x3;
        a1[5][7] = -m1m2*(L32[1][1]*x2-L32[1][0]*y2)*x3;

        a1[7][0] = -m1m2*(L13[1][2]*y1-L13[1][1]*z1);
        a1[7][1] = -m1m2*(L13[1][0]*z1-L13[1][2]*x1);
        a1[7][2] = -m1m2*(L13[1][1]*x1-L13[1][0]*y1);
        a1[7][3] = -m1m2*(L23[1][2]*y2-L23[1][1]*z2);
        a1[7][4] = -m1m2*(L23[1][0]*z2-L23[1][2]*x2);
        a1[7][5] = -m1m2*(L23[1][1]*x2-L23[1][0]*y2);
        a1[7][6] = 0.0;
        a1[7][7] = -m1m2*x3; //!!

        // делаем матрицу симметричной
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j<i; j++) {
                a1[j][i] = a1[i][j];
            }
        }

        //Задание матрицы правых частей уравнения A*omega` = B
        omega1[0] = x.get(0);
        omega1[1] = x.get(1);
        omega1[2] = x.get(2);

        omega2[0] = x.get(3);
        omega2[1] = x.get(4);
        omega2[2] = x.get(5);

        omega3[0] = 0;
        omega3[1] = x.get(6);
        omega3[2] = x.get(7);

        r1[0] = x1;
        r1[1] = y1;
        r1[2] = z1;

        r2[0] = x2;
        r2[1] = y2;
        r2[2] = z2;

        r3[0] = x3;
        r3[1] = y3;
        r3[2] = z3;

        MatrixOperations.Vect_Vect_31(omega1,r1,WxR1);
        MatrixOperations.Vect_Vect_31(omega1,WxR1,WxWxR1); //!!!!!!!
        MatrixOperations.Vect_Vect_31(omega2,r2,WxR2);
        MatrixOperations.Vect_Vect_31(omega2,WxR2,WxWxR2);
        MatrixOperations.Vect_Vect_31(omega3,r3,WxR3);
        MatrixOperations.Vect_Vect_31(omega3,WxR3,WxWxR3);

        double[] WxWxR1_TR = MatrixOperations.Mul_Matr_33_31(L1T,WxR1);
        double[] WxWxR2_TR = MatrixOperations.Mul_Matr_33_31(L2T,WxR2);
        double[] WxWxR3_TR = MatrixOperations.Mul_Matr_33_31(L3T,WxR3);

        double[] S12 = MatrixOperations.AddM_Matr_31(WxWxR2_TR,WxWxR1_TR);
        double[] S123 = MatrixOperations.Add_Matr_31(S12,WxWxR3_TR);

        MatrixOperations.Mul_Matr_31_Num(S123,mass2/(mass1+mass2),V1C);
        MatrixOperations.Mul_Matr_31_Num(S123,-mass1/(mass1+mass2),V2C); //стр. 29 формула 2.26

        VC[0] = x.get(17);
        VC[1] = 0;
        VC[2] = 0;

        double[] V1 = MatrixOperations.Add_Matr_31(VC,V1C);
        double[] V2 = MatrixOperations.Add_Matr_31(VC,V2C);

        double[] V1_CK1 = MatrixOperations.Mul_Matr_33_31(L1,V1);
        double[] V2_CK2 = MatrixOperations.Mul_Matr_33_31(L2,V2);

        ModR1 = MatrixOperations.Modul_Vect(r1);
        ModV1 = MatrixOperations.Modul_Vect(V1);
        cosA1 = -(r1[0]*V1_CK1[0]+r1[1]*V1_CK1[1]+r1[2]*V1_CK1[2])/ModR1/ModV1;

        ModR2 = MatrixOperations.Modul_Vect(r2);
        ModV2 = MatrixOperations.Modul_Vect(V2);
        cosA2 = (r2[0]*V2_CK2[0]+r2[1]*V2_CK2[1]+r2[2]*V2_CK2[2])/ModR2/ModV2;

        AL1 = arccos(cosA1);
        AL2 = arccos(cosA2);
        //AL1 = Math.acos(cosA1);
        //AL2 = Math.acos(cosA2);

        double[] WxWxR1_CK2 = MatrixOperations.Mul_Matr_33_31(L12,WxWxR1);
        double[] WxWxR1_CK3 = MatrixOperations.Mul_Matr_33_31(L13,WxWxR1);
        double[] WxWxR2_CK1 = MatrixOperations.Mul_Matr_33_31(L21,WxWxR2);
        double[] WxWxR2_CK3 = MatrixOperations.Mul_Matr_33_31(L23,WxWxR2);
        double[] WxWxR3_CK1 = MatrixOperations.Mul_Matr_33_31(L31,WxWxR3);
        double[] WxWxR3_CK2 = MatrixOperations.Mul_Matr_33_31(L32,WxWxR3);

        double[] W2subW1 = MatrixOperations.AddM_Matr_31(WxWxR2_CK1,WxWxR1);
        double[] W2subW1addW3_CK1 = MatrixOperations.Add_Matr_31(W2subW1,WxWxR3_CK1);

        double[] W1subW2 = MatrixOperations.AddM_Matr_31(WxWxR1_CK2,WxWxR2);
        double[] W1subW2addW3_CK2 = MatrixOperations.AddM_Matr_31(W1subW2,WxWxR3_CK2);

        W2subW1 = MatrixOperations.AddM_Matr_31(WxWxR2_CK3,WxWxR1_CK3);
        double[] W2subW1addW3_CK3 = MatrixOperations.Add_Matr_31(W2subW1,WxWxR3);

        MatrixOperations.Vect_Vect_31(r1,W2subW1addW3_CK1,R1W);
        MatrixOperations.Vect_Vect_31(r2,W1subW2addW3_CK2,R2W);
        //MatrixOperations.Vect_Vect_31(r3,W2subW1addW3_CK3,R3W);

        R3W[0] = 0;
        R3W[1] = W2subW1addW3_CK3[2];
        R3W[2] = W2subW1addW3_CK3[1];

        g = g0 * Math.pow(R3/(R3+x.get(19)),2); //ускорение свободного падения на высоте H, R3 - радиус Земли
        ro = 1.225 * Math.exp(-x.get(19)/7000); //плотность воздуха на высоте H
        q = 0.5 * ro * (x.get(17) * x.get(17)); //скоростной напор
        R0.add(ro);
        qList.add(q);

        RA1p[0] = Cx1 * Math.cos(AL1) * q * S1;
        RA1p[1] = Cy1 * Math.sin(AL1) * q * S1;
        RA1p[2] = 0;

        RA2p[0] = Cx2 * Math.cos(AL2) *q * S2;
        RA2p[1] = Cy2 * Math.sin(AL2) * q * S2;
        RA2p[2] =0;

        Cx1p = Cx1 * Math.cos(AL1);
        Cyp1 = Cy1 * Math.sin(AL1);
        Cx2p = Cx2 * Math.cos(AL2);
        Cyp2 = Cy2 * Math.sin(AL2);
        Cyv1 = Cyp1 * Math.cos(AL1) + Cx1p * Math.sin(AL1);
        Cyv2 = Cyp2 * Math.cos(AL2) + Cx2p * Math.sin(AL2);

        MatrixOperations.Transp_Matr_33(L1,Lx);
        RA1 = MatrixOperations.Mul_Matr_33_31(Lx, RA1p);
        MatrixOperations.Transp_Matr_33(L2,Lx);
        RA2 = MatrixOperations.Mul_Matr_33_31(Lx, RA2p);

        double[] r10 = MatrixOperations.Mul_Matr_33_31(L1, RA1);
        MatrixOperations.Vect_Vect_31(r1,r10,r1R1);
        r10 = MatrixOperations.Mul_Matr_33_31(L1, RA2);
        MatrixOperations.Vect_Vect_31(r1,r10,r1R2);

        r10 = MatrixOperations.Mul_Matr_33_31(L2, RA1);
        MatrixOperations.Vect_Vect_31(r2,r10,r2R1);
        r10 = MatrixOperations.Mul_Matr_33_31(L2, RA2);
        MatrixOperations.Vect_Vect_31(r2,r10,r2R2);

        double[] r3R1 = MatrixOperations.Mul_Matr_33_31(L3, RA1);
        double[] r3R2 = MatrixOperations.Mul_Matr_33_31(L3, RA2);


        /*a1[0][8] = m1m*r1R2[0] - m2m*r1R1[0] + m1m2*R1W[0];
        a1[1][8] = 0.0;
        a1[2][8] = 0.0;
        a1[3][8] = 0.0;
        a1[4][8] = 0.0;
        a1[5][8] = 0.0;
        a1[6][8] = 0.0;
        a1[7][8] = 0.0;*/

        a1[0][8] = m1m*r1R2[0] - m2m*r1R1[0] + m1m2*R1W[0];
        a1[1][8] = m1m*r1R2[1] - m2m*r1R1[1] + m1m2*R1W[1];
        a1[2][8] = m1m*r1R2[2] - m2m*r1R1[2] + m1m2*R1W[2];

        a1[3][8] = m2m*r2R1[0] - m1m*r2R2[0] + m1m2*R2W[0];
        a1[4][8] = m2m*r2R1[1] - m1m*r2R2[1] + m1m2*R2W[1];
        a1[5][8] = m2m*r2R1[2] - m1m*r2R2[2] + m1m2*R2W[2];

        a1[6][8] = m1m*r3R2[2] - m2m*r3R1[2] + m1m2*R3W[1];
        a1[7][8] = m1m*r3R2[1] - m2m*r3R1[1] + m1m2*R3W[2];

        double[] omega = new double[8];
        for(int i = 0; i < 8; i++){
            omega[i] = x.get(i);
        }
        double[] a2 = new double[8];
        for(int i = 0; i < 8; i++){
            a2[i] = a1[i][8];
        }
        double[] newb = Gaus.gaussSeidel(a1,a2);

        //b1 - полученная в результате решения матричного уравнения
        //матрица с заполненными первыми 6 элементами
        b1[8] = (x.get(2) * Math.sin(x.get(10)) - x.get(1) * Math.cos(x.get(10))) / Math.sin(x.get(9));
        b1[9] = x.get(2) * Math.cos(x.get(10)) + x.get(1) * Math.sin(x.get(10)) - (Cyv1*q*S1+Cyv2*q*S2)/(mass1+mass2)/x.get(17);
        b1[10] = x.get(0) - b1[8] * Math.cos(x.get(9));
        b1[11] = x.get(5) * Math.sin(x.get(13)) - x.get(4) * Math.cos(x.get(13)) / Math.sin(x.get(12));
        b1[12] = x.get(5) * Math.cos(x.get(13)) + x.get(4) * Math.sin(x.get(13)) - (Cyv1*q*S1+Cyv2*q*S2)/(mass1+mass2)/x.get(17);
        b1[13] = x.get(3) - b1[11] * Math.cos(x.get(12));
        b1[14] = (x.get(7) * Math.sin(x.get(16))-x.get(6)*Math.cos(x.get(16))/Math.sin(x.get(15)));
        b1[15] = x.get(7) * Math.cos(x.get(16))+x.get(6)*Math.sin(x.get(16));
        b1[16] = -b1[14] * Math.cos(x.get(15));


        Rx1 = Cx1*Math.cos(AL1)*q*S1;
        Ry1 = Cy1*Math.sin(AL1)*q*S1;
        Rx2 = Cx2*Math.cos(AL2)*q*S2;
        Ry2 = Cy2*Math.sin(AL2)*q*S2;

        Rxv = Rx1*Math.cos(AL1)-Ry1*Math.sin(AL1)+Rx2*Math.cos(AL2)-Ry2*Math.cos(AL2);

        f.set(0, newb[0]);
        f.set(1, (newb[1] + my1 * q * S1 * Math.abs(x1)));
        f.set(2, (newb[2] + mz1 * q * S1 * Math.abs(x1)));
        f.set(3, newb[3]);
        f.set(4, (newb[4] + my2 * q * S2 * Math.abs(x2)));
        f.set(5, (newb[5] + mz2 * q * S2 * Math.abs(x2)));
        f.set(6, (newb[6]));
        f.set(7, (newb[7]));

        for(int i = 8; i < 17; i++){
            f.set(i, b1[i]);
        }

        f.set(17, (Rxv/(mass1+mass2)) - (g * Math.sin(x.get(18)))); //x.get(18) это tetta - угол наклона траектории
        f.set(18, (-(g-(x.get(17)*x.get(17)/(R3+x.get(19)))) * Math.cos(x.get(18)))/x.get(17));
        f.set(19, x.get(17) * Math.sin(x.get(18)));
        //f.set(17,7700.0);

        //Вычисление силы N1
        rad1[0] = x1;
        rad1[1] = y1;
        rad1[2] = z1;

        rad2[0] = x2;
        rad2[1] = y2;
        rad2[2] = z2;

        rad3[0] = x3; //x3 - длина троса
        rad3[1] = 0;
        rad3[2] = 0;

        MatrixOperations.Vect_Vect_31(omega2,rad2,w2r2);
        MatrixOperations.Vect_Vect_31(omega1,rad1,w1r1);
        MatrixOperations.Vect_Vect_31(omega3,rad3,w3r3);

        d_omega1[0] = f.get(0);
        d_omega1[1] = f.get(1);
        d_omega1[2] = f.get(2);
        d_omega2[0] = f.get(3);
        d_omega2[1] = f.get(4);
        d_omega2[2] = f.get(5);

        MatrixOperations.Vect_Vect_31(d_omega1,rad1,dw1r1);
        MatrixOperations.Vect_Vect_31(d_omega2,rad2,dw2r2);
        MatrixOperations.Vect_Vect_31(omega1,w1r1,w1w1r1);
        MatrixOperations.Vect_Vect_31(omega2,w2r2,w2w2r2);

        double[] dw1r1_T = MatrixOperations.Mul_Matr_33_31(L1T,dw1r1);
        double[] dw2r2_T = MatrixOperations.Mul_Matr_33_31(L2T,dw2r2);
        double[] w1w1r1_T = MatrixOperations.Mul_Matr_33_31(L1T,w1w1r1);
        double[] w2w2r2_T = MatrixOperations.Mul_Matr_33_31(L2T,w2w2r2);

        double[] d2r1dt2_T = MatrixOperations.Add_Matr_31(dw1r1_T,w1w1r1_T);
        double[] d2r2dt2_T = MatrixOperations.Add_Matr_31(dw2r2_T,w2w2r2_T);

        double[] W1C = MatrixOperations.AddM_Matr_31(d2r2dt2_T,d2r1dt2_T); //ускорение центра масс КА относительно центра масс связки

        MatrixOperations.Mul_Matr_31_Num(RA2,mass1/(mass1+mass2),N1_1);
        MatrixOperations.Mul_Matr_31_Num(RA1,-mass1/(mass1+mass2),N1_2);
        MatrixOperations.Mul_Matr_31_Num(W1C,mass1*mass2/(mass1+mass2),N1_3);

        N1[0] = N1_1[0]+N1_2[0]+N1_3[0]; //N - это сила натяжения троса
        N1[1] = N1_1[1]+N1_2[1]+N1_3[1];
        N1[2] = N1_1[2]+N1_2[2]+N1_3[2];

        N1abs = MatrixOperations.Modul_Vect(N1)/10;
    }

    public static void Runge_Kutta4(double h, double x0, int nmax){

        /*mass1 = 10;
        mass2 = 0.2;
        x1 = -1;
        y1 = 0;
        z1 = 0;
        x2 = 1;
        y2 = 0;
        z2 = 0;
        x3 = 16;
        y3 = 0;
        z3 = 0;

        Y0.add(0,2.0);
        Y0.add(1,1.0);
        Y0.add(2,0.0);
        Y0.add(3,2.0);
        Y0.add(4,1.0);
        Y0.add(5,0.0);
        Y0.add(6,0.0);
        Y0.add(7,0.0);

        Y0.add(8,0.0);
        Y0.add(9,10.0);
        Y0.add(10,0.0);
        Y0.add(11,0.0);
        Y0.add(12,10.0);
        Y0.add(13,0.0);

        Y0.add(14,0.0);
        Y0.add(15,10.0);
        Y0.add(16,0.0);
        Y0.add(17,7800.0);
        Y0.add(18,-2.0);
        Y0.add(19,110000.0);

        Ix1 =  0.32;
        Iy1 = 0.32;
        Iz1 =  0.32;
        Ix2 =  0.128;
        Iy2 = 0.128;
        Iz2 =  0.128;

        S1 = 0.13;
        S2 = 0.3;

        Cx1 = -1;
        Cy1 = 2;
        Cx2 = -1;
        Cy2 = 5;

        my1 = 0.0;
        mz1 = 0.0;
        my2 = 0.0;
        mz2 = 0.0;

        for(int i = 8;i<17;i++){
            Y0.set(i,Y0.get(i)*Math.PI/180);
        }
        Y0.set(18,Y0.get(18)*Math.PI/180);

        for(int i = 0; i < 20; i++){
            k11.add(i,0.0);
            k22.add(i,0.0);
            k33.add(i,0.0);
            k44.add(i,0.0);
            f.add(i,0.0);
        }*/
        //==============================================================================================================
        for(x0 = 0; x0 < nmax; x0+=h) {

            PROF(x0,Y0,f); //k1
            for(int i = 0; i < 20; i++) {
                k11.set(i, f.get(i));
            }
            XList.add(x0);
            Gamma1.add(Math.abs(Y0.get(8) * 180/Math.PI));
            Alfa1.add(Math.abs(Y0.get(9) * 180/Math.PI));
            Fi1.add(Math.abs(Y0.get(10) * 180/Math.PI));
            NList.add(N1abs); //добавляем в массив силу натяжения троса
            H.add(Y0.get(19));

            for(int i = 0; i < 20; i++) {
                k22.set(i, Y0.get(i) + (h * k11.get(i)) / 2);
                Y0.set(i, Y0.get(i) + (h * k11.get(i)) / 2);
            }
            PROF(x0,Y0,k22);//k2
            XList.add(x0 + h / 2);
            Gamma1.add(Math.abs(Y0.get(8) * 180/Math.PI));
            Alfa1.add(Math.abs(Y0.get(9) * 180/Math.PI));
            Fi1.add(Math.abs(Y0.get(10) * 180/Math.PI));
            NList.add(N1abs); //добавляем в массив силу натяжения троса
            H.add(Y0.get(19));

            for(int i = 0; i < 20; i++) {
                k33.set(i, Y0.get(i) + (h * k22.get(i)) / 2);
                Y0.set(i, Y0.get(i) + (h * k22.get(i)) / 2);
            }
            PROF(x0,Y0,k33);//k3
            XList.add(x0 + h / 2);
            Gamma1.add(Math.abs(Y0.get(8) * 180/Math.PI));
            Alfa1.add(Math.abs(Y0.get(9) * 180/Math.PI));
            Fi1.add(Math.abs(Y0.get(10) * 180/Math.PI));
            NList.add(N1abs); //добавляем в массив силу натяжения троса
            H.add(Y0.get(19));

            for(int i = 0; i < 20; i++) {
                k44.set(i, Y0.get(i) + (h * k33.get(i)));
                Y0.set(i, Y0.get(i) + (h * k33.get(i)) / 2);
            }
            PROF(x0,Y0,k44);//k4
            XList.add(x0 + h);
            Gamma1.add(Math.abs(Y0.get(8) * 180/Math.PI));
            Alfa1.add(Math.abs(Y0.get(9) * 180/Math.PI));
            Fi1.add(Math.abs(Y0.get(10) * 180/Math.PI));
            NList.add(N1abs); //добавляем в массив силу натяжения троса
            H.add(Y0.get(19));

            for (int i = 0; i < 20; i++){
                Y0.set(i, Y0.get(i) + h*(k11.get(i) + 2*k22.get(i) + 2*k33.get(i) + k44.get(i))/6);
            }
        }
        test();
    }

    public static void test(){
        int i = 0;
    }

    public static List<Double> x(){
        return XList;
    }

    public static List<Double> y(){
        return Alfa1;
    }

    public static List<Double> getGamma1(){
        return Gamma1;
    }

    public static List<Double> getFi1(){
        return Fi1;
    }

    public static List<Double> N(){
        return NList;
    }

    public static List<Double> H(){
        return H;
    }

    public static List<Double> R0(){
        return R0;
    }

    public static List<Double> getqList(){
        return qList;
    }
}
