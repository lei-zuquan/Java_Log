package com.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * @Author:
 * @Date: 2020-12-05 22:28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Log4j2Test {
    // 定义日志记录器对象
    public static final Logger LOGGER = LogManager.getLogger(Log4j2Test.class);
    // 快速入门
    @Test
    public void testQuick() throws Exception {
        // 日志消息输出
        LOGGER.fatal("fatal");
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info");
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
