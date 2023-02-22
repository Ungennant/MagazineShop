package org.serf.magazineshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private static String DRIVER = "driver";
    private static String URL_KEY = "url";
    private static String USER_NAME_KEY = "user_name";
    private static String USER_PASSWORD_KEY = "user_password";

    public static Connection openConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(PropertiesUtil.get(URL_KEY), PropertiesUtil.get(USER_NAME_KEY), PropertiesUtil.get(USER_PASSWORD_KEY));
    }

}
