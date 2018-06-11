package servlets.inputParametres;

        import dao.InputParametrsDAO;
        import dao.DAO;
        import dao.impl.InputParametrsDAOImpl;
        import dao.impl.DAOPostgres;
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
        req.getSession().setAttribute("inputParametres", inputParametrs);
        req.getRequestDispatcher("inputParameters.jsp").forward(req,resp);
    }
}
