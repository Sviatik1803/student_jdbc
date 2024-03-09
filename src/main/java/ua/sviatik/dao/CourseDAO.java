package ua.sviatik.dao;

import ua.sviatik.entity.Course;

import java.util.Set;

public interface CourseDAO {
    void saveBatch(Set<Course> courses);
}
