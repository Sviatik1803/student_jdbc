package ua.sviatik.formatters;

import ua.sviatik.entity.Student;

import java.util.Set;

public interface StudentFormatter {
    String format(Set<Student> students);
}
