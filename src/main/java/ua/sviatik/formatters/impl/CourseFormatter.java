package ua.sviatik.formatters.impl;

import ua.sviatik.entity.Course;
import ua.sviatik.formatters.Formatter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseFormatter implements Formatter<Course> {
    @Override
    public String format(Set<Course> courses) {
        int count = makeListOfString(courses).get(0).length();
        return "*".repeat(count) + "\n" +
                String.join("\n" + "+" + "-".repeat(getMaxCourseIdSize(courses)) + "+" + "-".repeat(getMaxCourseNameSize(courses)) + "+" + "-".repeat(getMaxCourseDescriptionSize(courses)) + "+\n",
                        makeListOfString(courses)) + "\n" +
                "*".repeat(count);
    }

    private List<String> makeListOfString(Set<Course> courses) {
        int maxCourseIdSize = getMaxCourseIdSize(courses);
        int maxCourseNameSize = getMaxCourseNameSize(courses);
        int maxCourseDescriptionSize = getMaxCourseDescriptionSize(courses);
        return courses.stream()
                .map(course -> "|" + course.getCourseId() + getSpaces(maxCourseIdSize, String.valueOf(course.getCourseId())) +
                        "|" + course.getCourseName() + getSpaces(maxCourseNameSize, course.getCourseName()) +
                        "|" + course.getCourseDescription() + getSpaces(maxCourseDescriptionSize, course.getCourseDescription()) + "|")
                .collect(Collectors.toList());
    }

    private int getMaxCourseIdSize(Set<Course> courses) {
        return courses.stream()
                .mapToInt(course -> String.valueOf(course.getCourseId()).length())
                .max()
                .orElse(0);
    }

    private int getMaxCourseNameSize(Set<Course> courses) {
        return courses.stream()
                .mapToInt(course -> course.getCourseName().length())
                .max()
                .orElse(0);
    }

    private int getMaxCourseDescriptionSize(Set<Course> courses) {
        return courses.stream()
                .mapToInt(course -> course.getCourseDescription().length())
                .max()
                .orElse(0);
    }

    private String getSpaces(int maxSize, String value) {
        int spaces = maxSize - value.length();
        return " ".repeat(spaces);
    }
}