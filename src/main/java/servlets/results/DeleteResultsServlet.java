package servlets.results;

import dao.GraphicsDAO;
import dao.ResultsDAO;
import dao.impl.DAOPostgres;
import dao.impl.GraphicsDAOImpl;
import dao.impl.ResultsDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteResults")
public class DeleteResultsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ResultsDAO resultsDAO = new ResultsDAOImpl(DAOPostgres.getInstance());
        GraphicsDAO graphicsDAO = new GraphicsDAOImpl(DAOPostgres.getInstance());
        if (req.getParameter("parametrsId") != null) {
            int parametrsId = Integer.parseInt(req.getParameter("parametrsId"));
            resultsDAO.deleteResults(parametrsId);
            graphicsDAO.deleteGraphic(parametrsId);
        }
        resp.sendRedirect("results");
    }
}
