package ua.org.bolshakov.controllers;

import ua.org.bolshakov.dto.HallDTO;
import ua.org.bolshakov.service.impl.HallServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "AddHall", urlPatterns={"/addHall"})
public class AddHall extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/admin/addHall.jsp").forward(request, response);
        String name = request.getParameter("name");
        Integer price = Integer.valueOf(request.getParameter("price"));
        HallDTO hallDTO = new HallDTO(name, price);
        HallServiceImpl.getInstance().update(hallDTO);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
