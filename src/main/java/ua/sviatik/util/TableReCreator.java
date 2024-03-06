package ua.sviatik.util;


import ua.sviatik.dao.DBConnection;
import ua.sviatik.exceptions.ConnectionException;
import ua.sviatik.exceptions.FileException;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TableReCreator {

    private static final URI CREATE_PATH = URI.create("/create.sql");

    public static void tableReCreator() {
        ClassLoader classLoader = TableReCreator.class.getClassLoader();
        String filePath = Objects.requireNonNull(classLoader.getResource("create.sql")).getFile();
        String query;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(
                TableReCreator.class.getResourceAsStream(CREATE_PATH.getPath())), StandardCharsets.UTF_8))) {
            query = reader.lines().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            System.out.println("Failed to read SQL file: " + filePath);
            throw new FileException(e);
        }

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.execute();
        } catch (Exception e) {
            System.out.println("Failed to execute SQL statement: " + query);
            throw new ConnectionException(e);
        }
    }

    public TableReCreator() {

    }

}