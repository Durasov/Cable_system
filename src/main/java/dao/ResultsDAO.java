package dao;

import model.Results;

import java.util.List;

public interface ResultsDAO {

    String RESULT_ID = "result_id";

    String PARAMETRS_ID = "parametrs_id";

    String GAMMA1 = "gamma1";

    String ALFA1 = "alfa1";

    String FI1 = "fi1";

    String N = "n";

    void addResults(Results results);

    List<Results> getResults();

    void deleteResults(int parametrs_id);
}
