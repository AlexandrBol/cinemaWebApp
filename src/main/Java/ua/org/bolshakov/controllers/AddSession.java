package ua.org.bolshakov.controllers;

import ua.org.bolshakov.dto.HallDTO;
import ua.org.bolshakov.dto.MovieDTO;
import ua.org.bolshakov.dto.SessionDTO;
import ua.org.bolshakov.service.impl.HallServiceImpl;
import ua.org.bolshakov.service.impl.MovieServiceImpl;
import ua.org.bolshakov.service.impl.SessionServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet(name = "AddSession", urlPatterns={"/AddSession"})
public class AddSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy H");
     ///   request.getRequestDispatcher("pages/admin/AddSession.jsp").forward(request,response);

        List<MovieDTO> movieDTOList = MovieServiceImpl.getInstance().getAll();
        request.setAttribute("movieDTOList", movieDTOList);

        List<HallDTO> hallDTOList = HallServiceImpl.getInstance().getAll();
        request.setAttribute("hallDTOList", hallDTOList);

        if(request.getParameter("value")!= null && request.getParameter("value1") != null) {
            Integer movieID = Integer.valueOf(request.getParameter("value"));
            Integer hallId = Integer.valueOf(request.getParameter("value1"));
            LocalDate dateSession =LocalDate.of(1960, 12, 1);
                    //LocalDate.parse(request.getParameter("dateSession"), formatter);

            SessionDTO sessionDTO = new SessionDTO(movieID, hallId, dateSession);
            SessionServiceImpl.getInstance().update(sessionDTO);
        }


        request.getRequestDispatcher("pages/admin/AddSession.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }
}


