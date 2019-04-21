package com.li.service.impl;

import com.li.dto.Exposer;
import com.li.dto.SeckillExecution;
import com.li.mapper.SeckillMapper;
import com.li.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;


public class SeckillServiceImplTest implements HandlerInterceptor {
    static {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
    }
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
    SeckillService seckillService = applicationContext.getBean("seckillService", SeckillService.class);

    @Test
    public void getSeckillList() {
        System.out.println(seckillService.getSeckillList());
    }

    @Test
    public void getById() {
        System.out.println(seckillService.getById(21));
    }

    @Test
    public void exportSeckillUrl() {
        long id = 21;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        System.out.println(exposer);
    }

    @Test
    public void executeSeckill() {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
//        long id = 21;
//        long phone = 21332454L;
//        String md5 = "dd9bd3050967d9090e657c2146667223";
//        SeckillExecution execution = seckillService.executeSeckill(21, phone, md5);
//        System.out.println(execution);
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}