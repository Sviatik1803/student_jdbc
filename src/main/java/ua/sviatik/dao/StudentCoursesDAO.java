package ua.sviatik.dao;

import ua.sviatik.entity.Group;
import ua.sviatik.entity.StudentCourses;

import java.util.Set;

public interface StudentCoursesDAO {
    void saveBatch(Set<StudentCourses> studentCourses);
}
