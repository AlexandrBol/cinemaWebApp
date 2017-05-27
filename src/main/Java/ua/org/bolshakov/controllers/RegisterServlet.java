package ua.org.bolshakov.controllers;

import ua.org.bolshakov.dao.DaoFactory;
import ua.org.bolshakov.dao.impl.UserDaoImpl;
import ua.org.bolshakov.dto.RoleDTO;
import ua.org.bolshakov.dto.UserDTO;
import ua.org.bolshakov.model.Role;
import ua.org.bolshakov.model.User;
import ua.org.bolshakov.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "RegisterServlet", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/common/register.jsp").forward(request, response);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"), formatter);
        RoleDTO roleDTO = new RoleDTO("User");

       // UserDTO userDTO = UserServiceImpl.getInstance().update(new UserDTO(login, password, firstName, lastName, email,  sex,  birthday, roleDTO));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
