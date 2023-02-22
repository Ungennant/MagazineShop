package org.serf.magazineshop.service.impl;

import org.serf.magazineshop.dao.UserDAO;
import org.serf.magazineshop.dao.impl.UserDaoImpl;
import org.serf.magazineshop.domain.User;
import org.serf.magazineshop.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        try {
            this.userDAO = new UserDaoImpl();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User create(User user) {
        return userDAO.create(user);
    }

    @Override
    public User read(Integer id) {
        return userDAO.read(id);
    }

    @Override
    public User update(User user) {
        return userDAO.update(user);
    }

    @Override
    public void delete(Integer id) {
        userDAO.delete(id);
    }

    @Override
    public List<User> readAll() {
        return userDAO.readAll();
    }
}
