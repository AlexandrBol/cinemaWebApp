package ua.org.bolshakov.controllers;

import ua.org.bolshakov.dao.DaoFactory;
import ua.org.bolshakov.dao.impl.SQLs;
import ua.org.bolshakov.dao.impl.UserDaoImpl;
import ua.org.bolshakov.dto.RoleDTO;
import ua.org.bolshakov.dto.UserDTO;
import ua.org.bolshakov.model.Role;
import ua.org.bolshakov.model.User;
import ua.org.bolshakov.service.impl.UserServiceImpl;

import javax.jws.soap.SOAPBinding;
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
       // LocalDate birthday =  LocalDate().LocalDate.parse(request.getParameter("birthday"), formatter);
        LocalDate birthday = LocalDate.of(1960, 12, 1);
        RoleDTO roleDTO = new RoleDTO("User");
      //  Role role= new Role("User");
      //  UserDTO userDTO = //(new UserDTO(login, password, firstName, lastName, email,  sex,  birthday, roleDTO));
      // User user = new User(login, password, firstName, lastName, email,  sex,  birthday, role);
       UserDTO  userDTO = new UserDTO(login, password, firstName, lastName, email,  sex,  birthday, roleDTO);

    UserServiceImpl.getInstance().update(userDTO);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
