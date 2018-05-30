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
import java.io.IOException;

@WebServlet("/editInputParameters")
public class EditInputParametersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputParametrsDAO inputParametrsDAO = new InputParametrsDAOImpl(DAOPostgres.getInstance());
        InputParametrs inputParametrs = null;
        if (req.getParameter("parametrsId") != null) {
            int team_id = Integer.parseInt(req.getParameter("parametrsId"));
            inputParametrs = inputParametrsDAO.getInputParametrs(team_id);
        }
        req.getSession().setAttribute("parametersToEdit", inputParametrs);
        req.getRequestDispatcher("editInputParameters.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //if (//req.getParameter("team_id") != null &&
                //req.getParameter("team_name") != null &&
                        //req.getParameter("team_country") != null) {
            //team_id = Integer.parseInt(req.getParameter("team_id"));

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
            InputParametrs inputParametrs = (InputParametrs) req.getSession().getAttribute("parametersToEdit");

            inputParametrs.setMassFirst(massFirst);
            inputParametrs.setMassSecond(massSecond);

            inputParametrs.setS1(S1);
            inputParametrs.setS2(S2);

            inputParametrs.setX1(x1);
            inputParametrs.setY1(y1);
            inputParametrs.setZ1(z1);

            inputParametrs.setX2(x2);
            inputParametrs.setY2(y2);
            inputParametrs.setZ2(z2);

            inputParametrs.setX3(x3);
            inputParametrs.setY3(y3);
            inputParametrs.setZ3(z3);

            inputParametrs.setIx1(ix1);
            inputParametrs.setIy1(iy1);
            inputParametrs.setIz1(iz1);
            inputParametrs.setIx2(ix2);
            inputParametrs.setIy2(iy2);
            inputParametrs.setIz2(iz2);

            inputParametrs.setCx1(cx1);
            inputParametrs.setCy1(cy1);
            inputParametrs.setCx2(cx2);
            inputParametrs.setCy2(cy2);

            inputParametrs.setMy1(my1);
            inputParametrs.setMz1(mz1);
            inputParametrs.setMy2(my2);
            inputParametrs.setMz2(mz2);

            inputParametrs.setW11(w11);
            inputParametrs.setW12(w12);
            inputParametrs.setW13(w13);
            inputParametrs.setW21(w21);
            inputParametrs.setW22(w22);
            inputParametrs.setW23(w23);
            inputParametrs.setW31(w31);
            inputParametrs.setW32(w32);
            inputParametrs.setW33(w33);

            inputParametrs.setGamma1(gamma1);
            inputParametrs.setAlfa1(alfa1);
            inputParametrs.setFi1(fi1);
            inputParametrs.setGamma2(gamma2);
            inputParametrs.setAlfa2(alfa2);
            inputParametrs.setFi2(fi2);
            inputParametrs.setGamma3(gamma3);
            inputParametrs.setAlfa3(alfa3);
            inputParametrs.setFi3(fi3);

            inputParametrs.setV(v);
            inputParametrs.setTetta(tetta);
            inputParametrs.setH(h);

            inputParametrsDAO.updateInputParametrs(inputParametrs);
            resp.sendRedirect("/inputParameters");
        //}
    }
}
