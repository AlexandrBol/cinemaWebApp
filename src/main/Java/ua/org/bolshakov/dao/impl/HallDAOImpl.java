package ua.org.bolshakov.dao.impl;

import ua.org.bolshakov.model.Hall;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class HallDAOImpl extends CrudDAO<Hall>
    {
        private final String INSERT = SQLs.INSERT_HALL;
        private final String UPDATE = SQLs.UPDATE_HALL;
        private static HallDAOImpl crudDAO;

        public HallDAOImpl(Class type) {
            super(Hall.class );
        }

        public static synchronized HallDAOImpl getInstance() {
            if (crudDAO == null) {
                crudDAO = new HallDAOImpl(Hall.class);
            }
            return crudDAO;
        }

        @Override
        protected PreparedStatement createUpdateStatement(Connection connection, Hall entity) throws SQLException {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getPrice());
            return preparedStatement;
        }

        @Override
        protected PreparedStatement createInsertStatement(Connection connection, Hall entity) throws SQLException {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getPrice());

            return preparedStatement;
        }

        @Override
        protected List<Hall> readAll(ResultSet resultSet) throws SQLException {
            List<Hall> result = new LinkedList<>();
            Hall hall = null;
            while (resultSet.next()) {
                hall = new Hall();
                hall.setId(resultSet.getInt("id"));
                hall.setName(resultSet.getString("name"));
                hall.setPrice(resultSet.getInt("price"));
                result.add(hall);
            }
            return result;
        }
        private void setStatement(Hall entity, PreparedStatement preparedStatement) throws SQLException {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getPrice());
        }
    }
