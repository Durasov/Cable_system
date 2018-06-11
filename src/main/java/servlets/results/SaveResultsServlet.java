package servlets.results;

import dao.impl.DAOPostgres;
import dao.ResultsDAO;
import dao.impl.ResultsDAOImpl;
import model.Results;
import servlets.inputParametres.EditInputParametersServlet;
import servlets.inputParametres.inputParametersRungeKutta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/saveParameters")
public class SaveResultsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int result_id;
        int parametrs_id;

            List<Double> alfa1 = inputParametersRungeKutta.getY();
            List<Double> gamma1 = inputParametersRungeKutta.getGamma1();
            List<Double> fi1 = inputParametersRungeKutta.getFi1();
            List<Double> n = inputParametersRungeKutta.getN();
            parametrs_id = EditInputParametersServlet.getTeam_id();
            result_id = parametrs_id;
            ResultsDAO resultsDAO = new ResultsDAOImpl(DAOPostgres.getInstance());
            for (int i = 0; i < 100; i++) {
                result_id++;
                Results results = new Results(result_id, parametrs_id, gamma1.get(i), alfa1.get(i), fi1.get(i), n.get(i));
                resultsDAO.addResults(results);
            }
            resp.sendRedirect("/results");
    }
}
