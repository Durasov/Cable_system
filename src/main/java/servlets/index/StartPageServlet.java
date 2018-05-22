package main.java.servlets.index;

import main.java.math_methods.RungeKutta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class StartPageServlet extends HttpServlet {

    private static List <Double> d = new ArrayList<Double>(15);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n;
        int t0;
        double step;
        double stepmax;
        int n1;
        int nmax;
        int a;
        int b;

        if (req.getParameter("n") != null &&
                req.getParameter("t0") != null &&
                req.getParameter("step") != null) {
            HttpSession session = req.getSession();
            n = Integer.parseInt(req.getParameter("n"));
            t0 = Integer.parseInt(req.getParameter("t0"));
            step = Double.parseDouble(req.getParameter("step"));
            stepmax = Double.parseDouble(req.getParameter("stepmax"));
            n1 = Integer.parseInt(req.getParameter("n1"));
            nmax = Integer.parseInt(req.getParameter("nmax"));
            a = Integer.parseInt(req.getParameter("a"));
            b = Integer.parseInt(req.getParameter("b"));

            d.add(0,10.0); //сделать поменьше, это минимальный размер шага
            for(int i = 1; i < 15; i++){
                d.add(i,0.1);
            }
            RungeKutta.ReadInitialData();
            RungeKutta.Rungecutt(n,t0,step,stepmax,d, n1,nmax);

            List <Double> x = RungeKutta.x();
            List<Double> y = RungeKutta.y(); // тут массив xMod
            List<Double> yF = RungeKutta.yF(); // тут массив f

            List<Double> TestX = new ArrayList<Double>(15);
            List<Double> TestY = new ArrayList<Double>(15);
            for (int i = a; i < b; i++){
                TestX.add(x.get(i));
                TestY.add(y.get(i));
            }

            req.setAttribute("x", TestX);
            req.setAttribute("y", TestY);

            req.getRequestDispatcher("/TestGraphics.jsp").forward(req,resp);
            //resp.sendRedirect("/index");
        }
    }
}
