package ua.org.bolshakov.dao.impl;


import ua.org.bolshakov.dao.api.Dao;
import ua.org.bolshakov.model.Ticket;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TicketDaoImpl extends CrudDAO<Ticket> {
    private final String INSERT = SQLs.INSERT_TICKET;
    private final String UPDATE = SQLs.UPDATE_TICKET;
    private static TicketDaoImpl crudDAO;

    public TicketDaoImpl(Class type) {
        super(Ticket.class );
    }

    public static synchronized Dao<Integer, Ticket> getInstance() {
        if (crudDAO == null) {
            crudDAO = new TicketDaoImpl(Ticket.class);
        }
        return crudDAO;
    }


    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Ticket entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setInt(1, entity.getPlaceID());

        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Ticket entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getPlaceID());

        return preparedStatement;
    }

    @Override
    protected List<Ticket> readAll(ResultSet resultSet) throws SQLException {
        List<Ticket> result = new LinkedList<>();
        Ticket ticket = null;
        while (resultSet.next()) {
            ticket = new Ticket();
            ticket.setId(resultSet.getInt("id_ticket"));
            ticket.setPlaceID(resultSet.getInt("id_place"));

            result.add(ticket);
        }
        return result;
    }

    private void setStatement(Ticket entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getPlaceID());

    }
}
