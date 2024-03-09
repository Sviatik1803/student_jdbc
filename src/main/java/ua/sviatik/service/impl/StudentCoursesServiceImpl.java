package ua.sviatik.service.impl;

import ua.sviatik.config.Config;
import ua.sviatik.config.DAOConfig;
import ua.sviatik.dao.StudentCoursesDAO;
import ua.sviatik.entity.StudentCourses;
import ua.sviatik.service.StudentCoursesService;
import ua.sviatik.service.StudentService;

import java.util.Set;

public class StudentCoursesServiceImpl implements StudentCoursesService {
    private static final StudentCoursesDAO studentCoursesDAO = DAOConfig.getStudentCoursesDAO();

    @Override
    public void saveBatch(Set<StudentCourses> studentCourses) {
        studentCoursesDAO.saveBatch(studentCourses);
    }
}
