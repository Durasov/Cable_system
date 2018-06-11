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
                    inputParametrs.getY2(),inputParametrs.getZ2(),inputParametrs.getX3(),inputParametrs.getY3(),inputParametrs.getZ3(),
                    inputParametrs.getIx1(),inputParametrs.getIy1(),inputParametrs.getIz1(),inputParametrs.getIx2(),inputParametrs.getIy2(),inputParametrs.getIz2(),
                    inputParametrs.getCx1(),inputParametrs.getCy1(),inputParametrs.getCx2(),inputParametrs.getCy2(),
                    inputParametrs.getMy1(),inputParametrs.getMz1(),inputParametrs.getMy2(),inputParametrs.getMz2(),
                    inputParametrs.getW11(),inputParametrs.getW12(),inputParametrs.getW13(),inputParametrs.getW21(),inputParametrs.getW22(),inputParametrs.getW23(),
                    inputParametrs.getW31(),inputParametrs.getW32(),inputParametrs.getW33(),inputParametrs.getGamma1(),inputParametrs.getAlfa1(),inputParametrs.getFi1(),
                    inputParametrs.getGamma2(),inputParametrs.getAlfa2(),inputParametrs.getFi2(),inputParametrs.getGamma3(),inputParametrs.getAlfa3(),inputParametrs.getFi3(),
                    inputParametrs.getV(),inputParametrs.getTetta(),inputParametrs.getH());
        }
        resp.sendRedirect("/inputParametersRungeKutta.jsp");
    }

}
