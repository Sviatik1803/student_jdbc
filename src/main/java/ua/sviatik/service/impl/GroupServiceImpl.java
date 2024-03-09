package ua.sviatik.service.impl;

import ua.sviatik.config.Config;
import ua.sviatik.config.DAOConfig;
import ua.sviatik.dao.GroupDAO;
import ua.sviatik.entity.Group;
import ua.sviatik.service.GroupService;

import java.util.Set;

public class GroupServiceImpl implements GroupService {
    private final GroupDAO groupDAO = DAOConfig.getGroupDAO();

    @Override
    public void saveBatch(Set<Group> groups) {
        groupDAO.saveBatch(groups);
    }

    @Override
    public Set<Group> getGroupsWithFewerStudents() {
        return groupDAO.getGroupsWithFewerStudents();
    }




}
