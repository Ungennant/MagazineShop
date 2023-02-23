package org.serf.magazineshop.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.serf.magazineshop.service.impl.BucketServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static final String DRIVER = "driver";
    private static final String URL_KEY = "url";
    private static final String USER_NAME_KEY = "user_name";
    private static final String USER_PASSWORD_KEY = "user_password";

    private static final Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);

    public static Connection openConnection() throws SQLException {
        DOMConfigurator.configure("LoggerConfig.xml");
        try {
            Class.forName(PropertiesUtil.get(DRIVER));
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        }
        return DriverManager.getConnection(PropertiesUtil.get(URL_KEY), PropertiesUtil.get(USER_NAME_KEY), PropertiesUtil.get(USER_PASSWORD_KEY));
    }
}
