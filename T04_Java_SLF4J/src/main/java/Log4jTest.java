import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @Author:
 * @Date: Created in 4:36 下午 2020/12/1
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Log4jTest {
    // 定义 log4j 日志记录器
    public static final Logger LOGGER = Logger.getLogger(Log4jTest.class);
    
    // 测试桥接器
    @Test
    public void test01(){
        LOGGER.info("hello log4j");
    }
}
