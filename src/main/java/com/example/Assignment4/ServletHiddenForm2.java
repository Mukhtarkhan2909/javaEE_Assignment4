package com.example.Assignment4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletHiddenForm2", value = "/servlet-hidden-form2")
public class ServletHiddenForm2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            //Getting the value from the hidden field
            String n = request.getParameter("uname");
            request.getRequestDispatcher("header.jsp").include(request, response);
            out.print("<h1>Hello " + n + "</h1>");
            request.getRequestDispatcher("footer.jsp").include(request, response);
            out.close();
        }catch(Exception e){System.out.println("Error");}
    }
}
