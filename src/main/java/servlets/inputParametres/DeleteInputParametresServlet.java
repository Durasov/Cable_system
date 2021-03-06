package servlets.inputParametres;

import dao.InputParametrsDAO;
import dao.impl.DAOPostgres;
import dao.impl.InputParametrsDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteInputParameters")
public class DeleteInputParametresServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        InputParametrsDAO inputParametrsDAO = new InputParametrsDAOImpl(DAOPostgres.getInstance());
        if (req.getParameter("parametrsId") != null) {
            int parametrsId = Integer.parseInt(req.getParameter("parametrsId"));
            inputParametrsDAO.deleteInputParametrs(parametrsId);
        }
        resp.sendRedirect("inputParameters");
    }
}
