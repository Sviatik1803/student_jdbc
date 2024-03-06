package ua.sviatik.dao.impl;

import ua.sviatik.dao.DAO;
import ua.sviatik.dao.DBConnection;
import ua.sviatik.entity.Group;
import ua.sviatik.entity.Student;
import ua.sviatik.exceptions.ConnectionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class GroupDAO implements DAO<Group> {
    private static final String SQL_FIND_ALL = "SELECT * FROM groups";
    private static final String GET_BY_GROUP_NAME = "SELECT * FROM groups WHERE group_name = ?";

    public Set<Group> get(String query) {
        Set<Group> groups = new HashSet<>();
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)
        ){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int groupId = resultSet.getInt(1);
                String groupName = resultSet.getString(2);

                groups.add(new Group(groupId,groupName));
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }
        return groups;
    }

    //Optional одне ентіті, якщо ліст то нє
    public Group getByName(String name) {
        Group group = null;
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_BY_GROUP_NAME)
        ){
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                int groupId = resultSet.getInt(1);
                String groupName = resultSet.getString(2);
                group = new Group(groupId,groupName);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }
        return group;
    }
//
//    @Override
//    public void save(Object o) {
//
//    }
//
//    @Override
//    public void update(Object o, String[] params) {
//
//    }
//
//    @Override
//    public void delete(Object o) {
//
//    }
//
//    public void saveBatch(Set<Group> groups) {
//        try (Connection connection = DBConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(SQL_SAVE_GROUP)) {
//
//            for (Group group : groups) {
//                statement.setString(1, group.getGroupName());
//                statement.addBatch();
//            }
//
//            statement.executeBatch();
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

    private static final String SQL_SAVE_GROUP = "INSERT INTO groups (group_name) VALUES (?)";

    @Override
    public void saveBatch(Set<Group> groups) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SAVE_GROUP)) {

            for (Group group : groups) {
                statement.setString(1, group.getGroupName());
                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }
    }
}
