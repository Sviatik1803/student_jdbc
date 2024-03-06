package ua.sviatik.util;

import ua.sviatik.entity.Course;
import ua.sviatik.entity.Group;
import ua.sviatik.entity.Student;
import ua.sviatik.entity.StudentCourses;

import java.util.*;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class DataTableGenerator {
    public static Set<Course> generateCourses() {
        Set<Course> courses = new HashSet<>();
        courses.add(new Course("Mathematics", "Learning math"));
        courses.add(new Course("Materials Science", "Study of materials science"));
        courses.add(new Course("Metrology", "Study of metrology"));
        courses.add(new Course("Sopromat", "Sopromat study"));
        courses.add(new Course("English", "Learning English"));
        courses.add(new Course("Philosophy", "Study of psychology"));
        courses.add(new Course("Modeling", "Simulation study"));
        courses.add(new Course("Physics", "Physics study"));
        courses.add(new Course("Chemistry", "Chemistry study"));
        courses.add(new Course("Electrical Engineering", "Study of electrical engineering"));
        return courses;
    }

    public static Set<Student> generateStudents() {
        Set<Student> students = new HashSet<>();
        String[] firstNames = new String[20];
        firstNames[0] = "James";
        firstNames[1] = "Mary";
        firstNames[2] = "John";
        firstNames[3] = "Emma";
        firstNames[4] = "Michael";
        firstNames[5] = "Olivia";
        firstNames[6] = "William";
        firstNames[7] = "Sophia";
        firstNames[8] = "Benjamin";
        firstNames[9] = "Ava";
        firstNames[10] = "Daniel";
        firstNames[11] = "Isabella";
        firstNames[12] = "Christopher";
        firstNames[13] = "Amelia";
        firstNames[14] = "Matthew";
        firstNames[15] = "Mia";
        firstNames[16] = "Joseph";
        firstNames[17] = "Elijah";
        firstNames[18] = "David";
        firstNames[19] = "Grace";

        String[] lastNames = new String[20];
        lastNames[0] = "Smith";
        lastNames[1] = "Johnson";
        lastNames[2] = "Williams";
        lastNames[3] = "Brown";
        lastNames[4] = "Jones";
        lastNames[5] = "Miller";
        lastNames[6] = "Davis";
        lastNames[7] = "García";
        lastNames[8] = "Rodriguez";
        lastNames[9] = "Martinez";
        lastNames[10] = "Hernandez";
        lastNames[11] = "López";
        lastNames[12] = "Gonzalez";
        lastNames[13] = "Wilson";
        lastNames[14] = "Anderson";
        lastNames[15] = "Thomas";
        lastNames[16] = "Taylor";
        lastNames[17] = "Moore";
        lastNames[18] = "Jackson";
        lastNames[19] = "White";

        Random random = new Random();
        while (students.size() < 200) {
            String name = firstNames[random.nextInt(firstNames.length)];
            String surname = lastNames[random.nextInt(lastNames.length)];
            Integer groupId = random.nextInt(100) < 5 ? null : random.nextInt(10) + 1;
            students.add(new Student(name, surname, groupId));

        }

        return students;

    }

    public static Set<Group> generateGroups() {
        Set<Group> groups = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            Supplier<String> randomCharacter = (() -> {
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < 2; j++) {
                    char randomChar = (char) (random.nextInt(26) + 'A');
                    sb.append(randomChar);
                }
                return sb.toString();
            });

            IntSupplier randomNumber = (() -> {
                Random random = new Random();
                return random.nextInt(90) + 10;
            });

            String groupName = randomCharacter.get() + "-" + randomNumber.getAsInt();
            groups.add(new Group(groupName));
        }
        return groups;
    }

    public static Set<StudentCourses> generateStudentCourses() {
        Set<StudentCourses> studentCourses = new HashSet<>();
        for (int i = 1; i <= 200; i++) {
            int randCount = new Random().nextInt(3) + 1;
            for (int j = 0; j < randCount; j++) {
                studentCourses.add(new StudentCourses(i, new Random().nextInt(10) + 1));
            }
        }
        return studentCourses;
    }

}
