package ua.org.bolshakov.dao.impl;

import ua.org.bolshakov.model.Place;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PlaceDAOImpl  extends CrudDAO<Place> {

    private final String INSERT = SQLs.INSERT_PLACE;
    private final String UPDATE = SQLs.UPDATE_PLACE;
    private static PlaceDAOImpl crudDAO;

    public PlaceDAOImpl(Class type) {
        super(Place.class);
    }

    public static synchronized PlaceDAOImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new PlaceDAOImpl(Place.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Place entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setInt(1, entity.getSeat());
        preparedStatement.setInt(2, entity.getRow());
        preparedStatement.setBoolean(3, entity.isStatus());
        preparedStatement.setInt(4, entity.getSessionId());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Place entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getSeat());
        preparedStatement.setInt(2, entity.getRow());
        preparedStatement.setBoolean(3, entity.isStatus());
        preparedStatement.setInt(4, entity.getSessionId());
        return preparedStatement;
    }

    @Override
    protected List<Place> readAll(ResultSet resultSet) throws SQLException {
        List<Place> result = new LinkedList<>();
        Place place = null;
        while (resultSet.next()) {
            place = new Place();
            place.setId(resultSet.getInt("place_id"));
            place.setSeat(resultSet.getInt("seat"));
            place.setRow(resultSet.getInt("row"));
            place.setStatus(resultSet.getBoolean("status"));
            place.setSessionId(resultSet.getInt("session_id"));
            result.add(place);
        }
        return result;
    }

    private void setStatement(Place entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getSeat());
        preparedStatement.setInt(2, entity.getRow());
        preparedStatement.setBoolean(3, entity.isStatus());
        preparedStatement.setInt(4, entity.getSessionId());
    }
}
