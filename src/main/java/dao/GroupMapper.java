package dao;

import pojo.Group;

import java.util.List;

public interface GroupMapper {
    List<Group> getAllGroup();

    int addGroup(Group group);


    Group getGroupByName(String g_name);

    int updateGroupByID(Group group);

    String getGroupNameByID(Integer g_id);

    int delGroupByName(String g_name);

}
