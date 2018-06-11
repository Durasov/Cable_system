package servlets.inputParametres;

import dao.InputParametrsDAO;
import dao.impl.DAOPostgres;
import dao.impl.InputParametrsDAOImpl;
import model.InputParametrs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addInputParameters")
public class AddInputParametersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addInputParameters.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int parametrs_id = Integer.parseInt(req.getParameter("parametrsId"));
        double massFirst = Double.parseDouble(req.getParameter("massFirst"));
        double massSecond = Double.parseDouble(req.getParameter("massSecond"));
        double S1 = Double.parseDouble(req.getParameter("S1"));
        double S2 = Double.parseDouble(req.getParameter("S2"));
        double x1 = Double.parseDouble(req.getParameter("x1"));
        double y1 = Double.parseDouble(req.getParameter("y1"));
        double z1 = Double.parseDouble(req.getParameter("z1"));
        double x2 = Double.parseDouble(req.getParameter("x2"));
        double y2 = Double.parseDouble(req.getParameter("y2"));
        double z2 = Double.parseDouble(req.getParameter("z2"));
        double x3 = Double.parseDouble(req.getParameter("x3"));
        double y3 = Double.parseDouble(req.getParameter("y3"));
        double z3 = Double.parseDouble(req.getParameter("z3"));
        double ix1 = Double.parseDouble(req.getParameter("ix1"));
        double iy1 = Double.parseDouble(req.getParameter("iy1"));
        double iz1 = Double.parseDouble(req.getParameter("iz1"));
        double ix2 = Double.parseDouble(req.getParameter("ix2"));
        double iy2 = Double.parseDouble(req.getParameter("iy2"));
        double iz2 = Double.parseDouble(req.getParameter("iz2"));
        double cx1 = Double.parseDouble(req.getParameter("cx1"));
        double cy1 = Double.parseDouble(req.getParameter("cy1"));
        double cx2 = Double.parseDouble(req.getParameter("cx2"));
        double cy2 = Double.parseDouble(req.getParameter("cy2"));
        double my1 = Double.parseDouble(req.getParameter("my1"));
        double mz1 = Double.parseDouble(req.getParameter("mz1"));
        double my2 = Double.parseDouble(req.getParameter("my2"));
        double mz2 = Double.parseDouble(req.getParameter("mz2"));
        double w11 = Double.parseDouble(req.getParameter("w11"));
        double w12 = Double.parseDouble(req.getParameter("w12"));
        double w13 = Double.parseDouble(req.getParameter("w13"));
        double w21 = Double.parseDouble(req.getParameter("w21"));
        double w22 = Double.parseDouble(req.getParameter("w22"));
        double w23 = Double.parseDouble(req.getParameter("w23"));
        double w31 = Double.parseDouble(req.getParameter("w31"));
        double w32 = Double.parseDouble(req.getParameter("w32"));
        double w33 = Double.parseDouble(req.getParameter("w33"));
        double gamma1 = Double.parseDouble(req.getParameter("gamma1"));
        double alfa1 = Double.parseDouble(req.getParameter("alfa1"));
        double fi1 = Double.parseDouble(req.getParameter("fi1"));
        double gamma2 = Double.parseDouble(req.getParameter("gamma2"));
        double alfa2 = Double.parseDouble(req.getParameter("alfa2"));
        double fi2 = Double.parseDouble(req.getParameter("fi2"));
        double gamma3 = Double.parseDouble(req.getParameter("gamma3"));
        double alfa3 = Double.parseDouble(req.getParameter("alfa3"));
        double fi3 = Double.parseDouble(req.getParameter("fi3"));
        double v = Double.parseDouble(req.getParameter("v"));
        double tetta = Double.parseDouble(req.getParameter("tetta"));
        double h = Double.parseDouble(req.getParameter("h"));

            InputParametrsDAO inputParametrsDAO = new InputParametrsDAOImpl(DAOPostgres.getInstance());
            InputParametrs inputParametrs = new InputParametrs(parametrs_id, massFirst, massSecond, S1, S2, x1, y1, z1,
                    x2, y2, z2, x3, y3, z3, ix1, iy1, iz1, ix2, iy2, iz2, cx1, cy1, cx2, cy2, my1, mz1, my2, mz2,
                    w11, w12, w13, w21, w22, w23, w31, w32, w33, gamma1, alfa1, fi1, gamma2, alfa2, fi2,
                    gamma3, alfa3, fi3, v, tetta, h);
            inputParametrsDAO.addInputParametrs(inputParametrs);
            resp.sendRedirect("/inputParameters");
        }
    }
