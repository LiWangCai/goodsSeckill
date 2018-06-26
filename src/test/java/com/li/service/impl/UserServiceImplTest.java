package com.li.service.impl;

import com.li.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class UserServiceImplTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
    UserService userService = applicationContext.getBean("userService", UserService.class);


    @Test
    public void test() {
        System.out.println(userService.selectById(2));
    }

}