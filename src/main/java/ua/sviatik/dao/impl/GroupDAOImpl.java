package ua.sviatik.dao.impl;

import ua.sviatik.util.DBConnection;
import ua.sviatik.dao.GroupDAO;
import ua.sviatik.entity.Group;
import ua.sviatik.exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class GroupDAOImpl implements GroupDAO {
    private static final String  GET_GROUPS_WITH_FEWER_STUDENTS =
            "SELECT groups.group_id, group_name\n" +
                    "FROM groups \n" +
                    "JOIN students ON groups.group_id = students.group_id\n" +
                    "GROUP BY groups.group_id\n" +
                    "HAVING COUNT(students.student_id) = (\n" +
                    "    SELECT COUNT(students.student_id) AS group_count\n" +
                    "    FROM groups \n" +
                    "    JOIN students ON groups.group_id = students.group_id\n" +
                    "    GROUP BY groups.group_id\n" +
                    "    ORDER BY group_count\n" +
                    "    LIMIT 1\n" +
                    ");";
    private static final String GET_BY_GROUP_NAME = "SELECT * FROM groups WHERE group_name = ?";
    private static final String SQL_SAVE_GROUP = "INSERT INTO groups (group_name) VALUES (?)";



    public Set<Group> getGroupsWithFewerStudents() {
        Set<Group> groups = new HashSet<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_GROUPS_WITH_FEWER_STUDENTS)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int groupId = resultSet.getInt(1);
                String groupName = resultSet.getString(2);

                groups.add(new Group(groupId, groupName));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }
        return groups;
    }

    public Group getByName(String name) {
        Group group = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_BY_GROUP_NAME)
        ) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int groupId = resultSet.getInt(1);
                String groupName = resultSet.getString(2);
                group = new Group(groupId, groupName);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }
        return group;
    }

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
