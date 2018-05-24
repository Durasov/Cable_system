package math_methods;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
    private static double[][] L1T = new double[3][3];
    private static double[][] L2T = new double[3][3];
    private static double m1m2;
    private static double m1m;
    private static double m2m;
    //Массы 1 и 2 тел соответственно
    private static double mass1;
    private static double mass2;
    private static double tk;
    private static double dt1;
    private static double dt;
    private static double[][] a1 = new double[6][7];
    private static double[][] a2 = new double[6][7];
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
    private static double[] IXYn = {Ix1,Iy1,Iz1,Ix2,Iy2,Iz2};
    private static double x1,y1,z1,x2,y2,z2;
    private static double[] XY = {x1,y1,z1, x2,y2,z2};
    private static double[] omega1 = new double[3];
    private static double[] omega2 = new double[3];
    private static double[] r1 = new double[3];
    private static double[] r2 = new double[3];
    private static double[] WxR = new double[3];
    private static double[] WxWxR1 = new double[3];
    private static double[] WxWxR2 = new double[3];
    private static double[] WxWxR2_CK1 = new double[3];
    private static double[] WxWxR1_CK2 = new double[3];
    private static double[] W2subW1 = new double[3];
    private static double[] W1subW2 = new double[3];
    private static double[] R1W = new double[3];
    private static double[] R2W = new double[3];
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
    private static double Cyp2;
    private static double Rx1;
    private static double Rx2;
    private static double Ryp1;
    private static double Ryp2;
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
    private static double[] b1 = new double [12];
    private static double[] EPS = new double [12];
    //private static double[] f,x0,d = new double[15];
    private static double[] rad1 = new double[3];
    private static double[] rad2 = new double[3];
    private static double[] rad2rad1 = new double[3];
    private static double[] rad1_TP = new double [3];
    private static double[] rad2_TP = new double [3];
    private static double[] w1r1 = new double[3];
    private static double[] w2r2 = new double[3];
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
    private static double[] N11 = new double[3];
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
    private static double N1abs;
    //private static double s1,s2;
    private static double TT_C1, TT_C2,TT_2,TT_1;
    private static double TT,PP,EE;
    private static double Mod_wrwr, deltaT;
    private static List <Double> f = new ArrayList<Double>(15);
    private static List <Double> x0 = new ArrayList<Double>(15);
    private static List <Double> d = new ArrayList<Double>(15);

    private static int CurExi;
    private static List<Double> Exi = new ArrayList<Double>(15);
    private static List<Double> ExiTol = new ArrayList<Double>(15);

    private static List<Double> work = new ArrayList<Double>(15);
    private static List<Double> xBak = new ArrayList<Double>(15);
    private static List<Double> xMod = new ArrayList<Double>(15);
    private static List<Double> xNew = new ArrayList<Double>(15);
    private static List<Double> EpsCur = new ArrayList<Double>(15);
    private static List<Double> ExiOld = new ArrayList<Double>(15);

    public static void ReadInitialParameters(double massFirst, double massSecond, double s1, double s2, double X1, double Y1,
                                             double Z1, double X2, double Y2, double Z2, double RA11, double RA12, double RA13,
                                             double RA21, double RA22, double RA23, double ix1, double iy1, double iz1,
                                             double ix2, double iy2, double iz2){
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

        RA1[0] = RA11;
        RA1[1] = RA12;
        RA1[2] = RA13;

        RA2[0] = RA21;
        RA2[1] = RA22;
        RA2[2] = RA23;

        //Моменты энерции
        Ix1 = ix1;
        Iy1 = iy1;
        Iz1 = iz1;
        Ix2 = ix2;
        Iy2 = iy2;
        Iz2 = iz2;
    }

    public static void ReadInitialData() {
        try{
            InputStream is = new FileInputStream("C://ReadDataInitial.txt");
            DataInputStream dis = new DataInputStream(is);
            Scanner sc  = new Scanner(is);

            sc.nextLine();
            mass1 = sc.nextDouble();
            mass2 = sc.nextDouble();

            sc.nextLine();
            sc.nextLine();

            //x1,y1,z1, x2,y2,z2;
            x1 = sc.nextDouble();
            y1 = sc.nextDouble();
            z1 = sc.nextDouble();
            x2 = sc.nextDouble();
            y2 = sc.nextDouble();
            z2 = sc.nextDouble();

            sc.nextLine();
            sc.nextLine();

            int j = 0;
            for(double i:RA1){ //PEREDELAT!!!!!
                i = sc.nextDouble();
                RA1[j] = i;
                j++;
            }
            j = 0;
            for(double i:RA2){
                i = sc.nextDouble();
                RA2[j] = i;
                j++;
            }

            sc.nextLine();
            sc.nextLine();

            for(int i = 0;i < 6;i++){
                x0.add(i, sc.nextDouble());
            }

            sc.nextLine();
            sc.nextLine();

            for(int i = 6;i < 12;i++){
                x0.add(i, sc.nextDouble());
            }

            sc.nextLine();
            sc.nextLine();

            for(int i = 12;i<15;i++){
                x0.add(i, sc.nextDouble());
            }

            sc.nextLine();
            sc.nextLine();

            //Моменты энерции
            Ix1 = sc.nextDouble();
            Iy1 = sc.nextDouble();
            Iz1 = sc.nextDouble();
            Ix2 = sc.nextDouble();
            Iy2 = sc.nextDouble();
            Iz2 = sc.nextDouble();

            sc.nextLine();
            sc.nextLine();

            //Площади первого и второго тел
            S1 = sc.nextDouble();
            S2 = sc.nextDouble();

            sc.nextLine();
            sc.nextLine();

            Cx01 = sc.nextDouble();
            Cy01 = sc.nextDouble();
            Cx02 = sc.nextDouble();
            Cy02 = sc.nextDouble();
            sc.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка чтения файла");
            ex.printStackTrace();
        }
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

        Matrix.Vect_Vect_31(omega2,rad2,w2r2);
        Matrix.Vect_Vect_31(omega1,rad1,w1r1);

        double[] w2r2_T = Matrix.Mul_Matr_33_31(L2T,w2r2);
        double[] w1r1_T = Matrix.Mul_Matr_33_31(L1T,w1r1);

        //wrwr - матрица-вектор A
        double[] wrwr = Matrix.AddM_Matr_31(w2r2_T,w1r1_T);
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

        N11[0] = N1_1[0]+N1_2[0]+N1_3[0];
        N11[1] = N1_1[1]+N1_2[1]+N1_3[1];
        N11[2] = N1_1[2]+N1_2[2]+N1_3[2];

        N1abs = Matrix.Modul_Vect(N11);

        //Вычисление потенциальной, кинетической и полной энергий системы}
        TT_C1 = 0.5*(Ix1*x.get(0)*x.get(0) + Iy1*x.get(1)*x.get(1) + Iz1*x.get(2)*x.get(2));
        TT_C2 = 0.5*(Ix2*x.get(3)*x.get(3) + Iy2*x.get(4)*x.get(4) + Iz2*x.get(5)*x.get(5));

        deltaT = 0.5*mass1*mass2/(mass1+mass2)*Mod_wrwr*Mod_wrwr;
        TT = TT_C1 + TT_C2 + 0.5*(mass1+mass2)*V_C*V_C+deltaT;

        PP = (mass1*RA2[0]-mass2*RA1[0])/(mass1+mass2)*(-x1*Math.cos(x.get(7))+x2*Math.cos(x.get(10)));
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
        rad2rad1 = Matrix.AddM_Matr_31(rad2_TP,rad1_TP);
        Matrix.Vect_Vect_31(rad2rad1,wrwr,r2r1A);
        Matrix.Mul_Matr_31_Num(r2r1A,mass1*mass2/(mass1+mass2),KinMomAddon);

        KinMom = Matrix.Add_Matr_31(KinMomC,KinMomAddon);      //KinMom - кинетический момент системы}

        //Скоростной напор}
        //q:=ro*x[13]*x[13]/2;}

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

        Alfa1.add(x.get(7));
        Alfa2.add(x.get(10));
    }

    static void PROF (double t, List<Double> x, List<Double> f) {

        double [][] Lx = new double[3][3];

        //Вычисление матрицы L

        double [][] Lg1 = {
                { 1, 0, 0 },
                { Math.cos(x.get(6)), Math.sin(x.get(6)), 0 },
                { 0, -Math.sin(x.get(6)), Math.cos(x.get(6)) }
        };

        double [][] La1 = {
                { Math.cos(x.get(7)), Math.sin(x.get(7)), 0 },
                { -Math.sin(x.get(7)), Math.cos(x.get(7)), 0 },
                { 0, 0, 1 }
        };

        double [][] Lf1 = {
                { 1, 0, 0 },
                { 0, Math.cos(x.get(8)), Math.sin(x.get(8)) },
                { 0, -Math.sin(x.get(8)), Math.cos(x.get(8)) }
        };

        double [][] Lg2 = {
                { 1, 0, 0 },
                { 0, Math.cos(x.get(9)), Math.sin(x.get(9)) },
                { 0, -Math.sin(x.get(9)), Math.cos(x.get(9)) }
        };

        double [][] La2 = {
                { Math.cos(x.get(10)), Math.sin(x.get(10)), 0 },
                { -Math.sin(x.get(10)), Math.cos(x.get(10)), 0 },
                { 0, 0, 1 }
        };

        double [][] Lf2 = {
                { 1, 0, 0 },
                { 0, Math.cos(x.get(11)), Math.sin(x.get(11)) },
                { 0, -Math.sin(x.get(11)), Math.cos(x.get(11)) }
        };

        double[][] L1p = Matrix.Mul_Matr_33_33(La1,Lg1);
        double[][] L1 = Matrix.Mul_Matr_33_33(Lf1,L1p);
        double[][] L2p = Matrix.Mul_Matr_33_33(La2,Lg2);
        double[][] L2 = Matrix.Mul_Matr_33_33(Lf2,L2p);

        Matrix.Transp_Matr_33(L2,L2p);
        double[][] L = Matrix.Mul_Matr_33_33(L1,L2p);
        Matrix.Transp_Matr_33(L1,L2p);
        double[][] Lm = Matrix.Mul_Matr_33_33(L2,L2p);
        Matrix.Transp_Matr_33(L1,L1T);
        Matrix.Transp_Matr_33(L2,L2T);

          /*L1  - от траекторной к связанной СК1
            L2  - от траекторной к связанной СК2
            L1T - от СК1 к траекторной
            L2T - от СК2 к траекторной
            L   - от СК2 к СК1
            Lm  - от СК1 к СК2*/

        m1m2 = mass1*mass2/(mass1+mass2);
        m1m = mass1/(mass1+mass2);
        m2m = mass2/(mass1+mass2);

        a1[0][0] = Ix1+m1m2*(y1*y1+z1*z1);
        a1[0][1] = -m1m2*x1*y1;
        a1[0][2] = -m1m2*x1*z1;
        a1[1][0] = -m1m2*x1*y1;
        a1[1][1] = Iy1+m1m2*(x1*x1+z1*z1);
        a1[1][2] = -m1m2*y1*z1;
        a1[2][0] = -m1m2*x1*z1;
        a1[2][1] = -m1m2*y1*z1;
        a1[2][2] = Iz1+m1m2*(x1*x1+y1*y1);

        a1[0][3] = -m1m2*((y1*L[2][1]-z1*L[1][1])*z2-(y1*L[2][2]-z1*L[1][2])*y2);
        a1[0][4] = -m1m2*((y1*L[2][2]-z1*L[1][2])*x2-(y1*L[2][0]-z1*L[1][0])*z2);
        a1[0][5] = -m1m2*((y1*L[2][0]-z1*L[1][0])*y2-(y1*L[2][1]-z1*L[1][1])*x2);
        a1[1][3] = -m1m2*((z1*L[0][2]-x1*L[2][2])*y2-(z1*L[0][1]-x1*L[2][1])*z2);
        a1[1][4] = -m1m2*((z1*L[0][0]-x1*L[2][0])*z2-(z1*L[0][2]-x1*L[2][2])*x2);
        a1[1][5] = -m1m2*((z1*L[0][1]-x1*L[2][1])*x2-(z1*L[0][0]-x1*L[2][0])*y2);
        a1[2][3] = -m1m2*((x1*L[1][2]-y1*L[0][2])*y2-(x1*L[1][1]-y1*L[0][1])*z2);
        a1[2][4] = -m1m2*((x1*L[1][0]-y1*L[0][0])*z2-(x1*L[1][2]-y1*L[0][2])*x2);
        a1[2][5] = -m1m2*((x1*L[1][1]-y1*L[0][1])*x2-(x1*L[1][0]-y1*L[0][0])*y2);

        //индексы
        a1[3][0] = m1m2*((y2*L[2][2]-z2*L[1][2])*y2-(y2*L[2][1]-z2*L[1][1])*z2);
        a1[3][1] = m1m2*((y2*L[2][0]-z2*L[1][0])*z2-(y2*L[2][2]-z2*L[1][2])*x2);
        a1[3][2] = m1m2*((y2*L[2][1]-z2*L[1][1])*x2-(y2*L[2][0]-z2*L[1][0])*y2);
        a1[4][0] = m1m2*((z2*L[0][2]-x2*L[2][2])*y2-(z2*L[0][1]-x2*L[2][1])*z2);
        a1[4][1] = m1m2*((z2*L[0][0]-x2*L[2][0])*z2-(z2*L[0][2]-x2*L[2][2])*x2);
        a1[4][2] = m1m2*((z2*L[0][1]-x2*L[2][1])*x2-(z2*L[0][0]-x2*L[2][0])*y2);
        a1[5][0] = m1m2*((x2*L[1][2]-y2*L[0][2])*y2-(x2*L[1][1]-y2*L[0][1])*z2);
        a1[5][1] = m1m2*((x2*L[1][0]-y2*L[0][0])*z2-(x2*L[1][2]-y2*L[0][2])*x2);
        a1[5][2] = m1m2*((x2*L[1][1]-y2*L[0][1])*x2-(x2*L[1][0]-y2*L[0][0])*y2);

        a1[5][1] = a1[1][5];
        a1[4][2] = a1[2][4];

        a1[3][3] = Ix2+m1m2*(y2*y2+z2*z2);
        a1[3][4] = -m1m2*x2*y2;
        a1[3][5] = -m1m2*x2*z2;
        a1[4][3] = -m1m2*x2*y2;
        a1[4][4] = Iy2+m1m2*(x2*x2+z2*z2);
        a1[4][5] = -m1m2*y2*z2;
        a1[5][3] = -m1m2*x2*z2;
        a1[5][4] = -m1m2*y2*z2;
        a1[5][5] = Iz2+m1m2*(x2*x2+y2*y2);

        //Задание матрицы правых частей уравнения A*omega` = B
        omega1[0] = x.get(0);
        omega1[1] = x.get(1);
        omega1[2] = x.get(2);
        omega2[0] = x.get(3);
        omega2[1] = x.get(4);
        omega2[2] = x.get(5);

        r1[0] = x1;
        r1[1] = y1;
        r1[2] = z1;
        r2[0] = x2;
        r2[1] = y2;
        r2[2] = z2;
        /*BigDecimal[] alfasamec = new BigDecimal[omega2.length];
        for ( int i = 0; i < omega2.length; i++){
            alfasamec[i] = BigDecimal.valueOf(omega2[i]);
        }*/
        Matrix.Vect_Vect_31(omega2,r2,WxR);
        Matrix.Vect_Vect_31(omega2,WxR,WxWxR2);// тут ошибка при Exi = 9.4, WxWxR2 = NaN!
        Matrix.Vect_Vect_31(omega1,r1,WxR);
        Matrix.Vect_Vect_31(omega1,WxR,WxWxR1);
        double[] WxWxR2_CK1 = Matrix.Mul_Matr_33_31(L,WxWxR2);
        double[] WxWxR1_CK2 = Matrix.Mul_Matr_33_31(Lm,WxWxR1);

        double[] W2subW1 = Matrix.AddM_Matr_31(WxWxR2_CK1,WxWxR1);
        double[] W1subW2 = Matrix.AddM_Matr_31(WxWxR1_CK2,WxWxR2);

        Matrix.Vect_Vect_31(r1,W2subW1,R1W);
        Matrix.Vect_Vect_31(r2,W1subW2,R2W);

        g = g0 * Math.pow(R3/(R3+x.get(14)),2);
        ro = 1.225 * Math.exp(-x.get(14)/7000);
        Cx1 = Cx01 * Math.cos(x.get(7)); //аэродинамические коэффициенты Cx < 0, Cy > 0.
        Cyp1 = Cy01 * Math.sin(x.get(7));
        Cx2 = Cx02 * Math.cos(x.get(10));
        Cyp2 = Cy02 * Math.sin(x.get(10));
        Cyv1 = Cyp1 * Math.cos(x.get(7)) + Cx1 * Math.sin(x.get(7));
        Cyv2 = Cyp2 * Math.cos(x.get(10)) + Cx2 * Math.sin(x.get(10));
        q = 0.5 * ro * x.get(12) * x.get(12);
        Rx1 = Cx1 * q * S1; //аэродинамические силы
        Ryp1 = Cyp1*q* S1;
        Rx2 = Cx2 * q * S2;
        Ryp2 = Cyp2 * q * S2;

        r51[0] = Rx1;
        r51[1] = Ryp1;
        r51[2] = 0;
        r52[0] = Rx2;
        r52[1] = Ryp2;
        r52[2] = 0;

        Matrix.Transp_Matr_33(L1p,Lx);
        RA1 = Matrix.Mul_Matr_33_31(Lx, r51);
        Matrix.Transp_Matr_33(L2p,Lx);
        RA2 = Matrix.Mul_Matr_33_31(Lx, r52);

        double[] r10  = Matrix.Mul_Matr_33_31(L1, RA2);
        Matrix.Vect_Vect_31(r1,r10,r1R2);
        r10 = Matrix.Mul_Matr_33_31(L1, RA1);
        Matrix.Vect_Vect_31(r1,r10,r1R1);
        r10 = Matrix.Mul_Matr_33_31(L2, RA1);
        Matrix.Vect_Vect_31(r2,r10,r2R1);
        r10 = Matrix.Mul_Matr_33_31(L2, RA2);
        Matrix.Vect_Vect_31(r2,r10,r2R2);

        a1[0][6] = m1m*r1R2[0] - m2m*r1R1[0] + m1m2*R1W[0];
        a1[1][6] = m1m*r1R2[1] - m2m*r1R1[1] + m1m2*R1W[1];
        a1[2][6] = m1m*r1R2[2] - m2m*r1R1[2] + m1m2*R1W[2];
        a1[3][6] = m2m*r2R1[0] - m1m*r2R2[0] + m1m2*R2W[0];
        a1[4][6] = m2m*r2R1[1] - m1m*r2R2[1] + m1m2*R2W[1];
        a1[5][6] = m2m*r2R1[2] - m1m*r2R2[2] + m1m2*R2W[2];

        n6 = 5;
        if (t > 10)
            n6 = 5;
        for (int i = 0; i < 6; i++)
            b1[i] = a1[i][6];
        for (int i = 0; i < 6; i++)
            for (int j = 1; j < 7; j++)
                a2[i][j] = a1[i][j];
        Gaus.init(n6, a1, b1);
        Gaus.algGaus();

        //b1 - полученная в результате решения матричного уравнения
        //матрица с заполненными первыми 6 элементами
        b1[6] = (x.get(2) * Math.sin(x.get(8)) - x.get(1) * Math.cos(x.get(8))) / Math.sin(x.get(7));
        b1[7] = x.get(2) * Math.cos(x.get(8)) + x.get(1) * Math.sin(x.get(8)) - Cyv1*q*S1/mass1/x.get(12);
        b1[8] = x.get(0) - b1[6] * Math.cos(x.get(7));
        b1[9] = x.get(5) * Math.sin(x.get(11)) - x.get(4) * Math.cos(x.get(11)) / Math.sin(x.get(10));
        b1[10] = x.get(5) * Math.cos(x.get(11)) + x.get(4) * Math.sin(x.get(11)) - Cyv2*q*S2/mass2/x.get(12);
        b1[11] = x.get(3) - b1[9] * Math.cos(x.get(10));
        //t = 6;
        //if (t >5) { //проверка лишняя
        t += 0.0;
        my1 = 0;
        mz1 = 0;
        //Rxv:=Rx1*cos(x[8])-Ry1*sin(x[8])+Rx2*cos(x[11])-Ry2*cos(x[11]);
        f.add(0, b1[0]);
        f.add(1, b1[1] + my1 * q * S1 * Math.abs(x1));
        f.add(2, b1[2] + mz1 * q * S1 * Math.abs(x1));

        for(int i = 3; i < 12; i++){
            f.add(i, b1[i]);
        }

        Rxv = RA1[0]+RA2[0];
        //Rxv:=-2*q*2.5;mass1:=4000;mass2:=400;
        f.add(12, Rxv/(mass1+mass2)-g * Math.sin(x.get(13)));
        f.add(13, (-g/x.get(12)+x.get(12)/(R3+x.get(14))) * Math.cos(x.get(13)));
        f.add(14, x.get(12) * Math.sin(x.get(13)));
        //}
    }

    static void PROFI(double t,List<Double> xx,List<Double> ff,List <Double> ffi){

        double dt = 0;
        double r2,r1;

        tk = 350;
        ffi.add(0, tk-t);
        if(t<dt1)
            return;
        PRINT(t,xx,ff);
    }

    private static boolean FlagVarStep;
    private static boolean FlagExiFunProc = true;
    private static boolean FlagDefExiOld = false;
    private static boolean FlagExiRetry = false;

    private static double RelEpsMax = 0;
    private static double StepMax2 = 0.5 * 0.05;
    private static int CurIte = 0;

    private static List<Double> tModList = new ArrayList<Double>(15);
    private static List<Double> Alfa1 = new ArrayList<Double>(15);
    private static List<Double> Alfa2 = new ArrayList<Double>(15);

    public static List<Double> x(){
        return tModList;
    }

    public static List<Double> y(){
        return xMod;
    }

    public static List<Double> yF(){
        return f;
    }

    public static void Rungecutt(int NumInt,double t, double Step,double StepMax, List <Double> Eps,int NumExi,int CurIteMax) {
        int i,j;
        double tMod,Step2,kI,RelEpsCur;

        //интегрирование методом Рунге-Кутта 4-го порядка
        Step2 = 0.5 * Step;
        tMod = t;
        tModList.add(tMod);
        for (i = 0; i < NumInt; i++)
            xNew.add(i, x0.get(i)); //тут было add
        while (true){
            if (FlagVarStep){
                RelEpsMax = 0;
            }
            PROF(tMod,xNew,f);

            if (FlagExiFunProc)
                PROFI(tMod,xNew,f,Exi);
            FlagExiFunProc = true;
            for (i = 0; i < NumInt; i++) {
                xBak.add(i, xNew.get(i)); //тут было add
                kI = f.get(i) * Step;
                xNew.add(i, xNew.get(i) + kI / 6);
                xMod.add(i,xBak.get(i) + 0.5 * kI); //тут было add
                EpsCur.add(i, kI); //тут было add
            }
            tMod = tMod + Step2;
            tModList.add(tMod);
            PROF(tMod,xMod,f);
            for (i = 0; i < NumInt; i++) {
                kI = f.get(i) * Step;
                xNew.set(i, xNew.get(i) + kI / 3);
                xMod.set(i, xBak.get(i) + 0.5 * kI);
                EpsCur.set(i, EpsCur.get(i) - kI);
            }
            PROF(tMod,xMod,f);
            for (i = 0; i < NumInt; i++) {
                kI = f.get(i) * Step;
                xNew.set(i, xNew.get(i) + kI / 3);
                xMod.set(i, xBak.get(i) + kI);
                EpsCur.set(i, EpsCur.get(i) - kI);
            }
            tMod = tMod + Step2;
            tModList.add(tMod);
            PROF(tMod,xMod,f);//При Exi = 9.4, тут всё ломается!
            for (i = 0; i < NumInt; i++) {
                kI = f.get(i) * Step;
                xNew.set(i, xNew.get(i) + kI / 6);
                EpsCur.set(i, EpsCur.get(i) + kI);
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
                Rungecutt(NumInt, t, Step, StepMax, Eps, NumExi, CurIteMax);
            }

            //проверка условия выхода
            for (j = 0; j < NumExi; j++) {
                ExiTol.add(0,9.40);
                if (Math.abs(Exi.get(j)) <= ExiTol.get(0)) {
                    CurExi = j;
                    return;
                }
                if (FlagDefExiOld) {
                    FlagExiRetry = false;
                    if ((Exi.get(j) * ExiOld.get(j)) < 0) {
                        if (CurIte >= CurIteMax) {
                            CurExi = -j;
                            return;
                        }
                        CurIte++;
                        FlagExiRetry = true;
                        FlagVarStep = false;
                        Step = Step * Exi.get(j) / (ExiOld.get(j) - Exi.get(j));
                    }
                }
                ExiOld.add(j,Exi.get(j));
                if (FlagExiRetry)
                    Rungecutt(NumInt, t, Step, StepMax, Eps, NumExi, CurIteMax);
            }
            FlagDefExiOld = true;

            //выполнение шага
            for (i = 0; i < NumInt; i++)
                x0.set(i,xNew.get(i));
            t = tMod;

            //увеличение шага }
            if ((FlagVarStep) || (RelEpsMax < 0.1) || (Step <= StepMax2)) {
                Step = 2 * Step;
                Rungecutt(NumInt, t, Step, StepMax, Eps, NumExi, CurIteMax);
            }
        }
    }

    /*public static void main(String[] args) {

        dt1 = 0;
        n = 15; //количество интервалов
        int t0 = 0; //начальное время
        n1 = 1;
        nmax = 100;
        //d.set(0,0.1);
        d.add(0,0.1); //сделать поменьше, это минимальный размер шага
        for(int i = 1; i < 15; i++){
            d.add(i,0.1);
        }
        double step = 0.05; //размер шага
        double stepmax = 0.05; //макси. размер шага
        //tk = 10;
        boolean bool = true;

        //==============ТЕСТИК============
        for(int i = 0; i < 15; i++){
            xNew.add(i,0.0);
            EpsCur.add(i,0.0);
            xMod.add(i,0.0);
            f.add(i,0.0);
            xBak.add(i,0.0);
        }
        //=================================

        //График рисуется на основе tMod и xNew?
        //BigDecimal m = new BigDecimal(x0.get(10));
        //x0.get(10).toString();
        ReadInitialData();
        Rungecutt(n,t0,step,stepmax,d, n1,nmax);
        for (Double x : x0)
        {
            System.out.println(x);
        }
    }*/
}


