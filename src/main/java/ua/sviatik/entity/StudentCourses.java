package ua.sviatik.entity;

public class StudentCourses {
    private int studentCoursesId;
    private final int studentId;
    private final int courseId;

    public StudentCourses(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public StudentCourses(int studentCoursesId, int studentId, int courseId) {
        this.studentCoursesId = studentCoursesId;
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "StudentCourses{" +
                "studentCoursesId=" + studentCoursesId +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }
}
