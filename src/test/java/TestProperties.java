import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    @Test
    public void TestP() throws IOException {
        Properties properties=new Properties();
        properties.load(TestProperties.class.getClassLoader().getResourceAsStream("config/db.properties"));
        String driver=properties.getProperty("driver");
        String url=properties.getProperty("url");
        String username=properties.getProperty("username");
        String password=properties.getProperty("password");
        System.out.println(driver);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }
}
