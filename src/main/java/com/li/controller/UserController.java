package com.li.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.li.po.User;
import com.li.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nanGua
 * @since 2018-07-07
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "showAll", method = RequestMethod.POST)
    public ModelAndView showAll(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        User user = userService.selectById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(String username, String password) {
        String page = "loginFail";
        Wrapper wrapper = new EntityWrapper();
        wrapper.eq("username", username);
        User user = userService.selectOne(wrapper);
        if (user != null && password.equals(user.getPassword())) {
            page = "loginSuccess";
        }
        return page;
    }
}

