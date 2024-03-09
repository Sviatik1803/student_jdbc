package ua.sviatik.util;

import ua.sviatik.config.Config;
import ua.sviatik.dao.impl.CourseDAOImpl;
import ua.sviatik.dao.impl.StudentCoursesDAOImpl;
import ua.sviatik.dao.impl.StudentDAOImpl;

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
        Config.getGroupDAO().saveBatch(DataTableGenerator.generateGroups());
        Config.getGroupService().getGroupsWithFewerStudents();
    }

    private static void saveGroups() {
        new GroupDAO().saveBatch(DataTableGenerator.generateGroups());
    }

    private static void saveCourses() {
        new CourseDAOImpl().saveBatch(DataTableGenerator.generateCourses());
    }

    private static void saveStudentCourses() {
        new StudentCoursesDAOImpl().saveBatch(DataTableGenerator.generateStudentCourses());
    }
}
