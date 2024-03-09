package ua.sviatik.service;

import ua.sviatik.entity.Course;

import java.util.Set;

public interface CourseService {
    void saveBatch(Set<Course> courses);

}
