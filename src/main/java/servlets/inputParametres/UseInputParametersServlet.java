package servlets.inputParametres;

import math_methods.RungeKutta;
import model.InputParametrs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/useParameters")
public class UseInputParametersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("parametrsId") != null) {
            int parametrsId = Integer.parseInt(req.getParameter("parametrsId"));
            HttpSession session = req.getSession();
            List<InputParametrs> inputParametrList= (List<InputParametrs>) session.getAttribute("inputParametrList");
            InputParametrs inputParametrs = (InputParametrs)inputParametrList.get(parametrsId);
            RungeKutta.ReadInitialParameters(inputParametrs.getMassFirst(), inputParametrs.getMassSecond(), inputParametrs.getS1(),
                    inputParametrs.getS2(),inputParametrs.getX1(),inputParametrs.getY1(),inputParametrs.getZ1(),inputParametrs.getX2(),
                    inputParametrs.getY2(),inputParametrs.getZ2(),inputParametrs.getRA11(),inputParametrs.getRA12(),inputParametrs.getRA13(),
                    inputParametrs.getRA21(),inputParametrs.getRA22(),inputParametrs.getRA23(),inputParametrs.getIx1(),inputParametrs.getIy1(),
                    inputParametrs.getIz1(),inputParametrs.getIx2(),inputParametrs.getIy2(),inputParametrs.getIz2());
        }
        //req.getRequestDispatcher("editTeam.jsp").forward(req, resp);
        resp.sendRedirect("/index");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double massSecond = Double.parseDouble(req.getParameter("massSecond"));
        req.getRequestDispatcher("/TestGraphics.jsp").forward(req, resp);
        //resp.sendRedirect("/index");
    }
}
