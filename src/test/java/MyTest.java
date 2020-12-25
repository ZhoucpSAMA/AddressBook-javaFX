import dao.GroupMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.Group;
import utils.MybatisUtils;

import java.util.List;

public class MyTest {
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        GroupMapper mapper = sqlSession.getMapper(GroupMapper.class);
        List<Group> allGroup = mapper.getAllGroup();
        for (Group group : allGroup) {
            System.out.println(group);
        }
        sqlSession.close();
    }






}
