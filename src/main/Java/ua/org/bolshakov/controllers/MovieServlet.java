package ua.org.bolshakov.controllers;

import ua.org.bolshakov.dto.MovieDTO;
import ua.org.bolshakov.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MovieServlet", urlPatterns={"/movie"})
public class MovieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MovieDTO movieDTO = MovieServiceImpl.getInstance().getById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("movieDTO", movieDTO);
        request.getRequestDispatcher("pages/common/movie.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
