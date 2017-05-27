package ua.org.bolshakov.dao.impl;

import ua.org.bolshakov.dao.DaoFactory;
import ua.org.bolshakov.dto.MovieDTO;
import ua.org.bolshakov.model.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static ua.org.bolshakov.dao.impl.SQLs.INSERT_USER;
import static ua.org.bolshakov.dao.impl.SQLs.UPDATE_USER;

public class UserDaoImpl extends CrudDAO<User> {
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    private void setStatement(User entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString(4, entity.getLastName());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getSex());
        preparedStatement.setDate(7, Date.valueOf(entity.getBirthday()));
        preparedStatement.setInt(8, entity.getRole().getId());
    }


    @Override
    protected List<User> readAll(ResultSet resultSet) throws SQLException {
        List<User> result = new LinkedList<>();
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setSex(resultSet.getString("sex"));
            user.setBirthday(resultSet.getDate("birthday").toLocalDate());
            user.setRole(DaoFactory.getInstance().getRoleDao().getById(resultSet.getInt("role_id")));
            result.add(user);
        }
        return result;
    }

}
