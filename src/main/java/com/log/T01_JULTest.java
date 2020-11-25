package com.log;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author:
 * @Date: 2020-11-25 8:33
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T01_JULTest {
    // JUL 日志快速入门
    @Test
    public void testQuick() {
        // 1.创建日志记录器对象
        Logger logger = Logger.getLogger("com.log.test.T01_JULTest");
        // 2.日志记录输出
        logger.info("hello jul");

        // 通用方法进行日志记录
        logger.log(Level.INFO, "info msg");

        // 通过点位符方式进行日志记录
        String name = "jack";
        Integer age = 18;
        logger.log(Level.INFO, "用户信息：{0},{1}", new Object[]{name, age});
    }

    // JUL日志级别测试
    @Test
    public void testLogLevel() throws Exception {
        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.log.T01_JULTest");
        // 2.日志记录输出
        logger.severe("server");
        logger.warning("warning");
        logger.info("info"); // jul 默认的日志级别info
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }
}


























