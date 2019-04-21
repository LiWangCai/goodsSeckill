package com.li.service;

import com.li.dto.Exposer;
import com.li.dto.SeckillExecution;
import com.li.execption.RepeatKillExecption;
import com.li.execption.SeckillCloseExecption;
import com.li.execption.SeckillException;
import com.li.po.Seckill;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author nanGua
 * @since 2019-04-05
 */

/**
 * 使用者的角度去设计
 * 1.方法定义粒度
 * 2.参数
 * 3.返回类型
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时
     * 输出秒杀接口的地址，否则输出地址时间和秒杀时间
     * 不会暴露秒杀地址
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillExecption, SeckillCloseExecption;
}
