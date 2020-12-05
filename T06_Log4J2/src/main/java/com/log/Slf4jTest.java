package com.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:
 * @Date: Created in 11:46 上午 2020/11/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Slf4jTest {

    // 为了保证使用时，不需要每次都去创建logger 对象，我们声明静态常量
    public static final Logger LOGGER = LoggerFactory.getLogger(Slf4jTest.class);

    // 快速入门
    @Test
    public void testQuick(){
        // 日志输出
        LOGGER.error("error");
        LOGGER.warn("warning");
        LOGGER.info("info");    // 默认的日志级别信息
        LOGGER.debug("debug");
        LOGGER.trace("trace");  // 追踪信息

        // 使用占位符输出日志信息
        String name = "java_log";
        Integer age = 18;
        LOGGER.info("用户：{}，{}", name, age);

        // 将系统的异常信息输出
        try {
            int i = 1 / 0;
        } catch (Exception e){
            // e.printStackTrace();
            LOGGER.error("出现异常：", e);
        }
    }
}



























