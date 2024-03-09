package ua.sviatik.dao;

import ua.sviatik.entity.Student;

import java.util.Set;

public interface StudentDAO {
    void saveBatch(Set<Student> students);
}
