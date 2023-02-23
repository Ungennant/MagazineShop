package org.serf.magazineshop.service.impl;

import org.apache.log4j.Logger;
import org.serf.magazineshop.dao.UserDAO;
import org.serf.magazineshop.dao.impl.UserDaoImpl;
import org.serf.magazineshop.domain.User;
import org.serf.magazineshop.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    private static UserService userServiceImpl;

    private UserDAO userDAO;

    private UserServiceImpl() {
        try {
            userDAO = new UserDaoImpl();
        } catch (SQLException | ClassNotFoundException throwables) {
            LOGGER.error(throwables);
        }
    }

    public static UserService getUserService() {
        if (userServiceImpl == null)
            userServiceImpl = new UserServiceImpl();
        return userServiceImpl;
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

    @Override
    public User getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
}
