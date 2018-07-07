package com.li.mapper;

import com.li.po.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class StudentMapperTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
    StudentMapper studentMapper = applicationContext.getBean("studentMapper", StudentMapper.class);

    @Test
    public void select() {
        Student student = new Student();
        student.setStudentName("Li");
        System.out.println(studentMapper.selectOne(student));
    }
}