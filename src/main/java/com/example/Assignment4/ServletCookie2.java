package com.example.Assignment4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCookie2", value = "/servlet-cookie2")
public class ServletCookie2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            Cookie[] ck = request.getCookies();
            request.getRequestDispatcher("header.jsp").include(request, response);
            out.print("<h1>Hello " + ck[ck.length - 1].getValue() + "</h1>");
            request.getRequestDispatcher("footer.jsp").include(request, response);
            out.close();
        }catch(Exception e){System.out.println("Error");}
    }
}
