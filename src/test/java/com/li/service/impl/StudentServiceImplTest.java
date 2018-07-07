package com.li.service.impl;

import com.li.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class StudentServiceImplTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
    StudentService studentService = applicationContext.getBean("studentService", StudentService.class);

    @Test
    public void showTest() {
        System.out.println(studentService.selectById(1));
    }
}