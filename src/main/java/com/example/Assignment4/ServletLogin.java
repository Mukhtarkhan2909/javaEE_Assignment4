package com.example.Assignment4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletLogin", value = "/servlet-login")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        request.getRequestDispatcher("cookieLogin.jsp").include(request, response);

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if(password.equals("admin")){
            out.print("<h1>You are successfully logged in!</h1>");
            out.print("<br><h1>Welcome, " + name + "</h1>");

            Cookie ck = new Cookie("name",name);
            response.addCookie(ck);
        }else{
            out.print("<h1>sorry, username or password error!</h1>");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
