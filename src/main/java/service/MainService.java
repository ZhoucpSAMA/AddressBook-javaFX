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

    public  List<Person> getAllPerson(){
        sqlSession = MybatisUtils.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> allPerson = personMapper.getAllPerson();
        sqlSession.close();
        return allPerson;
    }
    public  List<Group> getAllGroup(){
        sqlSession = MybatisUtils.getSqlSession();
        GroupMapper groupMapper = sqlSession.getMapper(GroupMapper.class);
        List<Group> allGroup = groupMapper.getAllGroup();
        sqlSession.close();
        return allGroup;
    }
}
