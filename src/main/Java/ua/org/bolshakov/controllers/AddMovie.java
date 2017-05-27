package ua.org.bolshakov.controllers;

import com.mysql.jdbc.*;
import com.mysql.jdbc.Connection;
import ua.org.bolshakov.dao.impl.CrudDAO;
import ua.org.bolshakov.dao.impl.MovieDaoImpl;
import ua.org.bolshakov.dto.MovieDTO;
import ua.org.bolshakov.model.Movie;
import ua.org.bolshakov.service.impl.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;


@WebServlet(name = "AddMovie", urlPatterns={"/addmovie"})
public class AddMovie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pages/admin/addMovie.jsp").forward(request, response);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Integer duration = Integer.valueOf(request.getParameter("duration"));
        LocalDate rent_start = LocalDate.parse(request.getParameter("rent_start"), formatter);
        LocalDate rent_end = LocalDate.parse(request.getParameter("rent_end"), formatter);
        String genre = request.getParameter("genre");
        Integer rate = Integer.valueOf(request.getParameter("rate"));
        String poster = request.getParameter("poster");
        String video = request.getParameter("video");

        MovieDTO movie = new MovieDTO(title, description, duration, rent_start, rent_end, genre, rate, poster, video);
        // MovieDTO movieDTO = MovieServiceImpl.getInstance().update();/ ( title, description, duration, rent_start, rent_end, genre, rate, poster, video);
//MovieDaoImpl.getInstance().update(movie);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
