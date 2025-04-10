package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Servlet2
 */
public class Servlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        System.out.println("Inside init Method");

    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String cssTag = "<link rel='Stylesheet' type=text/css href='./style.css'>";

        String docType = "<!DOCTYPE html>\n";

        out.println(docType + "<HTML>\n"
                + "<HEAD><TITLE>Hello</TITLE>" + cssTag + "</HEAD>\n"
                + "<BODY>\n"
                + "<H1>Hello</H1>\n"
                + "<H5>Darshan Gandhi</H5>\n"
                + "</BODY></HTML>");

        System.out.println("Inside Get Method");
    }

    public void destroy() {
        System.out.println("Inside Destroy Method");

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
