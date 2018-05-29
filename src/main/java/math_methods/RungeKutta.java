package math_methods;

import java.io.*;

import static java.lang.Math.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//import java.util.function.BiFunction;

/**
 *
 * @author Сергей
 */

public class RungeKutta {
    private static double g0 = 9.80665;
    private static double R3 = 6371020;
    private static final double PI = 3.14;
    private static double[] RA1 = new double[3];
    private static double[] RA2 = new double[3];
    //L,L1,L2,L1T,L2T,L1p,L2p,Lx : array[1..3,1..3] of real; {Матрицы перехода СК1 и СК2}
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
    private static double tk;
    private static double dt1;
    private static double dt;
    private static double[][] a1 = new double[8][9];
    private static double[][] a2 = new double[8][9];
    private static double Ix1;
    private static double Iy1;
    private static double Iz1;
    private static double Ix2;
    private static double Iy2;
    private static double Iz2;
    private static double Cx01;
    private static double Cy01;
    private static double Cx02;
    private static double Cy02;
    private static double my1;
    private static double mz1;
    private static double mz2;
    private static double my2;
    private static double[] IXYn = {Ix1,Iy1,Iz1,Ix2,Iy2,Iz2};
    private static double x1,y1,z1,x2,y2,z2,x3,y3,z3;
    private static double[] XY = {x1,y1,z1, x2,y2,z2};
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
    private static double[] WxWxR2_CK1 = new double[3];
    private static double[] WxWxR1_CK2 = new double[3];
    private static double[] W2subW1 = new double[3];
    private static double[] W1subW2 = new double[3];
    private static double[] R1W = new double[3];
    private static double[] R2W = new double[3];
    private static double[][] L13 = new double[3][3];
    private static double ro;
    private static double cx01,cy01,cx02,cy02;
    private static double[] cxy  = {cx01,cy01,cx02,cy02}; //Исправить запись в массив
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
    private static double q,r5,omxp1,omxp2;
    private static double[] r1R2 = new double[3];
    private static double[] r1R1 = new double[3];
    private static double[] r2R1 = new double[3];
    private static double[] r2R2 = new double[3];
    private static double[] r51 = new double[3];
    private static double[] r52 = new double[3];
    private static int n,n1,nmax,n6;
    private static double[] b1 = new double [17];
    private static double[] EPS = new double [12];
    //private static double[] f,x0,d = new double[15];
    private static double[] rad1 = new double[3];
    private static double[] rad2 = new double[3];
    private static double[] rad3 = new double[3];
    private static double[] rad2rad1 = new double[3];
    private static double[] rad2rad3 = new double[3];
    private static double[] rad1_TP = new double [3];
    private static double[] rad2_TP = new double [3];
    private static double[] rad3_TP = new double [3];
    private static double[] w1r1 = new double[3];
    private static double[] w2r2 = new double[3];
    private static double[] w3r3 = new double[3];
    private static double[] w1r1_T = new double[3];
    private static double[] w2r2_T = new double[3];
    private static double[] d2r1dt2_T = new double[3];
    private static double[] d2r2dt2_T = new double[3];
    private static double[] wrwr = new double[3];
    private static double[] d_omega1 = new double[3];
    private static double[] d_omega2 = new double[3];
    private static double[] w1w1r1 = new double[3];
    private static double[] w2w2r2 = new double[3];
    private static double[] dw1r1 = new double[3];
    private static double[] dw2r2 = new double[3];
    private static double[] dw1r1_T = new double[3];
    private static double[] dw2r2_T = new double[3];
    private static double[] w1w1r1_T = new double[3];
    private static double[] w2w2r2_T = new double[3];
    private static double[] N1 = new double[3];
    private static double[] N1_1 = new double[3];
    private static double[] N1_2 = new double[3];
    private static double[] N1_3 = new double[3];
    private static double[] KinMom1 = new double[3];
    private static double[] KinMom1_CK1 = new double[3];
    private static double[] KinMom2 = new double[3];
    private static double[] KinMom2_CK2 = new double[3];
    private static double[] KinMomAddon = new double[3];
    private static double[] KinMomC = new double[3];
    private static double[] KinMom = new double[3];
    private static double[] r2r1A = new double[3];
    private static double V_C;
    private static double[] R1 = new double[3];
    private static double[] R2 = new double[3];
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
    //private static double s1,s2;
    private static double TT_C1, TT_C2,TT_2,TT_1;
    private static double TT,PP,EE;
    private static double Mod_wrwr, deltaT;
    private static List <Double> f = new ArrayList<Double>(17);
    private static List <Double> x0 = new ArrayList<Double>(20);
    private static List <Double> d = new ArrayList<Double>(20);

    private static int CurExi;
    private static List<Double> Exi = new ArrayList<Double>(20);
    private static List<Double> ExiTol = new ArrayList<Double>(20);

    private static List<Double> work = new ArrayList<Double>(20);
    private static List<Double> xBak = new ArrayList<Double>(20);
    private static List<Double> xMod = new ArrayList<Double>(20);
    private static List<Double> xNew = new ArrayList<Double>(20);
    private static List<Double> EpsCur = new ArrayList<Double>(20);
    private static List<Double> ExiOld = new ArrayList<Double>(20);

    private static double t0;
    private static double step;
    private static double stepmax;
    private static boolean flag = false;

    private static boolean FlagVarStep = true; //для РК
    private static boolean FlagExiFunProc = true; //для РК
    private static boolean FlagDefExiOld = false; //для РК
    private static boolean FlagExiRetry = false; //для РК

    private static double RelEpsMax = 0; //для РК
    private static double StepMax2 = 0.5 * 0.05; //для РК
    private static int CurIte = 0; //для РК

    private static List<Double> tModList = new ArrayList<Double>(15); //выходной массив Х
    private static List<Double> Alfa1 = new ArrayList<Double>(15); //выходной массив Y
    private static List<Double> Alfa2 = new ArrayList<Double>(15); //выходной массив Y

    public static void ReadInitialParameters(double massFirst, double massSecond, double s1, double s2, double X1, double Y1,
                                             double Z1, double X2, double Y2, double Z2, double X3, double Y3, double Z3,
                                             double ix1, double iy1, double iz1, double ix2, double iy2, double iz2,
                                             double cx1, double cy1, double cx2, double cy2, double My1, double Mz1, double My2, double Mz2,
                                             double w11, double w12, double w13, double w21, double w22, double w23,
                                             double w31, double w32, double w33, double gamma1, double alfa1, double fi1,
                                             double gamma2, double alfa2, double fi2, double gamma3, double alfa3, double fi3,
                                             double v, double tetta, double h){
        FlagVarStep = true;
        FlagExiFunProc = true;
        FlagDefExiOld = false;
        FlagExiRetry = false;

        if(xNew.size() > 0){
            xNew.clear();
        }

        if(EpsCur.size() > 0){
            EpsCur.clear();
        }

        if(xMod.size() > 0){
            xMod.clear();
        }

        if(f.size() > 0){
            f.clear();
        }

        if(xBak.size() > 0){
            xBak.clear();
        }

        if(x0.size() > 0){
            x0.clear();
        }

        if(Exi.size() > 0){
            Exi.clear();
        }

        if(ExiOld.size() > 0){
            ExiOld.clear();
        }

        if(ExiTol.size() > 0){
            ExiTol.clear();
        }

        if (tModList.size() > 0){
            tModList.clear();
        }

        if (Alfa1.size() > 0){
            Alfa1.clear();
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

        Cx1 = -cx1;
        Cy1 = cy1;
        Cx2 = cx2;
        Cy2 = cy2;

        my1 = My1;
        mz1 = Mz1;
        my2 = My2;
        mz2 = Mz2;


        x0.add(0,w11);
        x0.add(1,w12);
        x0.add(2,w13);
        x0.add(3,w21);
        x0.add(4,w22);
        x0.add(5,w23);
        x0.add(6,w32);
        x0.add(7,w33);
        x0.add(8,gamma1);
        x0.add(9,alfa1);
        x0.add(10,fi1);
        x0.add(11,gamma2);
        x0.add(12,alfa2);
        x0.add(13,fi2);
        x0.add(14,gamma3);
        x0.add(15,alfa3);
        x0.add(16,fi3);
        x0.add(17,v);
        x0.add(18,tetta);
        x0.add(19,h);

        for(int i = 8;i<17;i++){
            x0.set(i,x0.get(i)*Math.PI/180);
        }
        x0.set(18,x0.get(18)*Math.PI/180);

        for(int i = 0; i < 20; i++){
            xNew.add(i,0.0);
            EpsCur.add(i,0.0);
            xMod.add(i,0.0);
            f.add(i,0.0);
            xBak.add(i,0.0);
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

    static void PRINT(double t, List<Double> x, List<Double> f) {
        double r1;

        V_C = x.get(12); //это же аналогично V_C = x[13];?
        rad1[0] = x1;
        rad1[1] = y1;
        rad1[2] = z1;

        rad2[0] = x2;
        rad2[1] = y2;
        rad2[2] = z2;

        rad3[0] = x3;
        rad3[1] = 0;
        rad3[2] = 0;

        Matrix.Vect_Vect_31(omega2,rad2,w2r2);
        Matrix.Vect_Vect_31(omega1,rad1,w1r1);
        Matrix.Vect_Vect_31(omega3,rad3,w3r3);

        double[] w2r2_T = Matrix.Mul_Matr_33_31(L2T,w2r2);
        double[] w1r1_T = Matrix.Mul_Matr_33_31(L1T,w1r1);
        double[] w3r3_T = Matrix.Mul_Matr_33_31(L3T,w3r3);

        //wrwr - матрица-вектор A
        double[] wrwr1 = Matrix.AddM_Matr_31(w2r2_T,w1r1_T);
        double[] wrwr = Matrix.Add_Matr_31(wrwr1,w3r3_T);

        Mod_wrwr = Matrix.Modul_Vect(wrwr);

        //Вычисление силы N1}
        d_omega1[0] = f.get(0);
        d_omega1[1] = f.get(1);
        d_omega1[2] = f.get(2);
        d_omega2[0] = f.get(3);
        d_omega2[1] = f.get(4);
        d_omega2[2] = f.get(5);

        Matrix.Vect_Vect_31(d_omega1,rad1,dw1r1);
        Matrix.Vect_Vect_31(d_omega2,rad2,dw2r2);
        Matrix.Vect_Vect_31(omega1,w1r1,w1w1r1);
        Matrix.Vect_Vect_31(omega2,w2r2,w2w2r2);

        double[] dw1r1_T = Matrix.Mul_Matr_33_31(L1T,dw1r1);
        double[] dw2r2_T = Matrix.Mul_Matr_33_31(L2T,dw2r2);
        double[] w1w1r1_T = Matrix.Mul_Matr_33_31(L1T,w1w1r1);
        double[] w2w2r2_T = Matrix.Mul_Matr_33_31(L2T,w2w2r2);

        double[] d2r1dt2_T = Matrix.Add_Matr_31(dw1r1_T,w1w1r1_T);
        double[] d2r2dt2_T = Matrix.Add_Matr_31(dw2r2_T,w2w2r2_T);

        double[] W1C = Matrix.AddM_Matr_31(d2r2dt2_T,d2r1dt2_T);

        Matrix.Mul_Matr_31_Num(RA2,mass1/(mass1+mass2),N1_1);
        Matrix.Mul_Matr_31_Num(RA1,-mass1/(mass1+mass2),N1_2);
        Matrix.Mul_Matr_31_Num(W1C,mass1*mass2/(mass1+mass2),N1_3);

        N1[0] = N1_1[0]+N1_2[0]+N1_3[0];
        N1[1] = N1_1[1]+N1_2[1]+N1_3[1];
        N1[2] = N1_1[2]+N1_2[2]+N1_3[2];

        N1abs = Matrix.Modul_Vect(N1);

        //Вычисление потенциальной, кинетической и полной энергий системы}
        TT_C1 = 0.5*(Ix1*x.get(0)*x.get(0) + Iy1*x.get(1)*x.get(1) + Iz1*x.get(2)*x.get(2));
        TT_C2 = 0.5*(Ix2*x.get(3)*x.get(3) + Iy2*x.get(4)*x.get(4) + Iz2*x.get(5)*x.get(5));

        deltaT = 0.5*mass1*mass2/(mass1+mass2)*Mod_wrwr*Mod_wrwr;
        TT = TT_C1+TT_C2+deltaT;
        // /TT = TT_C1 + TT_C2 + 0.5*(mass1+mass2)*V_C*V_C+deltaT;

        PP = (mass1*RA2[0]-mass2*RA1[0])/(mass1+mass2)*(-x1*Math.cos(x.get(9))+x2*Math.cos(x.get(12))+x3*Math.cos(x.get(15)));
        EE = TT + PP;

        //Вычисление кинетического момента системы}
        KinMom1_CK1[0] = Ix1*x.get(0);
        KinMom1_CK1[1] = Iy1*x.get(1);
        KinMom1_CK1[2] = Iz1*x.get(2);
        KinMom2_CK2[0] = Ix2*x.get(3);
        KinMom2_CK2[1] = Iy2*x.get(4);
        KinMom2_CK2[2] = Iz2*x.get(5);

        KinMom1 = Matrix.Mul_Matr_33_31(L1T,KinMom1_CK1);      //Кинетический момент тел
        KinMom2 = Matrix.Mul_Matr_33_31(L2T,KinMom2_CK2);      //отн. их центров масс

        KinMomC = Matrix.Add_Matr_31(KinMom1,KinMom2);

        rad1_TP = Matrix.Mul_Matr_33_31(L1T,rad1);
        rad2_TP = Matrix.Mul_Matr_33_31(L2T,rad2);
        rad3_TP = Matrix.Mul_Matr_33_31(L3T,rad3);

        rad2rad1 = Matrix.AddM_Matr_31(rad2_TP,rad1_TP);
        rad2rad3 = Matrix.Add_Matr_31(rad2rad1,rad3_TP);

        Matrix.Vect_Vect_31(rad2rad3,wrwr,r2r1A);
        Matrix.Mul_Matr_31_Num(r2r1A,mass1*mass2/(mass1+mass2),KinMomAddon);

        KinMom = Matrix.Add_Matr_31(KinMomC,KinMomAddon);      //KinMom - кинетический момент системы}

        //Скоростной напор}
        q = ro*x.get(17)*x.get(17)/2;

        r1 = x.get(0)*(180/PI);
        if (r1 >= 0){
            r1 = r1 - (r1/360)*360;
            if (r1 > 180){
                r1 = r1 - 360;
            }
        }

        if (r1 < 0) {
            r1 += (Math.abs(r1/360))*360;
        }

        if (r1 < -180) {
            r1 += 360;
        }

        Alfa1.add(x.get(9) * 180/Math.PI);
        Alfa2.add(x.get(12) * 180/Math.PI);
        tModList.add(t);
    }

    static void PROF (double t, List<Double> x, List<Double> f) {

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

        Lx = Matrix.Mul_Matr_33_33(La1,Lg1);
        double[][] L1p = Lx; //Матрица перехода от траекторной с.к. к с.к, связанной с первым телом
        double[][] L1 = Matrix.Mul_Matr_33_33(Lf1,Lx);
        Lx = Matrix.Mul_Matr_33_33(La2,Lg2);
        double[][] L2p = Lx; //Матрица перехода от траекторной с.к. к с.к, связанной со вторым телом
        double[][] L2 = Matrix.Mul_Matr_33_33(Lf2,Lx);
        Lx = Matrix.Mul_Matr_33_33(La3,Lg3);
        double[][] L3 = Matrix.Mul_Matr_33_33(Lf3,Lx);

        //L1  - от траекторной к связанной СК1
        //L2  - от траекторной к связанной СК2
        //L3  - от траекторной к связанной СК3

        Matrix.Transp_Matr_33(L2,Lx); double[][] L21 = Matrix.Mul_Matr_33_33(L1,Lx);
        Matrix.Transp_Matr_33(L1,Lx); double[][] L12 = Matrix.Mul_Matr_33_33(L2,Lx);
        Matrix.Transp_Matr_33(L3,Lx); double[][] L31 = Matrix.Mul_Matr_33_33(L1,Lx);
        Matrix.Transp_Matr_33(L3,Lx); double[][] L32 = Matrix.Mul_Matr_33_33(L2,Lx);
        Matrix.Transp_Matr_33(L2,Lx); double[][] L23 = Matrix.Mul_Matr_33_33(L3,Lx);

        Matrix.Transp_Matr_33(L31,L13);
        Matrix.Transp_Matr_33(L32,L23);

        //L21 - от СК2 к СК1}
        //L12 - от СК1 к СК2}
        //L31 - от СК3 к СК1}
        //L32 - от СК3 к СК2}
        //L23 - от СК2 к СК3}

        Matrix.Transp_Matr_33(L1,L1T);
        Matrix.Transp_Matr_33(L2,L2T);
        Matrix.Transp_Matr_33(L3,L3T);

        //L1T - от СК1 к траекторной}
        //L2T - от СК2 к траекторной}
        //L3T - от СК3 к траекторной}

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

        a1[0][3] = -m1m2*((y1*L21[2][1]-z1*L21[1][1])*z2-(y1*L21[2][2]-z1*L21[1][2])*y2);
        a1[0][4] = -m1m2*((y1*L21[2][2]-z1*L21[1][2])*x2-(y1*L21[2][0]-z1*L21[1][0])*z2);
        a1[0][5] = -m1m2*((y1*L21[2][0]-z1*L21[1][0])*y2-(y1*L21[2][1]-z1*L21[1][1])*x2);
        a1[1][3] = -m1m2*((z1*L21[0][2]-x1*L21[2][2])*y2-(z1*L21[0][1]-x1*L21[2][1])*z2); //!
        a1[1][4] = -m1m2*((z1*L21[0][0]-x1*L21[2][0])*z2-(z1*L21[0][2]-x1*L21[2][2])*x2); //!
        a1[1][5] = -m1m2*((z1*L21[0][1]-x1*L21[2][1])*x2-(z1*L21[0][0]-x1*L21[2][0])*y2);
        a1[2][3] = -m1m2*((x1*L21[1][2]-y1*L21[0][2])*y2-(x1*L21[1][1]-y1*L21[0][1])*z2);
        a1[2][4] = -m1m2*((x1*L21[1][0]-y1*L21[0][0])*z2-(x1*L21[1][2]-y1*L21[0][2])*x2);
        a1[2][5] = -m1m2*((x1*L21[1][1]-y1*L21[0][1])*x2-(x1*L21[1][0]-y1*L21[0][0])*y2);

        //индексы
        /*a1[3][0] = m1m2*((y2*L21[2][2]-z2*L21[1][2])*y2-(y2*L21[2][1]-z2*L21[1][1])*z2);
        a1[3][1] = m1m2*((y2*L21[2][0]-z2*L21[1][0])*z2-(y2*L21[2][2]-z2*L21[1][2])*x2);
        a1[3][2] = m1m2*((y2*L21[2][1]-z2*L21[1][1])*x2-(y2*L21[2][0]-z2*L21[1][0])*y2);
        a1[4][0] = m1m2*((z2*L21[0][2]-x2*L21[2][2])*y2-(z2*L21[0][1]-x2*L21[2][1])*z2);
        a1[4][1] = m1m2*((z2*L21[0][0]-x2*L21[2][0])*z2-(z2*L21[0][2]-x2*L21[2][2])*x2);
        a1[4][2] = m1m2*((z2*L21[0][1]-x2*L21[2][1])*x2-(z2*L21[0][0]-x2*L21[2][0])*y2);
        a1[5][0] = m1m2*((x2*L21[1][2]-y2*L21[0][2])*y2-(x2*L21[1][1]-y2*L21[0][1])*z2);
        a1[5][1] = m1m2*((x2*L21[1][0]-y2*L21[0][0])*z2-(x2*L21[1][2]-y2*L21[0][2])*x2);
        a1[5][2] = m1m2*((x2*L21[1][1]-y2*L21[0][1])*x2-(x2*L21[1][0]-y2*L21[0][0])*y2);*/

        a1[3][0] = -m1m2*((y1*L21[2][2]-z1*L21[1][2])*y2-(y1*L21[2][1]-z1*L21[1][1])*z2);
        a1[3][1] = -m1m2*((z1*L21[0][2]-x1*L21[2][2])*y2-(z1*L21[0][1]-x1*L21[2][1])*z2);
        a1[3][2] = -m1m2*((x1*L21[1][2]-y1*L21[0][2])*y2-(x1*L21[1][1]-y1*L21[0][1])*z2);
        a1[4][0] = -m1m2*((y1*L21[2][0]-z1*L21[1][0])*z2-(y1*L21[2][2]-z1*L21[1][2])*x2);
        a1[4][1] = -m1m2*((z1*L21[0][0]-x1*L21[2][0])*z2-(z1*L21[0][2]-x1*L21[2][2])*x2);
        a1[4][2] = -m1m2*((x1*L21[1][0]-y1*L21[0][0])*z2-(x1*L21[1][2]-y1*L21[0][2])*x2);
        a1[5][0] = -m1m2*((y1*L21[2][1]-z1*L21[1][1])*x2-(y1*L21[2][0]-z1*L21[1][0])*y2);
        a1[5][1] = -m1m2*((z1*L21[0][1]-x1*L21[2][1])*x2-(z1*L21[0][0]-x1*L21[2][0])*y2);
        a1[5][2] = -m1m2*((x1*L21[1][1]-y1*L21[0][1])*x2-(x1*L21[1][0]-y1*L21[0][0])*y2);

        //a1[5][1] = a1[1][5];
        //a1[4][2] = a1[2][4];

        a1[3][3] = Ix2+m1m2*(y2*y2+z2*z2);
        a1[3][4] = -m1m2*x2*y2;
        a1[3][5] = -m1m2*x2*z2;
        a1[4][3] = -m1m2*x2*y2;
        a1[4][4] = Iy2+m1m2*(x2*x2+z2*z2);
        a1[4][5] = -m1m2*y2*z2;
        a1[5][3] = -m1m2*x2*z2;
        a1[5][4] = -m1m2*y2*z2;
        a1[5][5] = Iz2+m1m2*(x2*x2+y2*y2);

        a1[0][6] = -m1m2*(L31[1][2]*z1-L31[2][2]*y1)*x3;
        a1[0][7] = -m1m2*(L31[2][1]*y1-L31[1][1]*z1)*x3;
        a1[1][6] = -m1m2*(L31[2][2]*x1-L31[0][2]*z1)*x3;
        a1[1][7] = -m1m2*(L31[0][1]*z1-L31[2][1]*x1)*x3;
        a1[2][6] = -m1m2*(L31[0][2]*y1-L31[1][2]*x1)*x3;
        a1[2][7] = -m1m2*(L31[1][1]*x1-L31[0][1]*y1)*x3;


        a1[6][0] = m1m2*(L13[2][2]*y1-L13[2][1]*z1);
        a1[6][1] = m1m2*(L13[2][0]*z1-L13[2][2]*x1);
        a1[6][2] = m1m2*(L13[2][1]*x1-L13[2][0]*y1);
        a1[6][3] = -m1m2*(L23[2][2]*y2-L23[2][1]*z2);
        a1[6][4] = -m1m2*(L23[2][0]*z2-L23[2][2]*x2);
        a1[6][5] = -m1m2*(L23[2][1]*x2-L23[2][0]*y2);
        a1[6][6] = m1m2*x3*x3; //!!
        a1[6][7] = 0.0;



        a1[3][6] = m1m2*(L32[1][2]*z2-L32[2][2]*y2)*x3;
        a1[3][7] = m1m2*(L32[2][1]*y2-L32[1][1]*z2)*x3;
        a1[4][6] = m1m2*(L32[2][2]*x2-L32[0][2]*z2)*x3;
        a1[4][7] = m1m2*(L32[0][1]*z2-L32[2][1]*x2)*x3;
        a1[5][6] = m1m2*(L32[0][2]*y2-L32[1][2]*x2)*x3;
        a1[5][7] = m1m2*(L32[1][1]*x2-L32[0][1]*y2)*x3;

        a1[7][0] = m1m2*(L13[1][2]*y1-L13[1][1]*z1);
        a1[7][1] = m1m2*(L13[1][0]*z1-L13[1][2]*x1);
        a1[7][2] = m1m2*(L13[1][1]*x1-L13[1][0]*y1);
        a1[7][3] = -m1m2*(L23[1][2]*y2-L23[1][1]*z2);
        a1[7][4] = -m1m2*(L23[1][0]*z2-L23[1][2]*x2);
        a1[7][5] = -m1m2*(L23[1][1]*x2-L23[1][0]*y2);
        a1[7][6] = 0.0;
        a1[7][7] = -m1m2*x3*x3; //!!

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

        Matrix.Vect_Vect_31(omega1,r1,WxR1);
        Matrix.Vect_Vect_31(omega1,WxR1,WxWxR1); //!!!!!!!
        Matrix.Vect_Vect_31(omega2,r2,WxR2);
        Matrix.Vect_Vect_31(omega2,WxR2,WxWxR2);
        Matrix.Vect_Vect_31(omega3,r3,WxR3);
        Matrix.Vect_Vect_31(omega3,WxR3,WxWxR3);

        double[] WxWxR1_TR = Matrix.Mul_Matr_33_31(L1T,WxR1);
        double[] WxWxR2_TR = Matrix.Mul_Matr_33_31(L2T,WxR2);
        double[] WxWxR3_TR = Matrix.Mul_Matr_33_31(L3T,WxR3);

        double[] S12 = Matrix.AddM_Matr_31(WxWxR2_TR,WxWxR1_TR);
        double[] S123 = Matrix.Add_Matr_31(S12,WxWxR3_TR);

        Matrix.Mul_Matr_31_Num(S123,mass2/(mass1+mass2),V1C);
        Matrix.Mul_Matr_31_Num(S123,-mass1/(mass1+mass2),V2C); //стр. 29 формула 2.26

        VC[0] = x.get(17);
        VC[1] = 0;
        VC[2] = 0;

        double[] V1 = Matrix.Add_Matr_31(VC,V1C);
        double[] V2 = Matrix.Add_Matr_31(VC,V2C);

        double[] V1_CK1 = Matrix.Mul_Matr_33_31(L1,V1);
        double[] V2_CK2 = Matrix.Mul_Matr_33_31(L2,V2);

        ModR1 = Matrix.Modul_Vect(r1); //!!!!!!!!!!!
        ModV1 = Matrix.Modul_Vect(V1);
        cosA1 = -(r1[0]*V1_CK1[0]+r1[1]*V1_CK1[1]+r1[2]*V1_CK1[2])/ModR1/ModV1; //!!!!!!!!

        ModR2 = Matrix.Modul_Vect(r2);
        ModV2 = Matrix.Modul_Vect(V2);
        cosA2 = (r2[0]*V2_CK2[0]+r2[1]*V2_CK2[1]+r2[2]*V2_CK2[2])/ModR2/ModV2;

        AL1 = arccos(cosA1);
        AL2 = arccos(cosA2);
        //AL1 = Math.acos(cosA1);
        //AL2 = Math.acos(cosA2);

        double[] WxWxR1_CK2 = Matrix.Mul_Matr_33_31(L12,WxWxR1);
        double[] WxWxR1_CK3 = Matrix.Mul_Matr_33_31(L13,WxWxR1);
        double[] WxWxR2_CK1 = Matrix.Mul_Matr_33_31(L21,WxWxR2);
        double[] WxWxR2_CK3 = Matrix.Mul_Matr_33_31(L23,WxWxR2);
        double[] WxWxR3_CK1 = Matrix.Mul_Matr_33_31(L31,WxWxR3);
        double[] WxWxR3_CK2 = Matrix.Mul_Matr_33_31(L32,WxWxR3);

        double[] W2subW1 = Matrix.AddM_Matr_31(WxWxR2_CK1,WxWxR1);
        double[] W2subW1addW3_CK1 = Matrix.Add_Matr_31(W2subW1,WxWxR3_CK1);

        double[] W1subW2 = Matrix.AddM_Matr_31(WxWxR1_CK2,WxWxR2);
        double[] W1subW2addW3_CK2 = Matrix.AddM_Matr_31(W1subW2,WxWxR3_CK2);

        W2subW1 = Matrix.AddM_Matr_31(WxWxR2_CK3,WxWxR1_CK3); //!!!!!!!!!!!!!!
        double[] W2subW1addW3_CK3 = Matrix.Add_Matr_31(W2subW1,WxWxR3);

        Matrix.Vect_Vect_31(r1,W2subW1addW3_CK1,R1W);
        Matrix.Vect_Vect_31(r2,W1subW2addW3_CK2,R2W);
        //Matrix.Vect_Vect_31(r3,W2subW1addW3_CK3,R3W);

        R3W[0] = 0;
        R3W[1] = W2subW1addW3_CK3[2];
        R3W[2] = W2subW1addW3_CK3[1];

        g = g0 * Math.pow(R3/(R3+x.get(19)),2); //ускорение свободного падения на высоте H, R3 - радиус Земли
        ro = 1.225 * Math.exp(-x.get(19)/7000); //плотность воздуха на высоте H
        q = 0.5 * ro * (x.get(17) * x.get(17)); //скоростной напор

        /*Cx1 = Cx01 * Math.cos(x.get(7)); //аэродинамические коэффициенты Cx < 0, Cy > 0.
        Cyp1 = Cy01 * Math.sin(x.get(7));
        Cx2 = Cx02 * Math.cos(x.get(10));
        Cyp2 = Cy02 * Math.sin(x.get(10));
        Cyv1 = Cyp1 * Math.cos(x.get(7)) + Cx1 * Math.sin(x.get(7));
        Cyv2 = Cyp2 * Math.cos(x.get(10)) + Cx2 * Math.sin(x.get(10));
        Rx1 = Cx1 * q * S1; //аэродинамические силы
        Ryp1 = Cyp1*q* S1;
        Rx2 = Cx2 * q * S2;
        Ryp2 = Cyp2 * q * S2;*/

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

        /*r51[0] = Rx1;
        r51[1] = Ryp1;
        r51[2] = 0;
        r52[0] = Rx2;
        r52[1] = Ryp2;
        r52[2] = 0;*/

        Matrix.Transp_Matr_33(L1p,Lx);
        RA1 = Matrix.Mul_Matr_33_31(Lx, RA1p);
        Matrix.Transp_Matr_33(L2p,Lx);
        RA2 = Matrix.Mul_Matr_33_31(Lx, RA2p);

        double[] r10 = Matrix.Mul_Matr_33_31(L1, RA1);
        Matrix.Vect_Vect_31(r1,r10,r1R1);
        r10 = Matrix.Mul_Matr_33_31(L1, RA2);
        Matrix.Vect_Vect_31(r1,r10,r1R2);

        r10 = Matrix.Mul_Matr_33_31(L2, RA1);
        Matrix.Vect_Vect_31(r2,r10,r2R1);
        r10 = Matrix.Mul_Matr_33_31(L2, RA2);
        Matrix.Vect_Vect_31(r2,r10,r2R2);

        double[] r3R1 = Matrix.Mul_Matr_33_31(L3, RA1);
        double[] r3R2 = Matrix.Mul_Matr_33_31(L3, RA2);


        a1[0][8] = m1m*r1R2[0] - m2m*r1R1[0] + m1m2*R1W[0];
        a1[1][8] = m1m*r1R2[1] - m2m*r1R1[1] + m1m2*R1W[1];
        a1[2][8] = m1m*r1R2[2] - m2m*r1R1[2] + m1m2*R1W[2];

        a1[3][8] = m2m*r2R1[0] - m1m*r2R2[0] + m1m2*R2W[0];
        a1[4][8] = m2m*r2R1[1] - m1m*r2R2[1] + m1m2*R2W[1];
        a1[5][8] = m2m*r2R1[2] - m1m*r2R2[2] + m1m2*R2W[2];

        a1[6][8] = m1m*r3R2[2] - m2m*r3R1[2] + m1m2*R3W[1];
        a1[7][8] = m1m*r3R2[1] - m2m*r3R1[1] + m1m2*R3W[2];


        n6 = 5;

        /*if (t > 10)
            n6 = 5;
        for (int i = 0; i < 6; i++)
            b1[i] = a1[i][6];
        for (int i = 0; i < 6; i++)
            for (int j = 1; j < 7; j++)
                a2[i][j] = a1[i][j];*/
        Gaus.init(7, a1, b1);//решая методом гаусса матрицу переменных коэффициентов,
        //получаем матрицу B - вектор правых частей дифференциальных уравнений.
        Gaus.algGaus();

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

        for(int i = 0; i < 7; i++){
            EPS[i] = 0;
            for(int j = 0; j < 7; j++){
                EPS[i] += b1[j] * a2[i][j];
                EPS[i] += -a2[i][8];
            }
        }

        Rx1 = Cx1*Math.cos(AL1)*q*S1;
        Ry1 = Cy1*Math.sin(AL1)*q*S1;
        Rx2 = Cx2*Math.cos(AL2)*q*S2;
        Ry2 = Cy2*Math.sin(AL2)*q*S2;

        Rxv = Rx1*Math.cos(AL1)-Ry1*Math.sin(AL1)+Rx2*Math.cos(AL2)-Ry2*Math.cos(AL2);

        //t += 0.0;
        //my1 = 0;
        //mz1 = 0;
        //Rxv:=Rx1*cos(x[8])-Ry1*sin(x[8])+Rx2*cos(x[11])-Ry2*cos(x[11]);
        f.set(0, b1[0] - x.get(1) * x.get(2) * (Iz1 - Iy1));
        f.set(1, (b1[1] + my1 * q * S1 * Math.abs(x1)) - x.get(0) * x.get(2) * (Ix1 - Iz1));
        f.set(2, (b1[2] + mz1 * q * S1 * Math.abs(x1)) - x.get(0) * x.get(1) * (Iy1 - Ix1));
        f.set(3, b1[3] - x.get(4) * x.get(5) * (Iz2 - Iy2));
        f.set(4, (b1[4] + my2 * q * S2 * Math.abs(x2)) - x.get(3) * x.get(5) * (Ix2 - Iz2));
        f.set(5, (b1[5] + mz2 * q * S2 * Math.abs(x2)) - x.get(3) * x.get(4) * (Iy2 - Ix2));


        for(int i = 6; i < 17; i++){
            f.set(i, b1[i]);
        }

        //Rxv = RA1[0]+RA2[0];
        //Rxv:=-2*q*2.5;mass1:=4000;mass2:=400;
        f.set(17, Rxv/(mass1+mass2)-g * Math.sin(x.get(18))); //x.get(13) это tetta - угол наклона траектории
        f.set(18, (-g/x.get(17)+x.get(17)/(R3+x.get(19))) * Math.cos(x.get(18)));
        f.set(19, x.get(17) * Math.sin(x.get(18)));
        //}

    }

    static void PROFI(double t,List<Double> xx,List<Double> ff,List <Double> ffi){

        double dt = 0;
        double r2,r1;
        tk = 350.0;
        ffi.add(0,tk-t);
        if(t<dt1)
            return;
        PRINT(t,xx,ff);
    }

    public static void Rungecutt(int NumInt,double t, double Step,double StepMax, List <Double> Eps,int NumExi,int CurIteMax) {
        int i,j;
        double tMod,Step2,kI,RelEpsCur;

        //интегрирование методом Рунге-Кутта 4-го порядка
        Step2 = 0.5 * Step;
        tMod = t;
        for (i = 0; i < NumInt; i++)
            xNew.set(i, x0.get(i)); //тут было add
        while (true){
            if (FlagVarStep){
                RelEpsMax = 0;
            }
            PROF(tMod,xNew,f);

            if (FlagExiFunProc)
                PROFI(tMod,xNew,f,Exi);
            FlagExiFunProc = true;
            for (i = 0; i < NumInt; i++) {
                xBak.set(i, xNew.get(i)); //тут было add, а так же убрал индекс i
                kI = f.get(i) * Step;
                xNew.set(i, xNew.get(i) + kI / 6); //убрал индекс i
                xMod.set(i,xBak.get(i) + 0.5 * kI); //тут было add, а так же убрал индекс i
                EpsCur.set(i, kI); //тут было add, а так же убрал индекс i
            }
            tMod = tMod + Step2;
            PROF(tMod,xMod,f);
            for (i = 0; i < NumInt; i++) {
                kI = f.get(i) * Step;
                xNew.set(i, xNew.get(i) + kI / 3); //тут было set
                xMod.set(i, xBak.get(i) + 0.5 * kI); //тут было set
                EpsCur.set(i, EpsCur.get(i) - kI); //тут было set
            }
            PROF(tMod,xMod,f);
            for (i = 0; i < NumInt; i++) {
                kI = f.get(i) * Step;
                xNew.set(i, xNew.get(i) + kI / 3); //тут было set
                xMod.set(i, xBak.get(i) + kI); //тут было set
                EpsCur.set(i, EpsCur.get(i) - kI); //тут было set
            }
            tMod = tMod + Step2;
            PROF(tMod,xMod,f);
            for (i = 0; i < NumInt; i++) {
                kI = f.get(i) * Step;
                xNew.set(i, xNew.get(i) + kI / 6); //тут было set
                EpsCur.set(i, EpsCur.get(i) + kI); //тут было set
                if(FlagVarStep || i<= NumInt){
                    RelEpsCur = Math.abs(EpsCur.get(i)/Eps.get(i));
                    if (RelEpsCur > RelEpsMax)
                        RelEpsMax = RelEpsCur;
                }
            }

            //уменьшение шага
            if (FlagVarStep && RelEpsMax > 1) {
                Step = Step2;
                FlagExiFunProc = false;

                flag = true;
                n = NumInt;
                t0 = t;
                step = Step;
                stepmax = StepMax;
                d = Eps;
                n1 = NumExi;
                nmax = CurIteMax;
                return;
                //Rungecutt(NumInt, t, Step, StepMax, Eps, NumExi, CurIteMax);
            }

            //проверка условия выхода
            for (j = 0; j < NumExi; j++) {
                ExiTol.add(0,349.6);
                if (Math.abs(Exi.get(j)) <= ExiTol.get(0)) {
                    CurExi = j;
                    flag = false;
                    return;
                }
                if (FlagDefExiOld) {
                    FlagExiRetry = false;
                    if ((Exi.get(j) * ExiOld.get(j)) < 0) {
                        if (CurIte >= CurIteMax) {
                            CurExi = -j;
                            flag = false;
                            return;
                        }
                        CurIte++;
                        FlagExiRetry = true;
                        FlagVarStep = false;
                        Step = Step * Exi.get(j) / (ExiOld.get(j) - Exi.get(j));
                    }
                }
                ExiOld.add(j,Exi.get(j));
                if (FlagExiRetry) {
                    flag = true;
                    n = NumInt;
                    t0 = t;
                    step = Step;
                    stepmax = StepMax;
                    d = Eps;
                    n1 = NumExi;
                    nmax = CurIteMax;
                    return;
                    //Rungecutt(NumInt, t, Step, StepMax, Eps, NumExi, CurIteMax);
                }
            }
            FlagDefExiOld = true;

            //выполнение шага
            for (i = 0; i < NumInt; i++)
                x0.set(i,xNew.get(i)); //тут было set
            t = tMod;

            //увеличение шага }
            if ((FlagVarStep) || (RelEpsMax < 0.1) || (Step <= StepMax2)) {
                Step = 2 * Step;

                flag = true;
                n = NumInt;
                t0 = t;
                step = Step;
                stepmax = StepMax;
                d = Eps;
                n1 = NumExi;
                nmax = CurIteMax;
                return;
                //Rungecutt(NumInt, t, Step, StepMax, Eps, NumExi, CurIteMax);
            }
        }
    }

    public static List<Double> x(){
        return tModList;
    }

    public static List<Double> y(){
        return Alfa1;
    }

    public static boolean getFlag(){
        return flag;
    }

    public static double getT0(){
        return t0;
    }

    public static double getStep(){
        return step;
    }

    /*public static void main(String[] args) {
        tk = 350;
        dt1 = 0;
        n = 20; //количество интервалов
        t0 = 0; //начальное время
        n1 = 1;
        nmax = 100;
        //d.set(0,0.1);
        d.add(0,0.1); //сделать поменьше, это минимальный размер шага
        for(int i = 1; i < 20; i++){
            d.add(i,0.1);
        }
        step = 0.05; //размер шага
        stepmax = 0.05; //макси. размер шага
        //tk = 10;
        boolean bool = true;

        //==============ТЕСТИК============
        for(int i = 0; i < 20; i++){
            xNew.add(i,0.0);
            EpsCur.add(i,0.0);
            xMod.add(i,0.0);
            f.add(i,0.0);
            xBak.add(i,0.0);
        }
        //=================================

        ReadInitialData();
        Rungecutt(n,t0,step,stepmax,d, n1,nmax);
        while(flag){
            Rungecutt(n,t0,step,stepmax,d, n1,nmax);
        }

        for (Double x : x0)
        {
            System.out.println(x);
        }
    }*/
}


