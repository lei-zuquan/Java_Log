package com.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * @Author:
 * @Date: 2020-11-26 20:11
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class JCLTest {

    @Test
    public void testQuick(){
        // 获取 log 日志记录器对象
        Log log = LogFactory.getLog(JCLTest.class);
        // 日志记录输出
        log.info("hello jcl");
    }
}
