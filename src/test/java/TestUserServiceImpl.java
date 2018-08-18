import com.java.dto.User;
import com.java.service.impl.UserServiceImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserServiceImpl {
    UserServiceImpl usi=new UserServiceImpl();

    @Test
    public void testAdd() throws SQLException{
        User user=new User();
        user.setUsername("li");
        user.setPassword("123456");
        usi.add(user);
    }

    @Test
    public void testUpdate() throws SQLException{
        User user=usi.findById(1);
        System.out.println(user);
        user.setUsername("li");
        user.setPassword("123456");
        usi.update(user);
        user=usi.findById(1);
        System.out.println(user);
    }

    @Test
    public void testDelete() throws SQLException{
        User user=usi.findById(1);
        System.out.println(usi.delete(user));
    }

    @Test
    public void testFindById() throws SQLException{
        System.out.println(usi.findById(1));
    }

    @Test
    public void testFindByProp() throws SQLException{
        Map map=new HashMap();
        map.put("id",1);
        List<User> list = usi.findByProp(map);
        if (list.size() > 0) {
            for (User user : list) {
                System.out.println(user.toString());
            }
        } else {
            System.out.print("查不到相关数据");
        }
    }
}
