package com.li.service.impl;

import com.li.controller.SeckillController;
import com.li.dto.Exposer;
import com.li.dto.SeckillExecution;
import com.li.enums.SeckillStateEnum;
import com.li.execption.RepeatKillExecption;
import com.li.execption.SeckillCloseExecption;
import com.li.execption.SeckillException;
import com.li.mapper.RedisDao;
import com.li.mapper.SeckillMapper;
import com.li.mapper.SuccessKilledMapper;
import com.li.po.Seckill;
import com.li.po.SuccessKilled;
import com.li.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nanGua
 * @since 2019-04-05
 */
@Service("seckillService")
public class SeckillServiceImpl implements SeckillService {
//    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillMapper seckillMapper;

    @Autowired
    private SuccessKilledMapper successKilledMapper;

    @Autowired
    private RedisDao redisDao;

    //md5盐值
    private final String slat = "lkajsdkljlkaskiocj98127489#@$#@%";

    public List<Seckill> getSeckillList() {
        return seckillMapper.queryAll(0, 4);
    }

    public Seckill getById(long seckillId) {
        return seckillMapper.queryById(seckillId);
    }

    /**
     * 是否暴露接口
     * @param seckillId
     * @return
     */
    public Exposer exportSeckillUrl(long seckillId) {
        //访问redis
        Seckill seckill = redisDao.getSeckill(seckillId);
        if (seckill == null) {
            seckill = seckillMapper.queryById(seckillId);
            if (seckill == null) {
                return new Exposer(false, seckillId);
            } else {
                redisDao.putSeckill(seckill);
            }
        }

        Date startTime = seckill.getStartName();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        //转换特定字符串，//不可逆
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }


    /**
     * 执行秒杀方法
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws SeckillException
     * @throws RepeatKillExecption
     * @throws SeckillCloseExecption
     */
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillExecption, SeckillCloseExecption {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑
        Date nowTime = new Date();
        //减库存
        int updateCount = seckillMapper.reduceNumber(seckillId, nowTime);
        try {

            if (updateCount <= 0) {
                //没有更新到记录
                throw new SeckillCloseExecption("seckill is close");
            } else {
                //记录购买行为
                int insertCount = successKilledMapper.insertSuccessKilled(seckillId, userPhone,new Date());
                if (insertCount <= 0) {
                    throw new RepeatKillExecption("seckill repeated");
                } else {
                    //秒杀成功
                    SuccessKilled successKilled = successKilledMapper.queryByIdWithSeckill(seckillId, userPhone);
                    return new SeckillExecution(seckillId, SeckillStateEnum.END, successKilled);
                }
            }
        } catch (Exception e) {
//            logger.error(e.getMessage());
            //spring通过异常来进行rollback
            throw new SeckillException("seckill inner error" + e.getMessage());
        }
    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
}
