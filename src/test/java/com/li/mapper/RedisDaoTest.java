package com.li.mapper;

import com.li.po.Seckill;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class RedisDaoTest {
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
    SeckillMapper seckillMapper = applicationContext.getBean("seckillMapper", SeckillMapper.class);
    RedisDao redisDao = applicationContext.getBean("redisDao", RedisDao.class);

    private long id = 21;

    @Test
    public void getSeckill() {
        Seckill seckill = redisDao.getSeckill(id);
        if (seckill == null) {
            seckill = seckillMapper.queryById(id);
            if (seckill != null) {
                String res = redisDao.putSeckill(seckill);
                seckill = redisDao.getSeckill(id);
                System.out.println(seckill);
            }
        }
        System.out.println(seckill);
    }

    @Test
    public void putSeckill() {
    }
}