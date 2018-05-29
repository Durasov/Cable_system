package dao;

import model.InputParametrs;
import java.util.List;

public interface InputParametrsDAO {

    String PARAMETRS_ID = "parametrs_id";

    String MASS1 = "mass1";

    String MASS2 = "mass2";

    String S1 = "S1";

    String S2 = "S2";

    String X1 = "x1";

    String Y1 = "y1";

    String Z1 = "z1";

    String X2 = "x2";

    String Y2 = "y2";

    String Z2 = "z2";

    String X3 = "x3";

    String Y3 = "y3";

    String Z3 = "z3";

    String IX1 = "ix1";

    String IY1 = "iy1";

    String IZ1 = "iz1";

    String IX2 = "ix2";

    String IY2 = "iy2";

    String IZ2 = "iz2";

    String CX1 = "cx1";

    String CY1 = "cy1";

    String CX2 = "cx2";

    String CY2 = "cy2";

    String MY1 = "my1";

    String MZ1 = "mz1";

    String MY2 = "my2";

    String MZ2 = "mz2";

    String W11 = "w11";

    String W12 = "w12";

    String W13 = "w13";

    String W21 = "w21";

    String W22 = "w22";

    String W23 = "w23";

    String W31 = "w31";

    String W32 = "w32";

    String W33 = "w33";

    String GAMMA1 = "gamma1";

    String ALFA1 = "alfa1";

    String FI1 = "fi1";

    String GAMMA2 = "gamma2";

    String ALFA2 = "alfa2";

    String FI2 = "fi2";

    String GAMMA3 = "gamma3";

    String ALFA3 = "alfa3";

    String FI3 = "fi3";

    String V = "v";

    String TETTA = "tetta";

    String H = "h";


    void addInputParametrs(InputParametrs result);

    List<InputParametrs> getInputParametrs();

    List<InputParametrs> getInputParametrs(InputParametrs inputParametrs);

    InputParametrs getInputParametrs(int parametrs_id);

    void updateInputParametrs(InputParametrs result);

    void deleteInputParametrs(int parametrs_id);
}
