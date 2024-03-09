package ua.sviatik.dao.impl;

import ua.sviatik.dao.CourseDAO;
import ua.sviatik.util.DBConnection;
import ua.sviatik.entity.Course;
import ua.sviatik.exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

public class CourseDAOImpl implements CourseDAO {
    private static final String SQL_SAVE_COURSES = "INSERT INTO courses (course_name, course_description) VALUES (?, ?)";

    private static CourseDAOImpl instance;

    public static CourseDAOImpl getInstance(){
        if(instance==null){
            instance = new CourseDAOImpl();
        }
        return instance;
    }

    @Override
    public void saveBatch(Set<Course> courses) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SAVE_COURSES)) {

            for (Course course : courses) {
                statement.setString(1, course.getCourseName());
                statement.setString(2, course.getCourseDescription());
                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }
    }

    public Set<Course> get(String query) {
        Set<Course> set = new TreeSet<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int courseId = resultSet.getInt("course_id");
                String courseName = resultSet.getString("course_name");
                String courseDescription = resultSet.getString("course_description");
                set.add(new Course(courseId, courseName, courseDescription));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }

        return set;
    }
}
