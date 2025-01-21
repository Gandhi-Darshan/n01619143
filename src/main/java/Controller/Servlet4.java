package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class Servlet4
 */
public class Servlet4 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");

        response.setIntHeader("Refresh", 1);

        LocalDateTime datetime = LocalDateTime.now();

        DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String formattedDate = datetime.format(datetimeFormatter);

        PrintWriter out = response.getWriter();

        String cssTag = "<link rel='Stylesheet' type=text/css href='./style.css'>";

        String docType = "<!DOCTYPE html>\n";

        out.println(docType + "<HTML>\n"
                + "<HEAD><TITLE>Hello</TITLE>" + cssTag + "</HEAD>\n"
                + "<BODY>\n"
                + "<H1>Hello</H1>\n"
                + "<H3> Before Formatting" + datetime + "</H3>"
                + "<H3> Before Formatting" + formattedDate + "</H3>"
                + "<H5>Darshan Gandhi</H5>\n"
                + "</BODY></HTML>");

        System.out.println("Inside Get Method");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
