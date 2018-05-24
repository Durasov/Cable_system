package servlets.inputParametres;


import dao.InputParameters2DAO;
import dao.InputParametrsDAO;
import dao.DAO;
import dao.impl.InputParameters2DAOImpl;
import dao.impl.InputParametrsDAOImpl;
import dao.impl.DAOPostgres;
import model.InputParameters2;
import model.InputParametrs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/inputParameters")
public class InputParametersListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputParametrsDAO inputParametrsDAO = new InputParametrsDAOImpl(DAOPostgres.getInstance());
        List<InputParametrs> inputParametrs = inputParametrsDAO.getInputParametrs();
        InputParameters2DAO inputParameters2DAO = new InputParameters2DAOImpl(DAOPostgres.getInstance());
        List<InputParameters2> inputParameters2 = inputParameters2DAO.getInputParameters2();
        req.getSession().setAttribute("inputParameters2", inputParameters2);
        req.getSession().setAttribute("inputParametres", inputParametrs);
        req.getRequestDispatcher("inputParameters.jsp").forward(req,resp);
    }
}