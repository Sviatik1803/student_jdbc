package ua.sviatik.formatters.impl;

import ua.sviatik.entity.Group;
import ua.sviatik.formatters.Formatter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupFormatter implements Formatter<Group> {
    @Override
    public String format(Set<Group> groups) {
        int count = makeListOfString(groups).get(0).length();
        return "*".repeat(count) + "\n" + String.join("\n" + "+" + "-".repeat(getMaxGroupIdSize(groups)) + "+" + "-".repeat(getMaxGroupNameSize(groups))
                + "+" + "\n", makeListOfString(groups)) + "\n" + "*".repeat(count);
    }

    private List<String> makeListOfString(Set<Group> groups) {
        int maxGroupIdSize = getMaxGroupIdSize(groups);
        int maxGroupNameSize = getMaxGroupNameSize(groups);
        return groups.stream()
                .map(group -> "|" + group.getGroupId() + getSpaces(maxGroupIdSize, String.valueOf(group.getGroupId())) + "|" + group.getGroupName() + getSpaces(maxGroupNameSize, group.getGroupName()) + "|")
                .collect(Collectors.toList());
    }

    private int getMaxGroupIdSize(Set<Group> groups) {
        return groups.stream()
                .mapToInt(group -> String.valueOf(group.getGroupId()).length())
                .max()
                .orElse(0);
    }

    private int getMaxGroupNameSize(Set<Group> groups) {
        return groups.stream()
                .mapToInt(group -> group.getGroupName().length())
                .max()
                .orElse(0);
    }

    private String getSpaces(int maxSize, String value) {
        int spaces = maxSize - value.length();
        return " ".repeat(spaces);
    }
}