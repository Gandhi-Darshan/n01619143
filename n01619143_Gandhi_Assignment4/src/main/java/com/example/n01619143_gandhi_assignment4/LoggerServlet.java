package com.example.n01619143_gandhi_assignment4;

import java.io.*;

import com.example.n01619143_gandhi_assignment4.Bean.LoggerBean;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/logger")
public class LoggerServlet extends HttpServlet {

    @EJB
    private LoggerBean loggerBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException {

        String action = req.getParameter("action");

        if (action != null && !action.isEmpty()) {
            loggerBean.log(action);
            resp.getWriter().println("Action '" + action + "' was logged");
        }else {
            resp.getWriter().println("No action specified");
        }
    }
}