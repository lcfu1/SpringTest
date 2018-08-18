import com.java.dto.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.java.service.impl.UserServiceImpl;

import java.sql.SQLException;

public class TestSpring {
    //定义一个spring容器
    ApplicationContext ac;

    //得到容器上下文
    @Before
    public void init() {
        ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    }

    @Test
    public void test() throws SQLException {
        //将bean注入到此处
        User user = ac.getBean("user", User.class);
        System.out.println(user);

        User user1 = ac.getBean("user1", User.class);
        System.out.println(user1);

        UserServiceImpl usi = ac.getBean("userService", UserServiceImpl.class);
        System.out.println(usi);
    }
}
