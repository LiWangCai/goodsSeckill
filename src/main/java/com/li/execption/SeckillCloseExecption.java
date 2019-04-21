package com.li.execption;

import com.li.dto.SeckillExecution;

/**
 * 秒杀关闭异常
 */
public class SeckillCloseExecption extends SeckillException {
    public SeckillCloseExecption(String message) {
        super(message);
    }

    public SeckillCloseExecption(String message, Throwable cause) {
        super(message, cause);
    }
}
