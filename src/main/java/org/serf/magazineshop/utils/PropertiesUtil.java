package org.serf.magazineshop.utils;

import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
        DOMConfigurator.configure("loggerConfig.xml");
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties(){
        try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("database.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
