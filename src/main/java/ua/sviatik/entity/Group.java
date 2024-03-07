package ua.sviatik.entity;

public class Group {
    private int groupId;
    private final String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                '}';
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

}
