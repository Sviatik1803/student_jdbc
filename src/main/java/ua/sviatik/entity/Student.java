package ua.sviatik.entity;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private int studentId;
    private final String name;
    private final String surname;
    private Integer groupId;


    public Student(int studentId, String name, String surname, Integer groupId) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
    }

    public Student(String name, String surname, Integer groupId) {
        this.name = name;
        this.surname = surname;
        this.groupId = groupId;
    }

    public Student(int studentId, String name, String surname) {
        this.studentId = studentId;
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + studentId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", groupId=" + groupId +
                '}';
    }

    public int getId() {
        return studentId;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public Integer getGroupId() {
        return groupId;
    }


    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.studentId, o.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(groupId, student.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, surname, groupId);
    }

}
