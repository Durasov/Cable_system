package servlets.rkparameters;

import dao.RungeKuttaParametersDAO;
import dao.impl.DAOPostgres;
import dao.impl.RungeKuttaParametersDAOImpl;
import model.RungeKuttaParameters;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/rkparameters")
public class RungeKuttaParametersListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RungeKuttaParametersDAO rungeKuttaParametersDAO = new RungeKuttaParametersDAOImpl(DAOPostgres.getInstance());
        List<RungeKuttaParameters> rungeKuttaParameters = rungeKuttaParametersDAO.getRungeKuttaParameters();
        req.getSession().setAttribute("rkparameters", rungeKuttaParameters);
        req.getRequestDispatcher("inputParametersRungeKutta.jsp").forward(req,resp);
    }
}
