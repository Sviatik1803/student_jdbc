package ua.sviatik.service;

import ua.sviatik.dao.impl.CourseDAO;
import ua.sviatik.dao.impl.GroupDAO;
import ua.sviatik.dao.impl.StudentDAO;
import ua.sviatik.entity.Course;
import ua.sviatik.entity.Student;
import ua.sviatik.formatters.Formatter;
import ua.sviatik.formatters.FormatterFactory;
import ua.sviatik.formatters.impl.CourseFormatter;

import java.util.Scanner;

public class Console {
    public static final String a =
            "SELECT groups.group_id, group_name\n" +
                    "FROM groups \n" +
                    "JOIN students ON groups.group_id = students.group_id\n" +
                    "GROUP BY groups.group_id\n" +
                    "HAVING COUNT(students.student_id) = (\n" +
                    "    SELECT COUNT(students.student_id) AS group_count\n" +
                    "    FROM groups \n" +
                    "    JOIN students ON groups.group_id = students.group_id\n" +
                    "    GROUP BY groups.group_id\n" +
                    "    ORDER BY group_count\n" +
                    "    LIMIT 1\n" +
                    ");";
    public static final String b =
            "SELECT * FROM students JOIN student_courses USING (student_id) " +
                    "JOIN courses USING (course_id) WHERE course_name = ?";
    public static final String c = "INSERT INTO students (first_name, last_name, group_id) VALUES (?, ?, ?)";
    public static final String d = "DELETE FROM students WHERE student_id = ?";
    public static final String e = "INSERT INTO student_courses (student_id, courses_id) VALUES (?, ?)";
    public static final String f = "DELETE FROM student_courses WHERE (student_id = ? AND courses_id = ?)";


    public void start() {
        System.out.println("a. Find all groups with less or equals student count");
        System.out.println("b. Find all students related to course with given name");
        System.out.println("c. Add new student");
        System.out.println("d. Delete student by STUDENT_ID");
        System.out.println("e. Add a student to the course (from a list)");
        System.out.println("f. Remove the student from one of his or her courses");

        System.out.println("Type a-f for your action: ");

        try (Scanner scanner = new Scanner(System.in)) {
            char ch;
            do {
                ch = scanner.nextLine().charAt(0);
                switch (ch) {
                    case 'a':
//                        findGroupsWithFewerStudents();
                        break;
                    case 'b':
                        try (Scanner scanner1 = new Scanner(System.in)) {
                            getCourses("SELECT * FROM courses ORDER BY course_id");
                            System.out.println("Enter course name:");
                            executeQueryB(scanner1.nextLine());
                        }
                        break;
                    case 'c':
                        System.out.println("Enter new student:");
                        try (Scanner scanner1 = new Scanner(System.in)) {
                            System.out.println("Name:");
                            String name = scanner1.nextLine();
                            System.out.println("Surname:");
                            String surname = scanner1.nextLine();
                            System.out.println("Group name:");
                            String groupName = scanner1.nextLine();
//                            executeQueryC(new Student(name,surname, ));
                        }
                        break;
                    case 'd':
                        System.out.println("d");
                        break;
                    case 'e':
                        System.out.println("e");
                        break;
                    case 'f':
                        System.out.println("f");
                        break;
                    default:
                        System.out.println("You've entered an invalid character. Try again");

                }
            }
            while (!Character.toString(ch).matches("^[a-fA-F]*$"));
        }

    }

//    private void findGroupsWithFewerStudents() {
//        Formatter<Group> groupFormatter = FormatterFactory.createGroupFormatter();
//        String outputGroups = groupFormatter.format();
//        System.out.println(outputGroups);
//    }

    //Singleton for without "new DAO"
    private void executeQueryB(String courseName) {//це сервіс
        StudentDAO studentDAO = FactoryDAO.createStudentDAO();
        String outputStudents = FormatterFactory.createStudentFormatter().format(studentDAO.getByCourseName(courseName));
        System.out.println(outputStudents);
    }

    private void executeQueryC(Student student) {
        new StudentDAO().save(c, student);
        System.out.println("Student successfully added.....maybe");
    }

    private void getCourses(String query) {
        Formatter<Course> courseFormatter = new CourseFormatter();
        String outputCourses = courseFormatter.format(new CourseDAO().get(query));
        System.out.println(outputCourses);
    }

    private int getGroupId(String groupName) {
        return new GroupDAO().getByName(groupName).getGroupId();
    }

}
