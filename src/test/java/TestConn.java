import com.java.dao.Db;
import org.junit.Test;

public class TestConn {
    @Test
    public void testC(){
        //打印连接情况
        System.out.println(Db.getConn());
    }
}
