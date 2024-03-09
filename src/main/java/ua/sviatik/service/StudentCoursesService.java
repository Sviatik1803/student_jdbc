package ua.sviatik.service;

import ua.sviatik.entity.Course;
import ua.sviatik.entity.StudentCourses;

import java.util.Set;

public interface StudentCoursesService {
    void saveBatch(Set<StudentCourses> studentCourses);

}
