package ua.org.bolshakov.dao.impl;


import ua.org.bolshakov.model.Role;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class RoleDAOImpl extends CrudDAO<Role> {
    public RoleDAOImpl() {
        super(Role.class);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Role entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Role entity) throws SQLException {
        return null;
    }

    @Override
    protected List<Role> readAll(ResultSet resultSet) throws SQLException {
        List<Role> result = new LinkedList<>();
        Role rele = null;
        while (resultSet.next()) {
            rele = new Role();
            rele.setId(resultSet.getInt("id"));
            rele.setName(resultSet.getString("name"));
            result.add(rele);
        }
        return result;
    }
}
