package ua.sviatik.dao.impl;

import ua.sviatik.dao.StudentDAO;
import ua.sviatik.entity.Student;
import ua.sviatik.exceptions.ConnectionException;
import ua.sviatik.exceptions.CustomSQLException;
import ua.sviatik.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

public class StudentDAOImpl implements StudentDAO {

    private static final String SAVE_STUDENT = "INSERT INTO students (first_name, last_name, group_id) VALUES (?,?,?)";
    private static final String DELETE_STUDENT = "DELETE FROM students WHERE student_id = ?";

    private static final String FIND_BY_COURSE_NAME =
            "SELECT * FROM students JOIN student_courses USING (student_id) " +
                    "JOIN courses USING (course_id) WHERE course_name = ?";

    private static StudentDAOImpl instance;

    public static StudentDAOImpl getInstance(){
        if(instance==null){
            instance = new StudentDAOImpl();
        }
        return instance;
    }
    public Set<Student> getByCourseName(String courseName) {
        Set<Student> set = new TreeSet<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_COURSE_NAME)
        ) {
            statement.setString(1, courseName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("last_name");
                int groupId = resultSet.getInt("group_id");
                set.add(new Student(studentId, name, surname, groupId));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new CustomSQLException(e);
        }

        return set;
    }

    public Set<Student> getAll(String query) {
        Set<Student> set = new TreeSet<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("last_name");
                set.add(new Student(studentId, name, surname));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new CustomSQLException(e);
        }

        return set;
    }

    public void save(String query, Student student) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getSurname());
            statement.setInt(4, student.getGroupId());

            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new CustomSQLException(ex);
        }
    }

    @Override
    public void saveBatch(Set<Student> students) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_STUDENT)) {

            for (Student student : students) {
                statement.setString(1, student.getName());
                statement.setString(2, student.getSurname());

                Integer groupId = student.getGroupId();
                statement.setObject(3, groupId);

                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }
    }
}
