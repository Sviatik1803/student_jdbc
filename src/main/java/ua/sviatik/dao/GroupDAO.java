package ua.sviatik.dao;

import ua.sviatik.entity.Group;

import java.util.Set;

public interface GroupDAO {
    void saveBatch(Set<Group> groups);
     Set<Group> getGroupsWithFewerStudents();


    }
