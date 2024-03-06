package ua.sviatik.util;

import ua.sviatik.dao.impl.CourseDAO;
import ua.sviatik.dao.impl.GroupDAO;
import ua.sviatik.dao.impl.StudentCoursesDAO;
import ua.sviatik.dao.impl.StudentDAO;

public class LoadDataToDB {
    private LoadDataToDB() {

    }

    public static void loadAllData() {
        LoadDataToDB.saveGroups();
        LoadDataToDB.saveStudents();
        LoadDataToDB.saveCourses();
        LoadDataToDB.saveStudentCourses();
    }


    private static void saveStudents() {
        new StudentDAO().saveBatch(DataTableGenerator.generateStudents());
    }

    private static void saveGroups() {
        new GroupDAO().saveBatch(DataTableGenerator.generateGroups());
    }

    private static void saveCourses() {
        new CourseDAO().saveBatch(DataTableGenerator.generateCourses());
    }

    private static void saveStudentCourses() {
        new StudentCoursesDAO().saveBatch(DataTableGenerator.generateStudentCourses());
    }
}
