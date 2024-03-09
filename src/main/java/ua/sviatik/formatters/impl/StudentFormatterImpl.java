package ua.sviatik.formatters.impl;

import ua.sviatik.entity.Student;
import ua.sviatik.formatters.StudentFormatter;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentFormatterImpl implements StudentFormatter {
    @Override
    public String format(Set<Student> students) {
        int count = makeListOfString(students).get(0).length();
        return "*".repeat(count) + "\n" + String.join("\n" + "+" + "-".repeat(3) + "+" + "-".repeat(getMaxNameSize(students) + 1) + "+"
                + "-".repeat(getMaxSurnameSize(students) + 1) + "+" + "-".repeat(getMaxGroupIdSize(students)) + "+" + "\n", makeListOfString(students)) + "\n" + "*".repeat(count);
    }

    private List<String> makeListOfString(Set<Student> students) {
        int maxNameSize = getMaxNameSize(students);
        int surnameSize = getMaxSurnameSize(students);
        int maxIdSize = getMaxIdSize(students);
        int maxGroupIdSize = getMaxGroupIdSize(students);
        return students.stream()
                .map(student -> "|" + student.getId() + getSpaces(maxIdSize, String.valueOf(student.getId())) + "| " + student.getName() + getSpaces(maxNameSize, student.getName())
                        + "| " + student.getSurname() + getSpaces(surnameSize, student.getSurname()) + "|" + student.getGroupId() + getSpaces(maxGroupIdSize, String.valueOf(student.getGroupId())) + "|")
                .collect(Collectors.toList());
    }

    private int getMaxIdSize(Set<Student> students) {
        return students.stream()
                .mapToInt(student -> String.valueOf(student.getId()).length())
                .max()
                .orElse(0);
    }

    private int getMaxGroupIdSize(Set<Student> students) {
        return students.stream()
                .map(Student::getGroupId)
                .filter(Objects::nonNull)
                .max(Integer::compare).orElseThrow();
    }

    private int getMaxNameSize(Set<Student> students) {
        return students.stream()
                .mapToInt(student -> student.getName().length())
                .max()
                .orElse(0);
    }

    private int getMaxSurnameSize(Set<Student> students) {
        return students.stream()
                .mapToInt(student -> student.getSurname().length())
                .max()
                .orElse(0);
    }

    private String getSpaces(int maxSize, String value) {
        int spaces = maxSize - value.length();
        return " ".repeat(spaces);
    }

}
