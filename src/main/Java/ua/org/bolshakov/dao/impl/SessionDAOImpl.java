package ua.org.bolshakov.dao.impl;

import ua.org.bolshakov.model.Session;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SessionDAOImpl extends CrudDAO<Session> {
    private final String INSERT = SQLs.INSERT_SESSION;
    private final String UPDATE = SQLs.UPDATE_SESSION;
    private static SessionDAOImpl crudDAO;

    public SessionDAOImpl(Class type) {
        super(Session.class );
    }

    public static synchronized SessionDAOImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new SessionDAOImpl(Session.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Session entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setInt(1, entity.getMovieID());
        preparedStatement.setInt(2, entity.getHallId());
        preparedStatement.setDate(3, Date.valueOf(entity.getDateSession()));
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Session entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getMovieID());
        preparedStatement.setInt(2, entity.getHallId());
        preparedStatement.setDate(3, Date.valueOf(entity.getDateSession()));
        return preparedStatement;
    }

    @Override
    protected List<Session> readAll(ResultSet resultSet) throws SQLException {
        List<Session> result = new LinkedList<>();
        Session session = null;
        while (resultSet.next()) {
            session = new Session();
            session.setId(resultSet.getInt("id_session"));
            session.setMovieID(resultSet.getInt("movie_id"));
            session.setHallId(resultSet.getInt("hall_id"));
            session.setDateSession(resultSet.getDate("date_session").toLocalDate());
            result.add(session);
        }
        return result;
    }

    private void setStatement(Session entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getMovieID());
        preparedStatement.setInt(2, entity.getHallId());
        preparedStatement.setDate(3, Date.valueOf(entity.getDateSession()));
    }
}
