package com.li.dto;


import com.li.enums.SeckillStateEnum;
import com.li.po.SuccessKilled;

/**
 * 封装秒杀执行后的数据
 */
public class SeckillExecution {
    private long seckilled;

    /**
     * 表示状态
     */
    private int state;


    /**
     * 状态表示
     */
    private String stateInfo;


    //秒杀成功对象
    private SuccessKilled successKilled;

    public SeckillExecution(long seckilled, SeckillStateEnum stateEnum, SuccessKilled successKilled) {
        this.seckilled = seckilled;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    public SeckillExecution(long seckilled, SeckillStateEnum stateEnum) {
        this.seckilled = seckilled;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public long getSeckilled() {
        return seckilled;
    }

    public void setSeckilled(long seckilled) {
        this.seckilled = seckilled;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckilled=" + seckilled +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }
}
