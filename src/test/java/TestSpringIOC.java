import com.java.dao.impl.UserDaoImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.java.service.impl.UserServiceImpl;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/applicationContext.xml")
public class TestSpringIOC {

    @Autowired
    UserDaoImpl udi;
    @Autowired
    UserServiceImpl usi;

    @Test
    public void test() throws SQLException {
        //断言非空，则成功
        Assert.assertNotNull(udi);
        Assert.assertNotNull(usi);
        //断言"li"和usi.findById(1).getUsername()的值相等，相等则成功
        Assert.assertEquals("li",usi.findById(1).getUsername());
    }
}
