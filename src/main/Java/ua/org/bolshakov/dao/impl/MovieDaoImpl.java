package ua.org.bolshakov.dao.impl;

import ua.org.bolshakov.dao.api.Dao;
import ua.org.bolshakov.dto.MovieDTO;
import ua.org.bolshakov.model.Movie;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public final class MovieDaoImpl extends CrudDAO<Movie> {
    private final String INSERT = "Insert into movie (title, description, duration, rent_start, rent_end, genre, rating, poster, video) values (?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE movie SET title = ?, description = ?, duration = ?, rent_start = ?, rent_end = ?, genre = ?, rating = ?,poster = ?, video = ?, WHERE id = ?";
    private static MovieDaoImpl crudDAO;

    public MovieDaoImpl(Class type) {
        super(Movie.class );
    }


    public static synchronized Dao<Integer, Movie> getInstance() {
        if (crudDAO == null) {
            crudDAO = new MovieDaoImpl(Movie.class);
        }
        return crudDAO;
    }

    @Override
    public PreparedStatement createUpdateStatement(Connection connection, Movie entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getTitle());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setLong(3, entity.getDuration());
        preparedStatement.setDate(4, Date.valueOf(entity.getRent_start()));
        preparedStatement.setDate(5, Date.valueOf(entity.getRent_end()));
        preparedStatement.setString(6,entity.getGenre());
        preparedStatement.setInt(7,entity.getRate());
        preparedStatement.setString(8,entity.getPoster());
        preparedStatement.setString(9,entity.getVideo());
        preparedStatement.setInt(10, entity.getId());
        return preparedStatement;
    }

    @Override
    public List<Movie> readAll(ResultSet resultSet) throws SQLException {
        List<Movie> result = new LinkedList<>();
        Movie movie = null;
        while (resultSet.next()) {
            movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setDuration(resultSet.getInt("duration"));
            movie.setDescription(resultSet.getString("description"));
            movie.setRent_start(resultSet.getDate("rent_start").toLocalDate());
            movie.setRent_start(resultSet.getDate("rent_end").toLocalDate());
            movie.setGenre(resultSet.getString("genre"));
            movie.setRate(resultSet.getInt("rating"));
            movie.setPoster(resultSet.getString("poster"));
            movie.setVideo(resultSet.getString("video"));
            result.add(movie);
        }
        return result;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Movie entity) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, entity.getTitle());
                preparedStatement.setLong(2, entity.getDuration());
                preparedStatement.setString(3, entity.getDescription());
                preparedStatement.setDate(4, Date.valueOf(entity.getRent_start()));
                preparedStatement.setDate(5, Date.valueOf(entity.getRent_end()));
                preparedStatement.setString(6,entity.getGenre());
                preparedStatement.setInt(7,entity.getRate());
                preparedStatement.setString(8,entity.getPoster());
                preparedStatement.setString(9,entity.getVideo());

        return preparedStatement;
    }

}