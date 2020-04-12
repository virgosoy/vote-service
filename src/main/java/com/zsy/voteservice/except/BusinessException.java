package com.zsy.voteservice.except;

import lombok.Getter;

/**
 * 业务异常
 * @author Soy
 * @date 2020-3-28
 */
public class BusinessException extends RuntimeException{
    /**
     * 错误代码（可返回给前端）
     */
    @Getter
    private Integer errorCode;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Integer errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
