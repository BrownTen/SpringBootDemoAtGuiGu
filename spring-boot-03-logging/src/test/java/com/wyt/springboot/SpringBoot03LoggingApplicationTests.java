package com.wyt.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03LoggingApplicationTests {

    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        //日志的级别由低到高
        //由低到高:trace<debug<info<warn<error
        //可以调整需要的日志级别:日志就只会在这个级别以后的高级别生效
        logger.trace("这是trace日志,用来跟踪信息");
        logger.debug("这是debug日志,用来调试信息");
        //SpringBoot默认给我们使用的是Info级别的,没有指定级别的就用SpringBoot默认规定的级别,root级别
        logger.info("这是info日志,自定义信息");
        logger.warn("这是warn日志,警告信息");
        logger.error("这是error日志,异常");
    }

}
