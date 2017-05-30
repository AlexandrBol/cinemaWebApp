package ua.org.bolshakov.dao.impl;
import ua.org.bolshakov.model.Order;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OrderDaoImpl extends CrudDAO<Order>{

        private final String INSERT = SQLs.INSERT_HALL;
        private final String UPDATE = SQLs.UPDATE_HALL;
        private static OrderDaoImpl crudDAO;

        public OrderDaoImpl(Class type) {
        super(Order.class );
    }

    public static synchronized OrderDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new OrderDaoImpl(Order.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Order entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        preparedStatement.setInt(1, entity.getIdTicket());
        preparedStatement.setInt(2, entity.getIdUser());
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Order entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, entity.getIdTicket());
        preparedStatement.setInt(2, entity.getIdUser());

        return preparedStatement;
    }

    @Override
    protected List<Order> readAll(ResultSet resultSet) throws SQLException {
        List<Order> result = new LinkedList<>();
        Order order = null;
        while (resultSet.next()) {
            order = new Order();
            order.setId(resultSet.getInt("id_order"));
            order.setIdTicket(resultSet.getInt("id_ticket"));
            order.setIdUser(resultSet.getInt("id_user"));
            result.add(order);
        }
        return result;
    }
    private void setStatement(Order entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getIdTicket());
        preparedStatement.setInt(2, entity.getIdUser());
    }
}
