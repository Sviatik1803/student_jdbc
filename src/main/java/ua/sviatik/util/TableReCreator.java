package ua.sviatik.util;


import ua.sviatik.dao.DBConnection;
import ua.sviatik.exceptions.ConnectionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Objects;

public class TableReCreator {

    public static void tableReCreator() {
        try (InputStream inputStream = TableReCreator.class.getClassLoader().getResourceAsStream("create.sql")) {
            assert inputStream != null;
            byte[] bytes = inputStream.readAllBytes();
            String query = new String(bytes, StandardCharsets.UTF_8);
            executeQuery(query);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void executeQuery(String query) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
        } catch (Exception e) {
            System.out.println("Failed to execute SQL statement: " + query);
            throw new ConnectionException(e);
        }
    }

    private TableReCreator(){

    }
}