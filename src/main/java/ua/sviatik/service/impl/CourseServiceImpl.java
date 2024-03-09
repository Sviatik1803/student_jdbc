package ua.sviatik.service.impl;

import ua.sviatik.config.Config;
import ua.sviatik.config.DAOConfig;
import ua.sviatik.dao.CourseDAO;
import ua.sviatik.entity.Course;
import ua.sviatik.service.CourseService;

import java.util.Set;

public class CourseServiceImpl implements CourseService {
    private static final CourseDAO courseDAO = DAOConfig.getCourseDAO();

    @Override
    public void saveBatch(Set<Course> courses) {
        courseDAO.saveBatch(courses);
    }
}
