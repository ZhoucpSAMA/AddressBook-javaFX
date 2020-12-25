package dao;

import pojo.Group;

import java.util.List;

public interface GroupMapper {
    List<Group> getAllGroup();

    int addGroup(Group group);

    int delGroupByID(Integer g_id);

    Group getGroupByName(String g_name);

    int updateGroupByID(Group group);
}
