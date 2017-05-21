package ua.org.bolshakov.dao.impl;

import ua.org.bolshakov.dao.api.Dao;
import ua.org.bolshakov.model.Movie;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public final class MovieDaoImpl extends CrudDAO<Movie> {
    private final String INSERT = "Insert into movie (title, duration, description) values (?,?,?)";
    private final String UPDATE = "UPDATE movie SET title = ?, duration = ?, description = ?,WHERE id = ?";
    private static MovieDaoImpl crudDAO;

    public MovieDaoImpl(Class type) {
        super(type);
    }


    public static synchronized Dao<Integer, Movie> getInstance() {
        if (crudDAO == null) {
            crudDAO = new MovieDaoImpl(Movie.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Movie entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setString(1, entity.getTitle());
        preparedStatement.setLong(2, entity.getDuration());
        preparedStatement.setString(3, entity.getDescription());
        preparedStatement.setInt(4, entity.getId());
        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Movie entity) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, entity.getTitle());
                preparedStatement.setLong(2, entity.getDuration());
                preparedStatement.setString(3, entity.getDescription());
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
            result.add(movie);
        }
        return result;
    }
}