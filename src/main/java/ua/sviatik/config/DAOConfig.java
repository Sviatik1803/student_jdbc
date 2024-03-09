package ua.sviatik.config;

import ua.sviatik.dao.CourseDAO;
import ua.sviatik.dao.GroupDAO;
import ua.sviatik.dao.StudentCoursesDAO;
import ua.sviatik.dao.impl.CourseDAOImpl;
import ua.sviatik.dao.impl.GroupDAOImpl;
import ua.sviatik.dao.impl.StudentCoursesDAOImpl;
import ua.sviatik.dao.impl.StudentDAOImpl;

public class DAOConfig {
    private static final GroupDAO groupDAO = new GroupDAOImpl();
    private static final StudentDAOImpl studentDAO = new StudentDAOImpl();
    private static final CourseDAO coursesDAO = new CourseDAOImpl();
    private static final StudentCoursesDAO studentCoursesDAO = new StudentCoursesDAOImpl();
    public static GroupDAO getGroupDAO() {
        return groupDAO;
    }
    public static StudentDAOImpl getStudentDAOImpl() {
        return studentDAO;
    }

    public static CourseDAO getCourseDAO() {
        return coursesDAO;
    }

    public static StudentCoursesDAO getStudentCoursesDAO() {
        return studentCoursesDAO;
    }
}
