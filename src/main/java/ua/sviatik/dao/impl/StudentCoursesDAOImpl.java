package ua.sviatik.dao.impl;

import ua.sviatik.dao.StudentCoursesDAO;
import ua.sviatik.entity.StudentCourses;
import ua.sviatik.exceptions.ConnectionException;
import ua.sviatik.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class StudentCoursesDAOImpl implements StudentCoursesDAO {
    private static final String SAVE_STUDENT_COURSES = "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?)";
    public static final String DELETE_STUDENT_COURSE = "DELETE FROM student_courses WHERE (student_id = ? AND courses_id = ?)";
    private static StudentCoursesDAOImpl instance;

    public static StudentCoursesDAOImpl getInstance(){
        if(instance==null){
            instance = new StudentCoursesDAOImpl();
        }
        return instance;
    }


    @Override
    public void saveBatch(Set<StudentCourses> studentCourses) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_STUDENT_COURSES)) {

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
