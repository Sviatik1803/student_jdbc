package ua.sviatik.dao.impl;

import ua.sviatik.dao.DAO;
import ua.sviatik.dao.DBConnection;
import ua.sviatik.entity.StudentCourses;
import ua.sviatik.exceptions.ConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class StudentCoursesDAO implements DAO<StudentCourses> {
    private static final String SQL_SAVE_STUDENT_COURSES = "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?)";

    @Override
    public void saveBatch(Set<StudentCourses> studentCourses) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SAVE_STUDENT_COURSES)) {

            for (StudentCourses studentCourse : studentCourses) {
                statement.setInt(1, studentCourse.getStudentId());
                statement.setInt(2, studentCourse.getCourseId());
                statement.addBatch();
            }

            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new ConnectionException(e);
        }
    }
}
