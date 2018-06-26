package com.li.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserMapperTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
    UserMapper userMapper = applicationContext.getBean("userMapper", UserMapper.class);

    @Test
    public void test() {
        System.out.println(userMapper.selectById(1));
    }

}