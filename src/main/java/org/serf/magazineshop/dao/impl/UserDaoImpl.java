package org.serf.magazineshop.dao.impl;

import org.serf.magazineshop.dao.UserDAO;
import org.serf.magazineshop.domain.User;
import org.serf.magazineshop.utils.ConnectionUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDAO {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDaoImpl() throws SQLException, ClassNotFoundException {
        connection = ConnectionUtils.openConnection();
    }

    private static String READ_ALL = "SELECT * FROM users";
    private static String CREATE = "INSERT INTO users('email', 'first_name', 'last_name', 'password', 'role') values (?,?,?,?,?)";
    private static String READ_BY_ID = "SELECT * from users WHERE id =?";
    private static String UPDATE_BY_ID = "UPDATE users SET email=?, first_name=?, last_name=?, password=?, role=? WHERE id =?";
    private static String DELETE_BY_ID = "DELETE FROM users WHERE id =?";

    @Override
    public User create(User user) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            user.setId(rs.getInt(1));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            Integer userId = result.getInt("id");
            String email = result.getString("email");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String password = result.getString("password");
            String role = result.getString("role");

            user = new User(userId, email, firstName, lastName, password, role);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
    }

    @Override
    public List<User> readAll() {
        List<User> userRecords = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Integer userId = result.getInt("id");
                String email = result.getString("email");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                String password = result.getString("password");
                String role = result.getString("role");


                userRecords.add(new User(userId, email, firstName, lastName, password, role));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userRecords;
    }
}

