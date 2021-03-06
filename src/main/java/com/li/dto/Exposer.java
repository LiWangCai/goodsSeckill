package com.li.dto;

/**
 * 用来暴露秒杀接口
 */
public class Exposer {
    /**
     * 是否开启秒杀
     */
    private boolean exposed;

    /**
     * 一种加密措施
     */
    private String md5;

    /**
     * id
     */
    private long seckilled;

    /**
     * 系统当前时间
     */
    private long now;

    private long start;

    private long end;

    public Exposer(boolean exposed, String md5, long seckilled) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckilled = seckilled;
    }

    public Exposer(boolean exposed, long seckilled, long now, long start, long end) {
        this.seckilled = seckilled;
        this.exposed = exposed;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, String md5) {
        this.exposed = exposed;
        this.md5 = md5;
    }

    public Exposer(boolean exposed, long seckilled) {
        this.exposed = exposed;
        this.seckilled = seckilled;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getSeckilled() {
        return seckilled;
    }

    public void setSeckilled(long seckilled) {
        this.seckilled = seckilled;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckilled=" + seckilled +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
