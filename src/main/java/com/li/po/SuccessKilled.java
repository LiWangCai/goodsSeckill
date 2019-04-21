package com.li.po;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author nanGua
 * @since 2019-04-05
 */
public class SuccessKilled implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer skillId;
    private Integer userPhone;
    private Integer state;
    private Date createTime;
    private Integer seckillId;
    private Seckill seckill;

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Integer seckillId) {
        this.seckillId = seckillId;
    }

    @Override
    public String toString() {
        return "SuccessKilled{" +
        ", skillId=" + skillId +
        ", userPhone=" + userPhone +
        ", state=" + state +
        ", createTime=" + createTime +
        ", seckillId=" + seckillId +
        "}";
    }
}
