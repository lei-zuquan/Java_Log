package com.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author:
 * @Date: 2020-12-01 20:30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class LogbackTest {
    public static final Logger LOGGER = LoggerFactory.getLogger(LogbackTest.class);

    // 快速入门
    @Test
    public void testQuick() throws Exception {
        for (int i = 0; i < 10000; i++) {
            // 日志输出
            LOGGER.error("error");
            LOGGER.warn("warning");
            LOGGER.info("info");
            LOGGER.debug("debug");  // 默认的日志级别信息
            LOGGER.trace("trace");  // 追踪信息
        }
    }
}
