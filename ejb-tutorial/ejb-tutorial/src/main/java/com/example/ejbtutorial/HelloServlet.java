package com.example.ejbtutorial;

import com.example.ejb.CalculatorBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @EJB
    private CalculatorBean calculatorBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int a = 10;
        int b = 5;

        int sum = calculatorBean.add(a, b);
        int diff = calculatorBean.subtract(a, b);
        int prod = calculatorBean.multiply(a, b);
        int div = calculatorBean.divide(a, b);

        response.setContentType("text/html");
        response.getWriter().println("<h2>Calculator Operations:</h2>");
        response.getWriter().println("<p>" + a + " + " + b + " = " + sum + "</p>");
        response.getWriter().println("<p>" + a + " - " + b + " = " + diff + "</p>");
        response.getWriter().println("<p>" + a + " * " + b + " = " + prod + "</p>");
        response.getWriter().println("<p>" + a + " / " + b + " = " + div + "</p>");
    }
}
