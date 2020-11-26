package com.log;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.junit.Test;

/**
 * @Author:
 * @Date: 2020-11-25 18:56
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Log4jTest {

    // Log4j 基础
    @Test
    public void testQuick(){
        // 开启 log4j 内置日志记录，如果开启内置日志记录则日志输出会更多
        LogLog.setInternalDebugging(true);

        // 初始化配置信息，在入门案例中暂不使用配置文件
        // BasicConfigurator.configure();
        // 获取日志记录器对象
        Logger logger = Logger.getLogger(Log4jTest.class);
        // 日志记录输出
        logger.info("hello log4j");

        // 日志级别有6种，默认的日志级别是DEBUG
        logger.fatal("fatal"); // 严重错误，一般会造成系统崩溃并终止运行
        logger.error("error"); // 错误信息，不会影响系统运行
        logger.warn("warn");   // 警告信息，可能会发生问题
        logger.info("info");   // 运行信息，数据连接、网络连接、IO 操作等等
        logger.debug("debug"); // 调试信息，一般在开发中使用，记录程序变量参数传递信息等等
        logger.trace("trace"); // 追踪信息，记录程序所有的流程信息
    }
}
