package ua.sviatik.formatters;

import ua.sviatik.entity.Group;

import java.util.Set;

public interface GroupFormatter {
    String format(Set<Group> groups);

}
