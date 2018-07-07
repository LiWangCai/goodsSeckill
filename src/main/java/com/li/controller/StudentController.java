package com.li.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.li.po.Student;
import com.li.po.User;
import com.li.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nanGua
 * @since 2018-07-07
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    StudentService studentService;

    @RequestMapping("showAll")
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView();
        Wrapper wrapper = new EntityWrapper();
        wrapper.eq("student_name", "Li");
        Student student;
        student = studentService.selectOne(wrapper);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("student");
        return modelAndView;
    }
}

