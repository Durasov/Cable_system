package dao;

import model.InputParameters2;
import java.util.List;

public interface InputParameters2DAO {

    String PARAMETRS_ID = "parametrs_id";

    String PARAMETRS_ID2 = "parametrs_id2";

    String W1 = "w1";

    String W2 = "w2";

    String W3 = "w3";

    String W4 = "w4";

    String W5 = "w5";

    String W6 = "w6";

    String GAMMA1 = "gamma1";

    String ALFA1 = "alfa1";

    String FI1 = "fi1";

    String GAMMA2 = "gamma2";

    String ALFA2 = "alfa2";

    String FI2 = "fi2";

    String V = "v";

    String TETTA = "tetta";

    String H = "h";

    String CX01 = "cx01";

    String CX02 = "cx02";

    String CY01 = "cy01";

    String CY02 = "cy02";

    void addInputParameters2(InputParameters2 inputParameters2);

    List<InputParameters2> getInputParameters2();

    List<InputParameters2> getInputParameters2(InputParameters2 inputParametrs2);

    InputParameters2 getInputParameters2(int parametrs_id2);

    void updateInputParameters2(InputParameters2 inputParameters2);

    void deleteInputParameters2(int parametrs_id2);
}

