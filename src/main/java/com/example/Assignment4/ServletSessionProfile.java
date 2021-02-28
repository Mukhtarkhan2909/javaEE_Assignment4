package com.example.Assignment4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletSessionProfile", value = "/servlet-session-profile")
public class ServletSessionProfile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("sessionIndex.jsp").include(request, response);

        HttpSession session=request.getSession(false);
        if(session!=null){
            String name=(String)session.getAttribute("name");

            out.print("<h1>Hello, "+name+" Welcome to Profile</h1>");
        }
        else{
            out.print("<h1>Please login first</h1>");
            request.getRequestDispatcher("sessionLogin.jsp").include(request, response);
        }
        out.close();
    }
}
