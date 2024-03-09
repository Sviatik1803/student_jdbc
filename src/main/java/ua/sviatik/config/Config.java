package ua.sviatik.config;

import ua.sviatik.dao.CourseDAO;
import ua.sviatik.dao.GroupDAO;
import ua.sviatik.dao.StudentCoursesDAO;
import ua.sviatik.dao.impl.CourseDAOImpl;
import ua.sviatik.dao.impl.GroupDAOImpl;
import ua.sviatik.dao.impl.StudentCoursesDAOImpl;
import ua.sviatik.dao.impl.StudentDAOImpl;
import ua.sviatik.formatters.CourseFormatter;
import ua.sviatik.formatters.GroupFormatter;
import ua.sviatik.formatters.StudentFormatter;
import ua.sviatik.formatters.impl.CourseFormatterImpl;
import ua.sviatik.formatters.impl.GroupFormatterImpl;
import ua.sviatik.formatters.impl.StudentFormatterImpl;
import ua.sviatik.service.CourseService;
import ua.sviatik.service.GroupService;
import ua.sviatik.service.StudentCoursesService;
import ua.sviatik.service.impl.CourseServiceImpl;
import ua.sviatik.service.impl.GroupServiceImpl;
import ua.sviatik.service.impl.StudentCoursesServiceImpl;
import ua.sviatik.service.impl.StudentServiceImpl;

public class Config {

    private static final GroupService groupService = new GroupServiceImpl();
    private static final GroupFormatter groupFormatter = new GroupFormatterImpl();
    private static final StudentServiceImpl studentService = new StudentServiceImpl();
    private static final StudentFormatter studentFormatter = new StudentFormatterImpl();
    private static final CourseService coursesService = new CourseServiceImpl();
    private static final CourseFormatter coursesFormatter = new CourseFormatterImpl();
    private static final StudentCoursesService studentCoursesService = new StudentCoursesServiceImpl();
//    private static final StudentCoursesFormatter studentCoursesFormatter = new StudentCoursesFormatterImpl();


    // 12 fields


    public Config() {

    }


    public static GroupService getGroupService() {
        return groupService;
    }

    public static GroupFormatter getGroupFormatter() {
        return groupFormatter;
    }


    public static StudentServiceImpl getStudentService() {
        return studentService;
    }

    public static StudentFormatter getStudentFormatter() {
        return studentFormatter;
    }

    public static CourseService getCourseService() {
        return coursesService;
    }

    public static CourseFormatter getCourseFormatter() {
        return coursesFormatter;
    }

    public static StudentCoursesService getStudentCoursesService() {
        return studentCoursesService;
    }


}
