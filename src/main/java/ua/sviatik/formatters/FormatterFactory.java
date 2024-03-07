package ua.sviatik.formatters;

import ua.sviatik.formatters.impl.CourseFormatter;
import ua.sviatik.formatters.impl.GroupFormatter;
import ua.sviatik.formatters.impl.StudentFormatter;

public class FormatterFactory {
    public static StudentFormatter createStudentFormatter() {
        return new StudentFormatter();
    }

    public static GroupFormatter createGroupFormatter() {
        return new GroupFormatter();
    }

    public static CourseFormatter createCourseFormatter() {
        return new CourseFormatter();
    }

}