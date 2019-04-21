package com.li.service.impl;

import com.li.mapper.SeckillMapper;
import com.li.service.SeckillService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


public class Test {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        SeckillService seckillService = applicationContext.getBean("seckillService", SeckillService.class);
        SeckillMapper seckillMapper = applicationContext.getBean("seckillMapper", SeckillMapper.class);

    }
}
