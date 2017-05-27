package ua.org.bolshakov.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "time", urlPatterns = {"/time"})
public class Time extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        String name = "NA";
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("name")){
                name = cookie.getValue();
            }
        }
       // Cookie cookie = new Cookie("name", "Vasya");
      //  response.addCookie(cookie);
        try (PrintWriter writer = response.getWriter();){
            writer.print("<html><body><h2>Time</h2>");
        writer.print("<br>");
        writer.print(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        writer.print("<br>");
        writer.print("name = " + name);
        writer.print("</body></html>");

            System.out.println("Time Servlet");
    }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
