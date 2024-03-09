package ua.sviatik.service;

import ua.sviatik.entity.Course;
import ua.sviatik.entity.Group;

import java.util.Set;

public interface GroupService {
    void saveBatch(Set<Group> groups);

    Set<Group> getGroupsWithFewerStudents();
}
