package ua.org.bolshakov.controllers;

import ua.org.bolshakov.dto.MovieDTO;
import ua.org.bolshakov.service.impl.MovieServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MovieListServlet", urlPatterns={"/movies"})
public class MovieListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        List<MovieDTO> movieDTOList = MovieServiceImpl.getInstance().getAll();
        request.setAttribute("movieDTOList", movieDTOList);
        request.getRequestDispatcher("pages/common/movies.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}
