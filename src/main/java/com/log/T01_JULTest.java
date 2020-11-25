package com.log;

import org.junit.Test;

import java.io.InputStream;
import java.util.logging.*;

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

    // 自定义日志级别：输出到控制台、输出到指定文件中
    @Test
    public void testLogConfig() throws Exception {
        // 1.获取日志记录器对象
        Logger logger = Logger.getLogger("com.log.T01_JUCTest");
        // 关闭系统默认配置
        logger.setUseParentHandlers(false);

        // 自定义配置日志级别
        // 1.将日志通过 创建ConsoleHandler 控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        // 配置日志具体级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        // 2. 将日志 通过FileHandler 文件输出
        FileHandler fileHandler = new FileHandler("log\\jul.log");
        // 进行关联
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);


        // 2.日志记录输出
        logger.severe("server");
        logger.warning("warning");
        logger.info("info"); // jul 默认的日志级别info
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    // Logger 对象父子关系
    @Test
    public void testLogParent() throws Exception {
        // todo: 日志父子关系是根据包名关系继承的
        Logger logger1 = Logger.getLogger("com.log");
        Logger logger2 = Logger.getLogger("com"); // com包没有父包的话，默认继承自RootLogger

        // 测试日志对象是否存在父子关系：答案是存在的
        System.out.println(logger1.getParent() == logger2);
        // 所有日志记录器的顶级父无素 LogManager$RootLogger, name ""
        System.out.println("logger2 Parent:" + logger2.getParent() + ", name:" + logger2.getParent().getName());


        /*
            todo: 1因为logger2是父日志级别，通过修改它的日志输出级别，就可以控制logger1的日志输出级别
            todo: 2如果关闭logger2 父日志级别则logger1不再继承自logger2
         */
        // 关闭默认配置
        logger2.setUseParentHandlers(false);
        // 自定义配置日志级别
        // 1.将日志通过 创建ConsoleHandler 控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // 创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // 进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger2.addHandler(consoleHandler);

        logger1.severe("server");
        logger1.warning("warning");
        logger1.info("info"); // jul 默认的日志级别info
        logger1.config("config");
        logger1.fine("fine");
        logger1.finer("finer");
        logger1.finest("finest");
    }


    // 加载自定义配置文件：从指定配置文件中加载日志输出级别
    @Test
    public void testLogProperties() throws Exception {
        // 读取配置文件，通过类加载器
        InputStream in = T01_JULTest.class.getClassLoader().getResourceAsStream("logging.properties");
        // 创建LogManager
        LogManager logManager = LogManager.getLogManager();
        // 通过LogManager 加载配置文件；相当于将JAVA_HOME/lib/logging.properties 进行了替换
        logManager.readConfiguration(in);

        // TODO: 因为加载的是自定义日志配置文件，日志输出级别为ALL；可以运行起来验证
        // 创建日志记录器
        Logger logger = Logger.getLogger("com.log");
        logger.severe("server");
        logger.warning("warning");
        logger.info("info"); // jul 默认的日志级别info
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }
}


























