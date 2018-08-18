import com.java.aop.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//spring集成junit
@RunWith(SpringJUnit4ClassRunner.class)
//用注解方式读取容器全局配置文件
@ContextConfiguration(locations = "classpath:config/applicationContext.xml")
public class TestSpringAOP {
    @Autowired
    UserService userService;

    @Test
    public void test() {
        userService.add();
        userService.add(123);
        userService.findById();
    }
}
