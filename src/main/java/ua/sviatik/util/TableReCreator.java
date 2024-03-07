package ua.sviatik.util;


import ua.sviatik.dao.DBConnection;
import ua.sviatik.exceptions.ConnectionException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Objects;

public class TableReCreator {


    public static void tableReCreator() {
        ClassLoader classLoader = TableReCreator.class.getClassLoader();
        String filePath = Objects.requireNonNull(classLoader.getResource("create.sql")).getFile();
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

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }


}