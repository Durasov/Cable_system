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

    String RA11 = "RA11";

    String RA12 = "RA12";

    String RA13 = "RA13";

    String RA21 = "RA21";

    String RA22 = "RA22";

    String RA23 = "RA23";

    String IX1 = "Ix1";

    String IY1 = "Iy1";

    String IZ1 = "Iz1";

    String IX2 = "Ix2";

    String IY2 = "Iy2";

    String IZ2 = "Iz2";

    void addInputParametrs(InputParametrs result);

    List<InputParametrs> getInputParametrs();

    List<InputParametrs> getInputParametrs(InputParametrs inputParametrs);

    InputParametrs getInputParametrs(int parametrs_id);

    void updateInputParametrs(InputParametrs result);

    void deleteInputParametrs(int parametrs_id);
}
