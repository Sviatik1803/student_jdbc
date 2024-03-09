package ua.sviatik.formatters;

import ua.sviatik.entity.Course;

import java.util.Set;

public interface CourseFormatter {
    String format(Set<Course> courses);

}
