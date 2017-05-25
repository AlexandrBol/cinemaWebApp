package ua.org.bolshakov.controllers;

import ua.org.bolshakov.dto.UserDTO;
import ua.org.bolshakov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(name = "LoginServlet", urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserDTO userDTO = UserServiceImpl.getInstance().getByLogin(login);
        request.getRequestDispatcher("pages/common/login.jsp").forward(request, response);
        if(userDTO != null && userDTO.getPassword().equals(password)){
            request.getSession().setAttribute("user", userDTO);
            response.sendRedirect(request.getSession().getAttribute("/pages/admin/admin.jsp").toString());

        }else{
            request.getSession().setAttribute("message", "Wrong users name or password");
            response.sendRedirect(request.getContextPath() + "/login");
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }

}
