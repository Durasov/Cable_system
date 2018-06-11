package dao;

import model.RungeKuttaParameters;

import java.util.List;

public interface RungeKuttaParametersDAO {

    String RKPARAMETERS_ID = "rkparameters_id";

    String PARAMETRS_ID = "parametrs_id";

    String H = "h";

    String T0 = "t0";

    String NMAX = "nmax";

    //void addRungeKuttaParameters(RungeKuttaParameters rungeKuttaParameters);

    List<RungeKuttaParameters> getRungeKuttaParameters();
}
