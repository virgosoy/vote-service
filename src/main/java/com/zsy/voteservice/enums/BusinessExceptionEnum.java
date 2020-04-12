package com.zsy.voteservice.enums;

import com.zsy.voteservice.except.BusinessException;
import lombok.Getter;

import java.util.function.Supplier;

/**
 * 业务异常常量
 * @author Soy
 * @date 2020-3-28
 */
public enum BusinessExceptionEnum {
    // 注册
    USER_LOGIN_NAME_EXIST(1101,"登录名已存在"),
    // 登录/校验
    USER_LOGIN_UNKNOWN_ACCOUNT(1201,"登录名不存在"),
    USER_LOGIN_NAME_OR_PASSWORD_WRONG(1202, "登录名或密码不正确"),
    USER_PASSWORD_WRONG(1203, "密码不正确"),
    // 获取信息
    USER_NOT_LOGIN(1301, "当前为未登录状态"),
    // 上传文件
    FILE_EMPTY(2101, "上传文件为空");

    @Getter
    private Integer code;
    @Getter
    private String message;

    BusinessExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据枚举生成异常
     * @return
     */
    public BusinessException exception(){
        return new BusinessException(this.getCode(),this.getMessage());
    }
}
