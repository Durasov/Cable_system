package servlets.inputParametres;

import math_methods.RungeKutta;

import dao.DAO;
import dao.impl.DAOPostgres;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/inputParametersRungeKutta")
public class inputParametersRungeKutta extends HttpServlet {

    private static List <Integer> x = new ArrayList<Integer>(15);
    private static List <Double> y = new ArrayList<Double>(15);
    private static List <Double> gamma1 = new ArrayList<Double>(15);
    private static List <Double> fi1 = new ArrayList<Double>(15);
    private static List <Double> N = new ArrayList<Double>(15);
    private static List <Double> H = new ArrayList<Double>(15);
    private static List <Double> R0 = new ArrayList<Double>(15);
    private static List <Double> qList = new ArrayList<Double>(15);
    private static List <Double> Test = new ArrayList<Double>(15);
    private static List <Double> Test2 = new ArrayList<Double>(15);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double t0;
        double h;
        int nmax;

        if (req.getParameter("step") != null &&
                req.getParameter("t0") != null &&
                req.getParameter("nmax") != null) {
            HttpSession session = req.getSession();
            h = Double.parseDouble(req.getParameter("step"));
            t0 = Double.parseDouble(req.getParameter("t0"));
            nmax = Integer.parseInt(req.getParameter("nmax"));

            RungeKutta.Runge_Kutta4(h,t0,nmax);
            //x = RungeKutta.x();
            if(x.size() > 0){
                x.clear();
            }
            for(double d: RungeKutta.x()){
                x.add((int)d);
            }
            y = RungeKutta.y(); // тут массив Alfa1
            gamma1 = RungeKutta.getGamma1();
            fi1 = RungeKutta.getFi1();
            N = RungeKutta.N();
            H = RungeKutta.H();
            R0 = RungeKutta.R0();
            qList = RungeKutta.getqList();

            List<Integer> TestX = new ArrayList<Integer>(15); // x на заданном интервале
            List<Double> TestY = new ArrayList<Double>(15); // y на заданном интервале
            List<Double> TestN = new ArrayList<Double>(15); // N на заданном интервале
            for (int i = 0; i < 5000; i++){
                TestX.add(x.get(i));
                TestY.add(gamma1.get(i));
                TestN.add(N.get(i));
            }

            req.setAttribute("x", x);
            req.setAttribute("y", y);
            req.setAttribute("x1", x);
            req.setAttribute("N", N);
            req.setAttribute("H", H);
            req.setAttribute("R0", R0);
            req.setAttribute("gamma1", qList);
            req.setAttribute("TestX", x);

            long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory(); //потом поделить на 1048576

            req.getRequestDispatcher("/Graphics.jsp").forward(req,resp);
        }
    }

    public static List<Double> getY(){
        return y;
    }

    public static List<Double> getGamma1(){
        return gamma1;
    }

    public static List<Double> getFi1(){
        return fi1;
    }

    public static List<Double> getN(){
        return N;
    }
}

