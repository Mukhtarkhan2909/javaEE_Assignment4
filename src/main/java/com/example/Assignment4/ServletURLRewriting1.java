package com.example.Assignment4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletURLRewriting1", value = "/servlet-url-rewriting1")
public class ServletURLRewriting1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n=request.getParameter("userName");
            request.getRequestDispatcher("header.jsp").include(request, response);
            out.print("<h1>Welcome " + n + "</h1>");

            //appending the username in the query string
            out.print("<a href='servlet-url-rewriting2?uname=" + n + "'>visit</a>");
            request.getRequestDispatcher("footer.jsp").include(request, response);
            out.close();

        }catch(Exception e){System.out.println(e);}
    }
}
