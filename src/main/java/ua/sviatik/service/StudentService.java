package ua.sviatik.service;

import ua.sviatik.entity.Course;
import ua.sviatik.entity.Student;

import java.util.Set;

public interface StudentService {
    void saveBatch(Set<Student> students);

}
