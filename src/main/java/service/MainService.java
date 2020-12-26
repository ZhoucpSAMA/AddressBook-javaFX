package service;

import dao.GroupMapper;
import dao.PersonMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Group;
import pojo.Person;
import utils.MybatisUtils;

import java.util.List;

public class MainService {
    private SqlSession sqlSession = MybatisUtils.getSqlSession();

    public List<Person> getAllPerson() {
        sqlSession = MybatisUtils.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> allPerson = personMapper.getAllPerson();
        sqlSession.close();
        return allPerson;
    }

    public List<Group> getAllGroup() {
        sqlSession = MybatisUtils.getSqlSession();
        GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
        List<Group> allGroup = groupMapper.getAllGroup();
        sqlSession.close();
        return allGroup;
    }

    public int addPerson(Person person) {
        sqlSession = MybatisUtils.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        int i = personMapper.addPerson(person);
        sqlSession.close();
        return i;
    }

    public Person getPersonByName(String p_name) {
        sqlSession = MybatisUtils.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = personMapper.getPersonByName(p_name);
        sqlSession.close();
        return person;
    }

    public String getGroupNameByID(Integer p_id) {
        sqlSession = MybatisUtils.getSqlSession();
        GroupMapper mapper = sqlSession.getMapper(GroupMapper.class);
        String name = mapper.getGroupNameByID(p_id);
        sqlSession.close();
        return name;
    }

    public int updatePerson(Person person) {
        sqlSession = MybatisUtils.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        int i = mapper.updatePersonByName(person);
        sqlSession.close();
        return i;
    }

    public int delPersonByName(String p_name) {
        sqlSession = MybatisUtils.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        int i = mapper.delPersonByName(p_name);
        sqlSession.close();
        return i;
    }

    public int addGroup(Group group) {
        sqlSession = MybatisUtils.getSqlSession();
        GroupMapper mapper = sqlSession.getMapper(GroupMapper.class);
        int i = mapper.addGroup(group);
        sqlSession.close();
        return i;
    }

    public int delGroupByName(String g_name) {
        sqlSession = MybatisUtils.getSqlSession();
        GroupMapper mapper = sqlSession.getMapper(GroupMapper.class);
        int i = mapper.delGroupByName(g_name);
        sqlSession.close();
        return i;
    }

    public int delPersonByGroupID(Integer p_g_id) {
        sqlSession = MybatisUtils.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        int i = mapper.delPersonByGroupID(p_g_id);
        sqlSession.close();
        return i;
    }

    public Group getGroupByName(String g_name) {
        sqlSession = MybatisUtils.getSqlSession();
        GroupMapper mapper = sqlSession.getMapper(GroupMapper.class);
        Group group = mapper.getGroupByName(g_name);
        sqlSession.close();
        return group;
    }
    public int updateGroupByID(Group group){
        sqlSession = MybatisUtils.getSqlSession();
        GroupMapper mapper = sqlSession.getMapper(GroupMapper.class);
        int i = mapper.updateGroupByID(group);
        sqlSession.close();
        return i;
    }
}
