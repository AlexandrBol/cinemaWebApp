package ua.org.bolshakov.controllers;


import ua.org.bolshakov.dao.DaoFactory;
import ua.org.bolshakov.dao.api.Dao;
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
import java.time.LocalDate;

@WebServlet(name = "RegisterServlet", urlPatterns={"register"})
public class RegisterServlet extends HttpServlet {


static final String DEFAULT_ROLE= "user";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String sex = request.getParameter("sex");
        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));

        // TODO Validate

      try {
          User user = new User(login, password, firstName, lastName, email, sex, birthday,DaoFactory.getInstance().getRoleDao().getById(2));
          DaoFactory.getInstance().getUserDao().save(user);
          request.getSession().setAttribute("user",user);
          response.sendRedirect("index.jsp");
      }
      catch (Exception e ){
          request.getRequestDispatcher("pages/common/login.jsp");
      }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
