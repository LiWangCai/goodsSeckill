package com.li.mapper;

import com.li.po.SuccessKilled;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

public class SuccessKilledMapperTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
    SuccessKilledMapper successKilledMapper = applicationContext.getBean("successKilledMapper", SuccessKilledMapper.class);

    @Test
    public void test() {
//        System.out.println(successKilledMapper.);
        System.out.println(successKilledMapper.insertSuccessKilled(21, 123786, new Date()));
        System.out.println(successKilledMapper.insertSuccessKilled(22, 123786, new Date()));
//        System.out.println(successKilledMapper.queryByIdWithSeckill(21, 123786));
    }
}