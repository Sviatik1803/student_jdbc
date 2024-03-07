package ua.sviatik.service;

import ua.sviatik.dao.impl.CourseDAO;
import ua.sviatik.dao.impl.GroupDAO;
import ua.sviatik.dao.impl.StudentCoursesDAO;
import ua.sviatik.dao.impl.StudentDAO;

public class FactoryDAO {
    public static GroupDAO createGroupDAO() {
        return new GroupDAO();
    }

    public static StudentDAO createStudentDAO() {
        return new StudentDAO();
    }

    public static CourseDAO CreateCourseDAO() {
        return new CourseDAO();
    }

    public static StudentCoursesDAO StudentCoursesDAO() {
        return new StudentCoursesDAO();
    }
}

