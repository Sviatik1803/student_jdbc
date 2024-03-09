package ua.sviatik.util;

import ua.sviatik.exceptions.ConnectionException;
import ua.sviatik.exceptions.FileException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private DBConnection() {

    }

    public static Connection getConnection() {
        Properties prop = new Properties();
        try (InputStream input = DBConnection.class.getResourceAsStream("/postgres.properties")) {
            prop.load(input);
        } catch (IOException e) {
            throw new FileException(e);
        }

        try {
            return DriverManager.getConnection(
                    prop.getProperty("jdbc.url"),
                    prop.getProperty("jdbc.username"),
                    prop.getProperty("jdbc.password")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }
    }
}
