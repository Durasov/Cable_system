package servlets.results;

import dao.GraphicsDAO;
import dao.ResultsDAO;
import dao.impl.DAOPostgres;
import dao.impl.GraphicsDAOImpl;
import dao.impl.ResultsDAOImpl;
import model.Graphics;
import model.Results;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/results")
public class ResultsListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultsDAO resultsDAO = new ResultsDAOImpl(DAOPostgres.getInstance());
        List<Results> results = resultsDAO.getResults();
        GraphicsDAO graphicsDAO = new GraphicsDAOImpl(DAOPostgres.getInstance());
        List<Graphics> graphics = graphicsDAO.getGraphics();
        req.getSession().setAttribute("graphics", graphics);
        req.getSession().setAttribute("results", results);
        req.getRequestDispatcher("results.jsp").forward(req,resp);
    }
}
